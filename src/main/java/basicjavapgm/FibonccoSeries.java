package basicjavapgm;

public class FibonccoSeries {
	
	public static void main(String[] args) {
		int a=0,b=1,temp,n=10;
		// TODO Auto-generated method stub
		System.out.println(a+" "+b);
	
		for (int i = 0; i < n; i++) {
			
			temp=a+b;
			System.out.println(""+temp);
			a=b;
			b=temp;
		}
	}

}
