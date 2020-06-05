package game;

public enum GameState {

    START(1), IN_PROGRESS(2), END(3);

    private int state;

    GameState(int state){
        this.state = state;
    }

}
