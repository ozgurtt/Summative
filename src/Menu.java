//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Menu

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Menu extends JPanel implements MouseListener{

	private ImageIcon pic=new ImageIcon("MenuBG.png");
	private Test parent;
	
	public Menu(Test parent){
		this.parent=parent;
		addMouseListener(this);
	}
	
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

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("abs");
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if(x >= 1045 && x <= 1185){
			System.out.println("abs"+x+" "+y);
			if(y >= 15 && y <= 95){
				Test.State = Test.STATE.PLAY;
				parent.updateW();
			}
			else if(y >= 115 && y <= 195){
				Test.State = Test.STATE.HELP;
			}
			else if(y >= 215 && y <= 295){
				Test.State = Test.STATE.SCORE;
			}
			else if(y >= 315 && y <= 395){
				Test.State = Test.STATE.CREDS;
			}
			else if(y >= 415 && y <= 495){
				Test.State = Test.STATE.QUIT;
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}