package spaceInvaders.entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Inimigo extends Entidade{
	private BufferedImage desenho;
	private int direcao;
	
	public Inimigo(int x, int y) {
		super(x, y);
		loadImage();
		velocidade = 1;
		direcao = 1;
	}
	
	@Override
	public void loadImage() {
		desenho = null;
		try {
			desenho = ImageIO.read(new File("imagens/enemy2.png"));
		} catch (IOException e) {
			System.out.println("Não foi possível carregar a imagem do inimigo  ");
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar() {
		x += velocidade * direcao;
	}

	@Override
	public void pintar(Graphics2D g) {
		g.drawImage(desenho, x, y, x + 100, y + 100, 0, 0, desenho.getWidth(), desenho.getHeight(), null);
	}
	
	@Override
	public void atualizaPos() {
		direcao = direcao * -1;
		y += 25;
		velocidade += 0.25f;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getTam() {
		return 90;
	}
}
