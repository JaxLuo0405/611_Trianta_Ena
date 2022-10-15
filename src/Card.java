package src;
import java.util.*;

public class Card {
    private char suit;
    private int value;
    private String name;
    private boolean show = true;

    private Card() throws InvalidCardSuitException {
        this.suit = ' ';
        this.value = 0;
        this.name = " ";
    }
    
    private Card(boolean faceShow) throws InvalidCardSuitException {
        this.suit = ' ';
        this.value = 0;
        this.name = " ";
        this.show = faceShow;
    }

    public Card(char newSuit, String newName, Map<String,Integer> cardDict) throws InvalidCardValueNameException, InvalidCardSuitException {
        if (!cardDict.containsKey(newName))
            throw new InvalidCardValueNameException(newName);
        if (newSuit != 'H' && newSuit != 'S' && newSuit != 'D' && newSuit != 'C')
            throw new InvalidCardSuitException(newSuit);
        this.name = newName;
        this.value=cardDict.get(this.name);
        this.suit = newSuit;
    }
    
    public boolean equals(Card otherCard){
        if(this.name.equals(otherCard.name))
            return true;
        return false;
    }
    
    public void set_show(boolean isShow){
        show = isShow;
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


    public int get_value() {
        return this.value;
    }

    public String get_name() {
        return this.name;
    }

    public boolean get_show(){
        return this.show;
    }
    public char get_suit() {
        return this.suit;
    }
    
    public String toString(){
        return get_suit_name() + " " + get_name();
    }


    public boolean compare_suit(Card card){
        return this.suit == card.get_suit();

    }

    public boolean compare_value(Card card){
        return this.value == card.get_value();
    }

    public boolean compareTo(Card card){
        return this.suit == card.get_suit() && this.value == card.get_value();
    }


        public static void main(String[] args) throws InvalidCardSuitException, InvalidCardValueNameException {
//            Card jax = new Card('H',"Ace");
//            System.out.println(jax);
//            jax.show = false;
//            System.out.println(jax);
        }

}