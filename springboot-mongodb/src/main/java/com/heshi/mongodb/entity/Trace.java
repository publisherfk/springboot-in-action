package com.heshi.mongodb.entity;

import java.io.Serializable;

/**
 * 轨迹信息 NoSql
 *
 * @author ricky
 * @version 1.0.0
 * @date 2020-03-28 12:11
 * @copyright
 */
public class Trace implements Serializable {

    private static final long serialVersionUID = -3507267901728785832L;

    private Long userId;

    private Long timestamp;

    private String latitude;

    private String longitude;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}