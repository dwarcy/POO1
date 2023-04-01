package PontoeCirculo;
import java.util.Scanner;

public class Ponto {
    private double x, y;

    public void inicializa(double a, double b){
        setX(a);
        setY(b);
    }

    public double setX(double a){
        if (a <= 0) this.x = 0;
        else {
            this.x = a;
        }
        return a;
    }

    public double setY(double b){
        if (b <= 0) this.y = 0;
        else {
            this.y = b;
        }
        return b;
    }

    public void mostra(){
        System.out.println("("+this.x+","+this.y+")");
    }

    public double distancia(Ponto q){
        double d_um = q.x - this.x;
        double d_dois = q.y - this.y;
        double dist = (d_um*d_um) + (d_dois*d_dois);

        return (Math.sqrt(dist));
    }
}
