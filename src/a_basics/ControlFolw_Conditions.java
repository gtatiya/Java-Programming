package a_basics;

public class ControlFolw_Conditions {

	public static void main(String[] args) {
		
		boolean isRaining = false; // true or false
		boolean whocares = false;
		// Write an if statement below that prints out "Windshield wipers on." when isRaining is true.
		if(isRaining){
			    System.out.println("Windshield wipers on.");
			} else if(whocares)
			{
				System.out.println("YOLO");
			} else {
				System.out.println("You rock!!!!!!!!");
			}
		
		int month = 51; // should be a number 1-12
		String monthString;
		switch(month) {
		    case 1: monthString = "January";
		        break;
		    case 2: monthString = "February";
		        break;
		    case 3: monthString = "March";
		        break;
		    case 4: monthString = "April";
		        break;
		    case 5: monthString = "May";
		        break;
		    case 6: monthString = "June";
		        break;
		    case 7: monthString = "July";
		        break;
		    case 8: monthString = "August";
		        break;
		    case 9: monthString = "September";
		        break;
		    case 10: monthString = "October";
		        break;
		    case 11: monthString = "November";
		        break;
		    default: monthString = "Invalid month";
		        break;
		    // write case 12 and a default case below
		}
		System.out.println(monthString);
	}
	
}
