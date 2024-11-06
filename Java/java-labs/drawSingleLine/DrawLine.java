import java.applet.Applet ;
import java.awt.Graphics;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseAdapter; 


public class DrawLine extends Applet {

	boolean isPressed = false ;
	boolean isDraged = false ;   
	int pressedX ; 
	int PressedY ; 
	int draggedX ; 
	int draggedY ; 
	

public void init(){
	myMouse mouse = new myMouse(); 
	 
	this.addMouseListener(mouse);
	this.addMouseMotionListener(mouse);

}

public void paint(Graphics g ){

	if (isDraged == true )
	g.drawLine(pressedX , PressedY , draggedX ,draggedY ); 

}




class myMouse extends MouseAdapter{

	 	public void mousePressed(MouseEvent e){
	 		isPressed= true ; 
	 		pressedX = e.getX() ; 
	 		PressedY = e.getY() ; 
	 	
	 	}
	 	
	 	public void mouseReleased(MouseEvent e){
	 	
	 		
	 	}
	 	
	 	public void mouseDragged(MouseEvent e){
	 	
	 		isDraged = true ; 
	 		draggedX = e.getX() ;
	 		draggedY = e.getY() ;
	 		repaint();
	 		
	 	}
	 	

}

}
