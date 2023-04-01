package A;

import java.util.Scanner;

public class Principal {
    public static void main(String a[]){
        Maquina m = new Maquina(3);
        Scanner leitor = new Scanner(System.in);
        int op;

        do {
            System.out.println("==== MENU ====");
            System.out.println("[1] Comprar Ticket");
            System.out.println("[2] Verificar Montante");
            System.out.println("[3] Sair");
            System.out.print("Opcao: ");
            op = leitor.nextInt();

            switch (op){
                case 1:
                    //escolheu comprar ticket
                    System.out.println("- Valor do Ticket: "+m.getPreco());
                    System.out.println("Insira o dinheiro:");
                    int dinheiro = leitor.nextInt();
                    m.insereDinheiro(dinheiro);
                    break;
                case 2:
                    //verifica montante
                    m.mostraDados();
                    break;
            }

        } while (op != 3);

    }
}
