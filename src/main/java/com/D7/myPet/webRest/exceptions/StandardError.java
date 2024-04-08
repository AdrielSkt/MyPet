package com.D7.myPet.webRest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {

     private Instant timestamp;
     private Integer status;
     private String error;
     private String message;
     private String path;

}
