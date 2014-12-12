//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Player Health

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PlayerHealth {
	
	protected int interval = 0; //separates health blocks
	private ImageIcon heart = new ImageIcon("health.png");
	
	public void draw(Graphics g){
		g.drawImage(heart.getImage(), 1200 - 35 - interval, 0, 30, 30, null);
	}

}
