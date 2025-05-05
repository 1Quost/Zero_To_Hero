package quizzapp.zero_to_hero;

import javax.swing.*;
import java.util.List;
public class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String category;
    private String difficulty;

    // Constructor
    public Question(String question, List<String> options, String correctAnswer, String category, String difficulty) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.difficulty = difficulty;
    }

    // Getters and Setters
    public String getQuestion() { return question; }
    public List<String> getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getCategory() { return category; }
    public String getDifficulty() { return difficulty; }
}
