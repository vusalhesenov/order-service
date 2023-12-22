package az.work.orderservice.exception;


import az.work.orderservice.enums.ResultCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BaseException extends RuntimeException{

    private final ResultCode result;



}
