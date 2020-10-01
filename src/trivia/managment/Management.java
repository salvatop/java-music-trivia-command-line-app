/*
####################### Management class #######################

@ maintenanceMenu()
menu for the maintenance area in order to guide user through all the available options

@ selectTurnToEdit()
this method will present a menu to the user to select which turn to edit then
will call the method selectWhatToEditInATurn() passing the index chosen by the user

@ selectWhatToEditInATurn(int index)
where index will be the index of the static arraylist listOfTurns inherited from Game

################################################################
 */
package trivia.managment;

import trivia.game.Game;
import trivia.model.Turn;
import trivia.utils.FileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static trivia.Main.menu;

public class Management extends Game {

    private static final Path CONFIGURATION_PATH = Paths.get("configuration.txt");
    public static final String ADMIN_PASSWORD = FileManager.readFile(CONFIGURATION_PATH.toAbsolutePath().toString());

    public void maintenanceMenu() {
        System.out.println();
        System.out.println("Maintenance Menu\n");
        System.out.println("Press:");
        System.out.println("1 - Change the admin password");
        System.out.println("2 - List all the game turns by category in order to manage them");
        System.out.println("3 - Display diagnostic info on the configuration file");
        System.out.println("0 - Back to main menu\n");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s+");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());

        } catch (Exception e) {
            System.out.print("only number between 0 and 3\n\n");
            maintenanceMenu();
        }
        switch (choice) {
            case 0:
                menu();
                break;
            case 1: {
                System.out.println();
                System.out.print("before proceed please enter the current password: ");
                String password = scanner.nextLine();
                if(password.equals(ADMIN_PASSWORD)) {
                    System.out.println();
                    System.out.print("Enter the new password of the length of 3 at least : ");
                    String newPassword = scanner.nextLine();

                    try {
                        FileManager.writeFile("configuration.txt", newPassword);
                        System.out.println("password updated successfully!");
                        maintenanceMenu();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("something went wrong. please try again");
                        maintenanceMenu();
                        break;
                    }
                }
            }
            case 2:{
                selectTurnToEdit();
                break;
            }
            case 3:{
                System.out.println(FileManager.displayFileInfo(new File("configuration.txt")));
                maintenanceMenu();
                break;
            }
            default:{
                System.out.print("only number between 0 and 3\n\n");
                maintenanceMenu();
            }
        }
    }

    public void selectTurnToEdit(){
        String category = chooseCategory();
        int count = 0;
        for(Turn turn : listOfTurns) {
            if (turn.getCategory().equalsIgnoreCase(category)) {
                System.out.println(count + " - " + "Turn ID: " + turn.getId() + " - Question: " + turn.getQuestion());
                count++;
            }
        }
        System.out.println();
        System.out.println("Enter a number between 0 and 4 to select the record you want to edit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s+");
        int index = 0;
        try {
            index = Integer.parseInt(scanner.nextLine());
            if(index > 4){
                System.out.println("only number between 0 and 4\n\n");
                maintenanceMenu();
            }
        } catch (Exception e) {
            System.out.println("only number between 0 and 4\n\n");
            maintenanceMenu();
        }
        selectWhatToEditInATurn(index);
    }

    public void selectWhatToEditInATurn(int index) {
        System.out.println("\nTurn: " + listOfTurns.get(index));
        System.out.println("What would you like to edit from this turn?\n");
        System.out.println("Press:");
        System.out.println("1 - Question");
        System.out.println("2 - Answers");
        System.out.println("3 - Category");
        System.out.println("4 - Solution");
        System.out.println("0 - Back to maintenance menu\n");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s+");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if(choice > 4) {
                System.out.print("only number between 0 and 4\n\n");
                maintenanceMenu();
            }

        } catch (Exception e) {
            System.out.print("only number between 0 and 4\n\n");
            maintenanceMenu();
        }
        switch (choice){
            case 0:
                maintenanceMenu();
                break;
            case 1: {
                System.out.println("The actual question is: " + listOfTurns.get(index).getQuestion());
                System.out.print("Enter the new question: ");
                String question = scanner.nextLine();
                listOfTurns.get(index).setQuestion(question);
                System.out.println("question updated successfully!");
                System.out.println("The new question is: " + listOfTurns.get(index).getQuestion() + "\n");
                selectWhatToEditInATurn(index);
                break;
            }
            case 2: {
                System.out.println(listOfTurns.get(index).getAnswers());
                System.out.println("Enter a number between 0 and 4 to select the answer you want to edit");
                System.out.print("Enter your choice:_ ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if(choice > 4) System.out.print("only number between 0 and 4\n\n");
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.print("only number between 0 and 4\n\n");
                    break;
                }
                System.out.println();
                System.out.print("Enter the new answer: ");
                String answer = scanner.nextLine();
                listOfTurns.get(index).setAnswer(choice, answer);
                System.out.print("answer updated successfully!\n");
                System.out.println("The new answers: " + listOfTurns.get(index).getAnswers() + "\n");
                selectWhatToEditInATurn(index);
                break;
            }
            case 3: {
                System.out.println("The actual category is: " + listOfTurns.get(index).getCategory());
                System.out.print("Enter the new category: ");
                String category = scanner.nextLine();
                listOfTurns.get(index).setCategory(category);
                System.out.println("category updated successfully!");
                System.out.println("The new category is: " + listOfTurns.get(index).getCategory() + "\n");
                selectWhatToEditInATurn(index);
                break;
            }
            case 4: {
                System.out.println(listOfTurns.get(index).getAnswers());
                System.out.println("The actual solution is: " + listOfTurns.get(index).getSolution());
                System.out.print("Enter the new solution: ");
                int solution = Integer.parseInt(scanner.nextLine());
                listOfTurns.get(index).setSolution(solution);
                System.out.println("solution updated successfully!");
                System.out.println("The new solution is: " + listOfTurns.get(index).getSolution() + "\n");
                selectWhatToEditInATurn(index);
                break;
            }
            default:
                System.out.print("only number between 0 and 4\n\n");
        }
    }

    @Override
    protected void play() { }
    @Override
    protected void gameOver() { }

    @Override
    protected String chooseCategory() {
        String category = "";

        System.out.println("Please select the category you would like to edit\n");
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
                    maintenanceMenu();
            }
            return category;

        } catch (Exception e) {
            System.out.print("Only number between 0 and 2\n\n");
            maintenanceMenu();
        }
        return category;
    }
}
