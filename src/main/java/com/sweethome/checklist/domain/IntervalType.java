package com.sweethome.checklist.domain;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum IntervalType {

    DAILY(0),
    PERIODIC(1),
    WEEKLY(2)
    ;

    IntervalType(int code) {
        this.code = code;
    }

    private final int code;

    public IntervalType fromCode(int code) {
        return Stream.of(IntervalType.values()).filter(intervalType -> intervalType.getCode() == code).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid IntervalType code: " + code));
    }

}
