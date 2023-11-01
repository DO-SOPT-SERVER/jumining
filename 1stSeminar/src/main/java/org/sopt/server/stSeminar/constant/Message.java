package org.sopt.server.stSeminar.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Message {
    success("OK"),
    fail("FAIL");

    private final String message;
}
