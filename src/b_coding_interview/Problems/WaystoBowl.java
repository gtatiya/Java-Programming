package b_coding_interview.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Ways to Bowl 
Scoring 
The scoring rules of 10-pin bowling are as follows: 
1. A game consists of 10 frames. In each frame, the bowler has two chances to knock down as many pins as possible.
2. For each pin knocked down, the bowler scores 1 point. 
3. If the bowler knocks down all pins with the first ball in a frame, it is called a "strike".
In this case, the number of pins knocked down with the next two balls bowled is also added to the player's score for this frame.
4. Instead, if the bowler knocks down all remaining pins with the second ball in a frame, it is called a 'Spare".
In this case, the number of pins knocked down by the next ball bowled is also added to the player's score for this frame.
5. If the player bowls a strike in the last frame, he is awarded two extra balls so as to allow the awarding of bonus points.
If both of these balls also result in strikes, a total of 30 points (10 + 10 + 10) is awarded for the frame.
Similarly, if the player bowls a spare in the last frame, he is awarded
one extra ball and the score for that ball is added to the score of the last frame.

For this problem, we will consider games with N frames.
For example, if N = 4 and the scores in the 4 frames achieved are: 
36|10|55|9
The scores for each frame are 9, 10 + (5 + 5), 5 + 5 + 9, and 9 respectively.
The total score is 57.

If N = 3, and the scores in the 3 frames achieved are: 
10|10|55 
In this case, since the last frame was a spare, an additional ball will be bowled.
If the bowler scores say 3 on that ball, the scores for each frame are: 10 + 10 + 5, 10 + 5 + 5, 5 + 5 + 3, for a total score of 63.

Note: The maximum score with Nframes is 30 * N.
This score is attained when all N frames are strikes, and the two additional balls bowled are strikes as well. 
Given N and M, you need to count how many score sequences over Nframes can result in a total score of M.

Input Format 
The first line contains the number of test cases T.
The next T lines contain two integers, N and M respectively.

Output Format 
Output T lines, one for each test case. Output all answers modulo 1000000007.

Sample Input
5
1 9
1 11
1 25
3 90
3 10

Sample Output
10
12
1
1
3003

Explanation 
For the first case, there are 10 ways to score 9 in 1 frame - 0,9 or 1,8 or 9,0. 
For the second case, there are 10 ways to bowl a spare in the first frame and score an additional 1 point with the extra ball.
It is also possible to score a strike in the first frame followed by or with the two extra balls.
Thus there are a total of 12 ways. 

For the third case, there is only 1 way. Score a strike in the first frame, score another strike with the first extra ball, and an additional 5 with the second extra ball. 

For the fourth case, there is again only 1 way.
Score a strike in all frames, as well as with the two extra balls.
*/

/*
GT:
The following code can handle the case of only 1 frame.
For more than 1 frames, it returns -1.
*/

public class WaystoBowl {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		String tests = bufferedReader.readLine().trim();
		System.out.println("Integer.parseInt(tests): " + Integer.parseInt(tests));
		
		int total_num_of_pins = 10;
		for (int i = 0; i < Integer.parseInt(tests); i++){
			String[] input_string = bufferedReader.readLine().trim().split(" ");
			
			int total_frames = Integer.parseInt(input_string[0]);  // N
			int total_score = Integer.parseInt(input_string[1]);  // M
			
			System.out.println("total_frames: " + total_frames);
			System.out.println("total_score: " + total_score);
			
			if (total_frames == 1) {
				int current_score = 0;
				int count = 0;
				
				// First ball
				for (int score1 = 0; score1 < total_num_of_pins + 1; score1++){
//					System.out.println("score1: " + score1);
					int num_of_pins_left = total_num_of_pins - score1;
					// Strike
				    if (score1 == total_num_of_pins) {
				    	for (int score1_1 = 0; score1_1 < total_num_of_pins + 1; score1_1++){
				    		num_of_pins_left = total_num_of_pins;
				    		num_of_pins_left -= score1_1;
				    		
				    		if (num_of_pins_left == 0) {
				                num_of_pins_left = total_num_of_pins;				    			
				    		}
				    		
				    		for (int score1_2 = 0; score1_2 < num_of_pins_left + 1; score1_2++){
//				    			num_of_pins_left -= score1_2;
				    	        current_score = score1 + score1_1 + score1_2;
//				    	        System.out.println("score1, score1_1, score1_2: " + score1 + " " + score1_1 + " " + score1_2);
				    	        
				    	        if (current_score == total_score) {
				                    count += 1;
//				                    System.out.println("count = " + count);
				                    break;
				    	        }
				    		}
				    	}
				    }
				    else {
				    	// Second ball
				    	for (int score2 = 0; score2 < num_of_pins_left + 1; score2++){
//				    		System.out.println("score1, score2: " + score1 + " " + score2);
				    		current_score = score1 + score2;
//				    		System.out.println("current_score: " + current_score);
				    		// Spare
				            if (current_score == total_num_of_pins) {
				            	for (int score2_1 = 0; score2_1 < total_num_of_pins + 1; score2_1++){
//				            		num_of_pins_left2 = total_num_of_pins - score2_1;
				            		current_score = score1 + score2 + score2_1;
//				            		System.out.println("score1, score2, score2_1: " + score1 + " " + score2 + " " + score2_1);
				            		if (current_score == total_score) {
					                    count += 1;
//					                    System.out.println("count = " + count);
					                    break;
					    	        }
				            	}
				            }
				            else if (current_score == total_score) {
				            	count += 1;
//				            	System.out.println("count = " + count);
			                    break;
				            }
				    	}
				    }
				}
				System.out.println("count: " + count);
			}
			else {
				System.out.println("count: -1 :(");
			}
	      }
	}

}
