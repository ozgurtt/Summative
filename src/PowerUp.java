import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class PowerUp extends Background {
	
	int y;
	int position = 1, gradient=0; //gradient lightens the color
	public boolean makePowerUp = false;
	int dx = 0;
	public int choice; 
	public String powerType;
	public PowerUp(){
		y = 70*(int)(Math.random()*6);
		
	}
	
	public void draw(Graphics g){
		if(choice==1){
			power(80, 1250+dx, gradient, g);
			powerType = "Money";
		}
		else{
			magnet(80, 1200+dx, y, gradient, g);
			powerType = "Magnet";
		}
	}
	
	public void power(int radius, int x, int gradient, Graphics g){
		if(radius<=30)
			return;
		g.setColor(new Color(240,29+gradient,51+gradient));
		g.fillOval(x,y,radius,radius);
		power(radius-5, x+5, gradient+20, g);		
	}
	
	public void magnet(int radius, int x, int y, int gradient, Graphics g){
		if(radius<=15)
			return;
		g.setColor(new Color(20+gradient,70+gradient,240));
		g.fillOval(x, y, radius, radius);
		magnet(radius-5, x+3, y-5,gradient+10, g);
	}
	public void life(){
		
		
	}

	
	public void scroll(){
		dx-=40;
		if(dx<=-1210){
			dx=0;
			makePowerUp = false;
		}
	}
	
	public Rectangle getRect(){
		return new Rectangle(1200+dx, y, 80, 80);
	}
}
