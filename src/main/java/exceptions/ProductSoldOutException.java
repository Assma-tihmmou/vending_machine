package exceptions;

public class ProductSoldOutException extends Exception{
    ProductSoldOutException(String message){
        super(message);
    }
}
