package PontoeCirculo;

public class Main {
    public static void main(String[] args) {
        /*Ponto p = new Ponto();
        Ponto p2 = new Ponto();

        p.inicializa(3.2,1.0);
        p.mostra();

        p2.inicializa(1.0,2.1);
        p2.mostra();

        System.out.printf("A distancia do ponto A para o ponto B eh %.2f", p.distancia(p2));
        */
        Circulo c = new Circulo();

        c.inicializar(2.1,1.0,5.0);
        c.exibirDados();
        c.modificaNome("Primeiro");
    }
}