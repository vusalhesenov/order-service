package az.work.orderservice.exception;

public class ProductException extends BaseException{

    private String msg;
    public ProductException(String msg) {
        this.msg = msg;
    }

    public static ProductException productNotFound(){
        return new ProductException("product not in stock please try again later");
    }

}
