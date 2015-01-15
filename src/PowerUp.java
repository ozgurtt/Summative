//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Power Ups

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PowerUp extends Background {
	//Variables
	public int y;
	public int position = 1, gradient=0; //Gradient lightens the color
	public boolean makePowerUp = false;
	public int dx = 0;
	public int choice; 
	public String powerType;
	//Constructor
	public PowerUp(){
		y = 70*(int)(Math.random()*6);		
	}
	//Draws different power ups
	public void draw(Graphics g){
		if(choice==3){
			speed(1250+dx,y, 75, gradient, g);
			powerType = "Speed";
		}
		else if(choice==2){
			life(1250+dx,y,100,gradient,g); 
			powerType = "Life";
		}
		else if(choice==1){
			power(80, 1250+dx, gradient, g);
			powerType = "Money";
		}
		else{
			magnet(80, 1200+dx, y, gradient, g);
			powerType = "Magnet";
		}
	}
	
	//The following are power ups, which are drawn using recursion
	//They create a large shape, then create multiple smaller shapes, each with a slightly 
	//lighter colour. Colour lightening and the shrinking of sizes all use recursion.
	//If the size of the shape is smaller than a certain amount, the picture is done
	
	//EXTRA 50 COINS
	public void power(int radius, int x, int gradient, Graphics g){
		if(radius<=30)
			return;
		g.setColor(new Color(242,228,27+gradient));
		g.fillOval(x,y,radius,radius);
		power(radius-5, x+5, gradient+20, g);		
	}
	//MAGNET SUCKING COINS
	public void magnet(int radius, int x, int y, int gradient, Graphics g){
		if(radius<=15)
			return;
		g.setColor(new Color(20+gradient,70+gradient,240));
		g.fillOval(x, y, radius, radius);
		magnet(radius-5, x+3, y-5,gradient+10, g);
	}
	//EXTRA LIFE
	public void life (int x, int y, int radius, int gradient, Graphics g){
		if(radius<=5)
			return;
		
		g.setColor(new Color(255,0+gradient,127+gradient));
		g.fillOval(x,y,radius,radius);
		life(x+5,y+5,radius-10, gradient+12, g);
	}
	//MEGA SPEED BOOST
	public void speed(int x, int y, int radius, int gradient, Graphics g){
		if(radius<=2)
			return;
		
		g.setColor(new Color(0+gradient,250,154));
		g.fillRect(x, y, radius,radius);
		speed(x+7,y+2,radius-4,gradient+10,g);
		
	}
	//Changes power ups
	public void scroll(){
		dx-=40;
		if(dx<=-1210){
			dx=0;
			makePowerUp = false;
		}
	}
	//Returns hitboxes
	public Rectangle getRect(){
		return new Rectangle(1200+dx, y, 80, 80);
	}
}
