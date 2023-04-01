package Banco;

public class Cliente {
    String nome;
    String cpf;
    int idade;
    String telefone;
    static int contador = 0;
    Conta conta;

    public Conta getConta(){
        return conta;
    }

    public void cadastrarCliente(String n,String cp,int i,String t,Conta c){
        this.nome = n;
        this.cpf = cp;
        this.idade = i;
        this.telefone = t;
        conta = c;
        contador++;
    }

    public String mostrarDadosCliente(){
        String r = "";
        r += conta.num+" ";
        r += nome+" ";
        r += conta.saldo;

        return r;
    }

    public boolean estaNegativado(){
        return conta.ehNegativo();
    }
}
