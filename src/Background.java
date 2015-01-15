//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Background

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Background extends Rectangle{
	//Variables
	private ImageIcon bg ;
	protected int dx=0;
	public int picChoice = 1;
	//Draws backgrounds
	public void draw(Graphics g){
		bg = new ImageIcon("background"+picChoice+".png");
		g.drawImage(bg.getImage(),dx,0,2400,800,null);
	}
	//Changes backgrounds
	public void scroll(){
		dx-=20;

		if(dx<=-1200){
			dx=0;
		}
	}
}


