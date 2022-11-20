package com.example.gymapp.Exceptions;

import com.example.gymapp.Entities.Enums.GymAppErrorCode;

public class NotFoundException extends  GymAppException{

    public NotFoundException(){
        super("Dummy entinty not found", GymAppErrorCode.DUMMY_NOT_FOUND.getErrorCode());
    }

    public NotFoundException(String message) {
        super(message, GymAppErrorCode.DUMMY_NOT_FOUND.getErrorCode());
    }

    public  NotFoundException(String message,Throwable e){
        super(message,GymAppErrorCode.DUMMY_NOT_FOUND.getErrorCode(),e);
    }
}
