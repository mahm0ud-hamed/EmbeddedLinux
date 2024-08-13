abstract class shape {
	abstract public double  calcArea(); 
	
	private int dim1 ; 

	public void setDim1(int dim1){
		if(dim1>0){
			this.dim1=dim1 ;
		}	
	}

	public int getDim1(){
		return dim1 ; 
	}
	shape(){
		dim1=0 ; 
	}

	shape(int dim1){
		if(dim1>0){
			this.dim1=dim1 ; 
		}
	}
}

class Rectangle extends shape{
	public int dim2 ; 

	public void setDim2(int dim){
		dim2 = dim ; 

	}
	public int getDim2(){
		return dim2 ; 
	}
	/*overridded function */

	public double calcArea(){

		return dim2 * super.getDim1() ; 
	}

	/* constructors*/ 

	Rectangle(){
		dim2 =0 ; 
	}

	Rectangle(int x , int y){
		super(x); 
		dim2 = y ; 
	}

	

}

class Circle extends shape{
	private double  PI = 3.14; 

	/* ovridded function */ 

	public double calcArea(){
		return super.getDim1()*PI*2; 
	}

	/* cinstructors */

	Circle (int dim){
		super(dim); 
	}
}

class Triangle extends shape{
	private int height ;

	public void setHeight(int h ){
		if(h > 0 ){
			height = h ; 
		}
		 
	}
	
	public int getHeight(){
		return height ; 
	}

	public double calcArea(){
		return 0.5*super.getDim1()*height; 
	}

	/* constructor*/

	Triangle(int x , int y){
		super(x); 
		height=y ;
	}

	public double areaSum(shape circ , shape rec , shape tring){
		return circ.calcArea() + rec.calcArea() + tring.calcArea();  
	}

}

public class MAIN{
	public static void main(String[] args){
		Rectangle myrec = new Rectangle(3,4);
		Circle mycircle = new Circle(3); 
		Triangle  mytriangle = new Triangle(3 ,3); 
		System.out.println("ractangle area" + myrec.calcArea());
		System.out.println("circle area "+ mycircle.calcArea()); 
		System.out.println("triangle area "+ mytriangle.calcArea()); 
		
		System.out.println(mytriangle.areaSum(mycircle , mytriangle , myrec));	

	}

}
