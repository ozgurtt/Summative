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
	
	public Player(int left, int right, int top, int bottom){
		xmin = left;
	    xmax = right;
	    ymin = top;
	    ymax = bottom;
	    x = 300;
	    y = 40;
	}
	
	public void draw(Graphics g) {
		g.drawImage(pic.getImage(),x,y, 100, 100, null);
	}
	
	public Rectangle getRect(){
		 return new Rectangle(x, y, 100, 100);
	}
}
