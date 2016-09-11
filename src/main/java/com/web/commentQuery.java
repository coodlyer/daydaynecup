package com.web;

import com.common.Result;
import com.entity.commentDO;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liyang on 15/5/21.
 */
@Controller
@RequestMapping("/")
public class commentQuery {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/comment/query",method = RequestMethod.GET)
    public @ResponseBody
    Result queryComment(){
        Result result = new Result();
        Result<List<commentDO>> listByVote = commentService.selectAllComment();
        Result<List<commentDO>> listByTime = commentService.selectAllCommentByTime();
        if(listByTime.isSuccess()&&listByVote.isSuccess()) {
            result.addParam("commentByVote", listByVote.getValue());
            result.addParam("commentByTime", listByTime.getValue());
        }else{
            result.setError("1000");
        }
        return result;
    }
}
