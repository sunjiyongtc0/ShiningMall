package com.sjy.shining.dao;


import com.sjy.shining.entity.ResultMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * oracle代码生成器
 */
@Mapper
public interface SysOracleGeneratorDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<ResultMap> queryColumns(String tableName);
}
