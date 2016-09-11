package com.entity;

import java.util.Date;

/**
 * Created by liyang on 15/5/20.
 */
public class recordDO {
    private Long rid;
    private String device_tag;
    private int am_done;
    private int pm_done;
    private Date record_date;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public int getAm_done() {
        return am_done;
    }

    public void setAm_done(int am_done) {
        this.am_done = am_done;
    }

    public String getDevice_tag() {
        return device_tag;
    }

    public void setDevice_tag(String device_tag) {
        this.device_tag = device_tag;
    }

    public int getPm_done() {
        return pm_done;
    }

    public void setPm_done(int pm_done) {
        this.pm_done = pm_done;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }
}
