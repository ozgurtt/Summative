//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Credits Panel

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Creds extends JPanel implements MouseListener  {
	//Variables
	private Test parent;
	private ImageIcon pic = new ImageIcon("creds.png");
	
	public Creds(Test parent){
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
	//Draws content
	public void paintComponent(Graphics g){
		g.drawImage(pic.getImage(), 0, 0, null);
		Font f = new Font("New Athletic M54", Font.PLAIN, 50);
		Font f1 = new Font("New Athletic M54", Font.PLAIN, 70);
		
		g.setFont(f1);
		g.setColor(Color.black);
		g.drawString("BROUGHT TO YOU BY", ShiftWest(340, 2), ShiftNorth(80, 2));
		g.drawString("BROUGHT TO YOU BY", ShiftWest(340, 2), ShiftSouth(80, 2));
		g.drawString("BROUGHT TO YOU BY", ShiftEast(340, 2), ShiftNorth(80, 2));
		g.drawString("BROUGHT TO YOU BY", ShiftEast(340, 2), ShiftSouth(80, 2));
		g.setColor(Color.white);
		g.drawString("BROUGHT TO YOU BY",340,80);
		
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString("Daniel Li and Connie Yu", ShiftWest(380, 2), ShiftNorth(237, 2));
		g.drawString("Daniel Li and Connie Yu", ShiftWest(380, 2), ShiftSouth(237, 2));
		g.drawString("Daniel Li and Connie Yu", ShiftEast(380, 2), ShiftNorth(237, 2));
		g.drawString("Daniel Li and Connie Yu", ShiftEast(380, 2), ShiftSouth(237, 2));
		g.setColor(Color.white);
		g.drawString("Daniel Li and Connie Yu",380,237);
		
		g.setColor(Color.black);
		g.drawString("SPECIAL THANKS TO MS.S", ShiftWest(375, 2), ShiftNorth(320, 2));
		g.drawString("SPECIAL THANKS TO MS.S", ShiftWest(375, 2), ShiftSouth(320, 2));
		g.drawString("SPECIAL THANKS TO MS.S", ShiftEast(375, 2), ShiftNorth(320, 2));
		g.drawString("SPECIAL THANKS TO MS.S", ShiftEast(375, 2), ShiftSouth(320, 2));
		g.setColor(Color.yellow);
		g.drawString("SPECIAL THANKS TO MS.S",375,320);
		
		g.setColor(Color.black);
		g.drawString("And Of Course", ShiftWest(460, 2), ShiftNorth(410, 2));
		g.drawString("And Of Course", ShiftWest(460, 2), ShiftSouth(410, 2));
		g.drawString("And Of Course", ShiftEast(460, 2), ShiftNorth(410, 2));
		g.drawString("And Of Course", ShiftEast(460, 2), ShiftSouth(410, 2));
		g.setColor(Color.white);
		g.drawString("And Of Course",460,410);
		
		g.setColor(Color.black);
		g.drawString("The Original Creators", ShiftWest(380, 2), ShiftNorth(500, 2));
		g.drawString("The Original Creators", ShiftWest(380, 2), ShiftSouth(500, 2));
		g.drawString("The Original Creators", ShiftEast(380, 2), ShiftNorth(500, 2));
		g.drawString("The Original Creators", ShiftEast(380, 2), ShiftSouth(500, 2));
		g.setColor(Color.yellow);
		g.drawString("The Original Creators",380,500);
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
