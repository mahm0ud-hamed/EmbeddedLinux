class Complex{
	private double real ; 
	private double img ; 

	public double  getReal(){
		return real ; 
	} 

	public double getImaginary(){
		return img ; 
	}

	Complex(double real , double img ){
		this.real = real ; 
		this.img  = img ;
	}

	public static Complex sumComplex(Complex obj1 , Complex obj2 ){
		Complex temp = new Complex(0,0) ; 
		temp.real= obj1.getReal() + obj2.getReal() ; 
	       	temp.img = obj1.getImaginary() + obj2.getImaginary() ; 
		
		return temp ; 	
	}

	 public static Complex subComplex(Complex obj1 , Complex obj2 ){
                Complex temp = new Complex(0,0) ;
                temp.real= obj1.getReal() - obj2.getReal() ;
                temp.img = obj1.getImaginary() - obj2.getImaginary() ;

                return temp ;
        }


	public static void printComplex(Complex obj){

			System.out.println(obj.getReal() + " " + obj.getImaginary()+ "i"); 
		
	}


}

public class MAIN{
	public static void main(String[] args ){
		Complex obj1 = new  Complex(1 ,-3); 
		Complex obj2 = new Complex (2 , -2) ; 

		Complex sum ; 
		Complex sub ;
		sum = Complex.sumComplex(obj1 , obj2 ); 
		sub = Complex.subComplex(obj1 , obj2 );
		System.out.print("sum ");
		Complex.printComplex(sum);
		System.out.print("sub ");
		Complex.printComplex(sub);
	}
}
