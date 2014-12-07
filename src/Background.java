//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Background

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Background extends Rectangle{
	
	ArrayList<ImageIcon> pics = new ArrayList<ImageIcon>();
	ImageIcon bg = new ImageIcon("background.png");
	ImageIcon bg2 = new ImageIcon("background2.png");
	
	
	public Background(){
		//adds the backgrounds
		pics.add(bg);
		pics.add(bg2);
	}
	protected int dx=0;
	private int dx2=dx+1200;
	public int picChoice = 0;
	private int subPicChoice = 0;
	
	public void draw(Graphics g){
		g.drawImage(pics.get(picChoice).getImage(),dx,0,1200,800,null);
		g.drawImage(pics.get(picChoice).getImage(),dx2,0,2400,800,null);
	}
	
	public void scroll(){
		dx-=20;
		dx2-=20;
		if(dx<=-2400){
			dx=1200;
		}
		if(dx2<=-2400){
			dx2=dx+1200;
		}
	}
}