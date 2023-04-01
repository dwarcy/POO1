package Banco;

public class Conta {
    static int contador = 0;
    String tipo;
    float saldo;
    int num;
    String usuario,senha;

    public void cadastraConta(String t, String usuar, String sen, float sald){
        tipo = t;
        usuario = usuar;
        senha = sen;
        if (sald >= 500) saldo = sald;
        else saldo = 500;

        num = contador;
        contador++;
    }

    public void mostraSaldo(){
        System.out.println("O saldo da conta numero "+num+", do tipo ("+tipo+") eh "+saldo+"reais.");
    }

    public boolean sacar(float valor){
        if (valor <= (saldo+100)){
            saldo -= valor;
            return true;
        } else
            return false;
    }

    public boolean depositar(float valor){
        saldo += valor;
        return true;
    }

    public boolean ehNegativo(){
        return (saldo < 0);
    }

    public void tranferir(float valor, Conta c){
        //checa se há o valor a ser transferido na cconta
        if (sacar(valor)){
            c.depositar(valor);
            System.out.println("Transferencia concluida.");
        } else
            System.out.println("Erro na operação. Transferencia Cancelada.");
    }
}
