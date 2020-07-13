package com.heshi.kafka.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heshi.kafka.wechat.common.Result;
import com.heshi.kafka.wechat.config.WechatTemplateProperties;
import com.heshi.kafka.wechat.service.IWechatTemplateService;
import com.heshi.kafka.wechat.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/base/v1")
public class WechatTemplateController {

    @Autowired
    private WechatTemplateProperties wechatTemplateProperties;
    @Autowired
    private IWechatTemplateService wechatTemplateService;

    @GetMapping("/template")
    public Result getTemplate() {
        WechatTemplateProperties.WechatTemplate wechatTemplate = wechatTemplateService.getWechatTemplate();
        Map<String, Object> result = new HashMap<>();
        result.put("templateId", wechatTemplate.getTemplateId());
        result.put("template", FileUtils.readFile2JsonArray(wechatTemplate.getTemplateFilePath()));
        return Result.success(result);
    }

    @GetMapping("/template/result")
    public Result temoateStatistics(@RequestParam(required = false) String templateId) {
        JSONObject jsonObject = wechatTemplateService.templateStatistics(templateId);
        return Result.success(jsonObject);
    }

    @PostMapping("/template/report")
    public Result dataReported(@RequestBody String reportData) {
        wechatTemplateService.templateReported(JSON.parseObject(reportData));
        return Result.success(null);
    }
}
