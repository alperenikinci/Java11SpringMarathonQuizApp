package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    QUESTION_NOT_FOUND(1001,"Girdiginiz soru bulunamamaktadir.",HttpStatus.NOT_FOUND),
    AT_LEAST_TWO_OPTION(1002,"Her sorunun en az 2 secenegi olmalidir.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(3001,"Bad Request", HttpStatus.BAD_REQUEST),
    NO_QUESTION_FOUND(1003,"Hic soru bulunamadi" ,HttpStatus.NOT_FOUND );

    private int code;
    private  String message;
    private HttpStatus httpStatus;


}