package org.sopt.server.stSeminar.controller;

import org.sopt.server.stSeminar.dto.ApiResponse;
import org.sopt.server.stSeminar.dto.HealthCheckResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthCheckV3() {
        return "OK";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthCheckV5() {
        return ResponseEntity.ok(HealthCheckResponse.ok());
    }

    // 심화과제 - 추가한 부분
    @GetMapping("/v6")
    public ApiResponse healthCheckV6() {
        return ApiResponse.success();
    }

    @GetMapping("/v7")
    public ApiResponse healthCheckV7() {
        return ApiResponse.fail();
    }
}