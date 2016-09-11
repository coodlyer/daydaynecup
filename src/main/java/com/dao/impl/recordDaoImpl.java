package com.dao.impl;

import com.dao.recordDao;
import com.entity.recordDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by liyang on 15/5/21.
 */
public class recordDaoImpl extends SqlMapClientDaoSupport implements recordDao {
    private static String NS = "record.";
    @Override
    public Long insertRecord(recordDO record) throws SQLException {
        return (Long) this.getSqlMapClientTemplate().insert(NS+"insertRecord",record);
    }

    @Override
    public List<recordDO> selectRecord(String device_tag) throws SQLException {
        List<recordDO> record = this.getSqlMapClientTemplate().queryForList(NS + "selectRecord", device_tag);
        return record;
    }

    @Override
    public Integer updateRecord(recordDO record) throws SQLException {
        return (Integer) this.getSqlMapClientTemplate().update(NS+"updateRecord",record);
    }

    @Override
    public Integer deleteRecord(Long rid) throws SQLException {
        return (Integer) this.getSqlMapClientTemplate().delete(NS+"deleteRecord",rid);
    }
}
