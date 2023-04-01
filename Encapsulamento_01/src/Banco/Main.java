package Banco;
import java.util.Scanner;

public class Main {
    public static void main(String a[]){
        Cliente[] clientes = new Cliente[10];
        Scanner leitor = new Scanner(System.in);

        int opc = -1;
        int contadorClientes = 0;

        while (opc != 0) {
            System.out.println("=== MENU ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Clientes negativados");
            System.out.println("3 - Clientes com idade em intervalo");
            System.out.println("0 - Sair");
            opc = leitor.nextInt();
            leitor.nextLine();
            String tipo;
            float saldo;
            String nome, CPF, telefone;
            int idade;
            String usr,sen;
            Cliente c;

            switch (opc){
                case 1:
                    System.out.print("Tipo da Conta: ");
                    tipo = leitor.nextLine();
                    System.out.print("Saldo inicial: ");
                    saldo = leitor.nextFloat();
                    leitor.nextLine();
                    System.out.print("Nome: ");
                    nome = leitor.nextLine();
                    System.out.print("CPF: ");
                    CPF = leitor.nextLine();
                    System.out.print("Telefone: ");
                    telefone = leitor.nextLine();
                    System.out.print("Idade: ");
                    idade = leitor.nextInt();
                    leitor.nextLine();
                    System.out.print("Usuario: ");
                    usr = leitor.nextLine();
                    System.out.print("Senha: ");
                    sen = leitor.nextLine();
                    Conta c1 = new Conta();
                    c1.cadastraConta(tipo, usr, sen, saldo);
                    Cliente cli1 = new Cliente();
                    cli1.cadastrarCliente(nome, CPF, idade, telefone, c1);
                    clientes[contadorClientes] = cli1;
                    contadorClientes++;
                    break;
                case 2:
                    System.out.println("=== Clientes negativados ===");
                    for (int i=0;i<Cliente.contador;i++) {
                        if (clientes[i].estaNegativado())
                            System.out.println(clientes[i].mostrarDadosCliente());
                    }
                    break;
                case 3:
                    System.out.print("Idade inicial: ");
                    int idi = leitor.nextInt();
                    leitor.nextLine();
                    System.out.print("Idade final: ");
                    int idf = leitor.nextInt();
                    leitor.nextLine();
                    System.out.println("Clientes com idade entre "+idi+" e "+idf+" anos:");
                    for (int i=0;i<Cliente.contador;i++) {
                        if ((clientes[i].idade >= idi) &&
                                (clientes[i].idade <= idf))
                            System.out.println(clientes[i].mostrarDadosCliente());
                    }
            }
    }
}}
