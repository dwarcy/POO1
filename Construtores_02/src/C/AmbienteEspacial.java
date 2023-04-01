package C;
import java.util.Scanner;

public class AmbienteEspacial {
    NaveEspacial v[] = new NaveEspacial[5]; //se v[i]=1, então está preenchido
    int op, posicao=0;
    int contador;
    Scanner leitor = new Scanner(System.in);

    public void menu(){
        do {
            System.out.println(" ");
            System.out.println("[1] Criar Nova Nave");
            System.out.println("[2] Exibir Naves Existentes");
            System.out.println("[3] Parar Nave");
            System.out.println("[4] Ligar Nave");
            System.out.println("[5] Comparar Velocidade");
            System.out.println("[0] Sair");
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    criarNave();
                    break;
                case 2:
                    exibeNaves();
                    break;
                case 3:
                    exibeNaves();
                    System.out.println(" ");
                    System.out.println("Qual nave desejar parar?");
                    int x = leitor.nextInt();
                    pararNave(x);
                    break;
                case 4:
                    for (int i = 0; i<posicao; i++){
                        if (v[i].getVelocidade() != 0) contador++;
                    }
                    if (contador >= 3){
                        System.out.println("Superpopulacao de Naves!");
                    } else {
                        exibeNaves();
                        System.out.println(" ");
                        System.out.println("Qual nave desejar ligar?");
                        int y = leitor.nextInt();
                        ligarNave(y);
                    }
                case 5:
                    exibeNaves();
                    System.out.println("Qual nave deseja selecionar.");
                    int a = leitor.nextInt();
                    System.out.println("Com qual nave quer comparar?");
                    int b = leitor.nextInt();
                    if (v[a-1].naveMaisRapida(v[b-1]) == true){
                        System.out.println("A nave "+v[a-1].getNome()+" esta mais rapida.");
                    } else {
                        System.out.println("A nave "+v[a-1].getNome()+" esta mais lenta.");
                    };
            }
        }while (op != 0);
    }

    public void criarNave(){
        if (posicao == 5){
            System.out.println("Limite de Naves Atingido!");
        } else {
            System.out.println("-- Informe o nome da nave --");
            leitor.nextLine();
            String n = leitor.nextLine();
            v[posicao] = new NaveEspacial(n);
            posicao++;
            System.out.println("Nave criada.");
        }
    }

    public void exibeNaves() {
        System.out.println(" ");
        for (int i = 0;i < posicao;i++){
            if (v[i].getVelocidade() == 0){
                System.out.println("==========NAVE "+(i+1)+"===============");
                System.out.println("--Nome da Nave: "+v[i].getNome());
                System.out.println("--NAVE INOPERANTE--");
            } else {
                System.out.println("==========NAVE " + (i + 1) + "===============");
                System.out.println("--Nome da Nave: " + v[i].getNome());
                System.out.println("--Velocidade da Nave: " + v[i].getVelocidade());
            }
        }
    }

    public void pararNave(int x){
        v[x-1].setVelocidade(0);
        System.out.println("--Velocidade da nave "+v[x-1].getNome()+" alterada.");
        System.out.println("--Velocidade atual: "+v[x-1].getVelocidade());
        System.out.println(" ");
    }

    public void ligarNave(int y){
        System.out.println("Informe qual a velocidade da Nave:");
        int m = leitor.nextInt();
        v[y-1].setVelocidade(m);
        System.out.println("--Velocidade da nave "+v[y-1].getNome()+" alterada.");
        System.out.println("--Velocidade atual: "+v[y-1].getVelocidade());
        System.out.println(" ");
    }

}
