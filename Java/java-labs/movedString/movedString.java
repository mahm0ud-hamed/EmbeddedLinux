import java.applet.Applet ;
import java.awt.Graphics;

public class movedString extends Applet implements Runnable{
	Thread _thread ; 
	int x =0 ; 
	public void init(){
		_thread = new Thread(this);
		_thread.start(); 
		
	}

	public void paint(Graphics g ){
	
		g.drawString("Hamed",x,getHeight()/2);  // draw date in applet 
	
	
	}
	
	public void run(){
		
		while(true){
			try{
				
				if(x < getWidth()){
				
					x++;
				}
				if(x == getWidth()){
				
					x =0 ;
				}
				 repaint(); 
				_thread.sleep(10); 
				
			}
			catch (InterruptedException ie){
			
				ie.printStackTrace(); 
			
		}
		
	}

}
}
