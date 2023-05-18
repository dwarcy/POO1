package spaceInvaders.entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Entidade {
    protected int x, y;
    protected float velocidade;
    protected BufferedImage sprite;

    public Entidade(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected abstract void loadImage();
    protected abstract void atualizar();
    protected abstract void pintar(Graphics2D g);
    protected abstract void atualizaPos();
}
