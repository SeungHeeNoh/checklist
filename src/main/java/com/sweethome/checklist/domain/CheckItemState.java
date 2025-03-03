package com.sweethome.checklist.domain;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum CheckItemState {
    INACTIVE(0),
    ACTIVE(1)
    ;

    CheckItemState(int code) {
        this.code = code;
    }

    private final int code;

    public static CheckItemState fromCode(int code) {
        return Stream.of(CheckItemState.values()).filter(checkItemState -> checkItemState.getCode() == code).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid CheckItemState code: " + code));
    }

}
