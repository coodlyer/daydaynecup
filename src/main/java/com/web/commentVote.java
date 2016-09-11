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

/**
 * Created by liyang on 15/5/21.
 */
@Controller
@RequestMapping("/")
public class commentVote {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/comment/vote",method = RequestMethod.POST)
    public @ResponseBody
    Result voteComment(@RequestBody commentDO comment){
        long comment_id = comment.getComment_id();
        Result result = new Result();
        Result<commentDO> commentResult = commentService.votaComment(comment_id);
        if(commentResult.isSuccess()) {
            result.addParam("commentDO", commentResult.getValue());
        }else{
            result.setError(commentResult.getError());
        }
        return result;
    }
}
