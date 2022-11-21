package com.example.gymapp.Entities.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum GymAppErrorCode {
    DUMMY_NOT_FOUND("DUMMY_NOT_FOUND"),
    GENERIC_EXCEPTION("GENERIC_EXCEPTION"),
    REPO_ERROR("REPO_ERROR");

    private String errorCode;
}
