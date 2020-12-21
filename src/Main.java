import org.javatuples.Pair;

//import org.javatuples.Pair;

public class Main {

	public static void main(String[] args) {
		BigNumber numb1 = new BigNumber("A46534BFF");
		BigNumber numb2 = new BigNumber("87");
			
		System.out.println("This is first number:\r\n" + numb1.GetString());
		System.out.println("This is second number:\r\n" + numb2.GetString());
		/*
		BigNumber numb3 = numb1.Add(numb2);
		System.out.println("This is suma:\r\n" + numb3.GetString());
			
		int result = numb1.Cmp(numb2);
		System.out.println("This is result of compare:\r\n" + result);
		
		BigNumber numb5 = numb1.LongMul(numb2);
		System.out.println("This is MulMol:\r\n" + numb5.GetString());
		
		BigNumber numb6 = numb1.SquareMul();
		System.out.println("This is SquareMul:\r\n" + numb6.GetString());
		*/
		BigNumber numb7 = numb1.LongPower(numb2);
		System.out.println("This is LongPower:\r\n" + numb7.GetString());
		//System.out.println("Bit:" + numb2.GetBit(4));
		
	/*
		Pair<BigNumber, BigNumber> pair = numb1.LongDivMod(numb2); 
		BigNumber Q = pair.getValue0();
		BigNumber P = pair.getValue1();
		System.out.println("Q:\r\n" + Q.GetString());
		System.out.println("P:\r\n" + P.GetString());
	
		
		BigNumber numb4 = numb1.Sub(numb2);
		System.out.println("This is subtraction:\r\n" + numb4.GetString());
	
	
		BigNumber mu = numb2.BarretPreCompute();
		System.out.println("mu:\r\n" + mu.GetString());
		BigNumber numb8 = numb1.BarrettReduction(numb2, mu);
		System.out.println("Barret:\r\n" + numb8.GetString()); 
		
		//int k = numb1.BitLength();
		//System.out.println("BitLength:" + k);
		
		BigNumber numb8 = numb1.Gsd(numb2);
		System.out.println("Gsd:\r\n" + numb8.GetString());
		numb8 = numb1.Lcm(numb2);
		System.out.println("Lcm:\r\n" + numb8.GetString());
 */
		BigNumber numb9 = numb1.LongModPowerBarrett(numb1, numb2) ;
		System.out.println("PowerModBarrett:\r\n" + numb9.GetString());

	}
	
	
}
