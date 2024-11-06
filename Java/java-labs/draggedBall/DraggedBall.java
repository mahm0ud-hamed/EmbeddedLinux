import java.applet.Applet ;
import java.awt.Graphics;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseAdapter; 


public class DraggedBall extends Applet {

	boolean isPressed = false ;
	boolean isDraged = false ;   
	int pressedX   ; 
	int PressedY; 
	int draggedX ; 
	int draggedY ; 
	

public void init(){

	pressedX= getWidth()/2 ;
	PressedY= getHeight()/2 ;
	myMouse mouse = new myMouse(); 
	 
	this.addMouseListener(mouse);
	this.addMouseMotionListener(mouse);

}

public void paint(Graphics g ){

	//if (isDraged == true )
	//fillOval(int x, int y, int width, int height)
	g.fillOval(pressedX , PressedY , 100 ,100 ); 

}




class myMouse extends MouseAdapter{

	 /*	public void mousePressed(MouseEvent e){
	 		isPressed= true ; 
	 		pressedX = e.getX() ; 
	 		PressedY = e.getY() ; 
	 	
	 	}*/
	 	
	 	public void mouseReleased(MouseEvent e){
	 	
	 		
	 	}
	 	
	 	public void mouseDragged(MouseEvent e){
	 	
	 		isDraged = true ; 
	 		pressedX = e.getX() ;
	 		PressedY = e.getY() ;
	 		repaint();
	 		
	 	}
	 	

}

}
