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
	
	private ImageIcon pic=new ImageIcon("gameover.png");
	private Test parent;
	Scanner in, in1 =null;
	String distance, coins = "";
	
	public Gameover(Test parent){
		this.parent=parent;
		addMouseListener(this);
		try{
			in = new Scanner(new File("distance.txt"));
			in1 = new Scanner(new File("coins.txt"));
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
		while(in1.hasNextLine()){
			coins = in1.nextLine();
			if(!in1.hasNextLine()){
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
		g.drawImage(pic.getImage(), 0, 0, null);
		Font f = new Font("arial", Font.BOLD, 100);
		Font f1 = new Font("arial", Font.BOLD, 50);
		g.setColor(Color.black);
		g.setFont(f1);
		g.drawString("YOU FLEW", ShiftWest(470, 2), ShiftNorth(80, 2));
		g.drawString("YOU FLEW", ShiftWest(470, 2), ShiftSouth(80, 2));
		g.drawString("YOU FLEW", ShiftEast(470, 2), ShiftNorth(80, 2));
		g.drawString("YOU FLEW", ShiftEast(470, 2), ShiftSouth(80, 2));
		g.drawString("AND COLLECTED", ShiftWest(400, 2), ShiftNorth(250, 2));
		g.drawString("AND COLLECTED", ShiftWest(400, 2), ShiftSouth(250, 2));
		g.drawString("AND COLLECTED", ShiftEast(400, 2), ShiftNorth(250, 2));
		g.drawString("AND COLLECTED", ShiftEast(400, 2), ShiftSouth(250, 2));
		g.setFont(f);
		g.drawString(distance+"M", ShiftWest(500, 2), ShiftNorth(180, 2));
		g.drawString(distance+"M", ShiftWest(500, 2), ShiftSouth(180, 2));
		g.drawString(distance+"M", ShiftEast(500, 2), ShiftNorth(180, 2));
		g.drawString(distance+"M", ShiftEast(500, 2), ShiftSouth(180, 2));
		g.drawString(coins+"", ShiftWest(550, 2), ShiftNorth(350, 2));
		g.drawString(coins+"", ShiftWest(550, 2), ShiftSouth(350, 2));
		g.drawString(coins+"", ShiftEast(550, 2), ShiftNorth(350, 2));
		g.drawString(coins+"", ShiftEast(550, 2), ShiftSouth(350, 2));
		g.setColor(Color.white);
		g.setFont(f1);
		g.drawString("YOU FLEW",470,80);
		g.drawString("AND COLLECTED",400,250);
		g.setColor(Color.yellow);
		g.setFont(f);
		g.drawString(distance+"M", 500, 180);
		g.drawString(coins+"", 550, 350);

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
