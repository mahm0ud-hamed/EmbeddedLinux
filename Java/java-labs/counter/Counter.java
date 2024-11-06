import java.applet.Applet ;
import java.awt.Graphics;
import  java.awt.Button ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent;



public class Counter extends Applet {
	int count ; 
	Button incBtn ; 
	Button decBtn ; 
	
public void init(){
	/***** intialize attributes ***/ 
	
	count =0 ;
	incBtn = new Button(" + "); 
	decBtn = new Button(" - ");
	Increment incrementListner = new Increment(); 
	incBtn.addActionListener(incrementListner);
	
	/******************** annnymous class ************/ 
	decBtn.addActionListener(new ActionListener(){
	
		 public void actionPerformed(ActionEvent e){
	 	
	 		count-- ; 
	 		repaint(); 
	 	}

	
	});
	
	/********** show button *****/ 
	add(incBtn); 
	add(decBtn) ; 
	

}

public void paint(Graphics g ){

	g.drawString(""+count , getWidth()/2 , getHeight()/2); 

}



class Increment implements  ActionListener{

	 	public void actionPerformed(ActionEvent e){
	 	
	 		count++ ; 
	 		repaint(); 
	 	}
}


}

