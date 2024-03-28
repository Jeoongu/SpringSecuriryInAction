package com.aledma.springsecurity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.swing.plaf.SeparatorUI;
import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class ResponseDto {
    private final Boolean success;
    private final Integer code;
    private final String message;
//    private final LocalDateTime time;

    public static ResponseDto of(Boolean success, Code code){
        return new ResponseDto(success, code.getCode(), code.getMessage());
    }

    public static ResponseDto of(Boolean success, Code errorCode, Exception e){
        return new ResponseDto(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static ResponseDto of(Boolean success, Code errorCode, String message){
        return new ResponseDto(success, errorCode.getCode(), errorCode.getMessage(message));
    }
}
