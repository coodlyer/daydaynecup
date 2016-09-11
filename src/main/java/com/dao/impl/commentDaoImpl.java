package com.dao.impl;

import com.dao.commentDao;
import com.entity.commentDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by liyang on 15/5/21.
 */
public class commentDaoImpl extends SqlMapClientDaoSupport implements commentDao {
    private static String NS = "comment.";
    @Override
    public Integer insertComment(commentDO comment) throws SQLException {
        return (Integer) this.getSqlMapClientTemplate().insert(NS+"insertComment",comment);
    }

    @Override
    public commentDO selectComment(Long comment_id) throws SQLException {
        commentDO comment= (commentDO) this.getSqlMapClientTemplate().queryForObject(NS+"selecCommentDO",comment_id);
        return comment;
    }

    @Override
    public List<commentDO> selectAllComment() throws SQLException {
        List<commentDO> list = this.getSqlMapClientTemplate().queryForList(NS+"selectAllComment");
        return list;
    }

    @Override
    public List<commentDO> selectAllCommentByTime() throws SQLException {
        List<commentDO> list = this.getSqlMapClientTemplate().queryForList(NS+"selectAllCommentByTime");
        return list;
    }

    @Override
    public Integer deleteComment(Long comment_id) throws SQLException {
        return (Integer) this.getSqlMapClientTemplate().delete(NS+"deleteComment",comment_id);
    }

    @Override
    public Integer voteComment(commentDO comment) throws SQLException {
        return (Integer) this.getSqlMapClientTemplate().update(NS+"voteComment",comment);
    }
}
