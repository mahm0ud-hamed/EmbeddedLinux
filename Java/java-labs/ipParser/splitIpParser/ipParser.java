public class ipParser {

	public static void main(String[] args){
	
	if(args[0].length() == 0){
	
		System.out.println("invalid ip address "); 
	}
	else{
		String ipadd = args[0]; 
		String [] substr = ipadd.split("\\.");
		
		for(int i = 0 ; i< substr.length;i++){

			System.out.println(substr[i]); 
			
		}  
		
	
	
	}
      }
} 
