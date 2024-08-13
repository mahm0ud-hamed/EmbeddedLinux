class parent{
	
	private int no1 ; 
	private int no2 ;



	public void setNo1(int n1 ){
		no1= n1 ; 

	}

	public void setNo2(int n2){
		no2 = n2 ;
	}

	public int getNo1(){
		return no1 ; 
	}

	public int getNo2(){
	
		return no2;
	}

	public int sum(){
		return no1 + no2 ; 
	}

	/* constructors */ 

	parent(){
		no1=0; 
		no2=2 ; 
	}

	parent(int x , int y ){
	
		no1= x ; 
		no2= y ; 

	}

}


class child extends parent {

	private int  no3 ; 

	public void setNo3(int n3){
		no3 = n3 ; 
	}

	public int getNo3(){
		return no3 ; 
	}
	

	public int sum(){
	
		return no3 + super.sum(); 
	}
	/* constructors */ 

	child (){
		no3 = 0 ; 
	}

	child(int x , int y, int z  ){
		super(x ,y ); 
		no3=z ; 
		
	}

}



public class MAIN{

	public static void main(String[] args){
	
		child mahmoud = new child(3 , 4 ,5 ); 

		System.out.println("the child instance "+ mahmoud.getNo1() + mahmoud.getNo2() + mahmoud.getNo3() ); 

		System.out.println("the sum of all is "+ mahmoud.sum()); 
	}
}
