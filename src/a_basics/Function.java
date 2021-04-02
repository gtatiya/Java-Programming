package a_basics;

public class Function {

	public static void main(String[] args) {
		
		boolean playButton = true; // true or false
		playMusic(playButton); // function calling
		
		//Random
		System.out.println(Math.random());
		System.out.println(Math.PI);
		System.out.println(Math.E);
	}
	
	//function definition
	public static void playMusic(boolean playButton){
	    if (playButton){
	        System.out.println("Music is playing");
	    } else{
	        System.out.println("Music is paused");
	    }
	}
	
}
