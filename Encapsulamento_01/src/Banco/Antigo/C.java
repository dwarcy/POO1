package Banco.Antigo;

public class C {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;

    public void cadastrarCliente(String n,String c,int i,String t){
        this.nome = n;
        this.cpf = c;
        this.idade = i;
        this.telefone = t;
    }

    public void mostrarDadosCliente(){
        System.out.println("=======DADOS DO CLIENTE=======");
        System.out.println("Nome\t\t: "+this.nome);
        System.out.println("CPF\t\t\t: "+this.cpf);
        System.out.println("Idade\t\t: "+this.idade);
        System.out.println("Telefone\t: "+this.telefone);
        System.out.println("=============================");
    }
}
