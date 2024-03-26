package com.D7.myPet.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusinessExeption extends RuntimeException{

    public BusinessExeption(){
        super();
    }
    public BusinessExeption(String message){
        super(message);
    }
    public BusinessExeption(Throwable cause){
        super(cause);
    }
    public BusinessExeption(String message, Throwable cause){
        super(message, cause);
    }
}
