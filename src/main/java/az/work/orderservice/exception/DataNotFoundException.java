package az.work.orderservice.exception;

import az.work.orderservice.enums.ResultCode;

public class DataNotFoundException extends BaseException{

    private String msg;
    public DataNotFoundException(ResultCode resultCode) {
        super(resultCode);
    }
    public static DataNotFoundException productNotInStockException(){
        return new DataNotFoundException(ResultCode.PRODUCT_NOT_STOCK);
    }


}
