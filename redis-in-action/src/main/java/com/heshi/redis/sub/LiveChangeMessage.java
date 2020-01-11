package com.heshi.redis.sub;

public class LiveChangeMessage extends BaseSubMessage {
    private String liveIds;

    public LiveChangeMessage(String json) {
        super(json);
    }

    public String getLiveIds() {
        return liveIds;
    }

    public void setLiveIds(String liveIds) {
        this.liveIds = liveIds;
    }
}
