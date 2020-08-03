package basicjavapgm;

public class BiggestArray {

	public static void main(String[] args) {

		int arr[]= {10,2,3,5,7,15};
		
		int temp=arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i]>temp) {
				
				temp=arr[i];
			}
			
		}
		System.out.println(" Biggest largest digit : " +temp);
	
	}
}
