import org.javatuples.Pair;

public class Main {

	public static void main(String[] args) {	
		BigNumber numb1 = new BigNumber("DAF1ABDA4AD4D9FE3E36A529210C2AE99B905922FC0519798A26E351FE23AF375AD6BA288EE030B70DF0CE1CDF1E8B75BA56494DC6ED36B181814CD5783E6C81");
		BigNumber numb2 = new BigNumber("4D3C91C579C2C6216567A5241614B561ADDF76C4BB659E6FE7F65FF76A918C843F0458B3EF457BCD9022D78798A29462EC99C74E6674690267D3E9844251B39D");
		BigNumber mod   = new BigNumber("2AB3786D3A85E62EC763A05A73A7F08D21EEE3CBCAE207E40854121BFF8258F7B2B293B0D30277CDB987A6FCB5BF28B68D8E68ABA88DED37BD80A879A1BB53E3");	
//		BigNumber numb3 = new BigNumber("bcbAAFFFF6584A5768798A5763874A77479812AACC43475454bcbcbcbAAFFFF6584AF4FAE324454bcbcbc567798387412AF7438F75454bcbcbcbAAFFFF6584AF4cbcbAAFFFF6584A5768798A576879897FFF834947437989703A57");
		
		System.out.println(numb1 + " = num1");
		System.out.println(numb2 + " = num2");
//		System.out.println(numb3 + " = num3");
		System.out.println(mod   + " =  mod");
		/*
		BigNumber numb3 = numb1.Add(numb2);
		System.out.println("This is suma:\r\n" + numb3.GetString());
			
		int result = numb1.Cmp(numb2);
		System.out.println("This is result of compare:\r\n" + result);
		
		BigNumber numb5 = numb1.LongMul(numb2);
		System.out.println("This is MulMol:\r\n" + numb5.GetString());
		
		BigNumber numb6 = numb1.SquareMul();
		System.out.println("This is SquareMul:\r\n" + numb6.GetString());
		
		
		BigNumber numb7 = numb1.LongPower(numb2);
		System.out.println(numb7 + " = LongPower");
		
		
		Pair<BigNumber, BigNumber> pair = numb1.LongDivMod(numb2); 
		BigNumber Q = pair.getValue0();
		BigNumber P = pair.getValue1();
		System.out.println("Q:\r\n" + Q.GetString());
		System.out.println("P:\r\n" + P.GetString());
	
		
		BigNumber numb4 = numb1.Sub(numb2);
		System.out.println("This is subtraction:\r\n" + numb4.GetString());	
*/
		// Tests 1
/*		
		BigNumber numb9 = numb1.Test10(numb2, numb3);
		System.out.println(numb9 + " = Test10");
		
		BigNumber numb10 = numb1.Test11(numb2, numb3);
		System.out.println(numb10 + " = Test11");

		BigNumber numb11 = numb1.Test12(numb2, numb3);
		System.out.println(numb11 + " = Test12");
		
		BigNumber numb110 = numb1.Test20();
		System.out.println(numb110 + " = Before equal");
		
		BigNumber numb111 = numb1.Test21();
		System.out.println(numb111 + " = After equal");
*/
		
//		--------------LABA 2--------------
		
		BigNumber numb12 = numb1.Gsd(numb2);
		System.out.println(numb12 + " = Gsd");
		numb12 = numb1.Lcm(numb2);
		System.out.println(numb12 + " = Lcm");
		
		BigNumber mu = mod.BarretPreCompute();
		System.out.println(mu + " = mu");
		BigNumber numb8 = numb1.BarrettReduction(mod, mu);
		System.out.println(numb8 + " = num1 mod num2 (Barret)"); 
		
		BigNumber numb13 = numb1.AddMod(numb2, mod, mu) ;
		System.out.println(numb13 + " = AddMod");
		
		//BigNumber numb14 = numb1.SubMod(numb2, mod, mu) ;
		//System.out.println(numb14 + " = SubMod");
		
		BigNumber numb15 = numb1.MulMod(numb2, mod, mu) ;
		System.out.println(numb15 + " = MulMod");
		
		BigNumber numb16 = numb1.SquareMulMod(mod, mu) ;
		System.out.println(numb16 + " = SquareMod");
		
		BigNumber numb17 = numb1.LongModPowerBarrett(numb2, mod) ;
		System.out.println(numb17 + " = PowerModBarrett");
		
	// Tests 2	
/*
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
*/
		
//		BigNumber A = new BigNumber("a34fd32a");
//		BigNumber B = new BigNumber("40");
//		BigNumber N = new BigNumber("7543678fda");
//		BigNumber numb14 = A.LongModPowerBarrett(B, N) ;
		//System.out.println(numb10 + " = PowerModBarrett");
		
		
	}
	
	
}
