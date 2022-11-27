package com.example.gymapp.Exceptions;

import com.example.gymapp.Enums.GymAppErrorCode;
import com.example.gymapp.Exceptions.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.example.gymapp.Utils.GymAppUtils.getCurrentTimestampStringInUTC;

@ControllerAdvice
public class GymAppHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(NotFoundException e){
        ApiError apiError = new ApiError(
                e.getMessage(),
                GymAppErrorCode.DUMMY_NOT_FOUND.getErrorCode(),
                getCurrentTimestampStringInUTC()
        );
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ApiError> handleGenericException(GenericException e){
        ApiError apiError = new ApiError(
                e.getMessage(),
                GymAppErrorCode.GENERIC_EXCEPTION.getErrorCode(),
                getCurrentTimestampStringInUTC()
        );
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
