public class FormaBidimensional extends Forma {
    private int x, y;
    private int base, altura, lado;

    //centro do objeto
    public FormaBidimensional(int m, int n){
        x = m;
        y = n;
    }

    public int obterArea(){
        return (base*altura);
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public int getLado() {
        return lado;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
