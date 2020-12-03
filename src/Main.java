
public class Main {

	public static void main(String[] args) {
		BigNumber numb1 = new BigNumber("F");
		BigNumber numb2 = new BigNumber("5");
		System.out.println("This is first number:\r\n" + numb1.GetString());
		System.out.println("This is second number:\r\n" + numb2.GetString());
		
		 /*BigNumber numb3 = numb1.Add(numb2);
		System.out.println("This is suma:\r\n" + numb3.GetString());
		
		BigNumber numb4 = numb1.Sub(numb2);
		System.out.println("This is subtraction:\r\n" + numb4.GetString());
		
		int result = numb1.Cmp(numb2);
		System.out.println("This is result of compare:\r\n" + result);
		
		BigNumber numb5 = numb1.LongMul(numb2);
		System.out.println("This is MulMol:\r\n" + numb5.GetString());
		
		BigNumber numb6 = numb1.SquareMul();
		System.out.println("This is SquareMul:\r\n" + numb6.GetString());
		
		BigNumber numb7 = numb1.LongPower(numb2);
		System.out.println("This is LongPower:\r\n" + numb7.GetString());
		*/ 
		BigNumber numb8 = numb1.LongDivMod(numb2); 
		System.out.println("This is LongDivMod:\r\n" + numb8.GetString());
	}
	
}
