package basicjavapgm;

public class PalindromeInteger {
	
	public static void main(String[] args) {
	 
		int r,sum=0,temp,n=551;
		
		temp=n;
		
		while (n>0) {
			
			r=n%10;
			n=n/10;
			sum=(sum*10)+r;
			
		}
		if (temp==sum) {
			System.out.println(" palindrome " +sum);
		}
		else {
			System.out.println(" notpalindrome " +sum);
		}
		
		
	}

}
