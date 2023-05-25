package B;

public class MoneyException extends Exception{
    public MoneyException(){
        super("Saldo Insuficiente!");
    }
    public MoneyException(String msg){
        super(msg);
    }
}
