package com.sweethome.checklist.domain;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum CheckStatus {

    UNCHECKED(0),
    CHECKED(1);

    CheckStatus(int code) {
        this.code = code;
    }

    private final int code;

    public static CheckStatus fromCode(int code) {
        return Stream.of(CheckStatus.values()).filter(checkStatus -> checkStatus.getCode() == code).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid CheckStatus code: " + code));
    }

}
