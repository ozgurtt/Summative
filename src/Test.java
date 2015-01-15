//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Run Game Window

import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Test extends JFrame {
	//Variables
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
	private Menu m;
	private Play p;
	private Help h;
	private Score s;
	private Creds cr;
	private Gameover g;
	//Constructor
	public Test(){
		 super("Jetpack Joyride - By Daniel Li and Connie Yu");
		 c = getContentPane();
		 m = new Menu(this);
		 c.add(m);
	}
	//Changes panels
	public void updateW(){
		c.removeAll();
		if(state == STATE.MENU){
			c.add(m);
		}
		else if(state == STATE.PLAY){
			p = new Play(this);
			this.addKeyListener(p);
			c.add(p);
		}
		else if(state == STATE.HELP){
			h = new Help(this);
			c.add(h);
		}
		else if(state == STATE.SCORE){
			s = new Score(this);
			c.add(s);
		}
		else if(state == STATE.CREDS){
			cr = new Creds(this);
			cr.setLayout(new BorderLayout());
			Icon ic = new ImageIcon ("logo.png");
			JLabel label = new JLabel();
			label.setIcon( ic );
			cr.add(label,BorderLayout.SOUTH);
			c.add(cr);
		}
		else if(state == STATE.GAMEOVER){
			g = new Gameover(this);
			c.add(g);
		}
		else if(state == STATE.QUIT){
			System.exit(0);
		}
		revalidate();
		repaint();
	}
	//Runs game
	public static void main (String args[]){
		Test frame = new Test();
		frame.setSize(1200,700);
		frame.setResizable(false);
		frame.setVisible( true );
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
	}
}
