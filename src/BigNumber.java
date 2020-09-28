
public class BigNumber {
	// Чому я вибрав ромір 64 комірки?
	int[] array = new int[64]; 
	
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
			String stroka = initNumber.substring(start, end);
			amountSymbols =- 9;
			String data = new StringBuilder(stroka).reverse().toString();
			array[i] = Integer.parseUnsignedInt(data, 16);
		}
	}
	
	void PrintNumber() {
		for (int i = 0; i < array.length ; i++)
		{
			System.out.print(Integer.toHexString(array[i]));
		}
		
	}
	
	
	// public int number = Integer.parseInt(initNumber, 2);
	
}

		
	