//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Help Panel

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Help extends JPanel implements MouseListener {
	//Variables
	private Test parent;
	private ImageIcon pic = new ImageIcon("help.png");
	private ImageIcon bar = new ImageIcon("spacebar.png");
	private ImageIcon coin = new ImageIcon("coin.png");
	private ImageIcon ob1 = new ImageIcon("Obstacle1.gif");
	private ImageIcon ob2 = new ImageIcon("Obstacle2.gif");
	private ImageIcon ene = new ImageIcon("enemy.gif");
	private ImageIcon p = new ImageIcon("run.gif");
	private ImageIcon h = new ImageIcon("health.png");
	//Constructor
	public Help(Test parent){
		this.parent=parent;
		addMouseListener(this);
	}
	//Methods for an outlined text style
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
	//Recursion methods to draw power ups
	public void power(int radius, int x, int gradient, Graphics g){
		if(radius<=30)
			return;
		g.setColor(new Color(242,228,27+gradient));
		g.fillOval(x,320,radius,radius);
		power(radius-5, x+5, gradient+20, g);		
	}
	
	public void magnet(int radius, int x, int y, int gradient, Graphics g){
		if(radius<=15)
			return;
		g.setColor(new Color(20+gradient,70+gradient,240));
		g.fillOval(x, y, radius, radius);
		magnet(radius-5, x+3, y-5,gradient+10, g);
	}
	
	public void life (int x, int y, int radius, int gradient, Graphics g){
		if(radius<=5)
			return;
		g.setColor(new Color(255,0+gradient,127+gradient));
		g.fillOval(x,y,radius,radius);
		life(x+5,y+5,radius-10, gradient+12, g);
	}
	
	public void speed(int x, int y, int radius, int gradient, Graphics g){
		if(radius<=2)
			return;
		g.setColor(new Color(0+gradient,250,154));
		g.fillRect(x, y, radius,radius);
		speed(x+7,y+2,radius-4,gradient+10,g);
		
	}
	//Draws content
	public void paintComponent(Graphics g){
		g.drawImage(pic.getImage(), 0, 0, null);
		Font f = new Font("New Athletic M54", Font.PLAIN, 50);
		Font f1 = new Font("New Athletic M54", Font.PLAIN, 70);
		Font f2 = new Font("New Athletic M54", Font.PLAIN, 30);
		
		g.setFont(f1);
		g.setColor(Color.black);
		g.drawString("HOW TO PLAY", ShiftWest(440, 2), ShiftNorth(80, 2));
		g.drawString("HOW TO PLAY", ShiftWest(440, 2), ShiftSouth(80, 2));
		g.drawString("HOW TO PLAY", ShiftEast(440, 2), ShiftNorth(80, 2));
		g.drawString("HOW TO PLAY", ShiftEast(440, 2), ShiftSouth(80, 2));
		g.setColor(Color.white);
		g.drawString("HOW TO PLAY",440,80);
		
		power(60, 30, 0, g);
		magnet(50, 30, 250, 0, g);
		life(30,410,60,0,g); 
		speed(20,490, 60, 0, g);
		
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString("Power Ups", ShiftWest(10, 2), ShiftNorth(180, 2));
		g.drawString("Power Ups", ShiftWest(10, 2), ShiftSouth(180, 2));
		g.drawString("Power Ups", ShiftEast(10, 2), ShiftNorth(180, 2));
		g.drawString("Power Ups", ShiftEast(10, 2), ShiftSouth(180, 2));
		
		g.drawString("You have 5", ShiftWest(10, 2), ShiftNorth(640, 2));
		g.drawString("You have 5", ShiftWest(10, 2), ShiftSouth(640, 2));
		g.drawString("You have 5", ShiftEast(10, 2), ShiftNorth(640, 2));
		g.drawString("You have 5", ShiftEast(10, 2), ShiftSouth(640, 2));
		
		g.drawString("Your Goal", ShiftWest(520, 2), ShiftNorth(180, 2));
		g.drawString("Your Goal", ShiftWest(520, 2), ShiftSouth(180, 2));
		g.drawString("Your Goal", ShiftEast(520, 2), ShiftNorth(180, 2));
		g.drawString("Your Goal", ShiftEast(520, 2), ShiftSouth(180, 2));
		
		g.drawString("Avoid", ShiftWest(1000, 2), ShiftNorth(180, 2));
		g.drawString("Avoid", ShiftWest(1000, 2), ShiftSouth(180, 2));
		g.drawString("Avoid", ShiftEast(1000, 2), ShiftNorth(180, 2));
		g.drawString("Avoid", ShiftEast(1000, 2), ShiftSouth(180, 2));
		
		g.drawString("Good luck", ShiftWest(520, 2), ShiftNorth(640, 2));
		g.drawString("Good luck", ShiftWest(520, 2), ShiftSouth(640, 2));
		g.drawString("Good luck", ShiftEast(520, 2), ShiftNorth(640, 2));
		g.drawString("Good luck", ShiftEast(520, 2), ShiftSouth(640, 2));
		
		g.setColor(Color.yellow);
		g.drawString("Power Ups",10,180);
		g.drawString("You have 5", 10,640);
		g.drawImage(h.getImage(), 250, 595,50,50,null);
		g.drawString("Your Goal", 520,180);
		g.drawString("Avoid", 1000,180);
		g.drawString("Good luck", 520,640);
		g.setColor(Color.white);
		
		g.setFont(f2);
		g.drawString("Magnet",100,270);
		g.drawString("50+ Coins",100,360);
		g.drawString("Extra Life",100,455);
		g.drawString("Speed Boost",135,535);
		g.drawString("Run as far as possible",480,260);
		g.drawString("And Collect",540,300);
		g.drawImage(coin.getImage(), 695, 270, 35, 35, null);
		g.drawString("Press or Release",520,440);
		g.drawString("Up or Down",555,560);
		g.drawImage(bar.getImage(), 525, 450, 200, 80,null);
		
		for(int i=0;i<3;i++){
			g.drawImage(ob1.getImage(), 980+30*i, 220,100,100,null);
			g.drawImage(ob2.getImage(), 890+70*i, 280,200,200,null);
		}
		g.drawImage(p.getImage(), 580, 320,80,80,null);
		g.drawImage(ene.getImage(), 1020, 435,80,80,null);
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//Clicks back to main menu
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if(x >= 5 && x <= 130 && y >= 15 && y <= 95){
			Test.state = Test.STATE.MENU;
			parent.updateW();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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

}
