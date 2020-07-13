package com.heshi.kafka.wechat.service;

import com.alibaba.fastjson.JSONObject;
import com.heshi.kafka.wechat.config.WechatTemplateProperties;

public interface IWechatTemplateService {

    /**
     * 获取微信调查问卷模板
     *
     * @return
     */
    WechatTemplateProperties.WechatTemplate getWechatTemplate();

    /**
     * 上报调查问卷填写结果
     *
     * @param reportInfo
     */
    void templateReported(JSONObject reportInfo);

    /**
     * 统计结果
     *
     * @param templateId
     * @return
     */
    JSONObject templateStatistics(String templateId);
}
