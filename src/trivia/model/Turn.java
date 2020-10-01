/*
####################### Turn class #######################
Turn it's a model, represent one turn of a match in a game.

@Override toString()

@ id // unique static id to keep track if a turn it has been played already in a match
@ category //  a string containing the category of the question
@ question // a string containing a question
@ answers // arraylist containing the four possible answers to the question.
@ solution // an int containing the index of the arraylist answers with che correct answer.
################################################################
 */

package trivia.model;

import java.util.ArrayList;

public class Turn {

    private int id;
    private int solution;
    private String category;
    private String question;

    private ArrayList<String> answers;

    public Turn(int id, String category, String question, int solution, ArrayList<String> answers) {
        this.id = id;
        this.category = category;
        this.question = question;
        this.solution = solution;
        this.answers = answers;
    }

    public Turn(){}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public String getAnswers() {
        StringBuilder allTheAnswers = new StringBuilder("\n");
        int count = 0;
        for(String answer : answers) {
            allTheAnswers.append("answer: ").append(count).append(" - ").append(answer).append("\n");
            count++;
        }
        return allTheAnswers.toString();
    }

    public void setAnswer(int index, String answer) {
        answers.set(index, answer);
    }

    public int getId() { return this.id; }

    @Override
    public String toString() {
        return "ID: " + id + " Category: " + category + " Question: " + question + "\n" + "\nAnswers:\n" + getAnswers() + "\nSolution: " + solution + "\n";
    }
}
