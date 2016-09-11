package com.web;

import com.common.IDCreater;
import com.common.Result;
import com.entity.commentDO;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class commentInsert {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/comment/insert",method = RequestMethod.POST)
    public @ResponseBody
    Result insertComment(@RequestBody commentDO comment){
        commentDO com = new commentDO();
        IDCreater creater = new IDCreater();
        long comment_id = creater.createId();
        int vote_num =0;
        com.setContent(comment.getContent());
        com.setDevice_tag(comment.getDevice_tag());
        com.setVote_num(vote_num);
        com.setComment_id(comment_id);
        Result result = commentService.insertComment(com);
        return result;
    }
}
