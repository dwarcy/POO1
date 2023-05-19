public class Tetraedro extends FormaTridimensional{
    private int base, altura, alturaDaBase;

    public Tetraedro(int x, int y, int z, int b, int a, int ab){
        super(x,y,z);
        setBase(b);
        setAltura(a);
        setAlturaDaBase(ab);
    }

    public int obterVolume(){
        return ((1/3)*getAlturaDaBase()*getAltura());
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setAlturaDaBase(int alturaDaBase) {
        this.alturaDaBase = alturaDaBase;
    }

    public int getAlturaDaBase() {
        return alturaDaBase;
    }

    public int getAltura() {
        return altura;
    }
}
