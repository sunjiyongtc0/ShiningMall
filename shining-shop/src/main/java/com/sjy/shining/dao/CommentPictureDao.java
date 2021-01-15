package com.sjy.shining.dao;

import com.sjy.shining.entity.CommentPictureEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评价图片Dao
 *
 */
@Mapper
public interface CommentPictureDao extends BaseDao<CommentPictureEntity> {
    /**
     * 根据commentId删除
     *
     * @param commentId
     * @return
     */
    int deleteByCommentId(Integer commentId);
}
