package b_coding_interview.Problems;

/*
Common Factors

Consider the problem of finding all positive numbers which are less than 35 and are divisible by both 2 and 5.
This would yield 10, 20 and 30.
Write a program that computes how many positive numbers exist below nMax which are divisible by factor1 and factor2.
*/

public class CommonFactor {

	public static void main(String[] args) {

		int nMax = 350, factor1 = 2, factor2 = 5;
		
		int m = 1;
		int count = 0;
		while (m < nMax){
			if ((m % factor1 == 0) && (m % factor2 == 0)){
				System.out.println("m: " + m);
				count += 1;
			}
			m += 1;
		}
		System.out.println("count: " + count);
	}

}
