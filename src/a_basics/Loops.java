package a_basics;

import java.util.Arrays;

public class Loops {
	public static void main(String[] args) {
		
		String  google = "1";
		int len = google.length();
		while(len < 100) {
			google = google + "0";
			len = google.length();
		}
		System.out.println(google);
		
		for(int i=1; i<=5; i++) {
			System.out.println("Warning");
		}
		
		int [] temp = {1, 2, 3, 4};
		System.out.println(Arrays.toString(temp));
		
		String [] names = {"gyan", "pragya", "tatiya"};
		System.out.println(findLongestName(names));
		
		int [][] num = {{1}, {2}};
		System.out.println(Arrays.deepToString(num));
		
		String [] a = {"a1", "b1", "c1"};
        for (String item: a) System.out.println(item);
	}
	
	public static String findLongestName(String [] names){
	    int size = names.length;
	    String longestName = names[0];
	    for(int i =1; i<size; i++){
	        if(names[i].length() > longestName.length()){
	            longestName = names[i];
	        }
	    }
	    return longestName;
	}
	
}
