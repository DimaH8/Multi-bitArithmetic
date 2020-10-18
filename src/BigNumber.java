
public class BigNumber {
	long[] array = new long[64];  // One cell contains 32 bits => 32*64 = 2048 bit
		
	public BigNumber(String value) {
		ReadNumber(value);
	}
	public BigNumber() {}

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
			/*String reverseSubStroka = new StringBuilder(subStroka).reverse().toString();
			array[i] = Long.parseUnsignedLong(reverseSubStroka, 16); */
			array[i] = Long.parseUnsignedLong(subStroka, 16);
		}
	}
	
	String GetString() {
		
		String stroka = "";
		
		for (int i = array.length - 1; i >= 0 ; i--)
		{
			int cell = (int) array[i];
			String substring = Integer.toHexString(cell);
			//String reverseSubString = new StringBuilder(substring).reverse().toString();	
			//stroka = stroka + reverseSubString;
			stroka = stroka + substring;
		}
		return stroka;
	}
	
	BigNumber Add(BigNumber number) {
		// this [BigNumber] -- перший доданок
		// number [BigNumber] -- другий доданок
		// result [BigNumber] -- повертаємо результат додавання
		BigNumber result = new BigNumber();
		long carry = 0; 
		for (int i = 0; i < array.length; i++) {
			long temp = this.array[i] + number.array[i] + carry;
			result.array[i] = temp & ( (1L << 32) - 1);
			carry = (temp >> 32);
		}

		return result;
	}
	
	BigNumber Subtraction(BigNumber number) {
		// this [BigNumber] -- перший доданок
		// number [BigNumber] -- другий доданок
		// result [BigNumber] -- повертаємо результат додавання
		BigNumber result = new BigNumber();
		long borrow = 0; 
		for (int i = 0; i < array.length; i++) {
			long temp = this.array[i] - number.array[i] - borrow;
			if (temp >= 0) {
				result.array[i] = temp;
				borrow = 0;
			}
			else {
			result.array[i] = temp + (1L << 32);
			borrow = 1;
			}
		}

		return result;
	}

	
	int Compare()
	{
		
		return 0;
	}

	
}

	
		
	
		
	