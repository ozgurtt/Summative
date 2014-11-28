//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Window

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Test extends JFrame {
	
	private Container c ;
	public static enum STATE{
		MENU,
		PLAY,
		HELP,
		SCORE,
		CREDS,
		QUIT,
		GAMEOVER
	}
	public static STATE state = STATE.MENU;
	private Play p;
	private Menu m;
	
	public Test(){
		 super("Jetpack Joyride - By Daniel Li and Connie Yu");
		 c = getContentPane();
		 m = new Menu(this);
		 c.add(m);
	}
	
	public void updateW(){
		c.removeAll();
		if(state == STATE.PLAY){
			p = new Play(this);
			this.addKeyListener(p);
			c.add(p);
		}
		else if(state == STATE.MENU){
			c.add(m);
		}
		else if(state == STATE.QUIT){
			System.exit(0);
		}
		revalidate();
		repaint();
	}
	
	public static void main (String args[]){
		Test frame = new Test();
		frame.setSize(1200,700);
		frame.setResizable(false);
		frame.setVisible( true );
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
	}
}
