package basicjavapgm;

import java.util.Scanner;

public class AmstrongNumber {
	
	public static void main(String[] args) {
	 
		int r,sum=0,temp;
		//int n=153;
		
		Scanner sc = new Scanner(System.in);
	     int n = sc.nextInt();
		
		temp=n;
		
		while (n>0) {
			
			r=n%10;
			n=n/10;
			sum=sum+(r*r*r);
			
		}
		if (temp==sum) {
			System.out.println(" Amstrongnumber " +sum);
		}
		else {
			System.out.println(" notAmstrongnumber " +sum);
		}
		
		
	}

}
