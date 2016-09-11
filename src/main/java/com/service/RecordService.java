package com.service;

import com.common.Result;
import com.entity.recordDO;

import java.util.List;

/**
 * Created by liyang on 15/5/21.
 */
public interface RecordService {
    public Result<?> insertRecord(recordDO record);

    public Result<List<recordDO>> selectRecord(String device_tag);

    public Result<?> updateRecord(recordDO recordDO);

    public Result<?> deleteRecord(Long rid);
}
