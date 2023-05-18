package spaceInvaders.terceiros;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Explosao {
	private BufferedImage imagem;
	private int x, y;
	private int duracao;
	private int linha;
	private int coluna;
	private int animacaoTotal;
	
	public Explosao(int x, int y) {
		loadImage();
		this.x = x;
		this.y = y;
		
		duracao = 0;
		animacaoTotal = 16;
		
		linha = 0;
		coluna = 0;
	}

	private void loadImage() {
		imagem = null;
		try {
			imagem = ImageIO.read(new File("imagens/Explosion03.png"));
		} catch(IOException e) {
			System.out.println("Não foi possível carregar a imagem do inimigo  ");
			e.printStackTrace();
		}
	}

	public void atualizar() {
		duracao++;
		
		linha = duracao / 4;
		coluna = duracao  % 4;
	}
	
	public void pintar(Graphics2D g) {
	// 512 X 512
		g.drawImage(imagem, x, y, x + 100, y + 100, 128 * coluna, 128 * linha, 128 * coluna + 128, 128 * linha + 128, null);
	}
	
	public boolean acabou() {
		if(duracao >= animacaoTotal) {
			return true;
		} else return false;
	}
}
