//Connie Yu
//Ms.Strelkovska
//ICS4U1-01
//11/21/14
//Obstacles

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Obstacle{
	
	private BufferedReader reader;
	private String line = null;
	private ArrayList<String> obsType = new ArrayList<String>();
	private ArrayList<Integer> xObs = new ArrayList<Integer>();
	private ArrayList<Integer> yObs = new ArrayList<Integer>();
	private int y;
	
	public Obstacle(){	
		//determines the locations of all the obstacles
		try{
			int layout = (int)(Math.random()*4)+1;
			reader = new BufferedReader(new FileReader("obstacleLayout"+layout+".txt"));
		}		
		catch (IOException e){
			e.printStackTrace();
		}	
		try {
			while ((line = reader.readLine()) != null) {
			   y++;
			   for(int i = 0 ; i < line.length(); i++){				   
				//determines the type of obstacle that is being generated	  
				 if(line.charAt(i)=='X')
					obsType.add("X");
				 else if (line.charAt(i)=='N')
					obsType.add("N");
				 //adds the x and y location of each obstacle into an arraylist
				 if (line.charAt(i)=='X' || line.charAt(i)=='N'){
					 xObs.add(i);
					 yObs.add(y);
				 }
			   }			  
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	//returns x, y, and obstacle type of each obstacle
	public ArrayList<Integer> getX(){
		return xObs;
	}
	public ArrayList<Integer> getY(){
		return yObs;
	}
	public ArrayList<String> getType(){
		return obsType;
	}
	
}
