import java.applet.Applet ;
import java.awt.Graphics;
import java.awt.Color;

public class movedBall extends Applet implements Runnable {

		Thread _thread ;
		boolean  rightToleft = true ;
		boolean upDown = true ;  
		 int x = 0 ; 
		 int y = 0; 
		public void init(){
			
			_thread =new Thread(this); 
			_thread.start(); 
		
		}
		
		public void paint(Graphics g ){
	
			g.fillOval(x,y,60,60);// left oval 
	
		}
		public void run(){
			
			while(true ){
			try{
				
				if(x >= getWidth() && rightToleft ==true){
					
					rightToleft = false ; 
					
				}
				else if(rightToleft == true && x < getWidth()){
					
					x++ ; 
				}
				else if(rightToleft ==  false && x <= getWidth() ){
				
					x-- ; 
					if(x == 0 ){
						rightToleft =true ;
					}
				}
				
				
				if(y >= getHeight() && upDown ==true){
					
					upDown = false ; 
					
				}
				else if(upDown == true && y < getHeight()){
					
					y++ ; 
				}
				else if(upDown == false && y <= getHeight() ){
				
					y-- ; 
					if(y == 0 ){
						upDown =true ;
					}
				}
				
				repaint(); 
				_thread.sleep(4);
			
			
			}catch (InterruptedException ie){
			
				ie.printStackTrace(); 

			
			}	
		
		}
	}


}
