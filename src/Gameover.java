//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Over

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

public class Gameover extends JPanel implements MouseListener{
	
	private ImageIcon pic=new ImageIcon("MenuBG.png");
	private Test parent;
	Scanner in=null;
	String distance = "";
	
	public Gameover(Test parent){
		this.parent=parent;
		addMouseListener(this);
		try{
			in = new Scanner(new File("distance.txt"));
     	}
		catch(Exception e){
			System.out.println(e);	
		}
		while(in.hasNextLine()){
			distance = in.nextLine();
			if(!in.hasNextLine()){
				break;
			}
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
		Font f = new Font("arial", Font.BOLD, 100);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString("YOU FLEW", ShiftWest(300, 2), ShiftNorth(80, 2));
		g.drawString("YOU FLEW", ShiftWest(300, 2), ShiftSouth(80, 2));
		g.drawString("YOU FLEW", ShiftEast(300, 2), ShiftNorth(80, 2));
		g.drawString("YOU FLEW", ShiftEast(300, 2), ShiftSouth(80, 2));
		g.drawString(distance+"M", ShiftWest(450, 2), ShiftNorth(160, 2));
		g.drawString(distance+"M", ShiftWest(450, 2), ShiftSouth(160, 2));
		g.drawString(distance+"M", ShiftEast(450, 2), ShiftNorth(160, 2));
		g.drawString(distance+"M", ShiftEast(450, 2), ShiftSouth(160, 2));
		g.setColor(Color.white);
		g.drawString("YOU FLEW",300,80);
		g.setColor(Color.yellow);
		g.drawString(distance+"M", 450, 160);
		g.setColor(Color.black);
//		g.drawString(coinsCollected+"", ShiftWest(35, 2), ShiftNorth(60, 2));
//		g.drawString(coinsCollected+"", ShiftWest(35, 2), ShiftSouth(60, 2));
//		g.drawString(coinsCollected+"", ShiftEast(35, 2), ShiftNorth(60, 2));
//		g.drawString(coinsCollected+"", ShiftEast(35, 2), ShiftSouth(60, 2));
//		g.setColor(Color.yellow);
//		g.drawString(coinsCollected+"", 35, 60);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
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
