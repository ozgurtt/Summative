//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Draws Game Obstacles

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class ObstacleDraw extends Rectangle {
	
	private Obstacle o = new Obstacle();
	private ImageIcon obstacle;
	private ImageIcon obstacle1 = new ImageIcon("Obstacle1.gif");
	private ImageIcon obstacle2 = new ImageIcon("Obstacle2.gif");
	public int posX, posY;
	int dx=0;
	int x, y;
	String type;
	
	public ObstacleDraw(int x, int y, String type){
		this.x = x;
		this.y = y;
		this.type = type;
		
	}
	
	public void imageType(){
		if(type.equals("X"))
			obstacle = obstacle1;
		else if (type.equals("N"))
			obstacle = obstacle2;
	}
	
	public void draw(Graphics g){
		posX = 1000 + x * 70 + dx;
		posY = y * 70;
		imageType();
		g.drawImage(obstacle.getImage(), posX, posY, 200, 200, null);
	}
	
	public void scroll(){
		dx -= 40;
	}
	
	public Rectangle getRect(){
		return new Rectangle(posX, posY, (int)(200*0.6), (int)(200*0.6));
	}

}
