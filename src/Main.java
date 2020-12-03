import org.javatuples.Pair;

public class Main {

	public static void main(String[] args) {
		BigNumber numb1 = new BigNumber("8703A1E982F278420C2D60CA7A0ED76C91855E3147B50357074A04EAF6515F07C1D8967674C7577D4112652E8135D145329F0DAE738F75C35004A154F1C43449DB87B6BE0F3EBF5B3BA1016F0A04A10C7EA76C3D30EEDB34B1E6E1009B3FF5C987FA313097485E6F8C78744E2F49DF62D13AD204E00F731BAE0E085C353D8D75");
		BigNumber numb2 = new BigNumber("B3CEBC5B7F698FF87B7BED132D299F68010583247B9C9792E809ED86C07B4D65C9E83AEE30897B0DAB7E5883EABE17B40B8F39267AC62377A6AFE0976AA0B81707282EB5FE59B66ED5EB1D3118CA3555F3AFCC28990AB016FE5B89D9159E6BB26151C923501F69629A0D75A6C06B8D0AA0364694DDCEDE35441E011347F85E62");
		System.out.println("This is first number:\r\n" + numb1.GetString());
		System.out.println("This is second number:\r\n" + numb2.GetString());
		
		BigNumber numb3 = numb1.Add(numb2);
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
	
		Pair<BigNumber, BigNumber> pair = numb1.LongDivMod(numb2); 
		BigNumber Q = pair.getValue0();
		BigNumber P = pair.getValue1();
		System.out.println("Q:\r\n" + Q.GetString());
		System.out.println("P:\r\n" + P.GetString());
	}
	
}
