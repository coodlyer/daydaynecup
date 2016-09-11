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

/**
 * Created by liyang on 15/5/22.
 */
@Controller
@RequestMapping("/")
public class recordUpdate {
    @Autowired
    RecordService recordService;
    @RequestMapping(value = "/record/update",method = RequestMethod.POST)
    public @ResponseBody
    Result updateRecord(@RequestBody recordDO record){
        Result result ;
        result = recordService.updateRecord(record);
        return result;

    }
}
