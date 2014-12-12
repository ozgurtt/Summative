import java.awt.Graphics;

import javax.swing.ImageIcon;


public class AI extends Player{
	
	ImageIcon AIimage = new ImageIcon("enemy.gif");
	public boolean AIdodge = false;
	private Player p = new Player(0,1200,0,730);
	public AI(int left, int right, int top, int bottom){
		super(left,right,top,bottom);
		x=50;
		y=40;		
	}
	
	public void draw(Graphics g) {
		g.drawImage(AIimage.getImage(),x,y, 80, 80, null);
	}
	
	//checks if there is an obstacle in front of itself, so it can dodge it
	public boolean detector(int x, int y, int x1, int y1){
		if(Math.abs(x1-x)<=200 && Math.abs(y1-y)<=100 && x1>0){
			return true;
		}
		else if (Math.abs(y1-y)>100)
			AIdodge = false;
		return false;
	}
	//code for AI dodging the obstacle
	public void AImovement(){

		if(y <= 0){		
			y=0;
		}
		else{
			y-= 20;
		}
		AIdodge = true;
		
	}
	//code for AI when not dodging obstacle, just chasing the player
	public void fall(int py){
					
		if (py>y)
			y +=5;
		else if (y>py)
			y -=5;
	}

}
