import java.applet.Applet ;
import java.awt.Graphics;
import java.util.Date ;

public class TimerApp extends Applet implements Runnable {
	
	Thread _thread ;  // thread refrence  

	public void init(){
	
		 _thread = new Thread(this) ; // create thread 
		_thread.start(); // start thread 
	}
	
	public void paint(Graphics g ){
	
		Date _date = new Date(); // gettig an object form data 
		g.drawString(_date.toString(),getWidth()/2,getHeight()/2);  // draw date in applet 
	
	}
	
	public void run(){
	
		while(true){
			try{
			
				repaint(); // this will update date o applet 
				_thread.sleep(1000); 	// sleep for one second 		
			
			
			}catch(InterruptedException ie){
			
				ie.printStackTrace(); 
			}

			
		}
	}



}
