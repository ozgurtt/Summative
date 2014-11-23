//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Panel

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

class Panel extends JPanel implements KeyListener, ActionListener {
	
	private Player p = new Player(0,1200,0,750);
	private Background bg = new Background();
	private Obstacle o = new Obstacle();
	private Timer t;
	private boolean goDown = true;
	private int accel = 0;
	
	public Panel(){
		t = new Timer(30,this);
		t.start();
		addKeyListener(this);
		setFocusable(true);
	}
	public void up(){
		if(p.y <= 0){
			p.y = 0;
		}
		else{
			p.y -= 30;
		}
	}
	public void down(){
		if(p.y >= 580){
			p.y = 580;
		}
		else{
			p.y += ++accel;
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		bg.draw(g);		
		p.draw(g);	
		o.draw(g);
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

}