package src;

public interface Game {
    default void check_winner() {}
    
    default void one_round() {}

    default void play_game() throws Exception{}
}
