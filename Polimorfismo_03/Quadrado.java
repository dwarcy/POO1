public class Quadrado extends FormaBidimensional{

    public Quadrado(int x, int y, int l){
        super(x,y);
        this.setLado(l);
    }
    public int obterArea(){
        return (getLado()*getLado());
    }


}
