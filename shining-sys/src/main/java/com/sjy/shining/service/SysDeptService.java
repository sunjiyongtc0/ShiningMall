package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *
 */
public interface SysDeptService extends IService<SysDeptEntity> {


    List<SysDeptEntity> queryList(Map<String, Object> map);
    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

    /**
     * 获取子部门ID(包含本部门ID)，用于数据过滤
     */
    String getSubDeptIdList(Long deptId);

    SysDeptEntity getById(Long id);

    /**
     * 分页查询组织审批选择范围
     * @return
     */
//    Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum);
}
