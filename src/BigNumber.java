
public class BigNumber {
	int[] array = new int[64];  // One cell contains 32 bits => 32*64 = 2048 bit
	
	void ReadNumber(String initNumber) {
		int amountSymbols = initNumber.length();
		
		System.out.println("It is init length: " + amountSymbols);
		
		while (amountSymbols %8 != 0 ) 
		{ 
			initNumber = 0 + initNumber;
			amountSymbols = initNumber.length();
		}
		
		System.out.println("It is length of massive: " + amountSymbols);
		
		for (int i = 0; i < array.length && amountSymbols > 0; i ++) 
		{
			int end = amountSymbols;
			int start = end - 8;
			String subStroka = initNumber.substring(start, end);
			amountSymbols = amountSymbols - 8;
			String reverseSubStroka = new StringBuilder(subStroka).reverse().toString();
			array[i] = Integer.parseUnsignedInt(reverseSubStroka, 16);
		}
	}
	
	void PrintNumber() {
		
		String stroka = null;
		
		for (int i = array.length - 1; i >= 0 ; i--)
		{
			String substring = Integer.toHexString(array[i]);
			String reverseSubString = new StringBuilder(substring).reverse().toString();
			
			if (i != 63) { stroka = stroka + reverseSubString; }
			else { stroka = reverseSubString; }	
		}
		
			System.out.print(stroka);	
	}
	
}

		
	