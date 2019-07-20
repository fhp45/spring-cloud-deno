package com.fhp.configclient.controller;

import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/getConfig")
    public String getConfig(){
        return foo;
    }
}
