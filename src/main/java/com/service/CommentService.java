package com.service;

import com.common.Result;
import com.entity.commentDO;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by liyang on 15/5/21.
 */
public interface CommentService {
    public Result<?> insertComment(commentDO comment);

    public Result<commentDO> selectComment(Long comment_id);

    public Result<List<commentDO>> selectAllComment();

    public Result<List<commentDO>> selectAllCommentByTime();

    public Result<commentDO> votaComment(Long comment_id);

    public Result<?> deleteComment(Long comment_id);
}
