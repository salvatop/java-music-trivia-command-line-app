/*
####################### MUSIC TRIVIA FEATURES #######################
- The Trivia application will present a menu, where the user can identify by entering the
username, or the user id before having access to the Trivia game.

- Trivia game is composed of a minimum two different trivia category games, each trivia
game should have the minimum of 5 questions with theirs answers.

- Enumerate the possible answers for each question, and the user can enter the number
or the letter option to choose the appropriate answer.

- Save the user name and answers and count the good answers for statistic usage. Display
at the end of the game the information that you save.

- Only the manager have the option to manage the Trivia application, using a special code
that is to give access to the administrator to add/remove/modify questions and/or the answers.

 */

package trivia;

import trivia.game.Trivia;
import trivia.managment.Management;

import java.util.Scanner;

import static trivia.managment.Management.ADMIN_PASSWORD;


public class Main {

    static Trivia trivia;
    static Management management;

    public static void main(String[] args) {
        trivia = new Trivia();
        management = new Management();
        menu();
    }

    public static void menu() {
        System.out.println("\n\n");
        System.out.println("This application it's a trivia game about music\n");
        System.out.println("Press:");
        System.out.println("1 - Manage the application");
        System.out.println("2 - Play a game");
        System.out.println("3 - Wall of Fame");
        System.out.println("0 - Exit the application\n");

        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s+");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0: {
                    System.out.print("Bye!");
                    break;
                }
                case 1: {
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if(password.equals(ADMIN_PASSWORD)) {
                        System.out.println("Access granted!\n\n");
                        management.maintenanceMenu();
                    } else {
                        System.out.println("Access denied! : Password mismatch\n\n");
                        menu();
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    trivia.setPlayerName(name);
                    trivia.play();
                    menu();
                    break;
                }
                case 3: {
                    trivia.wallOfFame();
                    menu();
                    break;
                }
                default: {
                    System.out.print("only number between 0 and 3\n\n");
                    menu();
                    break;
                }
            }
        } catch (Exception e){
            System.out.print("this only number between 0 and 3\n\n");
            System.out.println(e.getMessage());
            menu();
        }
    }
}
