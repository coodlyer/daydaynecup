package com.service.impl;

import com.common.Result;
import com.dao.commentDao;
import com.entity.commentDO;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by liyang on 15/5/21.
 */
public class CommentServiceImpl implements CommentService {
    @Autowired
    commentDao commentDao;
    @Override
    public Result<?> insertComment(commentDO comment) {
        Result<?> result = new Result<Object>();
        try{
            commentDao.insertComment(comment);
        }catch (SQLException e){
            result.setError("1000");
            return result;
        }
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result<commentDO> selectComment(Long comment_id) {
        Result<commentDO> commentResult = new Result<commentDO>();
        commentDO comment;
        try{
            comment = commentDao.selectComment(comment_id);
        }catch (SQLException e){
            commentResult.setError("1000");
            return commentResult;
        }
        if(comment!=null){
            commentResult.setSuccess(true);
            commentResult.setValue(comment);
        }else{
            commentResult.setError("1000");
            return commentResult;
        }
        return commentResult;

    }

    @Override
    public Result<List<commentDO>> selectAllComment() {
        Result<List<commentDO>> commentResult = new Result<List<commentDO>>();
        List<commentDO> list ;
        try{
            list = commentDao.selectAllComment();
        }catch (SQLException e){
            commentResult.setError("1000");
            return commentResult;
        }
        commentResult.setSuccess(true);
        commentResult.setValue(list);
        return commentResult;
    }

    @Override
    public Result<List<commentDO>> selectAllCommentByTime() {
        Result<List<commentDO>> commentResult = new Result<List<commentDO>>();
        List<commentDO> list;
        try{
            list = commentDao.selectAllCommentByTime();
        }catch (SQLException e){
            commentResult.setError("1000");
            return commentResult;
        }
        commentResult.setSuccess(true);
        commentResult.setValue(list);
        return commentResult;
    }

    @Override
    public Result<commentDO> votaComment(Long comment_id) {
        Result<commentDO> result = new Result<commentDO>();
        commentDO comment = new commentDO();
        try{
            comment = commentDao.selectComment(comment_id);
        }catch (SQLException e){
            result.setError("1000");
            return result;
        }
        if(comment!=null){
            int vote_num=comment.getVote_num();
            comment.setVote_num(vote_num+1);
            try{
                commentDao.voteComment(comment);
            }catch (SQLException e){
                result.setError("1000");
                return result;
            }
            try{
                comment = commentDao.selectComment(comment_id);
            }catch (SQLException e){
                result.setError("1000");
                return result;
            }
            result.setSuccess(true);
            result.setValue(comment);
            return result;
        }else{
            result.setError("1000");
            return result;
        }

    }

    @Override
    public Result<?> deleteComment(Long comment_id) {
        Result<?> result = new Result<Object>();
        try{
            commentDao.deleteComment(comment_id);
        }catch (SQLException e){
            result.setError("1000");
            return result;
        }
        result.setSuccess(true);
        return result;
    }

}
