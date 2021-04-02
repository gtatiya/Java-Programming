package b_coding_interview.Problems;

/*
Hangman Referee 

Hangman is a game in which one player starts by picking a secret word.
This player then draws a number of dashes equal to the number of letters in the word. 
The other players then try to figure out the word by guessing one letter at a time.
If a guessed letter is in the word, this letter is written on the dash matching its place in the word.
If a guessed letter isn't in the word, a new element of a gallow is drawn. 

Write a program to determine if the secret word has been guessed, given a list of guessed letters. 

Input format 
The first line will be the secret word. 
The next line will be a String containing all of the guessed letters.
The order they appear does not matter.

Output format 
"true" or "false" depending on whether the secret word has been guessed. 
 */

public class HangMan {

	public static void main(String[] args) {
		
		String secretWord = "TATIYA", guessedLetters = "TYAI";
		
		for (int i = 0; i < guessedLetters.length(); i++) {
            System.out.println(guessedLetters.charAt(i));
            
            secretWord = secretWord.replace(guessedLetters.charAt(i), Character.MIN_VALUE);
            System.out.println("secretWord: " + secretWord);
        }
        
        boolean ans = true;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) != Character.MIN_VALUE) {
            	ans = false;
            }
        }
        System.out.println("ans: " + ans);

	}

}
