package az.work.orderservice.model;

import az.work.orderservice.enums.ResultCode;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResult {

    private int code;
    private String message;
    private LocalDateTime time;


    public ApiResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getValue();
        this.time = LocalDateTime.now();
    }

    public ApiResult(int code, String message, LocalDateTime time) {
        this.code = code;
        this.message = message;
        this.time = LocalDateTime.now();
    }
}
