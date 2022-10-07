package src;

public interface Game {
    default boolean check_winner() {
        return false;
    }
    
    default void one_round() {}

    default void play_game() {}
}
