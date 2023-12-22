package az.work.orderservice.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResultCode {
    PRODUCT_NOT_STOCK(-1,"product not in stock please try again later");

    private int code;
    private String value;

}
