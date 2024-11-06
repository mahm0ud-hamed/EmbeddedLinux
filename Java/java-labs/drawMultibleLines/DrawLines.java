import java.applet.Applet ;
import java.awt.Graphics;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseAdapter; 


public class DrawLines extends Applet {

	boolean isPressed = false ;
	boolean isDraged = false ;   
	int pressedX ; 
	int PressedY ; 
	int draggedX ; 
	int draggedY ; 
	line[] lines ;
	int counter ; 

public void init(){

	
	counter =0 ;  
	lines = new line[3];
	myMouse mouse = new myMouse();  
	this.addMouseListener(mouse);
	this.addMouseMotionListener(mouse);

}

public void paint(Graphics g ){
		
		if(isDraged == true  && counter < 3 ){
		
			g.drawLine(pressedX, PressedY, draggedX ,draggedY ); 
			isDraged =false  ;
		
		}
		
		if (counter > 0 && counter  < 3 ){
			for(int i = 0 ; i < counter ;i++){
		
				g.drawLine(lines[i].getPoint1X() , lines[i].getPoint1Y(), lines[i].getPoint2X() ,lines[i].getPoint2Y() ); 
			}
		}
}





class myMouse extends MouseAdapter{

	 	public void mousePressed(MouseEvent e){
	 		
	 		pressedX = e.getX();  
	 		PressedY = e.getY() ;
	 		
	 		if(counter < 3 ){
	 			lines[counter] = new line();
	 			lines[counter].setPoint1X(e.getX()) ; 
	 			lines[counter].setPoint1Y(e.getY()) ;
	 		}
 			else {
 			
 				return ;
 			}
	 	
	 	}
	 	
	 	public void mouseDragged(MouseEvent e){
	 	
	 		isDraged= true ; 
	 		draggedX = e.getX(); 
	 		draggedY = e.getY();
	 		if(counter < 3 ){
	 		lines[counter].setPoint2X(e.getX()) ;
	 		lines[counter].setPoint2Y(e.getY()); 
	 		
	 		}
	 		
	 		repaint();
	 	}
	 	
	 	public void mouseReleased(MouseEvent e){
	 		
	 		if (counter < 3  )
	 			counter ++ ;
	 		
	 		
	 	}
	 	

	 	

}

}


class line {

	private int point1X ; 
	private int point2X ; 
	private int point1Y ; 
	private int point2Y ; 
	
	public void setPoint1X(int point1X){
	
		this.point1X = point1X ; 
	}
	public void setPoint2X(int point2X){
	
		this.point2X = point2X ; 
	}
	public void setPoint1Y(int point1Y){
	
		this.point1Y = point1Y ; 
	}
	public void setPoint2Y(int point2Y){
	
		this.point2Y = point2Y ; 
	}
	
	
	
	
	public int getPoint1X(){
	
		return  point1X ; 
	}
	public int getPoint2X(){
	
		return point2X ; 
	}
	public int getPoint1Y(){
	
		return point1Y ; 
	}
	public int getPoint2Y(){
	
		return point2Y ; 
	}		
}
