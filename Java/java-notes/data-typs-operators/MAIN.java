 class person{

	private int age ; 
	private String name ; 
	
	public person(int age , String name ){
		this.age=age ; 
		this.name = name ; 
	}
	
	public String getName(){
	
		return name ; 
	}
	
	public int getAge(){
		return age ; 
		
	}
	
	public void play(int x){
		System.out.println("parent play function "); 
	}
}


 class dog extends person{

	private String childname ; 
	
	public dog(int age , String Childname , String Parentname){
	
		super(age , Parentname); 
		
		this.childname=Childname ; 
	}
	
	public String getParentName(){
	
		return super.getName() ; 
		 
	}
	public void play(int x){
		System.out.println("child play function "); 
	}	
}

public class MAIN{

	public static void main(String [] args ){
		
		person popy = new dog(10,"jell:", "meme"); 
		//System.out.println(popy.getParentName());
		popy.play(5);  
			
		if(popy instanceof dog){
			System.out.println("is instance");
		}
	
	}
}
