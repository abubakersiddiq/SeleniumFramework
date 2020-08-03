package basicjavapgm;

public class PalindromeStringAndReverseString {
	
	public static void main(String[] args) {
	 
		String name="mada";
		String rev="";
		
		for (int i = name.length()-1; i >=0 ; i--) {
			
			rev=rev+name.charAt(i);
			
		}
		
		System.out.println("Reverse of String :" + rev);
		
		if (rev.equals(name)) {
			
			System.out.println("palindrome" );
			
		}
		else {
			System.out.println("not palindrome" );
		}
		
	}

}
