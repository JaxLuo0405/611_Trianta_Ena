package src;

public interface Game {
    default boolean checkWinner() {
        return false;
    }

    default void playGame() {}
}
