package b_coding_interview.Problems;

/*
Message Decryption 

Substitution Cipher 
A Substitution Cipher can be used to encrypt and decrypt messages.
It uses a "Ciphertext Alphabet", such that each letter of the standard
alphabet is replaced with it's corresponding letter of the Ciphertext when encrypting a message.
For example, the following shows the standard alphabet next to a sample Ciphertext. 

Standard alphabet: 
ABCDEFGHIJKLMNOPQRSTUVWXYZ 
Ciphertext alphabet: 
DHTNQGACBIXMSYLPUJWOREFKZV 

Suppose we have a message "HELLO".
Using this ciphertext, the resulting encrypted message is "CQMML".
Given the Ciphertext alphabet and the message "CQMML", someone could figure out the decrypted message is "HELLO".

Write a program that computes the decrypted message, given an encrypted message and a ciphertext alphabet.

Input format 
The first line is the ciphertext alphabet in capital letters. 
The second is the encrypted message in capital letters. 

Output format
The decrypted message in capital letters.
*/

public class MsgDecription {

	public static void main(String[] args) {
		
		String stndText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", cipherText = "DHTNQGACBIXMSYLPUJWOREFKZV";
		String encryptedMessage = "CQMML";
		
		String msg = "";
		for (int i = 0; i < encryptedMessage.length(); i++) {
            System.out.println(encryptedMessage.charAt(i));
            
            int idx = cipherText.indexOf(encryptedMessage.charAt(i));
            msg += stndText.charAt(idx);
        }
		System.out.println("msg: " + msg);
	}

}
