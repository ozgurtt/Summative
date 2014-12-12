//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Backgrounds

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Background extends Rectangle{
	
	ArrayList<ImageIcon> pics = new ArrayList<ImageIcon>();
	ImageIcon bg = new ImageIcon("background.png");
	ImageIcon bg2 = new ImageIcon("background2.png");
	ImageIcon bg3 = new ImageIcon("background3.png");
	protected int dx=0;
	public int picChoice = 0;
	
	public Background(){
		//adds the backgrounds
		pics.add(bg);
		pics.add(bg2);
		pics.add(bg3);
	}
	
	public void draw(Graphics g){
		g.drawImage(pics.get(picChoice).getImage(),dx,0,2400,800,null);
	}
	
	public void scroll(){
		dx-=20;

		if(dx<=-1200){
			dx=0;
		}
	}
}


