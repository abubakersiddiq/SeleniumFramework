package basicjavapgm;

public class Factorial {
	int a=5,temp=1;

	public void factWay1() {

		while (a>0) {

			temp=temp*a;
			a--;

		}
		System.out.println("factWay1 :" + temp);
	}

	public void factWay2() {

		for(int i=1;i<=a; i++){    
			temp=temp*i;;    
		}    

		System.out.println("fact 2 :" + temp);

	}

	public static void main(String[] args) {

		new Factorial().factWay1();
		new Factorial().factWay2();

	}

}
