//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//AI

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class AI extends Player{
	//Variables
	private ImageIcon AIimage = new ImageIcon("enemy.gif");
	public boolean AIdodge = false;
	public boolean hardFall = false;
	public boolean direction;
	public boolean moved = false;
	//Constructor
	public AI(int left, int right, int top, int bottom){
		super(left,right,top,bottom);
		x=50;
		y=40;		
	}
	//Draws AI
	public void draw(Graphics g) {
		g.drawImage(AIimage.getImage(),x,y, 80, 80, null);
	}
	//Checks if there is an obstacle in front of itself, so it can dodge it
	public boolean detector(int x, int y, int x1, int y1){
		if(Math.abs(x1-x)<=200 && Math.abs(y1-y)<=100 && x1>0){
			return true;
		}
		
		else if (Math.abs(y1-y)>100)
			AIdodge = false;
		return false;
	}
	//Code for AI dodging the obstacle
	public void AImovement(){
			if((y <= 5 && !moved) || !direction){	
				direction = false;
				y+=3;
			}		
			else{
				y-=3;
				if(y<=-30)
					y=-30;
			}
		AIdodge = false;
		moved = true;
		
	}
	//Code for AI when not dodging obstacle, just chasing the player
	public void fall(int py){				
		if (py>y)
			y +=5;
		else if (y>py)
			y -=5;
	}
	//AI goes to heaven when catches up to player (overriding)
	public void die(){
		y-=10;
	}

}
