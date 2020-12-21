import org.javatuples.Pair;

public class BigNumber {
	long[] array = new long[64];  // One cell contains 32 bits => 32*64 = 2048 bit
		
	public BigNumber(String value) {
		ReadNumber(value);
	}
	public BigNumber() {}
	
	public BigNumber(BigNumber number) {
		for (int i = 0; i < array.length; i++) {
			array[i] = number.array[i];
		}		
	}

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
		SelfCheck();
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
	
	public String toString() {
		return GetString();
	}
	
	private void SelfCheck() {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > ((1L <<32) - 1)) {
				throw new IllegalArgumentException("Error: Self check failed");
			}
		}
	}
	
	BigNumber Add(BigNumber number) {
		// this [BigNumber] -- ïåðøèé äîäàíîê
		// number [BigNumber] -- äðóãèé äîäàíîê
		// result [BigNumber] -- ïîâåðòàºìî ðåçóëüòàò äîäàâàííÿ
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
		// this [BigNumber] -- ïåðøèé äîäàíîê
		// number [BigNumber] -- äðóãèé äîäàíîê
		// result [BigNumber] -- ïîâåðòàºìî ðåçóëüòàò äîäàâàííÿ
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
		if (borrow == 1) { throw new IllegalArgumentException("Error: The second number is greater than the first"); }
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
		
		for (int j = 0,i = array.length/2; i < array.length; i++, j++) {
			
			half1.array[j] = this.array[i];
		}
		BigNumber first =  half1.LongMul(half1);
		BigNumber temp = first;
		first.LongShiftDigitsToHigh(64);
		
		BigNumber second = half0.Add(half1);
		second = second.LongMul(second);
		BigNumber third = half0.LongMul(half0);
		//BigNumber temp3 = second.Sub(temp);
		//second = temp3.Sub(third);
		//second.LongShiftDigitsToHigh(32);
		BigNumber temp3 = temp.Add(third);
		if (second.Cmp(temp3) != -1) { second = second.Sub(temp3); }
		else { second = temp3.Sub(second); }
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
		return (int) ((array[cell] >>> shift) & 1L);
	}
	
	void SetBit(int pos) {
		int cell = pos / 32;
		int aim = pos % 32;
		array[cell] = array[cell] | (1L << (aim));	
	}
	
	BigNumber LongPower(BigNumber number) {
		BigNumber result = new BigNumber();
		result.SetBit(0);
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
	
		Pair<BigNumber, BigNumber> LongDivMod( BigNumber number) {
		BigNumber chastka = new BigNumber(); // Q
		BigNumber ostacha = new BigNumber(); // R
		int k = number.BitLength();
		ostacha = this; 
		while(ostacha.Cmp(number) == 1 || ostacha.Cmp(number) == 0) {
			int t = ostacha.BitLength();
			BigNumber C = new BigNumber(number);  // C
			C.LongShiftDigitsToHigh(t-k); 
			if (ostacha.Cmp(C) == -1) {
				t = t - 1;
				BigNumber temp = new BigNumber(number);
				temp.LongShiftDigitsToHigh(t-k);
				C = new BigNumber(temp);
			}
			ostacha = ostacha.Sub(C);
			chastka.SetBit(t-k); 
		}
		Pair<BigNumber, BigNumber> pair = Pair.with(chastka, ostacha);
		return pair;
	}
		  //  LABA 2
		
	private void ShiftRight_UpTo32(int count) { 
		long carryOld = 0;
		long carryNew = 0;

		if (count > 32 || count < 0) {
			throw new IllegalArgumentException("Error of count32: " + count);                                                  
	    }
		
		for (int j = array.length-1; j >= 0; j--) {
			
			carryNew = this.array[j] & ((1L << (count)) - 1);
			long ltemp = this.array[j] >>> count;
			this.array[j] = ltemp + (carryOld << (32 - count));
			carryOld = carryNew;
		}
	}
	
	void ShiftRight(int count) { 
		 if (count == 0) {return;}
		 if (count < 0) {
			throw new IllegalArgumentException("Error of count32: " + count);
		 }
		 
		 while (count > 32) {
			 ShiftRight_UpTo32(32);
		    count = count - 32; 
		 }
		 // count < 32 
		 ShiftRight_UpTo32(count);
	}
	
	BigNumber ModPow2(int pow) {
		int cell = pow / 32;
		int aim = pow % 32;
		
		BigNumber result = new BigNumber();
		for (int i = 0; i < cell; i++) {
			result.array[i] = array[i];
		}
		result.array[cell] = array[cell] & ((1L << aim) - 1L);
		return result;
	}
	
    BigNumber BarretPreCompute() {
    	// this = mod
        int k_minus_1 = BitLength();
        int k = k_minus_1 + 1;
        if (k > 1023) {
        	// îñê³ëüêè ðåàë³çàö³ÿ ëàáîðàòîðíî¿ ðîáîòè ìîæå âì³ùàòè íå á³ëüøå í³æ 2048 á³ò, à çàïèñ B^2k 
        	// çàéìàº 2k+1 á³ò, òîìó ìàêñèìàëüíå çíà÷åííÿ k ìîæå áóòè 1023 á³òè.
        	throw new IllegalArgumentException("Error: lenght of k > 1023. k = " + k); 
        }
        int two_k = 2 * k;
        BigNumber B = new BigNumber();
        B.SetBit(two_k);
        Pair<BigNumber, BigNumber> pair = B.LongDivMod(this);
        BigNumber mu = pair.getValue0();
        return mu;
    }
		
	BigNumber BarrettReduction(BigNumber mod, BigNumber mu)	{
		// this = x
		if ((this.BitLength() + 1) > 2*(mod.BitLength() +1)) {
			System.out.println("Lenght x: " + (this.BitLength() + 1));
			System.out.println("Lenght mod: " + (mod.BitLength() + 1));
			throw new IllegalArgumentException("Error: By definition: |n| = k, |x| = 2k");
		}
		BigNumber result = new BigNumber();
		BigNumber q = new BigNumber(this);
		int k = (mod.BitLength() + 1);
		//System.out.println(k + " = k");
		if (k > 1023) { 
			// îñê³ëüêè ðåàë³çàö³ÿ ëàáîðàòîðíî¿ ðîáîòè ìîæå âì³ùàòè íå á³ëüøå í³æ 2048 á³ò, à çàïèñ B^2k 
			// çàéìàº 2k+1 á³ò, òîìó ìàêñèìàëüíå çíà÷åííÿ k ìîæå áóòè 1023 á³òè.
			throw new IllegalArgumentException("Error: lenght of k > 1023. k = " + k); 
		}
		q.ShiftRight(k-1);
		//System.out.println(q + " = q1");
		q = q.LongMul(mu);
		//System.out.println(mu + " = mu");
		//System.out.println(q + " = q2");
		q.ShiftRight(k+1);
		//System.out.println(q + " = q3");
		BigNumber r1 = this.ModPow2(k+1);
		//System.out.println(r1 + " = r1");
		BigNumber temp = q.LongMul(mod);
		//System.out.println(temp + " = r2 ... temp");
		BigNumber r2 = temp.ModPow2(k+1);
		//System.out.println(r2 + " = r2");
		if (r1.Cmp(r2) == -1) { 
			//System.out.println("BarretReduction: set k+1 = " + (k+1));
			r1.SetBit(k+1);
		} 
		result = r1.Sub(r2); 
		//System.out.println(result + " = result");
		int count = 0;
		while (result.Cmp(mod) != -1) {
			result = result.Sub(mod);
			count++;
		}
		//System.out.println("BarretReduction: loop count " + count);
		return result;
	}
	BigNumber Abs (BigNumber num) {
		if ( this.Cmp(num) == 1 ) { return this.Sub(num); }
		else { return num.Sub(this); }
	}
	
	BigNumber Min (BigNumber num) {
		if ( this.Cmp(num) == 1) {return num;}
		else {return this;}
	}
	
	BigNumber Gsd (BigNumber number) {
		BigNumber result = new BigNumber();
		BigNumber num1 = new BigNumber(this);
		BigNumber num2 = new BigNumber(number);
		result.SetBit(0);
		while (((num1.GetBit(0) %2) == 0) && (num2.GetBit(0) %2) == 0) {
			num1.ShiftRight(1);
			num2.ShiftRight(1);
			result.ShiftRight(1);
		}
		while ((num1.GetBit(0) %2) == 0) {
			num1.ShiftRight(1);
		}
		BigNumber nul = new BigNumber();
		while (num2.Cmp(nul) != 0) {
			while ( (num2.GetBit(0) %2) == 0) {
				num2.ShiftRight(1);	
			}
			num1 = num1.Min(num2);
			num2 = num2.Abs(num2);
		}
		result = result.LongMul(num1);
		return result;
	}
	BigNumber Lcm (BigNumber number) {
		BigNumber temp0 = this.LongMul(number);
		BigNumber temp1 = this.Gsd(number);
		Pair<BigNumber, BigNumber> pair = temp0.LongDivMod(temp1);
        BigNumber result = pair.getValue0();		
		return result;
	}
	BigNumber LongModPowerBarrett (BigNumber number, BigNumber mod) {
		BigNumber result = new BigNumber();
		BigNumber A = new BigNumber(this);
		result.SetBit(0);
		BigNumber mu = result.BarretPreCompute();
	for (int i = 0; i <= number.BitLength() ; i++) {
			
			if (number.GetBit(i) == 1)
			{ 
				result = result.LongMul(A);
				result = result.BarrettReduction(mod, mu) ;
			}
			//if (i != 0) {
			A = result.LongMul(A);
			A = A.BarrettReduction(mod, mu);
			//}
		}
		return result;
	}
}


                                         
	
		
	
		
	
