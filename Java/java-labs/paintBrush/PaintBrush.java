
/* import neccessary library */ 
import java.applet.Applet ;
import java.awt.Graphics;
import java.awt.Color ; 

/* buttons action and action listener */
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

/** mouse action listener  */
import java.awt.event.MouseEvent ;
import java.awt.event.MouseAdapter; 

/** array list import  */
import java.util.ArrayList ;
/** buttons import  */
import java.awt.Button ; 




public class PaintBrush extends Applet {

	

	/* buttons for select color */
	Button [] colorButtons = new Button[3];  
	Button [] shapesButtons = new Button[9]; 

	/* array list of shapes  */
	public int countShapes = 0; 
	public ArrayList <Shape> shapesArray ; 
	public boolean isDragged=false  ;


public void init(){

	shapesArray = new ArrayList <Shape>();

	/*color buttons*/
	colorButtons[0] = new Button("RED"); 
	colorButtons[1] = new Button("GREEN");
	colorButtons[2] = new Button("BLUE"); 

	colorButtons[0].setBackground(Color.RED);
	colorButtons[1].setBackground(Color.GREEN);
	colorButtons[2].setBackground(Color.BLUE);

	setBackground(Color.WHITE);
	shapesButtons[0] = new Button("Rectangle"); 
	shapesButtons[1] = new Button("Oval");
	shapesButtons[2] = new Button("line"); 
	shapesButtons[3] = new Button("FreeHand"); 
	shapesButtons[4] = new Button("FILL"); 
	shapesButtons[5] = new Button("Outline");
	shapesButtons[6] = new Button("UNDO");
	shapesButtons[7] = new Button("ClearAll");
	shapesButtons[8] = new Button("Eraser");


	for(int index =0 ; index < colorButtons.length ; index++){

		add(colorButtons[index]);
	} 
	/*shpes slection buttons*/ 

	for(int index =0 ; index < shapesButtons.length ; index++){

		add(shapesButtons[index]);
	} 

	/*link color Buttons  */
	RedSelection redSlectionListener = new RedSelection(); 
	GreenSelection greenSlectionListner = new GreenSelection(); 
	BlueSelection blueSelectioListner = new BlueSelection(); 
	colorButtons[0].addActionListener(redSlectionListener);
	colorButtons[1].addActionListener(greenSlectionListner);
	colorButtons[2].addActionListener(blueSelectioListner) ;

	/** link shapes buttons */

	OvalSelection ovalActionListener = new OvalSelection(); 
	RectangleSelection recActionListener = new RectangleSelection(); 
	LineSelectoin lineActionListener = new LineSelectoin(); 
	FreeHandSelection fHandActionListener = new FreeHandSelection(); 
	FillSelection fillActionListener = new FillSelection();
	OutlineSelection outLineActionListener = new OutlineSelection(); 
	UndoSelection undoActionListener = new UndoSelection(); 
	ClearAllSelelction clearAllActionListener = new ClearAllSelelction();
	EraserSelection eraserActionListener = new EraserSelection();
	shapesButtons[0].addActionListener(recActionListener); 
	shapesButtons[1].addActionListener(ovalActionListener); 
	shapesButtons[2].addActionListener(lineActionListener); 
	shapesButtons[3].addActionListener(fHandActionListener);
	shapesButtons[4].addActionListener(fillActionListener);
	shapesButtons[5].addActionListener(outLineActionListener);
	shapesButtons[6].addActionListener(undoActionListener);
	shapesButtons[7].addActionListener(clearAllActionListener);
	shapesButtons[8].addActionListener(eraserActionListener);

	/** link mouse action  */
	MouseActions mouse = new MouseActions();  
	this.addMouseListener(mouse);
	this.addMouseMotionListener(mouse);



}

public void paint(Graphics g ){
	if(isDragged == true ){
	shapesArray.get(shapesArray.size()-1).drawShape(g);
	isDragged= false  ; 
	}

	for(Shape shape : shapesArray){
		shape.drawShape(g);
	}

}

class MouseActions extends MouseAdapter{

	public void mousePressed(MouseEvent e){
		/**depending on selection button we will instanciate an object of shape 
		 * this is shape selection flag 
		 */

		/** get pressing x & y points  */
		TempShape temp = new TempShape() ; 

		TempShape.xTempPress = e.getX(); 
		TempShape.yTempPress = e.getY(); 

		/** color selection */

		if(SelectionFlags.isRed == true){

			TempShape.TempColor = Color.RED ;
		}
		else if(SelectionFlags.isGreen == true){

			TempShape.TempColor = Color.GREEN ;
		}
		else if(SelectionFlags.isBlue == true){

			TempShape.TempColor = Color.BLUE ;
		}
		
		/**shpe selectoin */
		if (SelectionFlags.isOval == true){

			shapesArray.add(new Oval(temp));

		}
		else if (SelectionFlags.isRectangle == true){
			
			shapesArray.add(new Rectangle(temp));

			
		}
		else if (SelectionFlags.isLine == true ){

			shapesArray.add(new Line(temp));
		}
		else if ( SelectionFlags.isFreeHand == true){

			shapesArray.add(new FreeHand(temp));
		}
		
		else if (SelectionFlags.isErase == true){
			System.out.println("eraser object created");
			shapesArray.add(new Eraser(temp));
		}

	}
	public void mouseDragged(MouseEvent e){
		
		isDragged =true ;
		if(SelectionFlags.isFreeHand == false ){
			shapesArray.get(shapesArray.size()-1).updateDragedPoints(e.getX() , e.getY()); 
		}
		else if(SelectionFlags.isFreeHand == true){
			FreeHand tempFreeHand= (FreeHand) shapesArray.get(shapesArray.size()-1); 
			tempFreeHand.freeHandAddPoints(e.getX(),e.getY());
		}
		if (SelectionFlags.isErase == true ){
			System.out.println("dragging with erase ");
			Eraser tempEraser= (Eraser) shapesArray.get(shapesArray.size()-1); 
			tempEraser.eraserAddPoints(e.getX(),e.getY());
		}
		// will repaint and update the points of shapes 
		repaint();
	}


}

/********** undo class actio listener innerclass ******* */
class UndoSelection implements ActionListener{


	public void actionPerformed(ActionEvent e){
		if(shapesArray.size() > 0 ){
		shapesArray.remove(shapesArray.size()-1); 
		repaint();
		} 
	}
}

/*************************** Clear all action listener inner class  ******* */

class ClearAllSelelction implements ActionListener{

	public void actionPerformed(ActionEvent e){

		if (!shapesArray.isEmpty()){
			shapesArray.clear(); 
			repaint();
		}
	}
}


}



/**************************** buttons action listener ******************************/

class SelectionFlags {

	public static boolean isRectangle = false ; 
	public static boolean isOval= false ; 

	/** free hand initiated by true to be the default for the program  */
	public static boolean isFreeHand = true ; 

	public static boolean isLine = false ; 
	public static boolean isRed = false ; 
	public static boolean isGreen = false ;
	public static boolean isBlue = false ;

	public static boolean isErase = false ;
	

}
/*****************************color selection action listner ******************** */

class RedSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){

		SelectionFlags.isRed = true; 
		SelectionFlags.isGreen = false ;
		SelectionFlags.isBlue = false ;
	}

}

class GreenSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){
		SelectionFlags.isRed = false ; 
		SelectionFlags.isGreen = true ;
		SelectionFlags.isBlue = false ;
	}

}

class BlueSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){
		SelectionFlags.isRed = false ; 
		SelectionFlags.isGreen = false ;
		SelectionFlags.isBlue = true ;
	}

}

/*****************************Shapes slection action listener ***************************/

class OvalSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){
		
		SelectionFlags.isErase = false ;
		SelectionFlags.isRectangle = false;
		SelectionFlags.isFreeHand = false;
		SelectionFlags.isLine = false ; 
		SelectionFlags.isOval= true ;


	}

}

class RectangleSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){

		SelectionFlags.isErase = false ;
		SelectionFlags.isOval= false ; 
		SelectionFlags.isFreeHand = false;
		SelectionFlags.isLine = false ; 
		SelectionFlags.isRectangle = true;

	}

}
class LineSelectoin implements ActionListener{

	public void actionPerformed(ActionEvent e){
		SelectionFlags.isErase = false ;
		SelectionFlags.isRectangle = false;
		SelectionFlags.isOval= false  ; 
		SelectionFlags.isFreeHand = false;
		SelectionFlags.isLine = true ; 
	}

}

class FreeHandSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){
		SelectionFlags.isErase = false ;
		SelectionFlags.isRectangle = false;
		SelectionFlags.isOval= false  ; 
		SelectionFlags.isLine = false  ; 
		SelectionFlags.isFreeHand = true;

	}

}

class EraserSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){
		SelectionFlags.isRectangle = false;
		SelectionFlags.isOval= false  ; 
		SelectionFlags.isLine = false  ; 
		SelectionFlags.isFreeHand = false;

		SelectionFlags.isErase = true ; 
		System.out.println("Eraser flag is raised ");


	}

}
/******************* fill action listener *******************************/
class FillSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){

		TempShape.isFill = true; 
	}

}

class OutlineSelection implements ActionListener{

	public void actionPerformed(ActionEvent e){

		TempShape.isFill = false ; 

	}
}


/* temp class used to carry info for current shape to apass it to shape constructor */ 
class TempShape {

	public static  int xTempPress ; 
	public static  int yTempPress ;
	public static  int xTempDragged ; 
	public static  int yTempDragged ; 

	public static boolean isFill = false ; 


	public static Color TempColor = Color.BLACK;  

}

/* parent class of all shapes  */

abstract class  Shape {

	protected int xPressPOint ; 
	protected int ypressPoint ; 

	protected int yDraggedPoint ; 
	protected int xDraggedPoint ; 

	protected boolean shapeFill = false  ; 

	abstract public void drawShape(Graphics g);


	public void updateDragedPoints(int updateX , int updateY ){

		xDraggedPoint= updateX ; 
		yDraggedPoint =updateY ; 

	}
}

class Rectangle extends Shape {

		private int width ; 
		private int height ; 
		private Color RecColor ;

	Rectangle(){

	}
	Rectangle(TempShape info){
		xPressPOint = info.xTempPress ; 
		ypressPoint = info.yTempPress ;
		shapeFill = info.isFill ; 
		RecColor  = info.TempColor ;

	}

	public void drawShape(Graphics g){
		
		width = xDraggedPoint - xPressPOint ; 
		height = yDraggedPoint-ypressPoint ; 

		g.setColor(RecColor);
		if (shapeFill == true){

			
			g.fillRect(xPressPOint , ypressPoint , width , height ); 
		}
		else if (shapeFill == false ){ 
			g.drawRect(xPressPOint , ypressPoint , width ,height ); 

		}
	}

}

class Oval extends Shape {

	private int width ; 
	private int height ; 
	private Color ovalColor; 
	Oval(){}
	Oval(TempShape info){
		xPressPOint = info.xTempPress ; 
		ypressPoint = info.yTempPress ;
		shapeFill = info.isFill ; 
		ovalColor  = info.TempColor ;
	}

	public void drawShape(Graphics g){
		
		width = xDraggedPoint - xPressPOint ; 
		height = yDraggedPoint-ypressPoint ; 
		g.setColor(ovalColor);
		if (shapeFill == true){

			g.fillOval(xPressPOint , ypressPoint , width , height ); 
		}
		else if (shapeFill == false ){
			g.drawOval(xPressPOint , ypressPoint , width ,height ); 

		}
	}



}

class Line extends Shape{

	private Color lineColor ;

	Line(){}
	Line(TempShape info){

		xPressPOint = info.xTempPress ; 
		ypressPoint = info.yTempPress ;
		shapeFill = info.isFill ; 
		lineColor = info.TempColor ;

		
	}
		
	public void drawShape(Graphics g){

			g.setColor(lineColor);
			g.drawLine(xPressPOint , ypressPoint , xDraggedPoint , yDraggedPoint ); 

	}
}

class FreeHand extends Shape{
	
	private ArrayList<Integer> xPoints; 
	private ArrayList<Integer> yPOints;
	private Color freeHandColor;


	FreeHand(){

	}
	FreeHand(TempShape info){
		xPoints = new ArrayList <Integer>(); 
		yPOints = new ArrayList <Integer>(); 
		xPoints.add(info.xTempPress); 
		yPOints.add(info.yTempPress); 
		freeHandColor= info.TempColor ; 
	}
	public void freeHandAddPoints(int x , int y){
		xPoints.add(x);
		yPOints.add(y); 
	}

	public void drawShape(Graphics g){
			g.setColor(freeHandColor);
		for(int i =0 ; i< xPoints.size()-1; i++){
			g.drawLine(xPoints.get(i) , yPOints.get(i) , xPoints.get(i+1) , yPOints.get(i+1));

		}
	}	

}

class Eraser extends Shape{
	
	private ArrayList<Integer> xPoints; 
	private ArrayList<Integer> yPOints;
	private int width ; 
	private int height ; 
	private Color eraserColor ;


	Eraser(){
		eraserColor = Color.WHITE ;
		width = 20;
		height = 20; 
	}
	Eraser(TempShape info){
		xPoints = new ArrayList <Integer>(); 
		yPOints = new ArrayList <Integer>(); 
		xPoints.add(info.xTempPress); 
		yPOints.add(info.yTempPress); 
		eraserColor = Color.WHITE ;
		width = 20;
		height = 20; 

	}
	public void eraserAddPoints(int x , int y){
		xPoints.add(x);
		yPOints.add(y); 

	}

	public void drawShape(Graphics g){
			g.setColor(eraserColor);
		for(int i =0 ; i< xPoints.size()-1; i++){
			g.fillOval(xPoints.get(i) , yPOints.get(i) , width , height);

		}
	}	

}