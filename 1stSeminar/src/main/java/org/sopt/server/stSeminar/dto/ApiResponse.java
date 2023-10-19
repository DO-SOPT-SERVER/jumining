package org.sopt.server.stSeminar.dto;

import lombok.Builder;
import lombok.Getter;
import org.sopt.server.stSeminar.constant.Message;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ApiResponse {
    private final Integer code;
    private final String status;
    private final Boolean success;

    public static ApiResponse success() {
        return ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .status(Message.success.toString())
                .success(true)
                .build();
    }

    public static ApiResponse fail() {
        return ApiResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(Message.fail.toString())
                .success(false)
                .build();
    }
}
