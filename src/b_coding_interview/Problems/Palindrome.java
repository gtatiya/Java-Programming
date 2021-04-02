package b_coding_interview.Problems;

/*
Palindrome Math 

A palindrome is a word that reads the same forwards and backwards.
Some examples of palindromes are "racecar", "civic" and "rotor".
 
For this problem, we'll be looking at palindromic numbers, which similarly read the same forwards and backwards: 1441, 22, 15900951, 7. 

Given a certain number n, write a function that computes the smallest non-negative number m such that (n+m) is a palindromic number. 
*/

public class Palindrome {

	public static void main(String[] args) {
		
		boolean is_palindrome = isPalindrome(7);
		
		System.out.println("is_palindrome " + is_palindrome);
		
		int num = 33;
		
		int m = 1;
		while (true){
			int num2 = num + m;
			is_palindrome = isPalindrome(num2);
			
			if (is_palindrome){
				break;
			}
			m += 1;
		}
		
		System.out.println("num: " + num);
		System.out.println("m: " + m);
	}
	
	public static boolean isPalindrome(int num){
		boolean is_palindrome = false;
		
		int reversedInteger = 0, remainder, originalInteger;

        originalInteger = num;
        
	    // reversed integer is stored in variable 
        while( num != 0 ){
            remainder = num % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            num  /= 10;
        }

        // palindrome if orignalInteger and reversedInteger are equal
        if (originalInteger == reversedInteger) {
        	System.out.println(originalInteger + " is a palindrome.");
        	is_palindrome = true;
        }
        else {
        	System.out.println(originalInteger + " is not a palindrome.");
        	is_palindrome = false;
        }
	    return is_palindrome;
	}

}
