package org.sopt.server.stSeminar.dto;

public class HealthCheckResponse {
    private String status;

    public HealthCheckResponse(String status) {
        this.status = status;
    }

    public static HealthCheckResponse ok() {
        return new HealthCheckResponse("OK");
    }
}