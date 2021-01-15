package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.shining.entity.AdEntity;
import com.sjy.shining.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Dao
 *
 */
@Mapper
public interface AdDao  extends BaseMapper<AdEntity> {


    int saveAd(AdEntity adEntity);

    int updateAd(AdEntity adEntity);

    List<AdEntity> queryList(Map<String, Object> map);

    List<AdEntity> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();

    AdEntity queryObject(Object id);

//    int deleteBatch(Integer[]ids);
}
