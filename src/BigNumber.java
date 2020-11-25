
public class BigNumber {
	long[] array = new long[64];  // One cell contains 32 bits => 32*64 = 2048 bit
	//int a;
		
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
			array[i] = Long.parseUnsignedLong(subStroka, 16);
		}
	}
	
	String GetString() {
		
		String stroka = "";
		
		for (int i = array.length - 1; i >= 0 ; i--)
		{
			int cell = (int) array[i];
			String substring = Integer.toHexString(cell);
			while (substring.length() %8 != 0 ) 
			{ 
				substring = 0 + substring;
			}	
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
			carry = (temp >>> 32);
		}

		return result;
	}
	
	BigNumber Sub(BigNumber number) {
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

	int Cmp(BigNumber numberB) {

		int i = array.length - 1;
		while (i != -1 && this.array[i] == numberB.array[i]) {
			i = i - 1;
		}
		if (i == -1) { return 0; }
		else { 
			if( this.array[i] > numberB.array[i] ) { return 1; }
			else { return -1; }
		}

	}
	
	BigNumber LongMulOneDigit( long b ) {
		// this [BigNumber] -- перший доданок
		// number [BigNumber] -- другий доданок
		// result [BigNumber] -- повертаємо результат додавання
		BigNumber result = new BigNumber();
		long carry = 0; 
		for (int i = 0; i < array.length / 2; i++) {
			long temp = this.array[i]*b + carry;
			result.array[i] = temp & ( (1L << 32) - 1);
			carry = (temp >>> 32);
		}
		result.array[array.length / 2] = carry;
		return result;
 
	}
	
	private void LongShiftDigitsToHigh_UpTo32(int count) { 
		long carry = 0;

		if (count > 32 || count < 0) {
			throw new IllegalArgumentException("Error of count32: " + count);                                                  
	    }
		
		for (int j = 0; j < array.length; j++) {
			
			long ltemp = this.array[j] << count;
			ltemp = ltemp + carry;
			carry = (ltemp >>> 32);
			this.array[j] = ltemp & ( (1L << 32) - 1);
		}
	}
	
	void LongShiftDigitsToHigh(int count) { 
		 if (count == 0) {return;}
		 if (count < 0) {
			throw new IllegalArgumentException("Error of count32: " + count);
		 }
		 
		 while (count > 32) {
			 LongShiftDigitsToHigh_UpTo32(32);
		    count = count - 32; 
		 }
		 // count < 32 
		 LongShiftDigitsToHigh_UpTo32(count);
	}
	
	BigNumber LongMul( BigNumber number ) {
		// this [BigNumber] -- перший доданок
		// number [BigNumber] -- другий доданок
		// result [BigNumber] -- повертаємо результат додавання
		BigNumber result = new BigNumber();
		for (int i = 0; i < array.length; i++) {
			 BigNumber temp = LongMulOneDigit(number.array[i]);
			 temp.LongShiftDigitsToHigh(i*32);
			 BigNumber temp2 = result.Add(temp);
			 result = temp2;
			 }
		return result;
	}
	
	 BigNumber SquareMul (BigNumber number) {
			 
		BigNumber result = new BigNumber();
		BigNumber numb11 = new BigNumber();
		BigNumber numb12 = new BigNumber();
		BigNumber numb21 = new BigNumber();
		BigNumber numb22 = new BigNumber();
		
		for (int i = 0; i < array.length/2; i++) {
			numb11.array[i] = this.array[i];
			numb21.array[i] = number.array[i];
		}
		
		for (int i = array.length/2; i < array.length; i++) {
			numb12.array[i] = this.array[i];
			numb22.array[i] = number.array[i];
		}
		BigNumber first =  numb11.LongMul(numb12);
		first.LongShiftDigitsToHigh(64);
		
		BigNumber third = numb11.LongMul(numb12);
		BigNumber second = first.Add(third);
		second.LongShiftDigitsToHigh(32);
		
		BigNumber ttemp = numb21.Sub(numb11);
		BigNumber ttemp2 = numb12.Sub(numb22);
		BigNumber mttemp = ttemp.LongMul(ttemp2);
		BigNumber newthird = mttemp.Add(third);
		
		result = first.Add(second);
		result = result.Add(newthird);
		return result;
		
		/* BigNumber temp1 = numb11.Add(numb12);
		BigNumber temp2 = numb21.Add(numb22);
		BigNumber temp3 = temp1.LongMul(temp2);
		BigNumber temp4 = numb11.LongMul(numb22);
		BigNumber temp5 = temp3.Sub(first);
		BigNumber second = temp5.Sub(temp4);


		second.LongShiftDigitsToHigh(32);
		result = first.Add(second);
		result = result.Add(third); */
	} 
	
	
}

	
		
	
		
	