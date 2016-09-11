package com.web;

import com.common.Result;
import com.entity.recordDO;
import com.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liyang on 15/5/22.
 */
@Controller
@RequestMapping("/")
public class recordSelect {
    @Autowired
    RecordService recordService;
    @RequestMapping(value = "/record/query",method = RequestMethod.POST)
    public @ResponseBody
    Result selectRecord(@RequestBody recordDO record){
        String device_tag = record.getDevice_tag();
        Result result  = new Result();
        Result<List<recordDO>> recordResult = recordService.selectRecord(device_tag);
        if(recordResult.isSuccess()){
            result.setSuccess(true);
            result.addParam("recordList",recordResult.getValue());
        }else {
            result.setError(recordResult.getError());
        }
        return result;
    }
}
