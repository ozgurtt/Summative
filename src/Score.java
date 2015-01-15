//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Scoreboard (sorted by distance and coins)

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.*;

public class Score extends JPanel implements MouseListener {
	//Variables
	private ImageIcon pic = new ImageIcon("score.png");
	private ImageIcon coin = new ImageIcon("coin.png");
	private ImageIcon num = new ImageIcon("number.png");
	private Test parent;
	private Scanner in, in1 = null;
	private String d = "", c = "";
	private String [] dis;
	private String [] coi;
	private Integer [] distance;
	private Integer [] coins;
	private boolean displayD = true;
	//Constructor
	public Score(Test parent){
		this.parent=parent;
		addMouseListener(this);
		//Reads scores from local text files
		try{
			in = new Scanner(new File("distance.txt"));
			in1 = new Scanner(new File("coins.txt"));
     	}
		catch(Exception e){
			System.out.println(e);	
		}
		
		while(in.hasNextLine()){
			d += in.nextLine()+",";
			c += in1.nextLine()+",";
		}
		dis = d.split(",");
		coi = c.split(",");
		distance = new Integer [dis.length];
		coins = new Integer [coi.length];
		for(int i=0;i<dis.length;i++){
			distance[i] = Integer.parseInt(dis[i]);
			coins[i] = Integer.parseInt(coi[i]);
		}
		//Sortstop 5 scores
		Arrays.sort(distance, Collections.reverseOrder());
		Arrays.sort(coins, Collections.reverseOrder());
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
		//Default sorting by distance
		if(displayD){
			g.setFont(f1);
			g.setColor(Color.black);
			g.drawString("HIGH SCORES BY DISTANCE", ShiftWest(270, 2), ShiftNorth(80, 2));
			g.drawString("HIGH SCORES BY DISTANCE", ShiftWest(270, 2), ShiftSouth(80, 2));
			g.drawString("HIGH SCORES BY DISTANCE", ShiftEast(270, 2), ShiftNorth(80, 2));
			g.drawString("HIGH SCORES BY DISTANCE", ShiftEast(270, 2), ShiftSouth(80, 2));
			g.setColor(Color.white);
			g.drawString("HIGH SCORES BY DISTANCE",270,80);
			g.drawImage(coin.getImage(), 1020, 15, 80, 80, null);
			
			for(int i = 0; i < 5; i++){
				g.setFont(f);
				g.setColor(Color.black);
				g.drawString((i+1)+ ".     " + distance[i]+"M", ShiftWest(510, 2), ShiftNorth(237+i*90, 2));
				g.drawString((i+1)+ ".     " + distance[i]+"M", ShiftWest(510, 2), ShiftSouth(237+i*90, 2));
				g.drawString((i+1)+ ".     " + distance[i]+"M", ShiftEast(510, 2), ShiftNorth(237+i*90, 2));
				g.drawString((i+1)+ ".     " + distance[i]+"M", ShiftEast(510, 2), ShiftSouth(237+i*90, 2));
				g.setColor(Color.white);
				g.drawString((i+1)+ ".     " + distance[i]+"M",510,237+i*90);
			}
		}
		//Changes to sorting by coins
		else{
			g.setFont(f1);
			g.setColor(Color.black);
			g.drawString("HIGH SCORES BY COINS", ShiftWest(315, 2), ShiftNorth(80, 2));
			g.drawString("HIGH SCORES BY COINS", ShiftWest(315, 2), ShiftSouth(80, 2));
			g.drawString("HIGH SCORES BY COINS", ShiftEast(315, 2), ShiftNorth(80, 2));
			g.drawString("HIGH SCORES BY COINS", ShiftEast(315, 2), ShiftSouth(80, 2));
			g.setColor(Color.white);
			g.drawString("HIGH SCORES BY COINS",315,80);
			g.drawImage(num.getImage(), 1020, 15, 80, 80, null);
			
			for(int i = 0; i < 5; i++){
				g.setFont(f);
				g.setColor(Color.black);
				g.drawString((i+1)+ ".     " + coins[i], ShiftWest(510, 2), ShiftNorth(237+i*90, 2));
				g.drawString((i+1)+ ".     " + coins[i], ShiftWest(510, 2), ShiftSouth(237+i*90, 2));
				g.drawString((i+1)+ ".     " + coins[i], ShiftEast(510, 2), ShiftNorth(237+i*90, 2));
				g.drawString((i+1)+ ".     " + coins[i], ShiftEast(510, 2), ShiftSouth(237+i*90, 2));
				g.setColor(Color.white);
				g.drawString((i+1)+ ".     " + coins[i],510,237+i*90);
				g.drawImage(coin.getImage(), 680, 190+90*i, 55, 55, null);
			}
		}
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
		//Changes sorting option
		if(x >= 1030 && x <= 1095 && y >= 20 && y <= 90){
			if(displayD){
				displayD=false;
			}
			else{
				displayD=true;
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
