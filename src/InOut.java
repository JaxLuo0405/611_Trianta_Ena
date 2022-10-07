package src;

import java.util.*;

class InOut{
	
	public static int num_players(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to play Trianta Ena! Please enter the number of players (including dealer):");
		return scan.nextInt();
	}
	
	public static int get_dealer(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Which player would you like to be the dealer?");
		return scan.nextInt();
	}
	
	public static void start_round(int roundNum){
		System.out.println("Round "+roundNum+" starts!");
	}
	
	public static int ask_player_bet(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to bet or fold? (b/f)");
		String betOrFold = scan.next();
		if(betOrFold=="f")
			return 0;
		System.out.println("How much would you like to bet?");
		return scan.nextInt();
	}
	
	//public static void print_table(table)
	
	public static void main(String[] args) {
	}
}