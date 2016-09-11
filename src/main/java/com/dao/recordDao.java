package com.dao;

import com.entity.recordDO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by liyang on 15/5/21.
 */
public interface recordDao {
    public Long insertRecord(recordDO record) throws SQLException;

    public List<recordDO> selectRecord(String device_tag) throws SQLException;

    public Integer updateRecord(recordDO record) throws SQLException;

    public Integer deleteRecord(Long rid) throws SQLException;
}
