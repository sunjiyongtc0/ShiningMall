$(function () {
    initialPage();
    getGrid();

});

function initialPage() {
    $(window).resize(function () {
        TreeGrid.table.resetHeight({height: $(window).height() - 100});
    });
}


function getGrid() {
    var colunms = TreeGrid.initColumn();
    var table = new TreeTable(TreeGrid.id, '../sys/region/list', colunms);
    table.setExpandColumn(2);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("parentId");
    table.setExpandAll(true);
    table.setHeight($(window).height() - 100);
    table.init();
    TreeGrid.table = table;
}

var TreeGrid = {
    id: "regionTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TreeGrid.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '上级区域', field: 'parentName', visible: false, align: 'center', valign: 'middle', width: '80px'},
        {title: '区域名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '编号', field: 'agencyId', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '类型', field: 'type', align: 'center', valign: 'middle', sortable: true, width: '100px'}];
    return columns;
};

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    }
};
var ztree;



var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        region: {type: '1'},
        ruleValidate: {
            name: [
                {required: true, message: '区域名称不能为空', trigger: 'blur'}
            ]
        },
        q: {
            parentName: '',
            name: '',
            type: ''
        },
        regionList: []
    },
    methods: {
        getRegion:function(){
            //加载部门树
            Ajax.request({
                url: "../sys/region/select",
                async: true,
                successCallback: function (r) {
                    ztree = $.fn.zTree.init($("#regionTree"), setting, r.regionList);
                    var node = ztree.getNodeByParam("id", vm.region.parentId);
                    if (node) {
                        ztree.selectNode(node);
                        vm.region.parentName = node.name;
                    } else {
                        node = ztree.getNodeByParam("id", 0);
                        ztree.selectNode(node);
                        vm.region.parentName = node.name;
                    }
                }
            });
        },
        regionTree: function () {
            openWindow({
                title: "选择区域",
                area: ['300px', '450px'],
                content: jQuery("#regionLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.region.parentId = node[0].id;
                    vm.region.parentName = node[0].name;
                    layer.close(index);
                }
            });
        },
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.region = {type: '1'};
            vm.changeType(1);
        },
        update: function (event) {
            var RegionId = getRegionId();
            if (!RegionId) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(RegionId)
        },
        saveOrUpdate: function (event) {
            var url = vm.region.id == null ? "../sys/region/save" : "../sys/region/update";
            Ajax.request({
                type: 'POST',
                url: url,
                params: JSON.stringify(vm.region),
                contentType: "application/json",
                successCallback: function () {
                    alert('操作成功', function (index) {
                        vm.reload();
                    });
                }
            });
        },
        del: function (event) {
            var RegionId = getRegionId();
            if (!RegionId) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                Ajax.request({
                    url: "../sys/region/delete",
                    params: JSON.stringify(RegionId),
                    contentType: "application/json",
                    type: 'POST',
                    successCallback: function () {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    }
                });
            });
        },
        getInfo: function (id) {
            Ajax.request({
                url: "../sys/region/info/" + id,
                async: true,
                successCallback: function (r) {
                    vm.region = r.region;
                    vm.changeType(vm.region.type);
                }
            });
        },
        changeType: function (type) {
            Ajax.request({
                url: "../sys/region/getAreaByType?type=" + type,
                async: true,
                successCallback: function (r) {
                    vm.regionList = r.list;
                }
            });
        },
        reload: function (event) {
            vm.showList = true;
            TreeGrid.table.refresh();
            vm.handleReset('formValidate');
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
    }
});

function getRegionId() {
    var selected = $('#regionTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}


/*
$(function () {
    $("#jqGrid").Grid({
        url: '../sys/region/list',
        colModel: [
            {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
            {label: '上级区域', name: 'parentName', index: 'parent_id', width: 80},
            {label: '区域', name: 'name', index: 'name', width: 80},
            {
                label: '类型', name: 'type', index: 'type', width: 80,
                formatter: function (value) {
                    if (value === '0' || value === 0) {
                        return '国家';
                    }
                    if (value == '1') {
                        return '省份';
                    }
                    if (value == '2') {
                        return '地市';
                    }
                    if (value == '3') {
                        return '区县';
                    }
                }
            }]
    });

}


var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        region: {type: '1'},
        ruleValidate: {
            name: [
                {required: true, message: '区域名称不能为空', trigger: 'blur'}
            ]
        },
        q: {
            parentName: '',
            name: '',
            type: ''
        },
        regionList: []
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.region = {type: '1'};
            vm.changeType(1);
        },
        update: function (event) {
            var id = getSelectedRow("#jqGrid");
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.region.id == null ? "../sys/region/save" : "../sys/region/update";
            Ajax.request({
                type: 'POST',
                url: url,
                params: JSON.stringify(vm.region),
                contentType: "application/json",
                successCallback: function () {
                    alert('操作成功', function (index) {
                        vm.reload();
                    });
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows("#jqGrid");
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                Ajax.request({
                    url: "../sys/region/delete",
                    params: JSON.stringify(ids),
                    contentType: "application/json",
                    type: 'POST',
                    successCallback: function () {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    }
                });
            });
        },
        getInfo: function (id) {
            Ajax.request({
                url: "../sys/region/info/" + id,
                async: true,
                successCallback: function (r) {
                    vm.region = r.region;
                    vm.changeType(vm.region.type);
                }
            });
        },
        changeType: function (type) {
            Ajax.request({
                url: "../sys/region/getAreaByType?type=" + type,
                async: true,
                successCallback: function (r) {
                    vm.regionList = r.list;
                }
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'name': vm.q.name,
                    'parentName': vm.q.parentName,
                    'type': vm.q.type
                },
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
    }
});*/
