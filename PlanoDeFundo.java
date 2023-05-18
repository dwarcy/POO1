package spaceInvaders.terceiros;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import spaceInvaders.main.Main;


public class PlanoDeFundo {
	private BufferedImage imagem;
	private int y;
	
	public PlanoDeFundo() {
		try {
			imagem = ImageIO.read(new File("imagens/background.png"));
		} catch(IOException e) {
			System.out.println("Não foi possível carregar o fundo");
			e.printStackTrace();
		}
		y = 0;
	}
	
	public void pinta(Graphics2D g) {
		g.drawImage(imagem, 0, y - Main.monitor.getHeight() * 2, Main.monitor.getWidth(), Main.monitor.getHeight(), null);
		
		g.drawImage(imagem, 0, y - Main.monitor.getHeight(), Main.monitor.getWidth(), Main.monitor.getHeight(), null);
		
		g.drawImage(imagem, 0, y, Main.monitor.getWidth(), Main.monitor.getHeight(), null);
		
		y += 3;
		
		if(y > Main.monitor.getHeight() * 2) y = 0;
	}
}
