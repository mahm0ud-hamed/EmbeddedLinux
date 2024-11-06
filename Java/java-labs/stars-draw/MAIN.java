public class MAIN{

	public static void main(String [] args){
	
		int n =8 ; 
		for (int i =0 ; i< n ; i++ ){
			for(int j =0 ; j< n*2 ; j++){
			
				if((j <= i)){
				
					System.out.print("*");
				}
				else if(j>n && j<=(n+i)){
					System.out.print("*");
				
				}
				else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
	
	

	}
}
