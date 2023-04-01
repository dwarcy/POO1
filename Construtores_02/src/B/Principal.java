package B;
import java.util.Scanner;

public class Principal {
    public static void main(String a[]){
        Scanner leitor = new Scanner(System.in);
        int h,m,s;
        int opc;

        System.out.println("Insira as horas do relógio: ");
        h = leitor.nextInt();
        m = leitor.nextInt();
        s = leitor.nextInt();

        Tempo t = new Tempo(h,m,s);

        t.mostraHoraCompleta();

        do {
            System.out.println("O que deseja fazer agora:");
            System.out.println("[1] Aumentar Minutos");
            System.out.println("[2] Diminuir Minutos");
            System.out.println("[3] Ver Horas");
            System.out.println("[4] Sair");
            opc = leitor.nextInt();

            switch (opc){
                case 1:
                    t.aumentaMinutos();
                    t.mostraHoraCompleta();
                    break;
                case 2:
                    t.diminuiMinutos();
                    t.mostraHoraCompleta();
                    break;
                case 3:
                    t.mostraHoraCompleta();
                    break;
            }
        }while (opc != 4);

    }
}
