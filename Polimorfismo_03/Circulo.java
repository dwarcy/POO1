public class Circulo extends FormaBidimensional{
    private int raio;

    public Circulo(int x, int y, int r){
        super(x,y);
        this.raio = r;
    }
    public int obterArea(){
        return (int) (3.14*(raio*raio));
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public int getRaio() {
        return raio;
    }
}
