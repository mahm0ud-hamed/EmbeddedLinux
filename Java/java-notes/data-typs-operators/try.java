 public class person{

	private int age ; 
	private String name ; 
	
	public try(int age , int name ){
		this.age=age ; 
		this.name = name ; 
	}
	
	public String getName(){
	
		return name ; 
	}
	
	public int getAge(){
		return age ; 
		
	}
}


public class dog extends try{

	private String childname ; 
	
	public dog(int age , String Childname , String Parentname){
	
		super(int , parentname); 
		
		this.childname=childname ; 
	}
	
	public String getParentName(){
	
		return super.name ; 
		 
	}
}

public class MAIN{

	public class void main(String [] args ){
		
		dog popy = new dog(10 , "peter", "meme"); 
		popy.getParentName(); 
	
	}
}
