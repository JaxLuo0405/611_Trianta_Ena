package src;

import java.util.*;

class InOut{


	public static int num_players(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to play Trianta Ena! Please enter the number of players (including dealer):");
		boolean correctInput = false;
		int result = 0;
		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {
				int userInput = Integer.parseInt(userInputLine);
				result = userInput;
				if (result > 2 && result < 35 ) {
					correctInput = true;
				} else {
					System.out.println("Incorrect input, please enter again");

				}
			} catch (Exception e) {
				System.out.println("Please enter a correct choice");

			}
		}

		return result;
	}
	
	public static int get_dealer(int playerNum){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Which player index would you like to be the dealer?");
		boolean correctInput = false;
		int result = 0;
		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {
				int userInput =Integer.parseInt(userInputLine);
				result = userInput;
				if (result < playerNum && result >= 0 ) {
					correctInput = true;
				} else {
					System.out.println("Incorrect input, please enter again");

				}
			} catch (Exception e) {
				System.out.println("Please enter a correct choice");

			}
		}

		return result;

	}
	
	public static void start_round(int roundNum){
		System.out.println("Round "+roundNum+" starts!");
	}


	public static int ask_player_bet(){

		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to bet or fold? (b/f)");
		String betOrFold = scan.next();
		if(betOrFold.equals("f"))
			return 0;
		System.out.println("How much would you like to bet?");
		return scan.nextInt();
	}
	
	public static void print_table(Table table){
		System.out.println(table);

	}
	
	//@return: boolean hit
	public static boolean hit_or_stand(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to hit or stand? (h/s)");
		String hitOrStand = scan.next();
		if(hitOrStand.equals("h"))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		InOut test = new InOut();
		test.num_players();
		test.get_dealer(35);
	}
}