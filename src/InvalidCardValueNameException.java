package src;

public class InvalidCardNameException extends Exception
{
    private String valueIdentifier = " ";

    public InvalidCardNameException(String invalidName) {

        valueIdentifier = invalidName ;

        System.out.println("Invalid value " + invalidValue);
    }

    private InvalidCardValueException() {


        System.out.println("Invalid value");
    }

    public String toString() {


        return ("Attempted to create card with invalid suit argument" + " " + this.valueIdentifier);
    }

    public int getValue() {

        return valueIdentifier;
    }

} //End class
