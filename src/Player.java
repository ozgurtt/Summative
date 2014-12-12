//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Player

import java.awt.*;
import javax.swing.ImageIcon;

public class Player extends Rectangle {
	
	private int xmin, xmax;  
	private int ymin, ymax; 
	protected int x,y;   
	private ImageIcon pic=new ImageIcon("Run.gif");
	
	//sets the bounds for the players
	public Player(int left, int right, int top, int bottom){
		xmin = left;
	    xmax = right;
	    ymin = top;
	    ymax = bottom;
	    x = 300;
	    y = 40;
	}
	
	public void draw(Graphics g) {
		g.drawImage(pic.getImage(),x,y, 80, 80, null);
	}
	//rectangle of the player to check for collisions
	public Rectangle getRect(){
		 return new Rectangle(x, y, (int)(80*0.5), (int)(80*0.5));
	}
}
