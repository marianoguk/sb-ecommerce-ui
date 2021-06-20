package com.sb.ecommerceui.infrastructure.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsHealthChecker {
    @GetMapping("/")
    public String status() {
        return "OK";
    }
}
