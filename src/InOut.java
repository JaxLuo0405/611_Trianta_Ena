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
	
	
	public static void main(String[] args) {
	}
}