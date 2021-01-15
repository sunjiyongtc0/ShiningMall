package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.shining.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 会员Dao
 */

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    int saveUser(UserEntity userEntity);

    List<UserEntity> queryList(Map<String, Object> map);

    List<UserEntity> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();

    UserEntity queryObject(Object id);
}
