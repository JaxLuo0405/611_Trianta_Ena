package src;

class Table {//this class is constructed to print the current table condition of each player
	// and dealer, about their current moeny and current bet

	private final TE_Player[] currentPlayerList;

	private Table() {
		this.currentPlayerList = null;

	}
	public Table(TE_Player[] playerList){
		this.currentPlayerList = playerList;
	}



	public static void main(String[] args) {

	}
}