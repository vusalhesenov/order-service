package az.work.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BaseException.class)
    public String productNotInStockException() {
                return "product not in stock please try again later";
    }

}
