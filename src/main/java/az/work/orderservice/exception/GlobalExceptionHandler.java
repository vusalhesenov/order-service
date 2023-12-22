package az.work.orderservice.exception;

import az.work.orderservice.enums.ResultCode;
import az.work.orderservice.model.ApiResult;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BaseException.class)
    public ApiResult dataNotFoundException(BaseException exception) {
        return new ApiResult(exception.getResult());
    }
}
