
import java.util.StringTokenizer; 

public class ipParser{

	public static void main(String args[]){
	
		if(args.length != 0){
		
			String ip = args[0]; 
			
			StringTokenizer substr= new StringTokenizer(ip,".");
			
			while(substr.hasMoreTokens()){
			
				System.out.println(substr.nextToken());
			} 
			
			
		}
		
		else {
		
			System.out.println("invalid IP"); 
		}
	
	}
}
