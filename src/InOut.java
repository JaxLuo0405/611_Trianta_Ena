package src;

import java.util.*;

class InOut {


	public static int num_players() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to play Trianta Ena! Please enter the number of players (including dealer):");
		boolean correctInput = false;
		int result = 0;
		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {
				int userInput = Integer.parseInt(userInputLine);
				result = userInput;
				if (result > 2 && result < 35) {
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

	public static int get_dealer(int playerNum) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Which player index would you like to be the dealer?");
		boolean correctInput = false;
		int result = 0;
		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {
				int userInput = Integer.parseInt(userInputLine);
				result = userInput;
				if (result < playerNum && result >= 0) {
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

	public static void start_round(int roundNum) {
		System.out.println("Round " + roundNum + " starts!");
	}


	public static int ask_player_bet(int currentMoney) {

//		return result1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to bet or fold? (b/f)");
		boolean correctInput = false;
		boolean correctInput2 = false;
		int result = 0;

		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {

				if (userInputLine.equals("f"))
					return 0;
				if (userInputLine.equals("b"))
					correctInput = true;
				else {
					System.out.println("Incorrect input of b/f, please enter again");

				}
			} catch (Exception e) {
				System.out.println("Please enter a correct b/f");

			}
		}
		System.out.println("How much would you like to bet?");
		while (!correctInput2) {
			String userInputLine = scanner.nextLine();
			try {
				result = Integer.parseInt(userInputLine);
				if (result <= currentMoney) {
					correctInput2 = true;
				} else {
					System.out.println("Incorrect input of bet, please enter again");
				}
			} catch (Exception e) {
				System.out.println("Please enter a correct bet");
			}
		}

		return result;
	}

	public static void print_table(Table table) {
		System.out.println(table);

	}

	//@return: boolean hit
	public static boolean hit_or_stand() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to hit or stand? (h/s)");
		boolean correctInput = false;
		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {

				if (userInputLine.equals("h"))
					return true;
				if (userInputLine.equals("s"))
					return false;
				else {
					System.out.println("Incorrect input of h/s, please enter again");

				}
			} catch (Exception e) {
				System.out.println("Please enter a correct h/s");

			}
		}
		return true; // dummy return

	}

	public static boolean one_more_round(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to play one more round?(y/n)");
		boolean correctInput = false;
		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {

				if (userInputLine.equals("y")) {
					System.out.println("Perfect! Let's design our new dealer!");
					return true;
				}
				if (userInputLine.equals("n")) {
					System.out.println("End of Trianta Ena. Bye!");
					return false;
				}
				else {
					System.out.println("Incorrect input of y/n please enter again");

				}
			} catch (Exception e) {
				System.out.println("Please enter a correct y/n");

			}
		}
		return true; // dummy return

	}

	public static boolean ask_to_change_dealer(String pname){
		Scanner scanner = new Scanner(System.in);
		System.out.println( "Player "+ pname + ", would you like to become the new dealer?(y/n)");
		boolean correctInput = false;
		while (!correctInput) {
			String userInputLine = scanner.nextLine();
			try {

				if (userInputLine.equals("y"))
					return true;
				if (userInputLine.equals("n"))
					return false;
				else {
					System.out.println("Incorrect input of y/n please enter again");

				}
			} catch (Exception e) {
				System.out.println("Please enter a correct y/n");

			}
		}
		return true; // dummy return

	}


	public static void main(String[] args) {
		InOut test = new InOut();
		//test.num_players();
		//test.get_dealer(35);
		//test.ask_player_bet(100);
		test.hit_or_stand();
	}
}