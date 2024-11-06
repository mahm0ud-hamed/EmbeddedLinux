import java.applet.Applet ;
import java.awt.Graphics;
import java.awt.event.KeyAdapter ; 
import java.awt.event.KeyEvent ;

public class MovedString extends Applet {
 
	int step ; 
	int pressedX; 
	int pressedY; 

public void init(){
	step = 30 ; 
	pressedX= getWidth()/2 ;
	pressedY= getHeight()/2 ;
	
	MyKpd keyPad = new MyKpd(); 
	this.addKeyListener(keyPad);

}

public void paint(Graphics g ){

	g.drawString("Hamed" , pressedX, pressedY ); 

}




class MyKpd extends KeyAdapter{

	// when key is released 
	public void keyReleased(KeyEvent e){
	
		if(e.getKeyCode() == e.VK_UP || e.getKeyCode() == e.VK_KP_UP){
		
			pressedY-=step ; 
		}
		else if (e.getKeyCode() == e.VK_KP_DOWN || e.getKeyCode() == e.VK_DOWN ){
			pressedY+=step ;
		}
		
		 else if (e.getKeyCode() == e.VK_KP_RIGHT || e.getKeyCode() == e.VK_RIGHT ){
			pressedX+=step; 
		}
		
		else if (e.getKeyCode() == e.VK_KP_LEFT || e.getKeyCode() == e.VK_LEFT){
				pressedX-=step; 
		}
		repaint(); 
	}
	
	
}
}
