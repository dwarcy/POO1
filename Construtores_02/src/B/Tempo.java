package B;
import java.util.Scanner;

public class Tempo {
    int hora, minuto, segundo;

    public Tempo(int h, int m, int s){
        setHora(h);
        setMinuto(m);
        setSegundo(s);
    }

    public void setHora(int h) {
        if (h > 23 || h < 00){
            this.hora = 00;
        } else {
            this.hora = h;
        }
    }

    public int getHora(){
        return this.hora;
    }

    public void setMinuto(int m){
        if (m > 59) {
            this.minuto = 00;
        } if (m < 00){
            this.minuto = 59;
        } else this.minuto = m;
    }

    public int getMinuto(){
        return this.minuto;
    }

    public void setSegundo(int s){
        if (s > 59){
            this.segundo = 00;
        } if (s < 00){
            this.segundo = 59;
        } else this.segundo = s;
    }

    public int getSegundo(){
        return this.segundo;
    }

    public void mostraHoraSimples(){
        System.out.printf("%d%d%d\n",getHora(),getMinuto(),getSegundo());
    }

    public void mostraHoraCompleta(){
        System.out.printf("%d:%d:%d\n",getHora(),getMinuto(),getSegundo());
    }

    public void aumentaMinutos(){
        int m, h;
        minuto++;
        if (minuto > 59){
            m = minuto;
            setMinuto(m);
            hora++;
            if (hora > 23){
                h = hora;
                setHora(h);
            }
        }

        System.out.println("Hora Alterada.");
    }

    public void diminuiMinutos(){
        int m, h;
        minuto--;
        if (minuto<00){
            m = minuto;
            setMinuto(m);
            hora--;
            if (hora < 00){
                h = hora;
                setHora(h);
            }
        }

        System.out.println("Hora Alterada.");
    }
}
