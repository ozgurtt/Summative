//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Draws Game Coins

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class CoinDraw extends Background{
	//Variables
	private ImageIcon coin = new ImageIcon("coin.gif");
	private int x, y;
	protected int posX, posY;
	public boolean magnet;
	public int dx = 0, dy=0;
	//Constructor
	public CoinDraw(int x, int y){
		this.x = x;
		this.y = y;
	}
	//Draws the coins based on the location it received
	public void draw(Graphics g){
		posX = 1200 + x * 70 + dx;
		posY = y * 70 + dy;
		g.drawImage(coin.getImage(), posX, posY, 100, 100, null);
		
	}
	//Scrolls coin maps
	public void scroll(){
		dx -= 20;
		if(posX <= 0)
			dx = 0;
	
	}
	//Returns hitboxes
	public Rectangle getRect(){
		return new Rectangle(posX, posY, 80, 80);
	}
}
	
