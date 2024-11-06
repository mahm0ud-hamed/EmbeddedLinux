import java.applet.Applet ;
import java.awt.Graphics;
import java.awt.Color;
import  java.awt.Button ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent;

public class movedBall extends Applet  {



		Thread _thread ;
		boolean  rightToleft = true ;
		boolean upDown = true ;  
		int x = 0 ; 
		int y = 0; 
		Button start ; 
		Button stop ;
		boolean isFirst = true ;
		
		Runnable myRun = () -> {
		
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
		
		}; 
		
		
		
		class Start implements  ActionListener{

	 	public void actionPerformed(ActionEvent e){
	 	
	 			if(isFirst == true){
	 				_thread.start();
	 				isFirst = false ; 
	 				
	 			}
	 			else {
	 				if (isFirst == false )
	 				_thread.resume();
	 			}
	 			repaint(); 
	 		}
		}
		
		class Stop implements  ActionListener{

	 		public void actionPerformed(ActionEvent e){
	 	
				_thread.suspend();
				
	 			repaint(); 
	 		}
		}
		 
		public void init(){
			
			_thread =new Thread(myRun); 
			
			start = new Button("Start"); 
			
			stop = new Button("Stop"); 
			
			Stop stopBall = new Stop(); 
			
			Start StartBall = new Start() ; 
			
			start.addActionListener(StartBall);
			stop.addActionListener(stopBall);
			
			add(start); 
			add(stop); 
			 
		
		}
		
		public void paint(Graphics g ){
	
			g.fillOval(x,y,60,60);// left oval 
			
	
		}
		/*public void run(){
			
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
	}*/


}
