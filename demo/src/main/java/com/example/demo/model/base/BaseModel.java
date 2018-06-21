package com.example.demo.model.base;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 基类
 *
 * @author IT_donggua
 * @version V1.0
 */
public class BaseModel{

    private LocalDateTime created;

    private LocalDateTime updated;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "created=" + created +
                ", updated=" + updated +
                '}';
    }
}
