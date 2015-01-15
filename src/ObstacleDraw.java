//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Draws Game Obstacles

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class ObstacleDraw extends Background {
	//Variables
	private ImageIcon obstacle;
	private ImageIcon obstacle1 = new ImageIcon("Obstacle1.gif");
	private ImageIcon obstacle2 = new ImageIcon("Obstacle2.gif");
	public int posX, posY;
	public int dx=0;
	public int x, y;
	public String type;
	//Constructor
	public ObstacleDraw(int x, int y, String type){
		this.x = x;
		this.y = y;
		this.type = type;
		
	}
	//Determines the type of image that should be drawn
	public void imageType(){
		if(type.equals("X"))
			obstacle = obstacle1;
		else if (type.equals("N"))
			obstacle = obstacle2;
	}
	//Draws the obstacles
	public void draw(Graphics g){
		posX = 1000 + x * 77 + dx;
		posY = y * 77;
		imageType();
		g.drawImage(obstacle.getImage(), posX, posY, 200, 200, null);
	}
	//Changes obstacles
	public void scroll(){
		dx -= 40;
	}
	//Returns hitboxes
	public Rectangle getRect(){
		return new Rectangle(posX, posY, (int)(200*0.5), (int)(200*0.5));
	}

}
