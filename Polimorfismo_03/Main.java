import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Forma vet[] = new Forma[5];
        int op,ct = 0;
        Scanner leitor = new Scanner(System.in);
        do {
            System.out.println("======MENU======");
            System.out.println("[1] Cadastrar Forma");
            System.out.println("[2] Mostrar Formas");
            System.out.println("[3] Mostrar Área Bidimensionais");
            System.out.println("[4] Mostrar Volume Tridimensionais");
            System.out.println("[5] Verificar Intercepcao");
            System.out.println("[0] Sair");
            op = leitor.nextInt();

            switch (op){
                case 1:
                    System.out.println("Deseja cadastrar uma forma Bidimensional ou Tridimensional?");
                    System.out.println("[1]Tridimensional\t\t[2]Bidimensional");
                    int x = leitor.nextInt();
                    if (x == 1) {
                        System.out.println("Deseja Cadastrar: [1]Esfera [2]Cubo [3]Tetraedro");
                        int y = leitor.nextInt();
                        if (y == 1) {
                            vet[ct] = new Esfera(1, 2, 3, 5)
                        }
                        if (y == 2) {
                            vet[ct] = new Cubo(1, 2, 3, 4)
                        }
                        if (y == 3) {
                            vet[ct] = new Tetraedro(1, 2, 3, 2, 3, 4)
                        }
                    }
                    if (x == 2){
                        System.out.println("Deseja Cadastrar: [1]");
                    }
            }

        }while (op != 0);

    }
}