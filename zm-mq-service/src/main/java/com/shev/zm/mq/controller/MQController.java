package com.shev.zm.mq.controller;

import com.alibaba.fastjson.JSONObject;
import com.shev.mq.activemq.service.ActiveMQProducer;
import com.shev.zm.mq.common.MqQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.Topic;
import java.util.Date;
import java.util.Map;

@RequestMapping("/mq")
@RestController
public class MQController
{

    @Autowired
    private ActiveMQProducer activeMQProducer;

    @Autowired
    private Topic myTopic;


    @PostMapping("/sendActiveMQ")
    @ResponseBody
    public String sendActiveMQ(@RequestBody String request)
    {
        Map<String, String> params = (Map<String, String>) JSONObject.parse(request);
        activeMQProducer.sendMessage(MqQueue.ACTIVE_MQ_MY_QUEUE, params.get("context"));
        activeMQProducer.sendTopicMessage(myTopic, params.get("context"));
        return "success";
    }

    @GetMapping("/getSystemTime")
    public Long getSystemTime()
    {
        return new Date().getTime();
    }
}
