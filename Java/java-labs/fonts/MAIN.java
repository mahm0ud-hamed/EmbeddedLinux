
import java.applet.Applet ;
import java.awt.Graphics ;
import  java.awt.Toolkit ;
import java.awt.Font;	
import java.awt.GraphicsEnvironment;

public class MAIN extends Applet{

		String [] s; 
		public void init(){
		GraphicsEnvironment t = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		 s = t.getAvailableFontFamilyNames(); 
		}
		
		public void paint(Graphics g){

		for(int i=0 ; i< s.length ;i++){
		
			Font _font = new Font(s[i], 30, 50); 
			g.setFont(_font) ; 
			g.drawString(s[i],100,100+(i*50)); 
			

		}
		 
	 }


		
			
}





