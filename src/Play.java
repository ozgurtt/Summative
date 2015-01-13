//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Panel

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

class Play extends JPanel implements KeyListener, ActionListener, MouseListener {
	
	private Player p = new Player(0,1200,0,730);
	private Background bg = new Background();
	private Obstacle o;
	private AI ai = new AI(0,1200,0,730);
	private PowerUp pu = new PowerUp();
	
	//for the coins
	private Coin cs ;
	private ArrayList<Integer> xValues = new ArrayList<Integer>();
	private ArrayList<Integer> yValues = new ArrayList<Integer>();
	private ArrayList<CoinDraw> coins = new ArrayList<CoinDraw>();
	
	//for the obstacles
	private ArrayList<Integer> xObs = new ArrayList<Integer>();
	private ArrayList<Integer> yObs = new ArrayList<Integer>();
	private ArrayList<String> obsType = new ArrayList<String>();
	private ArrayList<ObstacleDraw> obstacles = new ArrayList<ObstacleDraw>();
	private boolean collide = false;
	
	private PlayerHealth hp = new PlayerHealth();
	private Timer t;
	private boolean goDown = true;
	private int accel = 0;
	private int tDamage = 0;
	private int health = 5;
	private int distance = 0;
	private boolean pause = false;
	private int coinsCollected = 0;
	private boolean coinsRemove = false;
	private boolean damageImmune = false;
	private boolean obstacleRemove = false;
	private int cnt = 0; 
	private int magCount = 0;
	private Test parent;
	private ImageIcon pause1 = new ImageIcon("pause.png");
	private ImageIcon pause2 = new ImageIcon("pauseScreen.png");
	private ImageIcon coin = new ImageIcon("coin1.png");
	private ImageIcon boom = new ImageIcon("boom.gif");
	private int picChange = 0;
	private int maxDistance;
	private int maxCoins;
	
	private int delay = 45;
	private boolean magnet = false;
	
	FileWriter wr, wr1 = null;
	BufferedWriter bw,bw1=null;
	
	public Play(Test parent){
		this.parent=parent;
		t = new Timer(35,this);
		t.start();
		addKeyListener(this);
		setFocusable(true);
		addMouseListener(this);
	}
	
	//for player movement
	public void up(){
		if(p.y <= 0){
			p.y = 0;		
		}
		else{
			p.y -= 20;
		}
	}
	
	public void down(){
		if(p.y >= 560){
			p.y = 560;
		}
		else{
			p.y += ++accel;
		}
	}
	//checks for collision between the generated rectangles
	public boolean collision(ObstacleDraw od){
		Rectangle player = p.getRect();
		Rectangle obstacle = od.getRect();
		
		if(player.intersects(obstacle)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int ShiftNorth(int p, int distance) {
		return (p - distance);
	}
	
	public int ShiftSouth(int p, int distance) {
		return (p + distance);
	}
	
	public int ShiftEast(int p, int distance) {
		return (p + distance);
	}
	
	public int ShiftWest(int p, int distance) {
		return (p - distance);
	}
	
	//checks if player collides with coins, and collects the coins
	public void collectCoins(CoinDraw c, int pos){
		Rectangle player = p.getRect();
		Rectangle coin = c.getRect();
		
		
		if(player.intersects(coin)){
			coins.remove(pos);
			coinsCollected++;
		}
	}
	//checks for powerups
	public void collectPower(){
		Rectangle player = p.getRect();
		Rectangle powerUp = pu.getRect();
		if(player.intersects(powerUp) && pu.makePowerUp){
			pu.makePowerUp = false;
			pu.dx = 0;
			if(pu.powerType.equals("Money"))
				coinsCollected+=50;
			else if( pu.powerType.equals("Magnet")){
				magnet = true;
				p.pic = new ImageIcon("magnetMan.gif");
			}
		}
	
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		bg.draw(g);			
		p.draw(g);	
		ai.draw(g);
		
		if(cnt%200==0){
			pu.makePowerUp = true;
			pu.choice = (int)(Math.random()*2);
		}
		if(pu.makePowerUp){
			pu.draw(g);
			collectPower();
		}
	
		ai.AIdodge = false; //ai is not dodging at the moment
		//fonts
		Font f = new Font("arial", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString(distance+"M", ShiftWest(35, 2), ShiftNorth(30, 2));
		g.drawString(distance+"M", ShiftWest(35, 2), ShiftSouth(30, 2));
		g.drawString(distance+"M", ShiftEast(35, 2), ShiftNorth(30, 2));
		g.drawString(distance+"M", ShiftEast(35, 2), ShiftSouth(30, 2));
		g.setColor(Color.white);
		g.drawString(distance+"M", 35, 30);
		g.setColor(Color.black);
		g.drawString(coinsCollected+"", ShiftWest(35, 2), ShiftNorth(60, 2));
		g.drawString(coinsCollected+"", ShiftWest(35, 2), ShiftSouth(60, 2));
		g.drawString(coinsCollected+"", ShiftEast(35, 2), ShiftNorth(60, 2));
		g.drawString(coinsCollected+"", ShiftEast(35, 2), ShiftSouth(60, 2));
		g.setColor(Color.yellow);
		g.drawString(coinsCollected+"", 35, 60);
		g.drawImage(pause1.getImage(), 1130, 18, 60, 60, null);
		String numString = coinsCollected+"";
		int num = numString.length()-1;
		g.drawImage(coin.getImage(), 30+16*num, 15, 85, 85, null);
		
		//resets the obstacles and coins
		if(coins.size()==0){
			coinsRemove=false;
			cs = new Coin();
			xValues = cs.getX();
			yValues = cs.getY();
		}
		
		if(obstacles.size()==0){

			obstacleRemove=false;
			o = new Obstacle();
			xObs = o.getX();
			yObs = o.getY();
			obsType = o.getType();
		}
		//generates the obstacles and coins
		if(!coinsRemove){
			for(int i=0; i<xValues.size(); i++){
				coins.add(new CoinDraw(xValues.get(i),yValues.get(i)));
			}
			coinsRemove = true;
		}
		
		if(!obstacleRemove){
			for(int i=0; i<xObs.size(); i++){
				obstacles.add(new ObstacleDraw(xObs.get(i),yObs.get(i), obsType.get(i)));
			}
			obstacleRemove = true;
		}
		if(distance>10){
			//draws all obstacles and coins
			for(int i=0; i<coins.size(); i++){
				
				coins.get(i).draw(g);
				collectCoins(coins.get(i), i);
				
			}
			for(int i=0; i<obstacles.size(); i++){
				obstacles.get(i).draw(g);
				collide = collision(obstacles.get(i));
				if(collide && damageImmune==false){
					health --;
					hp.interval += 35;
					damageImmune = true;
					ai.x+=50;
				}	
				
				if(ai.detector(ai.x, ai.y, obstacles.get(i).posX, obstacles.get(i).posY)){
					ai.AIdodge=true;
					ai.AImovement();
				}
				else if(i==obstacles.size()-1 && !ai.AIdodge){
					ai.AIdodge = false;
				}
	
			}	
		}
		if(damageImmune){
			tDamage++;
		}
		//allows for 150 ms invulnerable
		if(tDamage == 150){
			tDamage = 0;
			damageImmune=false;
		}
		for(int i = 0; i < health; i++){
			hp.draw(g);
			hp.interval += 35;
		}
		hp.interval = 35 * (5 - health);
		
		if(pause){
			g.drawImage(pause2.getImage(),220, 280, null);
		}
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == t){
			if(goDown){
				down();
			}
			else{
				up();
			}
			bg.scroll(); 
			
			if(pu.makePowerUp)
				pu.scroll();
			
			if(!ai.AIdodge)
				ai.fall(p.y);
			
			//the following deals with the obstacles and the coins reaching the end of the screen
			for (int i=0; i<coins.size(); i++){
				coinsRemove = true;
				coins.get(i).scroll();

				if(magnet){
					if((coins.get(i).posX - p.x <=300)){
						if (coins.get(i).posY > p.y)
							coins.get(i).dy-=15;
						else if(coins.get(i).posY < p.y)
							coins.get(i).dy+=15;
					}
					
					magCount++;
					System.out.println(magCount);
					
				}		
				if(magCount==6000){
					magCount = 0;
					magnet = false;
					p.pic = new ImageIcon("run.gif");
				}
				
				if(coins.get(i).posX<=0){
					coins.remove(i);
					i--;
				}
			}
			for (int i=0; i<obstacles.size(); i++){
				obstacles.get(i).scroll();
				obstacleRemove = true;
				if(obstacles.get(i).posX<=-100){
					obstacles.remove(i);
					i--;
				}
				
			}
			if(obstacles.size()==0)
				ai.direction = true;
			
			cnt ++;
			if(cnt % 4 == 0){
				picChange++;
				distance ++;
				//as time goes on, the speed of the game becomes faster 
				if(distance%75==0 && distance>0 && delay>=5){
					t.setDelay(delay);
					delay-=5;				
				}
			}
			
			//determines the background picture
			if (picChange%50==0 && cnt%4==0 && picChange>0){
				if(picChange>=150)
					bg.picChoice=0;
				else
					bg.picChoice++;				
			}
			
			
			//if hp=0 (player dies), then the screen goes to the gameover screen
			if(health == 0){
										
				Test.state = Test.STATE.GAMEOVER;
				parent.updateW();
			
				
			}
			
			if(health == 0){
				t.stop();
				maxDistance = distance;
				maxCoins = coinsCollected;
				try{
					wr = new FileWriter("distance.txt",true);
					wr1 = new FileWriter("coins.txt",true);
					bw = new BufferedWriter(wr);
					bw1 = new BufferedWriter(wr1);
					bw.write(String.valueOf(maxDistance));
					bw.newLine();
					bw1.write(String.valueOf(maxCoins));
					bw1.newLine();
					bw.close();
					bw1.close();
			 	}
				catch(Exception e1){
					System.out.println(e1);	
				}
				Test.state = Test.STATE.GAMEOVER;
				parent.updateW();
				
			}
			
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE) { 
	        up();
	        goDown = false;
	    }
	    repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE ) { 
	       goDown = true;
	       accel = 0;
	    }
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if(x >= 1145 && x <= 1175 && y >= 30 && y <=65){
			t.stop();
			pause = true;
		}
		//resets everything
		if(pause){
			if(y >= 275 && y <= 385){
				if(x >= 215 && x <= 455){
					Test.state = Test.STATE.MENU;
					parent.updateW();
				}
				else if(x >= 480 && x <= 710){
					p = new Player(0,1200,0,730);
					ai = new AI(0,1200,0,730);
					bg = new Background();
					o = new Obstacle();
					cs = new Coin();
					xValues = new ArrayList<Integer>();
					yValues = new ArrayList<Integer>();
					coins = new ArrayList<CoinDraw>();
					hp = new PlayerHealth();
					goDown = true;
					accel = 0;
					tDamage = 0;
					health = 5;
					cnt = 0;
					distance = 0;
					coinsCollected = 0;
					coinsRemove = false;
					t.start();
					pause = false;
					repaint();
				}
				else if(x >= 730 && x <= 960){
					t.start();
					pause = false;
					repaint();
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}