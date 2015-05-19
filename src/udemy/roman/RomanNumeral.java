package udemy.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

	private Map<String, Integer> table;

	public RomanNumeral() {
		table = new HashMap<String, Integer>();
		table.put("I", 1);
		table.put("V", 5);
		table.put("X", 10);
	}
	
	public int convert(String roman) {
		int result = 0;
		for(int i = 0; i < roman.length(); i++) {

			int right = nextRoman(roman, i);
			int current = table.get(String.valueOf(roman.charAt(i)));
			
			if(right > current) {
				current *= -1;
			}
			
			result += current;
		}
		
		return result;
	}

	private int nextRoman(String roman, int i) {
		int right = 0;
		if(i < roman.length()-1) {
			String rightRoman = roman.substring(i+1, i+2);
			right = table.get(rightRoman);
		}
		return right;
	}

}
