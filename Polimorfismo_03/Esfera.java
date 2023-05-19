public class Esfera extends FormaTridimensional{
    private int raio;

    public Esfera(int x, int y, int z, int r){
        super(x,y,z);
        this.setRaio(r);
    }

    public int obterVolume(){
        return (int) ((4/3)*3.14*(getRaio()*getRaio()*getRaio()));
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public int getRaio() {
        return raio;
    }
}
