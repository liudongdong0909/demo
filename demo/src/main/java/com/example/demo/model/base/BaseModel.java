package com.example.demo.model.base;

import java.util.Date;

/**
 * 基类
 *
 * @author IT_donggua
 * @version V1.0
 */
public class BaseModel{

    private Date created;

    private Date updated;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
