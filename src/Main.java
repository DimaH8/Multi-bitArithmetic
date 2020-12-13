import org.javatuples.Pair;

//import org.javatuples.Pair;

public class Main {

	public static void main(String[] args) {
		BigNumber numb1 = new BigNumber("243F11FA243F11FFFF32FFFFF7654FF45FF4AABCEFFF");
		BigNumber numb2 = new BigNumber("FFFFF234567FFF");
			// B3CEBC5B7F698FF87B7BED132D299F68010583247B9C9792E809ED86C07B4D65C9E83AEE30897B0DAB7E5883EABE17B40B8F39267AC62377A6AFE0976AA0B81707282EB5
		    // 8703A
		System.out.println("This is first number:\r\n" + numb1.GetString());
		System.out.println("This is second number:\r\n" + numb2.GetString());
		/*BigNumber numb3 = numb1.Add(numb2);
		System.out.println("This is suma:\r\n" + numb3.GetString());
			
		int result = numb1.Cmp(numb2);
		System.out.println("This is result of compare:\r\n" + result);
		
		BigNumber numb5 = numb1.LongMul(numb2);
		System.out.println("This is MulMol:\r\n" + numb5.GetString());
		
		BigNumber numb6 = numb1.SquareMul();
		System.out.println("This is SquareMul:\r\n" + numb6.GetString());
		*/
		//BigNumber numb7 = numb1.LongPower(numb2);
		//System.out.println("This is LongPower:\r\n" + numb7.GetString());
		//System.out.println("Bit:" + numb2.GetBit(4));
		
	/*
		Pair<BigNumber, BigNumber> pair = numb1.LongDivMod(numb2); 
		BigNumber Q = pair.getValue0();
		BigNumber P = pair.getValue1();
		System.out.println("Q:\r\n" + Q.GetString());
		System.out.println("P:\r\n" + P.GetString());
		
		BigNumber numb4 = numb1.Sub(numb2);
		System.out.println("This is subtraction:\r\n" + numb4.GetString());
	*/
		int k = numb1.BitLength();
		BigNumber B2k = new BigNumber();
		B2k.SetBit(k);
		Pair<BigNumber, BigNumber> pair = B2k.LongDivMod(numb2);
		System.out.println("Div Ok");
		BigNumber mu = pair.getValue0();
		BigNumber numb8 = numb1.BarrettReduction(numb2, mu);
		System.out.println("Barret:\r\n" + numb8.GetString());
	}
	
}
