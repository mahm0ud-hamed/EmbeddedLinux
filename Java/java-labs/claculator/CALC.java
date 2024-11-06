public class CALC {

	public static void main(String[] args){
		
		/*parsing string to intger */

		int op1 = Integer.parseInt(args[0]) ;
	    
		if (args.length == 3){
			int op2 = Integer.parseInt(args[2]);
			switch(args[1]){
				case "+":
					System.out.println(op1+ " + " + op2 + " = "+(op1+op2)); 	
				break ;
				case "-":
					System.out.println(op1+ " - " + op2 + " = "+(op1-op2));
					break ;
					case "x":
					System.out.println(op1+ " X " + op2 + " = "+(op1*op2));
					break ;
					case "/":
						if(op2 == 0 ){
						System.out.println("can't divide by zero"); 
						}
						else {
							System.out.println(op1+ " / " + op2 + " = "+(op1/op2));
						}
					break ;

				default: 
					System.out.println("invalid operation");
				


				}

		}
		else {
			System.out.println("invlaid argument");
		}
		
	}

}
