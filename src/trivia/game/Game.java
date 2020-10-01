/*
####################### Game class #######################
Base class

@ NUMBERS_OF_TURN_TO_PLAY_IN_A_GAME // static variable representing the number of turn to play in a match
@ listOfTurns // arraylist containing the turn to play in the match
@ score // int representing the number of turn won by the user
################################################################
 */

package trivia.game;

import trivia.model.Turn;

import java.util.ArrayList;

public abstract class Game {

    private int numbersOfTurnToPlayInAGame = 5;
    private int score;

    public static ArrayList<Turn> listOfTurns = new ArrayList<>();


    //default constructor
    public Game() { }

    //overloaded constructor
    public Game(ArrayList<Turn> newListOfTurns) {
        this.score = 0;
        listOfTurns = newListOfTurns;
    }

    protected abstract void play();
    protected abstract void gameOver();
    protected abstract String chooseCategory();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumbersOfTurnToPlayInAGame() {
        return numbersOfTurnToPlayInAGame;
    }

    public void setNumbersOfTurnToPlayInAGame(int numbersOfTurnToPlayInAGame) {
        this.numbersOfTurnToPlayInAGame = numbersOfTurnToPlayInAGame;
    }
}
