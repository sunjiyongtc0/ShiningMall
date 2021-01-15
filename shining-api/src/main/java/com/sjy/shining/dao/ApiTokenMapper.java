package com.sjy.shining.dao;

import com.sjy.shining.entity.TokenEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Token
 *
 */
@Mapper
public interface ApiTokenMapper extends BaseDao<TokenEntity> {

    TokenEntity queryByUserId(@Param("userId") Long userId);

    TokenEntity queryByToken(@Param("token") String token);

}
