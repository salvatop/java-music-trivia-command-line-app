/*
####################### Management class #######################
implements play, gameOver methods from Game class

@ play() // will play a turn of the game, if the user answer correctly, will play another turn
            until reach the max number of turns per game, if the user answer correctly until last turn will win, otherwise gameOver()

@ gameOver() // will call the method result() to display statistics about the game played and end the game


################################################################
 */

package trivia.game;

import trivia.game.Game;
import trivia.model.Turn;
import trivia.utils.FileManager;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static trivia.utils.DataLoader.loadTurns;

public class Trivia extends Game {

    private static final Path WALL_OF_FAME_PATH = Paths.get("wallOfFame.txt");
    private static final String WALL_OF_FAME = Paths.get("wallOfFame.txt").toString();

    private String playerName;

    private final ArrayList<Integer> turnPlayed;


    public Trivia() {
        turnPlayed = new ArrayList<>();
        loadTurns();
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public  String chooseCategory() {
        String category = "";

        System.out.println("Please select the category\n");
        System.out.println("Press:");
        System.out.println("1 - Casual");
        System.out.println("2 - Classical\n");

        System.out.print("Enter your choice:_ ");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s+");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    category = "Casual";
                    System.out.println("Selected category is " + category);
                    System.out.println();
                    break;
                case 2:
                    category = "Classical";
                    System.out.println("Selected category is " + category);
                    System.out.println();
                    break;
                default:
                    System.out.print("Only number between 0 and 2\n\n");
                    chooseCategory();
            }
            return category;

        } catch (Exception e) {
            System.out.print("Only number between 0 and 2\n\n");
            chooseCategory();
        }
        return category;
    }

    public Turn loadNextTurn(String category){
        for (Turn nextTurn : listOfTurns) {
            if (!turnPlayed.contains(nextTurn.getId()) && nextTurn.getCategory().equals(category))
                return nextTurn ;
        }
        return new Turn();
    }
    @Override
    public void play() {
        System.out.println("\n\n");
        System.out.println("Hi " + playerName + " welcome to Music Trivia!\n");

        String category = chooseCategory();
        setScore(0);
        int actualTurn = 1;
        turnPlayed.clear();
        boolean keepPlaying = true;

        while (keepPlaying) {
            Turn turn = loadNextTurn(category);
            int answer = 0;
            if (actualTurn <= getNumbersOfTurnToPlayInAGame()) {
                System.out.println("TURN: " + actualTurn);
                System.out.println("Question: " + turn.getQuestion());
                System.out.println("\n");
                System.out.println("Answers: " + turn.getAnswers());
                Scanner scanner = new Scanner(System.in).useDelimiter("\\s+");
                System.out.print("Enter the your answer: ");

                try {
                    answer = Integer.parseInt(scanner.nextLine());
                    if(answer > 3){
                        System.out.println("only number between 0 and 3\n\n");
                        System.out.print("Enter the your answer: ");
                        answer = Integer.parseInt(scanner.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("only number between 0 and 3\n\n");
                    System.out.print("Enter the your answer: ");
                    answer = Integer.parseInt(scanner.nextLine());
                }
            } else if (actualTurn > getNumbersOfTurnToPlayInAGame()) {
                keepPlaying = false;
                System.out.println("Congratulations Yuo Won!");
                results();
            }
            //verify if the answer is correct and is not the last turn else gameOver
            if (answer == turn.getSolution()) {
                System.out.println("\n\n");
                if(actualTurn < 5) {
                    System.out.println("The answer it's correct!");
                    System.out.println("Prepare for next turn!\n\n");
                }
                turnPlayed.add(turn.getId());
                setScore(getScore() + 1);
                actualTurn++;

            } else {
                System.out.println("The answer it's wrong!");
                keepPlaying = false;
                gameOver();
            }
        }
    }

    @Override
    protected void gameOver() {
        System.out.println();
        System.out.println("Game Over!\n");
        results();
    }

    public void results(){
        String msg = playerName + " your score is: " + getScore() + " correct answers out of " + getNumbersOfTurnToPlayInAGame();
        String wallOfFame = playerName + " - scored: " + getScore()+ " correct answers out of " + getNumbersOfTurnToPlayInAGame() + ",";

        FileManager.updateFile(WALL_OF_FAME, wallOfFame);
        System.out.println(msg);
    }

    public void wallOfFame() {
        System.out.println("\n");
        System.out.println("The Wall Of Fame\n");
        String str = FileManager.readFile(WALL_OF_FAME_PATH.toAbsolutePath().toString());

        String[] arrSplit = str.split(",");
        for (String s : arrSplit) {
            System.out.println(s);
        }
    }
}