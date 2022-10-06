package src;

public class InvalidCardValueNameException extends Exception
{
    private String valueIdentifier = " ";

    public InvalidCardValueNameException(String invalidName) {

        valueIdentifier = invalidName ;

        System.out.println("Invalid card value name " + invalidName);
    }

    private InvalidCardValueNameException() {


        System.out.println("Invalid card value name");
    }

    public String toString() {


        return ("Attempted to create card with invalid value name argument" + " " + this.valueIdentifier);
    }

    public String getValue() {

        return valueIdentifier;
    }

} //End class
