public class Triangulo extends FormaBidimensional{

    public Triangulo(int x, int y, int b, int a){
        super(x,y);
        this.setBase(b);
        this.setAltura(a);
    }
    public int obterArea(){
        return (getBase()*getAltura());
    }
}
