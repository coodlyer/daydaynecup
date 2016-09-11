package com.entity;

import java.util.Date;

/**
 * Created by liyang on 15/5/20.
 */
public class commentDO {
    private Long comment_id;
    private String device_tag;
    private String content;
    private Integer vote_num;
    private Date gmt_create;

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getDevice_tag() {
        return device_tag;
    }

    public void setDevice_tag(String device_tag) {
        this.device_tag = device_tag;
    }

    public Integer getVote_num() {
        return vote_num;
    }

    public void setVote_num(Integer vote_num) {
        this.vote_num = vote_num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }
}
