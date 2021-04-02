package a_basics;

public class HelloWorld {

	public static void main(String[] args) {		
		System.out.println("Hello, World!!!!!");
		System.out.println(2+5);
		
		//Integer variable
		System.out.println("Integer variable");
		int passengers;
		passengers = 0;
		System.out.println(passengers);
		
		//String variable
		System.out.println("String variable");
		String driver;
		driver = "Harish";
		System.out.println(driver);
		System.out.println(driver.length());
		System.out.println(driver.toUpperCase());
		
		//String Concatenation
		System.out.println("String Concatenation");
		String driverSurname = "Sharma";
		String driverFullname = driver + " " + driverSurname;
		System.out.println(driverFullname);
		
		//Variable types (numbers)
		System.out.println("Variable types (numbers)");
		int maxInt = 2147483647;
		long muchMore = 2147483647*10000000;
		double fraction = 99.275;
		System.out.println("maxInt: " + maxInt);
		System.out.println("muchMore: " + muchMore);
		System.out.println("fraction: " + fraction);
		
		//Variable types (text)
		System.out.println("Variable types (text)");
		String fullText = "GYAN TATIYA";
		char answer = 'b';
		System.out.println(fullText + " " + answer);
		
		//Variable types (decision)
		System.out.println("Variable types (decision)");
		boolean fact = true;
		System.out.println(fact);
		
		//Variable arithmetic
		System.out.println("Variable arithmetic");
		System.out.println(5/2);
		System.out.println(5/2.0);
		
		//Casting
		System.out.println("Casting");
		double future = 25.5;
		int approx = (int) future; // converting from double to int
		System.out.println(approx);
	}
}
