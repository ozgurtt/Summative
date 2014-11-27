//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Panel

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

class Play extends JPanel implements KeyListener, ActionListener, MouseListener {
	
	private Player p = new Player(0,1200,0,730);
	private Background bg = new Background();
	private Obstacle o = new Obstacle();
	private Coin cs = new Coin();
	private PlayerHealth hp = new PlayerHealth();
	private Timer t;
	private boolean goDown = true;
	private int accel = 0;
	private int tDamage = 0;
	private int health = 5;
	private int distance = 0;
	private Test parent;
	private ImageIcon pause1 = new ImageIcon("pause.png");
	private ImageIcon pause2 = new ImageIcon("pauseScreen.png");
	private boolean pause = false;
	
	public Play(Test parent){
		this.parent=parent;
		t = new Timer(35,this);
		t.start();
		addKeyListener(this);
		setFocusable(true);
		addMouseListener(this);
	}
	
	public void up(){
		if(p.y <= 0){
			p.y = 0;
		}
		else{
			p.y -= 35;
		}
	}
	
	public void down(){
		if(p.y >= 560){
			p.y = 560;
		}
		else{
			p.y += ++accel;
		}
	}
	
	public boolean collision(){
		Rectangle player = p.getRect();
		Rectangle obstacle = o.getRect();
		if(player.intersects(obstacle)){
			tDamage ++;
			return true;
		}
		else{
			return false;
		}
	}
	public int ShiftNorth(int p, int distance) {
		return (p - distance);
	}
	public int ShiftSouth(int p, int distance) {
		return (p + distance);
	}
	public int ShiftEast(int p, int distance) {
		return (p + distance);
	}
	public int ShiftWest(int p, int distance) {
		return (p - distance);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		bg.draw(g);		
		p.draw(g);	
		o.draw(g);
		cs.draw(g);
		Font f = new Font("arial", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString(distance+"M", ShiftWest(35, 2), ShiftNorth(30, 2));
		g.drawString(distance+"M", ShiftWest(35, 2), ShiftSouth(30, 2));
		g.drawString(distance+"M", ShiftEast(35, 2), ShiftNorth(30, 2));
		g.drawString(distance+"M", ShiftEast(35, 2), ShiftSouth(30, 2));
		g.setColor(Color.white);
		g.drawString(distance+"M", 35, 30);
		g.setColor(Color.black);
		g.drawString(distance+"M", ShiftWest(35, 2), ShiftNorth(60, 2));
		g.drawString(distance+"M", ShiftWest(35, 2), ShiftSouth(60, 2));
		g.drawString(distance+"M", ShiftEast(35, 2), ShiftNorth(60, 2));
		g.drawString(distance+"M", ShiftEast(35, 2), ShiftSouth(60, 2));
		g.setColor(Color.yellow);
		g.drawString(distance+"M", 35, 60);
		g.drawImage(pause1.getImage(), 1130, 18, 60, 60, null);
		
		if(collision() && tDamage == 1){
			if(tDamage == 1){
				health --;
				hp.interval += 35;
			}
		}
		//allows for 100 ms invulnerable
		if(tDamage == 100)
			tDamage = 0;
		
		for(int i = 0; i < health; i++){
			hp.draw(g);
			hp.interval += 35;
		}
		hp.interval = 35 * (5 - health);
		
		if(pause){
			g.drawImage(pause2.getImage(),220, 280, null);
		}
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == t){
			if(goDown){
				down();
			}
			else{
				up();
			}
			bg.scroll(); 
			o.scroll(); 
			cs.scroll();
			distance ++;
			if(health == 0){
				Test.State = Test.STATE.GAMEOVER;
				parent.updateW();
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE) { 
	        up();
	        goDown = false;
	    }
	    repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE ) { 
	       goDown = true;
	       accel = 0;
	    }
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		System.out.println(x);
		System.out.println(y);
		if(x >= 1145 && x <= 1175 && y >= 30 && y <=65){
			t.stop();
			pause = true;
		}
		if(pause){
			if(y >= 275 && y <= 385){
				if(x >= 215 && x <= 455){
					Test.State = Test.STATE.MENU;
					parent.updateW();
				}
				else if(x >= 480 && y <= 710){
					
				}
				else if(x >= 730 && y <= 960){
					t.start();
					pause = false;
					repaint();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}