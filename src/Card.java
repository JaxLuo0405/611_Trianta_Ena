public class Card {
    private char suit;
    private int value;
    private char name;

    private Card() {
        this.suit = ' ';
        this.value = 0;
        this.name = ' ';
    }

    public String getSuitName() {

        String suit_name;

        if (this.suit == 'H') {

            suit_name = "Hearts";

        } else if (this.suit == 'S') {

            suit_name = "Spades";

        } else if (this.suit == 'C') {

            suit_name = "Clubs";

        } else if (this.suit == 'D') {

            suit_name = "Diamonds";

        } else {

            suit_name = "Unknown";
        }

        return suit_name;
    }

    public int getValue(){
        return this.value;
    }

    public String getValueName(){

        String name = "Unknown";

        if (this.value == 1) {
            name = "Ace";
        }
        else if (this.value == 2) {
            name = "Two";
        }
        else if (this.value == 3) {
            name = "Three";
        }
        else if (this.value == 4) {
            name = "Four";
        }
        else if (this.value == 5) {
            name = "Five";
        }
        else if (this.value == 6) {
            name = "Six";
        }
        else if (this.value == 7) {
            name = "Seven";
        }
        else if (this.value == 8) {
            name = "Eight";
        }
        else if (this.value == 9) {

            name = "Nine";
        }
        else if (this.value == 10) {

            name = "Ten";
        }
        else if (this.value == 11) {

            name = "Jack";
        }
        else if (this.value == 12) {

            name = "Queen";
        }
        else if (this.value == 13) {

            name = "King";

        }
        return name;

    }
    public Card(char suit)
}
