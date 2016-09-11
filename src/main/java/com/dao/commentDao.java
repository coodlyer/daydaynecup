package com.dao;

import com.entity.commentDO;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.sun.tools.corba.se.idl.InterfaceGen;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by liyang on 15/5/21.
 */
public interface commentDao {
    /**
     * 发表评论
     * @param comment
     * @return
     * @throws SQLException
     */
    public Integer insertComment(commentDO comment) throws SQLException;

    /**
     * 查询评论
     */
    public commentDO selectComment(Long comment_id) throws SQLException;
    /**
     * 查询全部评论
     */
    public List<commentDO> selectAllComment() throws SQLException;

    public List<commentDO> selectAllCommentByTime() throws SQLException;
    /**
     * 删除评论
     */
    public Integer deleteComment(Long comment_id) throws SQLException;
    /**
     * 点赞
     */
    public Integer voteComment(commentDO comment) throws SQLException;
}
