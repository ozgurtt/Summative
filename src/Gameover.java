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
	
	private ImageIcon pic = new ImageIcon("gameover.png");
	private ImageIcon coin = new ImageIcon("coin1.png");
	private Test parent;
	private Scanner in, in1 = null;
	private String distance, coins = "";
	
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
		Font f = new Font("New Athletic M54", Font.PLAIN, 100);
		Font f1 = new Font("New Athletic M54", Font.PLAIN, 50);
		String numDistance = distance+"M";
		int num = numDistance.length()-1;
		String numCoins = coins+"";
		int num1 = numCoins.length()-1;
		
		g.setColor(Color.black);
		g.setFont(f1);
		g.drawString("YOU FLEW", ShiftWest(510, 2), ShiftNorth(100, 2));
		g.drawString("YOU FLEW", ShiftWest(510, 2), ShiftSouth(100, 2));
		g.drawString("YOU FLEW", ShiftEast(510, 2), ShiftNorth(100, 2));
		g.drawString("YOU FLEW", ShiftEast(510, 2), ShiftSouth(100, 2));
		g.drawString("AND COLLECTED", ShiftWest(450, 2), ShiftNorth(270, 2));
		g.drawString("AND COLLECTED", ShiftWest(450, 2), ShiftSouth(270, 2));
		g.drawString("AND COLLECTED", ShiftEast(450, 2), ShiftNorth(270, 2));
		g.drawString("AND COLLECTED", ShiftEast(450, 2), ShiftSouth(270, 2));
		g.setFont(f);
		g.drawString(distance+"M", ShiftWest(530-num*5, 2), ShiftNorth(200, 2));
		g.drawString(distance+"M", ShiftWest(530-num*5, 2), ShiftSouth(200, 2));
		g.drawString(distance+"M", ShiftEast(530-num*5, 2), ShiftNorth(200, 2));
		g.drawString(distance+"M", ShiftEast(530-num*5, 2), ShiftSouth(200, 2));
		g.drawString(coins+"", ShiftWest(522-num1*8, 2), ShiftNorth(370, 2));
		g.drawString(coins+"", ShiftWest(522-num1*8, 2), ShiftSouth(370, 2));
		g.drawString(coins+"", ShiftEast(522-num1*8, 2), ShiftNorth(370, 2));
		g.drawString(coins+"", ShiftEast(522-num1*8, 2), ShiftSouth(370, 2));
		
		g.setColor(Color.white);
		g.setFont(f1);
		g.drawString("YOU FLEW",510,100);
		g.drawString("AND COLLECTED",450,270);
		g.setColor(Color.yellow);
		g.setFont(f);
		g.drawString(distance+"M", 530-num*5, 200);
		g.drawString(coins+"", 522-num1*8, 370);
		g.drawImage(coin.getImage(), 522+num1*12, 228, 260, 260, null);
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
		if(y >= 455 && y <= 600){
			if(x >= 345 && x <= 605){
				Test.state = Test.STATE.PLAY;
				parent.updateW();
			}
			else if(x >= 605 && x <= 870){
				Test.state = Test.STATE.MENU;
				parent.updateW();
			}
			
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
