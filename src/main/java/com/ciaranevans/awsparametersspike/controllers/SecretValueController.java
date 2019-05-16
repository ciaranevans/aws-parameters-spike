package com.ciaranevans.awsparametersspike.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretValueController {

    @Value("${super.secret.value}")
    private String secretValue;

    @GetMapping("/getSecretValue")
    @ResponseBody
    public String getSecretValue() {
        return "My secret value is: " + secretValue;
    }

}
