//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Background

import java.awt.*;
import javax.swing.ImageIcon;

public class Background extends Rectangle{
	
	ImageIcon bg = new ImageIcon("background.png");
	protected int dx=0;
	
	public void draw(Graphics g){
		g.drawImage(bg.getImage(),dx,0,2400,800,null);
	}
	
	public void scroll(){
		dx-=20;
		if(dx<=-1200)
			dx=0;
	}
}