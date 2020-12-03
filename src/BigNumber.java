import org.javatuples.Pair;

public class BigNumber {
	long[] array = new long[64];  // One cell contains 32 bits => 32*64 = 2048 bit
		
	public BigNumber(String value) {
		ReadNumber(value);
	}
	public BigNumber() {}

	void ReadNumber(String initNumber) {
		int amountSymbols = initNumber.length();
		
		//System.out.println("It is init length: " + amountSymbols);
		
		while (amountSymbols %8 != 0 ) 
		{ 
			initNumber = 0 + initNumber;
			amountSymbols = initNumber.length();
		}
		
		//System.out.println("It is length of massive: " + amountSymbols);
		
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
	
	BigNumber SquareMul() {
		BigNumber result = new BigNumber();
		BigNumber half0 = new BigNumber();
		BigNumber half1 = new BigNumber();
		
		for (int i = 0; i < array.length/2; i++) {
			half0.array[i] = this.array[i];
		}
		
		for (int i = array.length/2; i < array.length; i++) {
			half1.array[i] = this.array[i];
		}
		BigNumber first =  half1.LongMul(half1);
		BigNumber temp = first;
		first.LongShiftDigitsToHigh(64);
		
		BigNumber second = half0.Add(half1);
		second = second.LongMul(second);
		BigNumber third = half0.LongMul(half0);
		BigNumber temp3 = second.Sub(temp);
		second = temp3.Sub(third);
		second.LongShiftDigitsToHigh(32);
		
		result = first.Add(second);
		result = result.Add(third);
		
		return result; 
	} 
	
	final int  BitLength() {
		for (int i = array.length - 1; i >=  0; i--) {
			if (array[i] != 0) {
				for (int shift = 31; shift >= 0; shift--) {
					long temp = array[i] >>> shift;
			        if (temp == 1L) {
			        	int pos = shift;
			        	return 32*i + pos;
			        }
							
				}
					
			}
		}
		throw new IllegalArgumentException("Value of BigNumber is zero!");
	}
	
	int GetBit(int pos) {
		int cell = pos / 32;
		int shift = pos % 32;
		return (int) array[cell] >>> shift;
	}
	
	void SetBit(int pos) {
		int cell = pos / 32;
		int aim = pos % 32;
		array[cell] = array[cell] | (1L << (aim ));	
	}
	
	BigNumber LongPower(BigNumber number) {
		BigNumber result = new BigNumber();
		result.ReadNumber("1");
		for (int i = number.BitLength(); i >= 0 ; i--) {
			
			if (number.GetBit(i) == 1)
			{ 
				result = result.LongMul(this);
			}
			if (i != 0) {
				result = result.SquareMul();
			}
			
		}
		return result;
	}
	
	BigNumber LongDivMod( BigNumber number) {
		BigNumber chastka = new BigNumber(); // Q
		BigNumber ostacha = new BigNumber(); // R
		int k = number.BitLength();
		ostacha = this; 
		while(ostacha.Cmp(number) == 1) {
			int t = ostacha.BitLength();
			BigNumber C = number;  // C
			C.LongShiftDigitsToHigh(t-k); 
			if (ostacha.Cmp(C) == -1) {
				t = t - 1;
				C.LongShiftDigitsToHigh(t-k);
			}
			ostacha = ostacha.Sub(C);
			chastka.SetBit(t-k); 
		}
		Pair<BigNumber, BigNumber> pair = Pair.with(chastka, ostacha);
		System.out.println(pair);
		return ostacha;
	}
}
	
		
	
		
	