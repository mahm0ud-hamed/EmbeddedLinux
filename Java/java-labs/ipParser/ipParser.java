/*public int indexOf(String str,int fromIndex)
                   
Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
The returned index is the smallest value k for which:

 k >= fromIndex  && this.startsWith(str, k)
 
If no such value of k exists, then -1 is returned.
Parameters:
str - the substring to search for.
fromIndex - the index from which to start the search.
Returns:
the index of the first occurrence of the specified substring, starting at the specified index, or -1 if there is no such occurrence.*/

/*
public String substring(int beginIndex)
Returns a string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string.
Examples:

 "unhappy".substring(2) returns "happy"
 "Harbison".substring(3) returns "bison"
 "emptiness".substring(9) returns "" (an empty string)
 
Parameters:
beginIndex - the beginning index, inclusive.
Returns:
the specified substring.
Throws:
IndexOutOfBoundsException - if beginIndex is negative or larger than the length of this String object.



*/
public class ipParser{
    public static void main(String [] args){  

	if(args[0] != null){
		String ipadd = args[0] ; 
		int i = 0; 
		String substr; 
		int index = 0 ; 
		while(i < ipadd.length()){
		
			index = ipadd.indexOf('.'); 
			substr= ipadd.substring(0,index); 
			System.out.println(substr); 
			ipadd = ipadd.substring(index+1); 
			i= index; 
		}
		substr=ipadd.substring(0) ; 
		System.out.println(substr); 
	}
    }
}
