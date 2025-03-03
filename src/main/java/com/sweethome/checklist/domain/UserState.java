package com.sweethome.checklist.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UserState {

    INACTIVE(0),
    ACTIVE(1)
    ;

    UserState(int code) {
        this.code = code;
    }

    private final int code;

    public static UserState fromCode(int code) {
        return Arrays.stream(UserState.values()).filter(userState -> userState.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid user state code: " + code));
    }
}
