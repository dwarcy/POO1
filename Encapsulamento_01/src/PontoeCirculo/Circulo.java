package PontoeCirculo;

public class Circulo {
    private double raio;
    private String nome;
    private Ponto centro;
    Ponto pont = new Ponto();

    public void inicializar(double a,double b,double r){
        setRaio(r);
        pont.inicializa(a,b);
    }

    public void setRaio(double r){
        if (r > 0) this.raio = r;
    }

    public double calculaDiametro(){
        return (this.raio*this.raio);
    }

    public double calculaArea(){
        return (3.14*(this.raio*this.raio));
    }

    public double calculaPerimetro(){
        return (2*3.14*this.raio);
    }

    public String modificaNome(String n){
        this.nome = n;

        return this.nome;
    }

    public void exibirDados(){
        System.out.println("============================");
        System.out.printf("Dados do circulo de raio %.2f\n",this.raio);
        System.out.printf("Diametro\t\t: %.2f\n",calculaDiametro());
        System.out.printf("Circuferencia\t: %.2f\n",calculaPerimetro());
        System.out.printf("Area\t\t\t: %.2f\n",calculaArea());
        System.out.println("============================");
    }
}
