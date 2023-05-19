public class Cubo extends FormaTridimensional{
    private int lado;
    public Cubo(int x, int y, int z, int l){
        super(x,y,z);
        setLado(l);
    }

    public int obterVolume(){
        return (getLado()*getLado()*getLado());
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }
}
