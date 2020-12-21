import org.javatuples.Pair;

public class Main {

	public static void main(String[] args) {	
		BigNumber numb1 = new BigNumber("a34fd32a");
		BigNumber numb2 = new BigNumber("401fdc");
			
		System.out.println(numb1 + " = num1");
		System.out.println(numb2 + " = num2");
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
		
		//BigNumber numb7 = numb1.LongPower(numb2);
		//System.out.println(numb7 + " = LongPower");
		
		
//		Pair<BigNumber, BigNumber> pair = numb1.LongDivMod(numb2); 
//		BigNumber Q = pair.getValue0();
//		BigNumber P = pair.getValue1();
//		System.out.println("Q:\r\n" + Q.GetString());
//		System.out.println("P:\r\n" + P.GetString());
//	
//		
//		BigNumber numb4 = numb1.Sub(numb2);
//		System.out.println("This is subtraction:\r\n" + numb4.GetString());
//				
//		
//		BigNumber mu = numb2.BarretPreCompute();
//		System.out.println(mu + " = mu");
//		BigNumber numb8 = numb1.BarrettReduction(numb2, mu);
//		System.out.println(numb8 + " = num1 mod num2 (Barret)"); 
		
		//int k = numb1.BitLength();
		//System.out.println("BitLength:" + k);
		
		BigNumber numb9 = numb1.Gsd(numb2);
		System.out.println(numb9 + " = Gsd");
		//numb9 = numb1.Lcm(numb2);
		//System.out.println(numb9 + " = Lcm");
 
		BigNumber A = new BigNumber("a34fd32a");
		BigNumber B = new BigNumber("40");
		BigNumber N = new BigNumber("7543678fda");
		BigNumber numb10 = A.LongModPowerBarrett(B, N) ;
		System.out.println(numb10 + " = PowerModBarrett");
	}
	
	
}
