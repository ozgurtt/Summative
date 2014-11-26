//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Coins

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Coin extends Background{
	
	private ImageIcon coin = new ImageIcon("coin.gif");
	private BufferedReader reader;
	private String line = null;
	private ArrayList<Integer> xValues = new ArrayList<Integer>();
	private ArrayList<Integer> yValues = new ArrayList<Integer>();
	private int y = 0;
	
	public Coin(){
		try{
			reader = new BufferedReader(new FileReader("coinLayout1.txt"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
		try {
			while ((line = reader.readLine()) != null) {
			   y++;
			   for(int i = 0 ; i < line.length(); i++){				   
				   if(line.charAt(i) == 'X'){
					   xValues.add(i);
					   yValues.add(y);
				   }
			   }			  
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void draw(Graphics g){

		for (int i = 0; i < yValues.size(); i++){
			g.drawImage(coin.getImage(), 1300 + xValues.get(i)*70 + dx, yValues.get(i) * 70, 30, 30, null);
		}
	}
}


