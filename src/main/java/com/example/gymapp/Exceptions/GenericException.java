package com.example.gymapp.Exceptions;

import com.example.gymapp.Enums.GymAppErrorCode;

public class GenericException extends  GymAppException{

    public GenericException(){
        super("Generic exception occurred", GymAppErrorCode.GENERIC_EXCEPTION.getErrorCode());
    }

    public GenericException(String message) {
        super(message, GymAppErrorCode.GENERIC_EXCEPTION.getErrorCode());
    }

    public GenericException(String message, Throwable e){
        super(message,GymAppErrorCode.GENERIC_EXCEPTION.getErrorCode(),e);
    }
}
