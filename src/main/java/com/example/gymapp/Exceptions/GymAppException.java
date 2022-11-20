package com.example.gymapp.Exceptions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@NoArgsConstructor
public class GymAppException extends  RuntimeException{
    @Serial
    private static final long serialVersionUID = -6366875128444607109L;
    private  String message;
    private  String code;


    public GymAppException(final String message,final  String code,final Throwable cause){
        super(message,cause);
        this.message = message;
        this.code = code;
    }

    public GymAppException(String message, String code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public GymAppException(String message){
        super(message);
        this.message = message;
    }
}
