package application;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;

public class Diceroll 
{	
	private static int dice(int rand)
	{
		//System.out.println("ok");
		return (rand = (int)(Math.random()*6 + 1));
	}
		
	public static int get_diceroll()
	{
		int rand = 0;
		rand = dice(rand);
		return rand;
	}
	
	public static void timer(int value) throws InterruptedException
	{
		Timer t = new Timer();
	    TimerTask task = new TimerTask() {
	      int i=1;
	      
	      public void run() 
	      {
	        if(i==7) 
	        {
	        	diceface(value);
	        	t.cancel();
	        }
	        
	        else 
	        {
	        	diceface(i);
	        }
	        i=i+1;
	      }
	    };
	    
	    t.schedule(task, new Date(),45);
	}
	
	private  static void diceface(int value) 
	{	
	    Image two = null;
  	  	if  (value==1) {
			 two = new Image("one.jpeg");
		}
		else if  (value==2) {
			 two = new Image("two.jpeg");
		}
		else if  (value==3) {
			 two = new Image("three.jpeg");
		}
		else if  (value==4) {
			 two = new Image("four.jpeg");
		}
		else if  (value==5) {
			 two = new Image("five.jpeg");
		}
		else if  (value==6) {
			 two = new Image("six.jpeg");
		}
  	 
  	  Main.dice.setImage(two);
	}
	
}
