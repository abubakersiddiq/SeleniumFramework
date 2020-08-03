package basicjavapgm;

import java.util.HashMap;
import java.util.Map;

public class NumberofOccurence {
	public static void main(String[] args) {
		
		String s="Rafan Abubaker";
		
		char[] charArray = s.toCharArray();
		
		Map<Character, Integer>occurence=new HashMap<Character, Integer>();
		for (char c : charArray) {
			
			if (occurence.containsKey(c)) {
				
				int valueChar=occurence.get(c);
				occurence.put(c, valueChar+1);				
			}
			else {
				occurence.put(c, 1);
			}
			
		}
		System.out.println("number of character repeated in the word is : " +occurence);
	}
}
