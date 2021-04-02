package b_coding_interview.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Forward Kinematics of Three Link Manipulator 

A robotic manipulator has three links.

The base of the first link is connected to the ground through a rotational joint.
The angle of this joint is given by t1.
The length of the first link is 2.
 
The second link is connected to the end of the first link by another rotational joint.
The angle of the second link relative to the first link is given by t2.
 
Along the second link is a prismatic (telescoping) joint. 
The length of the second link is given by x, where x is always positive.

At the end of this prismatic joint is the end point, also called "end effector" of the robot. 

Both angles are given in radians and obey the right hand rule.

The base of the first link is at the origin of an x-y coordinate system.
When t1 and t2 are both zero, both links are aligned with the positive x-axis.

As t1 and t2 move slightly in the positive direction from zero, the end effector moves into the positive x and positive y quadrant.

Write a program, given t1, t2, and x, that returns the x-y position of the end point ("end effector"). 

Input Format 
The input will be a single line containing t1, t2, and x separated by a single space.

Output Format
Output the x-y position of the end point on a single line with x and y separated by a single space.
Each number should be rounded to the nearest hundredth place, and always include zeros.
For example "12.0976" should be returned as "12.10". 

Sample Input 1: 0 0 4
Sample Output 1: 6.00 0.00

Sample Input 2: 1.57 0 6
Sample Output 2: 0.01 8.00

Sample Input 3: 0.53 0.53 1.2
Sample Output 3: 2.31 2.06
*/

public class ForwardKinamatics {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] input_string = bufferedReader.readLine().trim().split(" ");
		
		List<Double> intput_double = new ArrayList<>();
		for (int i = 0; i < input_string.length; i++){
			intput_double.add(Double.parseDouble(input_string[i]));
		}
		
		Double t1 = intput_double.get(0);
		Double t2 = intput_double.get(1);
		Double x = intput_double.get(2);
		Double link1_len = 2.0;

//		System.out.println("t1, t2, x: " + t1 + ", " + t2 + ", " + x);
		
		Double x_ratio = Math.cos(t1), y_ratio = Math.sin(t1);		
		Double x1 = 0 + (link1_len * x_ratio);
		Double y1 = 0 + (link1_len * y_ratio);
		
		x_ratio = Math.cos(t1 + t2);
		y_ratio = Math.sin(t1 + t2);
		Double x2 = x1 + (x * x_ratio);
		Double y2 = y1 + (x * y_ratio);
		
		x2 = Math.round(x2 * 100.0) / 100.0;
		y2 = Math.round(y2 * 100.0) / 100.0;

		System.out.printf("%.2f %.2f", x2, y2);
	}

}
