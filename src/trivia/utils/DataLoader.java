/*
####################### DataLoader class #######################
A simple class to load the game data.
################################################################
 */
package trivia.utils;

import trivia.model.Turn;

import java.util.ArrayList;
import java.util.Arrays;

import static trivia.game.Game.listOfTurns;

public class DataLoader {

    public static void loadTurns() {

        // CATEGORY: CASUAL

        //TURN 1
        //prepare the answers
        String[] answers0 = {"A High Pitched Tone", "A Minor Scale", "A Legato", "An Octave"};
        ArrayList<String> ans0 = new ArrayList<>(Arrays.asList(answers0));
        //setup the solution
        int solution0 = ans0.indexOf(answers0[0]);
        //create a turn and add it to the list of turns
        listOfTurns.add(new Turn(66,"Casual", "What playing a string harmonics on a string instrument produces?", solution0, ans0));

        //TURN 2
        String[] answers1 = {"Roger Waters","The Pink Floyd","David Gilmore","Elvis Presley"};
        ArrayList<String> ans1 = new ArrayList<>(Arrays.asList(answers1));
        int solution1 = ans1.indexOf(answers1[0]);
        listOfTurns.add(new Turn(101,"Casual", "Who wrote the song: I whish you were here?", solution1, ans1));
        //TURN 3
        String[] answers2 = {"Miserlou","Surf Rider","Girl You'll Be a Woman Soon","Pulp"};
        ArrayList<String> ans2 = new ArrayList<>(Arrays.asList(answers2));
        int solution2 = ans2.indexOf(answers2[0]);
        listOfTurns.add(new Turn(12,"Casual", "What's the name of Dick Dale's song whois in the openning of the movie Pulp Fiction?", solution2, ans2));

        //TURN 4
        String[] answers3 = {"Steve Harris","John Paul Jones","John Patitucci","Les Claypool"};
        ArrayList<String> ans3 = new ArrayList<>(Arrays.asList(answers3));
        int solution3 = ans3.indexOf(answers3[3]);
        listOfTurns.add(new Turn(105,"Casual", "What is the name of the bass player of the band Primus?", solution3, ans3));

        //TURN 5
        String[] answers4 = {"E major and E minor","A minor and A major","G minor and E major","A major and E minor"};
        ArrayList<String> ans4 = new ArrayList<>(Arrays.asList(answers4));
        int solution4 = ans4.indexOf(answers4[0]);
        listOfTurns.add(new Turn(14,"Casual", "A barre chord which use six strings on which chords are based?", solution4, ans4));

        // CATEGORY: CLASSICAL

        //TURN 1
        String[] answers5 = {"Bartolomeo Cristofori","Leonardo Da Vinci","Ludwig van Beethoven","Luciano Pavarotti"};
        ArrayList<String> ans5 = new ArrayList<>(Arrays.asList(answers5));
        int solution5 = ans5.indexOf(answers5[0]);
        listOfTurns.add(new Turn(189,"Classical", "Who is the credited to be the inventor of the piano?", solution5, ans5));

        //TURN 2
        String[] answers6 = {"LA","B","F","A"};
        ArrayList<String> ans6 = new ArrayList<>(Arrays.asList(answers6));
        int solution6 = ans6.indexOf(answers6[2]);
        listOfTurns.add(new Turn(78,"Classical", "On the pentagram which notes correspond to the bass clef?", solution6, ans6));

        //TURN 3
        String[] answers7 = {"Vincenzo Bellini","Ennio Monrricone","Wolfgang Amadeus Mozart","Giuseppe Verdi"};
        ArrayList<String> ans7 = new ArrayList<>(Arrays.asList(answers7));
        int solution7 = ans7.indexOf(answers7[0]);
        listOfTurns.add(new Turn(99,"Classical", "Who is the composer of the opera La Norma?", solution7, ans7));

        //TURN 4
        String[] answers8 = {"Cheltenham", "Oxford", "Cambridge", "Cirencester"};
        ArrayList<String> ans8 = new ArrayList<>(Arrays.asList(answers8));
        int solution8 = ans8.indexOf(answers8[1]);
        listOfTurns.add(new Turn(77,"Classical", "Where was cellist Jaqueline du Pré born?", solution8, ans8));

        //TURN 5
        String[] answers9 = {"Thomas beecham", "Malcolm Sargent", "Henry Wood", "Jhon Barbiolli"};
        ArrayList<String> ans9 = new ArrayList<>(Arrays.asList(answers9));
        int solution9 = ans9.indexOf(answers9[1]);
        listOfTurns.add(new Turn(145,"Classical", "Which conductor always appeared on the podium wearing a white carnation?", solution9, ans9));
    }
}
