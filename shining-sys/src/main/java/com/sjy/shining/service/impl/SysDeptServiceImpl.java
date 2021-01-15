package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysDeptDao;
import com.sjy.shining.entity.SysDeptEntity;
//import com.sjy.shining.page.Page;
//import com.sjy.shining.page.PageHelper;
import com.sjy.shining.service.SysDeptService;
import com.qiniu.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("SysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {


    public List<SysDeptEntity> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    @Override
    public List<Long> queryDetpIdList(Long parentId) {
        return baseMapper.queryDetpIdList(parentId);
    }

    @Override
    public String getSubDeptIdList(Long deptId) {
        //部门及子部门ID列表
        List<Long> deptIdList = new ArrayList<>();

        //获取子部门ID
        List<Long> subIdList = queryDetpIdList(deptId);
        getDeptTreeList(subIdList, deptIdList);

        //添加本部门
        deptIdList.add(deptId);

        String deptFilter = StringUtils.join(deptIdList, ",");
        return deptFilter;
    }

    /**
     * 递归
     */
    public void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList) {
        for (Long deptId : subIdList) {
            List<Long> list = queryDetpIdList(deptId);
            if (list.size() > 0) {
                getDeptTreeList(list, deptIdList);
            }

            deptIdList.add(deptId);
        }
    }


    public SysDeptEntity getById(Long id){
        return baseMapper.selectById(id);
    }

//    @Override
//    public Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum) {
//        PageHelper.startPage(pageNum, Constant.pageSize);
//        sysDeptDao.queryPageByDto(userWindowDto);
//        return PageHelper.endPage();
//    }
}
