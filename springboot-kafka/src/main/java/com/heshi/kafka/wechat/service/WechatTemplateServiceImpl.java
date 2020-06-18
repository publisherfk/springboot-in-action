package com.heshi.kafka.wechat.service;

import com.alibaba.fastjson.JSONObject;
import com.heshi.kafka.wechat.config.WechatTemplateProperties;
import com.heshi.kafka.wechat.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class WechatTemplateServiceImpl implements IWechatTemplateService {
    @Autowired
    private WechatTemplateProperties wechatTemplateProperties;
    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public WechatTemplateProperties.WechatTemplate getWechatTemplate() {
        List<WechatTemplateProperties.WechatTemplate> templates = wechatTemplateProperties.getTemplates();
        return templates.stream().filter(template -> template.isActive()).findAny().get();
    }

    @Override
    public void templateReported(JSONObject reportInfo) {
        log.info("templateReported:[{}]", reportInfo);
        String topicName = "wechat-topic";
        String templateId = reportInfo.getString("templateId");
        ProducerRecord<String, Object> record = new ProducerRecord<>(topicName, templateId, reportInfo.getJSONArray("result"));
        kafkaProducer.send(record);
    }

    @Override
    public JSONObject templateStatistics(String templateId) {
        if (wechatTemplateProperties.getTemplateResultType() == 0) {
            Optional<JSONObject> optional = FileUtils.readFile2JsonObject(wechatTemplateProperties.getTemplateResultFilePath());
            if (optional.isPresent()) {
                return optional.get();
            }
        } else {
            // TODO  from db
        }
        return null;
    }
}
