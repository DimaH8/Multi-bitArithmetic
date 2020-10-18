
public class Main {

	public static void main(String[] args) {
		BigNumber numb1 = new BigNumber("123456789ABCDEF");
		BigNumber numb2 = new BigNumber("167a");
		System.out.println("This is first number:\r\n" + numb1.GetString());
		System.out.println("This is second number:\r\n" + numb2.GetString());
		
		BigNumber numb3 = numb1.Add(numb2);
		System.out.println("This is suma:\r\n" + numb3.GetString());
		System.out.println(((long)Math. pow(2, 32)));
	}
	
}
