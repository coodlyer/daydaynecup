package com.service.impl;

import com.common.Result;
import com.dao.recordDao;
import com.entity.recordDO;
import com.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyang on 15/5/21.
 */
public class RecordServiceImpl implements RecordService {
    @Autowired
    recordDao recordDao;
    @Override
    public Result<Long> insertRecord(recordDO record) {
        Result<Long> result = new Result<Long>();
        long rid;
        try{
            rid=recordDao.insertRecord(record);
        }catch (SQLException e){
            result.setError("1000");
            return result;
        }
        result.setSuccess(true);
        result.setValue(rid);
        return result;
    }

    @Override
    public Result<List<recordDO>> selectRecord(String device_tag) {
        Result<List<recordDO>> result = new Result<List<recordDO>>();
        List<recordDO> list ;
        try{
            list=recordDao.selectRecord(device_tag.trim());
        }catch (SQLException e){
            result.setError("1000");
            return result;
        }
        result.setSuccess(true);
        result.setValue(list);
        return result;
    }

    @Override
    public Result<?> updateRecord(recordDO record) {
        Result<?> result = new Result<Object>();
        try{
            recordDao.updateRecord(record);
        }catch (SQLException e){
            result.setError("1000");
        }
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result<?> deleteRecord(Long rid) {
        Result<?> result = new Result<Object>();
        try{
            recordDao.deleteRecord(rid);
        }catch (SQLException e){
            result.setError("1000");
        }
        result.setSuccess(true);
        return result;
    }
}
