package basicjavapgm;

public class PrintPrimeNumber {

	public static void main(String[] args) {
		int n=50;
		int i,j;

		for (i = 15; i < n; i++) {

			for ( j = 2; j <= i; j++) {
				if(i%j==0) {
					break;
				}
			}
			if (i==j) {
				System.out.println("prime number"+i);
			}
		}
	}
}