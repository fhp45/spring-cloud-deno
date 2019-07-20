package com.fhp.usercenter.kafka;

import com.fhp.usercenter.log.ControllerLogAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@ControllerLogAccessor(description = "测试kafka日志")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send/{msg}")
    public void send(@PathVariable("msg")  String msg){
        kafkaTemplate.send("test",msg);
    }

}
