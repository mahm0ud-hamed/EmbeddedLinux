import java.applet.Applet ;
import java.awt.Graphics ;
import java.awt.Color; 

import java.awt.GraphicsEnvironment;

public class MAIN extends Applet{

	public void paint(Graphics g){
		
			g.setColor(Color.YELLOW); 
			g.fillOval(150,50,100,30);// top oval 
			
			g.setColor(Color.BLACK); 
			
			g.drawLine(150,70,100,150);//left line
			g.drawLine(250,70,300,150);// right line 
			
			
			g.drawLine(170,175,150,300);//left down line
			g.drawLine(200,175,220,300);// right down line                                                                                       
                       
                       g.drawRect(120,300, 130,  40);//base 
                       g.setColor(Color.YELLOW); 
                       
                       g.fillOval(150,90,15,60);// left oval 
                       g.fillOval(235,90,15,60); // right oval 
                       g.fillOval(180,90,30,60); // right oval 
                       
                       g.setColor(Color.BLACK); 
                       
                       g.drawArc(100 , 122 , 200 , 50 , -180,180 ); // arch 
                       
	}
	
	
	/*public abstract void drawArc(int x,
                             int y,
                             int width,
                             int height,
                             int startAngle,
                             int arcAngle)*/
}

