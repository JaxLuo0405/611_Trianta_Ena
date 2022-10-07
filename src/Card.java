package src;

import java.util.*;
    public class Card {
        private char suit;
        private int value;
        private String name;

        private Card() throws InvalidCardSuitException {
            this.suit = ' ';
            this.value = 0;
            this.name = " ";
        }

        public Card(char newSuit, String newName) throws InvalidCardValueNameException, InvalidCardSuitException {
            String[] values= new String[]{"Ace", "Two", "Three" , "Four" , "Five" , "Six" , "Seven", "Eight" , "Nine", "Ten" ,"Jack","Queen","King"};
            List<String> valuesList = new ArrayList<String>(Arrays.asList(values));
//            System.out.println(values);
//            System.out.println(valuesList);
//            System.out.println(valuesList.contains("Two"));
            if (!valuesList.contains(newName)) {
                throw new InvalidCardValueNameException(newName);
            } else {

                this.name = newName;
                this.set_value();
            }
            if (newSuit != 'H' && newSuit != 'S' && newSuit != 'D' && newSuit != 'C') {
                throw new InvalidCardSuitException(newSuit);
            } else {
                this.suit = newSuit;
            }

        }




    public String get_suit_name() {

        String suit;

        if (this.suit == 'H') {

            suit = "Hearts";

        } else if (this.suit == 'S') {

            suit = "Spades";

        } else if (this.suit == 'C') {

            suit = "Clubs";

        } else if (this.suit == 'D') {

            suit = "Diamonds";

        } else {

            suit = "Unknown";
        }
        return suit;
    }

        public void set_value() {
            if (this.name == "Ace") {// Ace can be either 1 or 11, remeber to handle this in th value calcuation part :)
                this.value = 1;
            } else if (this.name == "Two") {
                this.value = 2;
            } else if (this.name == "Three") {
                this.value = 3;
            } else if (this.name == "Four") {
                this.value = 4;
            } else if (this.name == "Five") {
                this.value = 5;
            } else if (this.name == "Six") {
                this.value = 6;
            } else if (this.name == "Seven") {
                this.value = 7;
            } else if (this.name == "Eight") {
                this.value = 8;
            } else if (this.name == "Nine") {
                this.value = 9;
            } else if (this.name == "Jack") {
                this.value = 10;
            } else if (this.name == "Queen") {
                this.value = 10;
            } else if (this.name == "King") {
                this.value = 10;
            }
        }


    public int get_value() {

        return this.value;
    }

    public String get_name() {

        return this.name;
    }


    public char get_suit() {

        return this.suit;
    }
    public String toString() {return get_suit_name() + " " + get_name();}


        public boolean compare_suit(Card card){

            return this.suit == card.get_suit();

        }

        public boolean compare_value(Card card){

            return this.value == card.get_value();
        }

        public boolean compareTo(Card card){

            return this.suit == card.get_suit() && this.value == card.get_value();
        }




//        public static void main(String[] args) throws InvalidCardSuitException, InvalidCardValueNameException {
//            Card jax = new Card('H',"Ace");
//            System.out.println(jax);
//        }

}
