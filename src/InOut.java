package src;

import java.util.*;

class InOut {


	public static int num_players() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to play Trianta Ena! Please enter the number of players (including dealer):");
		boolean correctInput = false;
		int result = 0;
		while (!correctInput) {
			String userInputLine = scanner.next();
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
			String userInputLine = scanner.next();
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

	public static void see_hand(TE_Player player){
		System.out.println("\nHere is your current hand, " + player.get_name() + ":");
		System.out.println(player.get_hand_player());
		System.out.println("Your current hand value is: "+player.get_handVal());
	}

	public static int ask_player_bet(TE_Player player) {
		Scanner scanner = new Scanner(System.in);
		see_hand(player);
		System.out.println("Here is your current hand values: "+ player.get_handVal());
		System.out.println("Here is your current money: " + player.get_money());
		System.out.println("Here is your current bet: " + player.get_bet());
		System.out.println(player.get_name()+", would you like to bet or fold? (b/f)");
		boolean correctInput = false;
		boolean correctInput2 = false;
		int result = 0;

		while (!correctInput) {
			String userInputLine = scanner.next();
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
			String userInputLine = scanner.next();
			try {
				result = Integer.parseInt(userInputLine);
				if (result <= player.get_money()) {
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
	public static boolean hit_or_stand(TE_Player player) {
		Scanner scanner = new Scanner(System.in);
		see_hand(player);
		System.out.println(player.get_name()+", would you like to hit or stand? (h/s)");
		boolean correctInput = false;
		while (!correctInput) {
			String userInputLine = scanner.next();
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
			String userInputLine = scanner.next();
			try {

				if (userInputLine.equals("y")) {
					System.out.println("Perfect! Let's designate our new dealer!");
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
			String userInputLine = scanner.next();
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
		//test.hit_or_stand();
	}
}