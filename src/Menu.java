//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Menu

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Menu extends JPanel implements MouseListener{
	//Variables
	private ImageIcon pic=new ImageIcon("MenuBG.png");
	private Test parent;
	//Constructor
	public Menu(Test parent){
		this.parent=parent; 
		addMouseListener(this);
	}
	//Draws background
	public void paintComponent(Graphics g){
		g.drawImage(pic.getImage(),0, 0, null);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//Clicks to corresponding actions
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if(x >= 1045 && x <= 1185){
			if(y >= 15 && y <= 95){
				Test.state = Test.STATE.PLAY;
				parent.updateW();
			}
			else if(y >= 115 && y <= 195){
				Test.state = Test.STATE.HELP;
				parent.updateW();
			}
			else if(y >= 215 && y <= 295){
				Test.state = Test.STATE.SCORE;
				parent.updateW();
			}
			else if(y >= 315 && y <= 395){
				Test.state = Test.STATE.CREDS;
				parent.updateW();
			}
			else if(y >= 415 && y <= 495){
				Test.state = Test.STATE.QUIT;
				parent.updateW();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}