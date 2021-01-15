package com.sjy.shining.dao;

import com.sjy.shining.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Dao
 *
 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {

    public int deleteByParentBatch(Object[] id);
}
