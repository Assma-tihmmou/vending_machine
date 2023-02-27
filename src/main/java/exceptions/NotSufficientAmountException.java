package exceptions;

public class NotSufficientAmountException extends Exception{
    NotSufficientAmountException(String meessage){
        super(meessage);
    }
}
