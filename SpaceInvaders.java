package spaceInvaders.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import spaceInvaders.entidades.Inimigo;
import spaceInvaders.entidades.Nave;
import spaceInvaders.terceiros.Explosao;
import spaceInvaders.terceiros.PlanoDeFundo;
import spaceInvaders.terceiros.Tiro;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener{
	private Font minhaFonte = new Font("Consolas", Font.BOLD, 20);
	private Nave nave;
	public ArrayList<Tiro> tiros;
	private ArrayList<Inimigo> inimigos;
	private ArrayList<Explosao> explosoes;
	private PlanoDeFundo fundo;
	private boolean ganhou;
	private boolean perdeu;
	private final int FPS_SET = 60;
    private final int UPS_SET = 100;
	
	// Construtor chamado quando é executado o new SpaceInvaders();
	public SpaceInvaders() {
		
		nave = new Nave(this);
		tiros = new ArrayList<Tiro>();
		inimigos = new ArrayList<Inimigo>();
		explosoes = new ArrayList<Explosao>();
		fundo = new PlanoDeFundo();
		ganhou = false;
		perdeu = false;

		for(int i = 0; i < 60; i++) {
			inimigos.add(new Inimigo((50 + i % 20 * 75), (50 + i / 20  * 75)));
		}
		
		Thread lacoDoJogo = new Thread(this);
		lacoDoJogo.start();
	}
	
	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long previousTime = System.nanoTime();
        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();
        double deltaU = 0;
        double deltaF = 0;
        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }

            if(deltaF >= 1){
                repaint();
                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.printf("FPS: %d | UPS: %d\n", frames, updates);
                frames = 0;
                updates = 0;
            }
        }
	}
	
	private void update() {
		if(inimigos.size() == 0) {
			ganhou = true;
		}
		
		nave.atualizar();
		
		for(int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).atualizar();
			
			if(inimigos.get(i).getY() >= Main.monitor.getHeight() - 150)
				perdeu = true;
		}
		
		for(int i = 0; i < tiros.size(); i++) {
			tiros.get(i).atualizar();
			
			if(tiros.get(i).destroi()) {
				tiros.remove(i);
				i--;
			}
			else { 
				for(int j = 0; j < inimigos.size(); j++) {
					if(tiros.get(i).colideCom(inimigos.get(j))) {
						explosoes.add(new Explosao(inimigos.get(j).getX(), inimigos.get(j).getY()));
						inimigos.remove(j);
						j--;
						tiros.remove(i);
						break;
					}
				}
			}
			
		}
		
		for(int i = 0; i < inimigos.size(); i++) {
			if(inimigos.get(i).getX() <= 0 || inimigos.get(i).getX() >= Main.monitor.getWidth() - 90) {
				for(int j = 0; j < inimigos.size(); j++) {
					inimigos.get(j).atualizaPos();
				}
				break;
			}
		}
	
		for(int i = 0; i < explosoes.size(); i++) {
			explosoes.get(i).atualizar();
			
			if(explosoes.get(i).acabou()) {
				explosoes.remove(i);
				i--;
			}
		}
	}
	
	int x = 0;
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2); // Limpa a tela
		
		Graphics2D g = (Graphics2D) g2.create();
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		fundo.pinta(g);
		
		// Desenha as explosões
		for(int i = 0; i < explosoes.size(); i++) {
			explosoes.get(i).pintar(g);
		}
		
		// Desenha os inimigos
		for(int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).pintar(g);
		}
			
		// Desenha a nave
		nave.pintar(g);
		
		// Desenha os tiros
		for(int i = 0; i < tiros.size(); i++) {
			tiros.get(i).pintar(g);
		}
		
		if(ganhou) {
			g.setColor(Color.white);
			g.setFont(minhaFonte);
			g.drawString("VOCÊ TERMINOU O JOGO!!!", Main.monitor.getWidth()/2 - 100, Main.monitor.getHeight()/2);	
		}
		
		if(perdeu) {
			g.setColor(Color.white);
			g.setFont(minhaFonte);
			g.drawString("DEPLORÁVEL! Você perdeu...", Main.monitor.getWidth()/2 - 100, Main.monitor.getHeight()/2);	
		}
	}   
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_D:
				nave.setRight(true);
				break;
			case KeyEvent.VK_A:
				nave.setLeft(true);
				break;
			case KeyEvent.VK_SPACE:
				nave.setAtirando(true);
				break;
			default:
				break;
		}

	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_D:
				nave.setRight(false);
				break;
			case KeyEvent.VK_A:
				nave.setLeft(false);
				break;
			case KeyEvent.VK_SPACE:
				nave.setAtirando(false);
				break;
			default:
				break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
