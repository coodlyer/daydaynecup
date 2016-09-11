package com.web;

import com.common.IDCreater;
import com.common.Result;
import com.entity.recordDO;
import com.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liyang on 15/5/21.
 */
@Controller
@RequestMapping("/")
public class recordInsert {
    @Autowired
    RecordService recordService;
    @RequestMapping("/record/insert")
    public @ResponseBody
    Result insertRecord(@RequestBody recordDO record){
        Result result = new Result();
        IDCreater creater = new IDCreater();
        recordDO re = new recordDO();
        long rid = creater.createId();
        re.setRid(rid);
        re.setAm_done(record.getAm_done());
        re.setDevice_tag(record.getDevice_tag());
        re.setPm_done(record.getPm_done());


        Result recordResult =recordService.insertRecord(re);
        if(recordResult.isSuccess()){
            result.addParam("rid",recordResult.getValue());
        }else{
            result.setError(recordResult.getError());
        }
        return result;
    }
}
