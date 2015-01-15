//Daniel Li and Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Game Coins

import java.io.*;
import java.util.ArrayList;

public class Coin{
	//Variables
	private BufferedReader reader;
	private String line = null;
	private ArrayList<Integer> xValues = new ArrayList<Integer>();
	private ArrayList<Integer> yValues = new ArrayList<Integer>();
	private int y = 0;
	//Constructor
	public Coin(){
		//Reads a random file and creates a coin layout based on the text file read
		try{
			int layout = (int)(Math.random()*7)+1;
			reader = new BufferedReader(new FileReader("coinLayout"+layout+".txt"));	
		
		}	
		catch (IOException e){
			e.printStackTrace();
		}
		
		try {
		//Adds the coordinates of the coins into an arraylist
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
	//Returns the coordinates of all the coins
	public ArrayList<Integer> getX(){
		return xValues;
	}
	
	public ArrayList<Integer> getY(){
		return yValues;
	}
}


