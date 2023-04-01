package C;
import java.util.Random; //gerar numeros aleatorios

public class NaveEspacial {
    private String nome;
    private int velocidade;
    private int min = 5;
    private int max = 10;

    public NaveEspacial(String s){
        this.nome = s;
        this.velocidade = (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public String getNome(){
        return this.nome;
    }

    public int getVelocidade(){
        return this.velocidade;
    }

    public void setVelocidade(int x){
        this.velocidade = x;
    }

    public boolean naveMaisRapida(NaveEspacial n){
        if (this.velocidade > n.getVelocidade()) return true;
        else return false;
    }
}
