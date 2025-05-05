package quizzapp.zero_to_hero;

import java.util.List;

/**
 * Represents a quiz question that includes an image
 */
public class QuestionImage extends Question {
    private String imagePath;

    /**
     * Constructs a new image-based question
     *
     * @param question The question text
     * @param options The answer options
     * @param correctAnswer The correct answer
     * @param category The question category
     * @param difficulty The question difficulty
     * @param imagePath Path to the question image
     */
    public QuestionImage(String question, List<String> options, String correctAnswer,
                         String category, String difficulty, String imagePath) {
        super(question, options, correctAnswer, category, difficulty);
        this.imagePath = imagePath;
    }

    /**
     * Get the path to the question image
     *
     * @return The image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Set the path to the question image
     *
     * @param imagePath The new image path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Check if this question has a valid image path
     *
     * @return true if the image path is not null or empty
     */
    public boolean hasImage() {
        return imagePath != null && !imagePath.isEmpty();
    }
}