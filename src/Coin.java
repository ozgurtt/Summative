//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Coins

import java.io.*;
import java.util.ArrayList;

public class Coin{
	
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
	
	public ArrayList<Integer> getX(){
		return xValues;
	}
	
	public ArrayList<Integer> getY(){
		return yValues;
	}
}


