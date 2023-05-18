package spaceInvaders.entidades;

import java.awt.Graphics2D;
import java.io.*;
import javax.imageio.ImageIO;

import spaceInvaders.main.Main;
import spaceInvaders.main.SpaceInvaders;
import spaceInvaders.terceiros.Tiro;

public class Nave extends Entidade{
	private SpaceInvaders spaceInvaders;
	private boolean left, right, atirando;
	private int tempo;
	
	public Nave(SpaceInvaders spaceInvaders) {
		super(683,  Main.monitor.getHeight() - 150);
		loadImage();
		velocidade = 3;
		this.spaceInvaders = spaceInvaders;
		tempo = 0;
	}

	@Override
	public void loadImage(){
		try {
			sprite = ImageIO.read(new File("imagens/NicePng_spaceship-png_138961.png"));
		} catch(IOException e) {
			System.out.println("Não foi possível carregar a imagem da nave");
			e.printStackTrace();
		}
	}

	@Override
	public void pintar(Graphics2D g) {
		g.drawImage(sprite,												// Imagem a ser desenhada 
					x, Main.monitor.getHeight() - 150, 					// Posição x e y da imagem
					x + 100, Main.monitor.getHeight() - 150 + 100, 		// Tamanho da imagem
					0, 0, 												// Canto da imagem original
					sprite.getWidth(), sprite.getHeight(), 				// Tamanho da imagem original
					null); 		
	}

	@Override
	public void atualizar(){
		atualizaPos();
		atualizaTiro();
	}

	private void atualizaTiro() {
		if(atirando && tempo == 0){
			atirar();
		}
		tempo++;
		if(tempo == 30){
			tempo = 0;
		}
	}

	public void atirar() {		//49 é o meio da nave
		spaceInvaders.tiros.add(new Tiro(x + 49, Main.monitor.getHeight() - 150));
	}

	private boolean colideComCantoTela(int x){
        if(x <= 0 || x >= Main.monitor.getWidth() - 90){
            return true;
        }
        return false;
    }
	
	public void atualizaPos() {
		if(right && !colideComCantoTela(x + 15)) {
			x += velocidade;
		}else{
			x -= 5;
		}
		if(left && !colideComCantoTela(x)) {
			x -=velocidade;
		}else{
			x += 5;
		}
	}

	public void setLeft(boolean left){
		this.left = left;
	}

	public void setRight(boolean right){
		this.right = right;
	}

	public boolean getLeft(){
		return left;
	}

	public boolean getRight(){
		return right;
	}

	public boolean getAtirando(){
		return atirando;
	}

	public void setAtirando(boolean atirando){
		this.atirando = atirando;
	}
}	
