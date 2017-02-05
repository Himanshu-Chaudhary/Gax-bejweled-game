package com.putable.gax.gaxby;

public class launcher {
	public static void main(String[] args) {
		// launched advanced if advanced if passed , runs gaxby if nothing is passed and displays message if anything else is passed
		if (args.length == 0){
			Gaxby game = new Gaxby();
			game.CreateGUI();
		}
		else if (args[0].toUpperCase().equals("ADVANCED")){
			Advanced advancedGame = new Advanced();
			advancedGame.CreateGUI();
		}
		else System.out.print("Not Supported by this Gax");
		}
}
