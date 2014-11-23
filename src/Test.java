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
		QUIT
	}
	public static STATE State = STATE.MENU;
	private Panel p = new Panel();
	private Menu m = new Menu();
	
	public Test(){
		 super("Jetpack Joyride - By Daniel Li and Connie Yu");
		 c = getContentPane();
		 if(State == STATE.PLAY){
			 p.setBackground(Color.white);
			 c.add(p);
		 }
		 else if(State == STATE.MENU){
			 c.add(m);
		 }
		 else if(State == STATE.QUIT){
			 System.exit(0);
		 }
		 
	}
	
	public static void main (String args[]){
		Test frame = new Test();
		frame.setSize(1200,700);
		frame.setResizable(false);
		frame.setVisible( true );
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
	}
}

