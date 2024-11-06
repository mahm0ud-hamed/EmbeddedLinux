
import java.util.ArrayList ;

class hamed  {

	private int point1X ; 
	private int point2X ; 
	private int point1Y ; 
	private int point2Y ; 
	
	public void setPoint1X(int point1X){
	
		this.point1X = point1X ; 
	}
	public void setPoint2X(int point2X){
	
		this.point2X = point2X ; 
	}
	public void setPoint1Y(int point1Y){
	
		this.point1Y = point1Y ; 
	}
	public void setPoint2Y(int point2Y){
	
		this.point2Y = point2Y ; 
	}
	
	
	
	
	public int getPoint1X(){
	
		return  point1X ; 
	}
	public int getPoint2X(){
	
		return point2X ; 
	}
	public int getPoint1Y(){
	
		return point1Y ; 
	}
	public int getPoint2Y(){
	
		return point2Y ; 
	}		
}


public  class arraylist {

	public static void main(String[] args ){
	
		ArrayList<hamed> mahmoud = new ArrayList<hamed>() ; 
		mahmoud.add(new hamed()); 
		mahmoud.get(0).setPoint1X(10);
		System.out.println(mahmoud.get(0).getPoint1X());
		
	
	}
}
