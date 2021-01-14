import java.math.BigInteger;

import org.javatuples.Pair;

public class Main {

	public static void main(String[] args) {	
		
		BigNumber numb1 = new BigNumber("94EDE1A444B9738ADF06CDB40DCAFA87B25A8BECA2D2262A53D8431A119405F0CBEFB83D2AD547CCE3AE74A8EC74A313C8BED20D4349D9EFBA356FE6E8AD89E2");
		BigNumber numb2 = new BigNumber("5BCC0B222EE17877C9EB60FA91632BC7A6E29D80F02CD3FE16B5C2A2231B43DB2B2D12F21B293AAF49FE1165CB7A21D12D6ACEC225285544B36BABD3F8B4DD8D");
		BigNumber mod   = new BigNumber("8E06E4DFFB37B57A66ECC52CF2D7D888C49C2794E6FB944C4183A128203932FEBEA4B6E62B2EBDAD4FF0B80DBEDC8439D31280D13E7E523596D92861F6A89E81");	
		BigNumber numb3 = new BigNumber("bcbAAFFFF6584A5768798A5763874A77479812AACC43475454bcbcbcbAAFFFF6584AF4FAE324454bcbcbc567798387412AF7438F75454bcbcbcbAAFFFF6584AF4cbcbAAFFFF6584A5768798A576879897FFF834947437989703A57");
		
		System.out.println(numb1 + " = num1");
		System.out.println(numb2 + " = num2");
		System.out.println(numb3 + " = num3 \r\n");
		System.out.println(mod   + " =  mod \r\n");
		
		long avTime = 0;
		String temp = "";
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb0 = numb1.Add(numb2);
			j++;
			
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb0.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + "= Suma");
		System.out.println("Time of work <Add> is: " + avTime);
		temp = "";
		avTime = 0;
		

		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			int result = numb1.Cmp(numb2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = String.valueOf(result);
		}
		avTime = avTime/100;
		System.out.println(temp + "= Compare");
		System.out.println("Time of work <Compare> is: " + avTime);
		avTime = 0;
		temp = "";

		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb5 = numb1.LongMul(numb2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb5.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + "= MulMol");
		System.out.println("Time of work <Multiplication> is: " + avTime);
		avTime = 0;
		temp = "";
		
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb6 = numb1.SquareMul();
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb6.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + "= SquareMul");
		System.out.println("Time of work <Square Multiplication> is: " + avTime);
		avTime = 0;
		temp = "";

		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb7 = numb1.LongPower(numb2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb7.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + "= LongPower");
		System.out.println("Time of work <LongPower> is: " + avTime);
		avTime = 0;
		temp = "";

		
		String temp2 = "";
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			Pair<BigNumber, BigNumber> pair = numb1.LongDivMod(numb2); 
			BigNumber Q = pair.getValue0();
			BigNumber P = pair.getValue1();
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = Q.GetString();
			temp2 = P.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + "= Q" );
		System.out.println(temp2 + "= P");
		System.out.println("Time of work <Division> is: " + avTime);
		avTime = 0;	
		temp = "";
		temp2 = "";

		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb4 = numb1.Sub(numb2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb4.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + "= Subtraction");	
		System.out.println("Time of work <Subtraction> is: " + avTime);
		avTime = 0;	
		temp = "";

		// Tests 1
		
		BigNumber numb9 = numb1.Test10(numb2, numb3);
		System.out.println(numb9 + " = (a + b)*c ");
		
		BigNumber numb10 = numb1.Test11(numb2, numb3);
		System.out.println(numb10 + " = c*(a + b)");

		BigNumber numb11 = numb1.Test12(numb2, numb3);
		System.out.println(numb11 + " = a*c + b*c \r\n");
		
		BigNumber numb110 = numb1.Test20();
		System.out.println(numb110 + " = n*a");
		
		BigNumber numb111 = numb1.Test21();
		System.out.println(numb111 + " = a + a + ... + a");

		
//		--------------LABA 2--------------
// /*		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb12 = numb1.Gsd(numb2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb12.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = Gsd");	
		System.out.println("Time of work <Gsd> is: " + avTime);
		avTime = 0;	
		temp = "";

//---------------
		for (int j = 0; j < 100; j++) {
			
			BigNumber numb12 = numb1.Gsd(numb2);
			long startTime = System.nanoTime();

			numb12 = numb1.Gsd(numb2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb12.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = Lsm");	
		System.out.println("Time of work <Lsm> is: " + avTime);
		avTime = 0;	
		temp = "";
//--------
		BigNumber mu = mod.BarretPreCompute();
		System.out.println(mu + " = mu");
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb8 = numb1.BarrettReduction(mod, mu);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb8.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = num1 mod num2 (BarrettReduction)");	
		System.out.println("Time of work <BarrettReduction> is: " + avTime);
		avTime = 0;	
		temp = ""; 
//-------
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb13 = numb1.AddMod(numb2, mod, mu) ;
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb13.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = AddMod");	
		System.out.println("Time of work <AddMod> is: " + avTime);
		avTime = 0;	
		temp = ""; 
//------
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb14 = numb1.SubMod(numb2, mod, mu) ;
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb14.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = SubMod");	
		System.out.println("Time of work <SubMod> is: " + avTime);
		avTime = 0;	
		temp = "";
//-----		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb15 = numb1.MulMod(numb2, mod, mu) ;
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb15.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = MulMod");	
		System.out.println("Time of work <MulMod> is: " + avTime);
		avTime = 0;	
		temp = "";
//------		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb16 = numb1.SquareMulMod(mod, mu) ;
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb16.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = SquareMod");	
		System.out.println("Time of work <SquareMod> is: " + avTime);
		avTime = 0;	
		temp = "";
		
//--------
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			BigNumber numb17 = numb1.LongModPowerBarrett(numb2, mod) ;
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = numb17.GetString();
		}
		avTime = avTime/100;
		System.out.println(temp + " = PowerModBarrett");	
		System.out.println("Time of work <PowerModBarrett> is: " + avTime);
		avTime = 0;	
		temp = "";
		
	// Tests 2	

		BigNumber numb18 = numb1.Test110(numb2, numb3, mod, mu);
		System.out.println(numb18 + " = Test10");
		
		BigNumber numb19 = numb1.Test111(numb2, numb3, mod, mu);
		System.out.println(numb19 + " = Test11");

		BigNumber numb20 = numb1.Test112(numb2, numb3, mod, mu);
		System.out.println(numb20 + " = Test12");
		
		BigNumber numb21 = numb1.Test210(mod, mu);
		System.out.println(numb21 + " = Before equal");
		
		BigNumber numb22 = numb1.Test211(mod, mu);
		System.out.println(numb22 + " = After equal");
		

	// Built-in operations
		
		String stroka1 = "94EDE1A444B9738ADF06CDB40DCAFA87B25A8BECA2D2262A53D8431A119405F0CBEFB83D2AD547CCE3AE74A8EC74A313C8BED20D4349D9EFBA356FE6E8AD89E2";
		String stroka2 = "5BCC0B222EE17877C9EB60FA91632BC7A6E29D80F02CD3FE16B5C2A2231B43DB2B2D12F21B293AAF49FE1165CB7A21D12D6ACEC225285544B36BABD3F8B4DD8D";
		String stokamod   = "8E06E4DFFB37B57A66ECC52CF2D7D888C49C2794E6FB944C4183A128203932FEBEA4B6E62B2EBDAD4FF0B80DBEDC8439D31280D13E7E523596D92861F6A89E81";
		BigInteger number1 = new BigInteger(stroka1, 16);
		BigInteger number1Copy = new BigInteger(stroka1, 16);
		BigInteger number2 = new BigInteger(stroka2, 16);
		BigInteger bmod   = new BigInteger(stokamod, 16);
		BigInteger[] pair;
		BigInteger[] tempDiv = null;
		int res = 0;


//		long avTime = 0;
//		String temp3 = "";
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.add(number2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println();
		System.out.println();
		System.out.println(temp + " = BuiltAdd");	
		System.out.println("Time of work <BuiltAdd> is: " + avTime);
		avTime = 0;	
		temp = ""; 

        
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.subtract(number2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = BuiltSubtract");	
		System.out.println("Time of work <BuiltSubtract> is: " + avTime);
		avTime = 0;	
		temp = ""; 
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			res = number1.compareTo(number2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;

		}
		avTime = avTime/100;
		System.out.println(res + " = BuiltcompareTo");	
		System.out.println("Time of work <BuiltcompareTo> is: " + avTime);
		avTime = 0;	
		temp = ""; 

		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.multiply(number2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = Builtmultiply");	
		System.out.println("Time of work <Builtmultiply> is: " + avTime);
		avTime = 0;	
		temp = ""; 
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.multiply(number1);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = BuiltSquareMultiply");	
		System.out.println("Time of work <BuiltSquareMultiply> is: " + avTime);
		avTime = 0;	
		temp = ""; 	
		
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			pair = number1.divideAndRemainder(number2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			tempDiv = pair;
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(tempDiv[0] + " = BuiltQ");	
		System.out.println(tempDiv[1] + " = BuiltP");	
		System.out.println("Time of work <BuiltDivision> is: " + avTime);
		avTime = 0;	
		temp = ""; 
//-----------------------
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.mod(bmod);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println();
		System.out.println();
		System.out.println(temp + " = BuiltBarret");	
		System.out.println("Time of work <BuiltBarret> is: " + avTime);
		avTime = 0;	
		temp = ""; 

		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.add(number2);
			number1 = number1.mod(bmod);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println();
		System.out.println();
		System.out.println(temp + " = BuiltAddMod");	
		System.out.println("Time of work <BuiltAddMod> is: " + avTime);
		avTime = 0;	
		temp = ""; 

        
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.subtract(number2);
			number1 = number1.mod(bmod);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = BuiltSubtractMod");	
		System.out.println("Time of work <BuiltSubtractMod> is: " + avTime);
		avTime = 0;	
		temp = ""; 
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.multiply(number2);
			number1 = number1.mod(bmod);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = BuiltmultiplyMod");	
		System.out.println("Time of work <BuiltmultiplyMod> is: " + avTime);
		avTime = 0;	
		temp = ""; 
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.multiply(number1);
			number1 = number1.mod(bmod);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = BuiltSquareMultiplyMod");	
		System.out.println("Time of work <BuiltSquareMultiplyMod> is: " + avTime);
		avTime = 0;	
		temp = ""; 	
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.modPow(number2, bmod);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = BuiltPowerMod");	
		System.out.println("Time of work <BuiltPowerMod> is: " + avTime);
		avTime = 0;	
		temp = ""; 	
		
		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			pair = number1.divideAndRemainder(number2);
			pair[0] = pair[0].mod(bmod);
			pair[1] = pair[1].mod(bmod);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			tempDiv = pair;
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(tempDiv[0] + " = BuiltQ");	
		System.out.println(tempDiv[1] + " = BuiltP");	
		System.out.println("Time of work <BuiltDivision> is: " + avTime);
		avTime = 0;	
		temp = ""; 

		for (int j = 0; j < 100; j++) {
			long startTime = System.nanoTime();

			number1 = number1.gcd(number2);
			j++;
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			avTime = avTime + duration;
			temp = number1.toString(16);
			number1 = number1Copy;
		}
		avTime = avTime/100;
		System.out.println(temp + " = GSD");	
		System.out.println("Time of work <GSD> is: " + avTime);
		avTime = 0;	
		temp = ""; 
	}
	
}
