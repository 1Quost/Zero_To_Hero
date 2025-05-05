package quizzapp.zero_to_hero;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.animation.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Quiz extends Application {

    // Store player's current score
    private int currentScore = 0;
    private int totalQuestions = 0;
    private String playerName = "Player";
    private String currentCategory = "";
    private QuizManager quizManager = new QuizManager();

    @Override
    public void start(Stage primaryStage) {


        /*/////////////*/
        /* Intro Video */
        /*/////////////*/

        // Load video
        Media media = new Media(new File("src/main/resources/videos/intro2.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // Create a StackPane to hold the video
        StackPane videoPane = new StackPane(mediaView);

        //first scene:
        // Set the initial scene to video
        Scene introScene = new Scene(videoPane, 800, 700);//video scene or intro scene

        // Make the video fit the window
        mediaView.fitWidthProperty().bind(videoPane.widthProperty());
        mediaView.fitHeightProperty().bind(videoPane.heightProperty());
        mediaView.setPreserveRatio(false); // or true if you want to preserve the original video ratio

        primaryStage.setTitle("INTRO_Welcome_To_The_Game!!");
        primaryStage.setScene(introScene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Play video
        mediaPlayer.play();

        /*/////////////*/
        /*  Home Play  */
        /*/////////////*/

        // Home GridPane
        GridPane home = new GridPane();
        home.setVgap(35);
        home.setHgap(10);
        home.setPadding(new Insets(50, 0, 50, 0));

        //2nd scene:
        // After video ends, switch to home scene
        mediaPlayer.setOnEndOfMedia(() -> {
            Scene homeScene = new Scene(home, 750, 500);
            primaryStage.setScene(homeScene);
            primaryStage.setTitle("READY!!Let's GO!!");
            AudioManager.startBackgroundMusic();
        });

        //Home background image
        Image image = new Image(getClass().getResource("/images/background.png").toExternalForm());
        BackgroundSize backgroundSize = new BackgroundSize(
                750, 500, true, true, true, true);

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                backgroundSize);

        home.setBackground(new Background(backgroundImage));



        //Logo image
        ImageView logo = new ImageView(new Image(getClass().getResource("/images/logo.png").toExternalForm()));
        logo.setFitWidth(200);
        logo.setFitHeight(200);
        GridPane.setHalignment(logo, javafx.geometry.HPos.CENTER);
        GridPane.setMargin(logo, new Insets(0, 0, 0, 100));
        home.add(logo, 1, 0, 2, 1);

        //name label
        Label Name = new Label("Player Name");
        Name.setTextFill(Paint.valueOf("White"));
        Name.setFont(Font.font("Yu Gothic UI", 18));
        GridPane.setMargin(Name, new Insets(15, 0, 50, 150));
        home.add(Name, 1, 1, 1, 1);

        //name TextField
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name HERE!");
        nameField.setFont(Font.font("Yu Gothic UI", 18));
        GridPane.setMargin(nameField, new Insets(15, 0, 50, 50));
        home.add(nameField, 2, 1, 1, 1);

        //Play button
        Button Play = new Button("Play");
        Play.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Play.setStyle("-fx-border-radius: 55px");
        GridPane.setMargin(Play, new Insets(0, 0, 80, 150));
        Play.setPadding(new Insets(0, 50, 0, 50));

        home.add(Play, 1, 2, 1, 1);

        //Setting button
        Button setting = new Button("Settings");
        setting.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        GridPane.setMargin(setting, new Insets(0, 0, 80, 50));
        setting.setPadding(new Insets(0, 50, 0, 50));
        home.add(setting, 2, 2, 1, 1);

        //After hitting Play
        VBox root = new VBox();
        root.setStyle("-fx-background-color: lightpink ;");

        Label welcome = new Label("WELCOME !!");
        welcome.setFont(Font.font("Monospaced", FontWeight.BOLD, 45));
        welcome.setStyle(
                "-fx-text-fill: linear-gradient(from 0% 0% to 0% 100%, #00c3ff, #0047ff);" +
                        "-fx-background-clip: text;"
        );

        // Wrap the VBox in a ScrollPane
        ScrollPane scrollPane = new ScrollPane(root);

        // Optional: Scroll only vertically
        scrollPane.setFitToWidth(true); // ensures content uses full width
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);



        //category page
        Scene categoryChoice = new Scene(scrollPane, 1000, 700);//category scene
        Play.setOnAction(event -> {   //play event handler
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                name = "Player";
                nameField.setText("Player");
            }
            playerName = name;
            primaryStage.setScene(categoryChoice); // change the scene!
            primaryStage.setTitle("GO!! Test your knowledge☺  " + playerName);

        });

        /*/////////////*/
        /*  Categories */
        /*/////////////*/

        GridPane categories = new GridPane();
        categories.setVgap(5);
        categories.setHgap(5);
        GridPane.setHalignment(logo, javafx.geometry.HPos.CENTER);

        Label choose = new Label("Choose from 7+ categories.");
        choose.setFont(Font.font("Monospaced", FontWeight.BOLD, 34));

        welcome.setPadding(new Insets(0, 0, 0, 5));
        choose.setPadding(new Insets(0, 0, 0, 5));

        /*category1 OOP*/
        ImageView OOP = new ImageView(new Image(getClass().getResource("/images/OOP.png").toExternalForm()));
        OOP.setFitWidth(200);
        OOP.setFitHeight(200);
        categories.add(OOP, 0, 0);
        Button OOPb = new Button("OOP");
        OOPb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        OOPb.setStyle("-fx-background-radius: 25;");
        categories.add(OOPb, 0, 1);

        /*category2 Technology*/
        ImageView Technology = new ImageView(new Image(getClass().getResource("/images/Robot.png").toExternalForm()));
        Technology.setFitWidth(200);
        Technology.setFitHeight(200);
        categories.add(Technology, 1, 0);
        Button Technologyb = new Button("Technology");
        Technologyb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Technologyb.setStyle("-fx-background-radius: 25;");
        categories.add(Technologyb, 1, 1);

        /*category3 Art*/
        ImageView Art = new ImageView(new Image(getClass().getResource("/images/Art.png").toExternalForm()));
        Art.setFitWidth(200);
        Art.setFitHeight(200);
        categories.add(Art, 2, 0);
        Button Artb = new Button("Art");
        Artb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Artb.setStyle("-fx-background-radius: 25;");
        categories.add(Artb, 2, 1);

        /*category4 Logo*/
        ImageView Logo = new ImageView(new Image(getClass().getResource("/images/logos.png").toExternalForm()));
        Logo.setFitWidth(200);
        Logo.setFitHeight(200);
        categories.add(Logo, 3, 0);
        Button Logob = new Button("Logo");
        Logob.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Logob.setStyle("-fx-background-radius: 25;");
        categories.add(Logob, 3, 1);

        /*category5 Science*/
        ImageView Science = new ImageView(new Image(getClass().getResource("/images/science.png").toExternalForm()));
        Science.setFitWidth(200);
        Science.setFitHeight(200);
        categories.add(Science, 0, 2);
        Button Scienceb = new Button("Science");
        Scienceb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Scienceb.setStyle("-fx-background-radius: 25;");
        categories.add(Scienceb, 0, 3);

        /*category6 Animals*/
        ImageView Animal = new ImageView(new Image(getClass().getResource("/images/animals.png").toExternalForm()));
        Animal.setFitWidth(200);
        Animal.setFitHeight(200);
        categories.add(Animal, 1, 2);
        Button Animalb = new Button("Animal");
        Animalb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Animalb.setStyle("-fx-background-radius: 25;");
        categories.add(Animalb, 1, 3);

        /*category7 Sports*/
        ImageView Sport = new ImageView(new Image(getClass().getResource("/images/Sport.png").toExternalForm()));
        Sport.setFitWidth(200);
        Sport.setFitHeight(200);
        categories.add(Sport, 2, 2);
        Button Sportb = new Button("Sport");
        Sportb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Sportb.setStyle("-fx-background-radius: 25;");
        categories.add(Sportb, 2, 3);

        /*category8 Geograpgy*/
        ImageView Geography = new ImageView(new Image(getClass().getResource("/images/geography.png").toExternalForm()));
        Geography.setFitWidth(200);
        Geography.setFitHeight(200);
        categories.add(Geography, 3, 2);
        Button Geographyb = new Button("Geography");
        Geographyb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Geographyb.setStyle("-fx-background-radius: 25;");
        categories.add(Geographyb, 3, 3);

        /*category9 Hist*/
        ImageView Hist = new ImageView(new Image(getClass().getResource("/images/hist.png").toExternalForm()));
        Hist.setFitWidth(200);
        Hist.setFitHeight(200);
        categories.add(Hist, 0, 4);
        Button Histb = new Button("Hist");
        Histb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Histb.setStyle("-fx-background-radius: 25;");
        categories.add(Histb, 0, 5);

        /*category10 General knowledge*/
        ImageView General = new ImageView(new Image(getClass().getResource("/images/general.png").toExternalForm()));
        General.setFitWidth(200);
        General.setFitHeight(200);
        categories.add(General, 1, 4);
        Button Generalb = new Button("General");
        Generalb.setFont(Font.font("Monospaced", FontWeight.BOLD, 15));
        Generalb.setStyle("-fx-background-radius: 25;");
        categories.add(Generalb, 1, 5);

        /*Margin between categories inside the categories gridpane*/
        GridPane.setMargin(OOP, new Insets(10, 0, 0, 15));
        GridPane.setMargin(OOPb, new Insets(0, 0, 0, 90));
        GridPane.setMargin(Technology, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Technologyb, new Insets(0, 0, 0, 70));
        GridPane.setMargin(Art, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Artb, new Insets(0, 0, 0, 90));
        GridPane.setMargin(Logo, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Logob, new Insets(0, 0, 0, 90));
        GridPane.setMargin(Science, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Scienceb, new Insets(0, 0, 0, 70));
        GridPane.setMargin(Animal, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Animalb, new Insets(0, 0, 0, 80));
        GridPane.setMargin(Sport, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Sportb, new Insets(0, 0, 0, 70));
        GridPane.setMargin(Geography, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Geographyb, new Insets(0, 0, 0, 60));
        GridPane.setMargin(Hist, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Histb, new Insets(0, 0, 35, 85));
        GridPane.setMargin(General, new Insets(10, 0, 0, 15));
        GridPane.setMargin(Generalb, new Insets(0, 0, 35, 70));

        root.getChildren().addAll(welcome, choose, categories);

        /*Levels*/
        VBox pick = new VBox(4);
        Label levelchoice = new Label("Pick Your Level");
        levelchoice.setFont(Font.font("Monospaced", FontWeight.BOLD, 62));
        pick.getChildren().add(levelchoice);
        pick.setStyle("-fx-background-color: lightblue;");

        HBox emoji = new HBox();
        ImageView easy = new ImageView(new Image(getClass().getResource("/images/easy.png").toExternalForm()));
        easy.setFitWidth(175);
        easy.setFitHeight(150);

        ImageView medium = new ImageView(new Image(getClass().getResource("/images/medium.png").toExternalForm()));
        medium.setFitWidth(168);
        medium.setFitHeight(159);

        ImageView hard = new ImageView(new Image(getClass().getResource("/images/hard.png").toExternalForm()));
        hard.setFitWidth(200);
        hard.setFitHeight(150);

        emoji.getChildren().addAll(easy, medium, hard);

        VBox.setMargin(levelchoice, new Insets(50, 0, 0, 100));
        HBox.setMargin(easy, new Insets(60, 0, 0, 50));
        HBox.setMargin(medium, new Insets(60, 0, 0, 85));
        HBox.setMargin(hard, new Insets(60, 0, 0, 80));

        pick.getChildren().add(emoji);

        HBox buttons = new HBox();
        Button easyb = new Button("Easy");
        Button mediumb = new Button("Medium");
        Button hardb = new Button("Hard");

        /*Stylling buttons*/
        easyb.setStyle("-fx-background-color:  #5086ff;" +
                " -fx-text-fill: black ; " +
                "-fx-background-radius:5 ; ");
        easyb.setFont(Font.font("Monospaced", FontWeight.NORMAL, 19));

        mediumb.setStyle("-fx-background-color:  #FFD107;" +
                "-fx-text-fill: black ; " +
                "-fx-background-radius:5 ; ");
        mediumb.setFont(Font.font("Bookman Old Style", FontWeight.BOLD, 16));

        hardb.setStyle("-fx-background-color:  #DC143C; " +
                "-fx-text-fill: white ; " +
                "-fx-background-radius:5 ; ");
        hardb.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        /*setting buttons sizes*/
        easyb.setPrefWidth(160);
        mediumb.setPrefWidth(168);
        hardb.setPrefWidth(156);
        easyb.setPrefHeight(39);
        mediumb.setPrefHeight(42);
        hardb.setPrefHeight(42.5);
        buttons.getChildren().addAll(easyb, mediumb, hardb);

        HBox.setMargin(easyb, new Insets(20, 90, 0, 50));
        easyb.setPadding(new Insets(10, 50, 10, 50));
        HBox.setMargin(mediumb, new Insets(20, 50, 0, 0));
        mediumb.setPadding(new Insets(10, 50, 10, 50));
        HBox.setMargin(hardb, new Insets(20, 0, 0, 40));
        hardb.setPadding(new Insets(10, 50, 10, 50));

        ImageView back = new ImageView(new Image(getClass().getResource("/images/back.png").toExternalForm()));
        back.setFitWidth(200);
        back.setFitHeight(150);
        pick.getChildren().addAll(buttons, back);

        Scene level = new Scene(pick, 752, 587);

        /* Event handler for each category button*/
        OOPb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "OOP";
            primaryStage.show();
        });

        Technologyb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "Technology";
            primaryStage.show();
        });

        Sportb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "Sport";
            primaryStage.show();
        });

        Animalb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "Animal";
            primaryStage.show();
        });

        Artb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "Art";
            primaryStage.show();
        });

        Generalb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "General";
            primaryStage.show();
        });

        Geographyb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "Geography";
            primaryStage.show();
        });

        Logob.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "Logo";
            primaryStage.show();
        });

        Scienceb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "Science";
            primaryStage.show();
        });

        Histb.setOnAction(e -> {
            primaryStage.setTitle("Choose your level!");
            primaryStage.setScene(level);
            primaryStage.setResizable(false);
            currentCategory = "History";
            primaryStage.show();
        });

        back.setOnMouseClicked(e -> {
            primaryStage.setScene(categoryChoice); // change the scene!
            primaryStage.setTitle("GO!! Test your knowledge☺ ");
            primaryStage.setResizable(false);
            primaryStage.show();
        });

        // Event handlers for difficulty levels
        easyb.setOnAction(e -> {
            if (currentCategory.equals("Logo")) {
                List<QuestionImage> imageQuestions = quizManager.getImageQuestions(currentCategory, "Easy");
                if (!imageQuestions.isEmpty()) {
                    showQuizImageScene(primaryStage, imageQuestions, currentCategory, "Easy", categoryChoice);
                } else {
                    showNotAvailableAlert(primaryStage, currentCategory, "Easy");
                }
            } else {
                List<Question> questions = quizManager.getQuestions(currentCategory, "Easy");
                if (!questions.isEmpty()) {
                    showQuizScene(primaryStage, questions, currentCategory, "Easy", categoryChoice);
                } else {
                    showNotAvailableAlert(primaryStage, currentCategory, "Easy");
                }
            }
        });

        mediumb.setOnAction(e -> {
            if (currentCategory.equals("Logo")) {
                List<QuestionImage> imageQuestions = quizManager.getImageQuestions(currentCategory, "Medium");
                if (!imageQuestions.isEmpty()) {
                    showQuizImageScene(primaryStage, imageQuestions, currentCategory, "Medium", categoryChoice);
                } else {
                    showNotAvailableAlert(primaryStage, currentCategory, "Medium");
                }
            } else {
                List<Question> questions = quizManager.getQuestions(currentCategory, "Medium");
                if (!questions.isEmpty()) {
                    showQuizScene(primaryStage, questions, currentCategory, "Medium", categoryChoice);
                } else {
                    showNotAvailableAlert(primaryStage, currentCategory, "Medium");
                }
            }
        });

        hardb.setOnAction(e -> {
            if (currentCategory.equals("Logo")) {
                List<QuestionImage> imageQuestions = quizManager.getImageQuestions(currentCategory, "Hard");
                if (!imageQuestions.isEmpty()) {
                    showQuizImageScene(primaryStage, imageQuestions, currentCategory, "Hard", categoryChoice);
                } else {
                    showNotAvailableAlert(primaryStage, currentCategory, "Hard");
                }
            } else {
                List<Question> questions = quizManager.getQuestions(currentCategory, "Hard");
                if (!questions.isEmpty()) {
                    showQuizScene(primaryStage, questions, currentCategory, "Hard", categoryChoice);
                } else {
                    showNotAvailableAlert(primaryStage, currentCategory, "Hard");
                }
            }
        });
    }

    private void showNotAvailableAlert(Stage primaryStage, String category, String difficulty) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Questions Not Available");
        alert.setHeaderText(null);
        alert.setContentText("Questions for " + category + " in " + difficulty + " difficulty are not available yet. Please try another category or difficulty!");
        alert.showAndWait();
    }

    private void showQuizScene(Stage primaryStage, List<Question> questions, String categoryName, String difficulty, Scene returnScene) {
        // Reset score for new quiz
        currentScore = 0;
        totalQuestions = questions.size();

        // Keep track of the current question
        AtomicInteger currentIndex = new AtomicInteger(0);

        // Create quiz layout components
        BorderPane quizLayout = new BorderPane();
        quizLayout.setPadding(new Insets(20));

        if (difficulty.equals("Easy")) {
            quizLayout.setStyle("-fx-background-color: #69a4e3;"); // Light blue for easy
        } else if (difficulty.equals("Medium")) {
            quizLayout.setStyle("-fx-background-color: #efd571;"); // Light yellow for medium
        } else {
            quizLayout.setStyle("-fx-background-color: #e33b3b;"); // Light red for hard
        }

       // Top area - Quiz title and progress
        HBox topArea = new HBox(150);
        Label titleLabel = new Label(categoryName + " - " + difficulty);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        HBox.setMargin(topArea,new Insets(0,0,25,0));

        // Lives display - Hearts
        HBox livesDisplay = new HBox(5);
        livesDisplay.setAlignment(Pos.CENTER);

        ImageView heart1 = new ImageView(new Image(getClass().getResource("/images/heart-full.png").toExternalForm()));
        heart1.setFitWidth(30);
        heart1.setFitHeight(30);

        ImageView heart2 = new ImageView(new Image(getClass().getResource("/images/heart-full.png").toExternalForm()));
        heart2.setFitWidth(30);
        heart2.setFitHeight(30);

        livesDisplay.getChildren().addAll(heart1, heart2);

        // Question progress indicators (circles)
        HBox progressIndicators = new HBox(10);
        progressIndicators.setAlignment(Pos.CENTER);

        // Create circles for each question (up to 5 questions shown)
        int maxIndicators = Math.min(questions.size(), 5);
        Circle[] questionCircles = new Circle[maxIndicators];

        for (int i = 0; i < maxIndicators; i++) {
            Circle circle = new Circle(12);
            circle.setFill(Color.LIGHTGRAY);
            circle.setStroke(Color.GRAY);

            StackPane circleContainer = new StackPane();
            circleContainer.getChildren().add(circle);

            // If this is the current question, highlight it
            if (i == 0) {
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLUE);
            }

            questionCircles[i] = circle;
            progressIndicators.getChildren().add(circleContainer);
        }

        topArea.getChildren().addAll(livesDisplay, titleLabel, progressIndicators);
        topArea.setAlignment(Pos.CENTER);
        quizLayout.setTop(topArea);

        // Center area - Question and options
        VBox centerArea = new VBox(20);
        centerArea.setPadding(new Insets(20));

        Label questionLabel = new Label("Loading question...");
        questionLabel.setFont(Font.font("Arial", 18));
        questionLabel.setWrapText(true);

        VBox optionsBox = new VBox(15);
        AtomicReference<ToggleGroup> optionsGroup = new AtomicReference<>(new ToggleGroup());

        centerArea.getChildren().addAll(questionLabel, optionsBox);
        quizLayout.setCenter(centerArea);

        // Bottom area - Navigation buttons
        HBox bottomArea = new HBox(20);

        Button nextButton = new Button("Next Question");
        nextButton.setFont(Font.font("Arial", 16));
        nextButton.setDisable(true);

        Button quitButton = new Button("Quit Quiz");
        quitButton.setFont(Font.font("Arial", 16));

        bottomArea.getChildren().addAll(quitButton, nextButton);
        bottomArea.setAlignment(Pos.CENTER_RIGHT);
        quizLayout.setBottom(bottomArea);

        // Keep track of remaining lives
        AtomicInteger remainingLives = new AtomicInteger(2);

        // Create the scene
        Scene quizScene = new Scene(quizLayout, 800, 600);
        primaryStage.setScene(quizScene);
        primaryStage.setTitle(categoryName + " Quiz - " + difficulty);

        // Function to load a question
        Runnable loadQuestion = () -> {
            if (currentIndex.get() < questions.size()) {
                Question currentQuestion = questions.get(currentIndex.get());

                // Update UI elements
                questionLabel.setText((currentIndex.get() + 1) + ". " + currentQuestion.getQuestion());

                // Update progress indicators
                for (int i = 0; i < maxIndicators; i++) {
                    Circle circle = questionCircles[i];

                    if (i < currentIndex.get()) {
                        // Previous questions
                        StackPane container = (StackPane) progressIndicators.getChildren().get(i);

                        // Check if we already updated this indicator
                        if (container.getChildren().size() == 1) {
                            // Previous question was answered correctly or incorrectly
                            boolean wasCorrect = i < currentIndex.get() &&
                                    (i >= currentIndex.get() - currentScore);

                            // Add checkmark or X
                            Text mark = new Text(wasCorrect ? "✓" : "✗");
                            mark.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                            mark.setFill(wasCorrect ? Color.GREEN : Color.RED);
                            container.getChildren().add(mark);
                        }
                    } else if (i == currentIndex.get()) {
                        // Current question
                        circle.setFill(Color.WHITE);
                        circle.setStroke(Color.BLUE);
                    } else {
                        // Future questions
                        circle.setFill(Color.LIGHTGRAY);
                        circle.setStroke(Color.GRAY);
                    }
                }

                // Clear previous options
                optionsBox.getChildren().clear();
                optionsGroup.set(new ToggleGroup());

                // Add new options
                for (String option : currentQuestion.getOptions()) {
                    RadioButton rb = new RadioButton(option);
                    rb.setFont(Font.font("Arial", 16));
                    rb.setToggleGroup(optionsGroup.get());
                    rb.setUserData(option);
                    optionsBox.getChildren().add(rb);

                    // Enable next button when an option is selected
                    rb.setOnAction(e -> nextButton.setDisable(false));
                }

                nextButton.setDisable(true);
            } else {
                // Quiz completed, show results
                showQuizResults(primaryStage, categoryName, difficulty, returnScene);
            }
        };

        // Load the first question
        loadQuestion.run();

        /**Next Button**/


        // Handle next button click
        nextButton.setOnAction(e -> {
            RadioButton selectedButton = (RadioButton) optionsGroup.get().getSelectedToggle();
            if (selectedButton != null) {
                // Check if answer is correct
                String selectedAnswer = (String) selectedButton.getUserData();
                boolean isCorrect = selectedAnswer.equals(questions.get(currentIndex.get()).getCorrectAnswer());

                if (isCorrect) {
                    currentScore++;

                    // Update the current question circle with a check mark
                    if (currentIndex.get() < maxIndicators) {
                        StackPane container = (StackPane) progressIndicators.getChildren().get(currentIndex.get());
                        Text checkmark = new Text("✓");
                        checkmark.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                        checkmark.setFill(Color.GREEN);
                        container.getChildren().add(checkmark);
                    }

                    // Show correct answer feedback
                    showAnswerFeedback(true, questions.get(currentIndex.get()).getCorrectAnswer());
                    currentIndex.incrementAndGet();
                    loadQuestion.run();
                } else {
                    // Remove one heart

                    if (remainingLives.get() > 0) {
                        ImageView heartToEmpty = remainingLives.get() == 2 ? heart2 : heart1;
                        heartToEmpty.setImage(new Image(getClass().getResource("/images/heart-empty.png").toExternalForm()));
                        remainingLives.decrementAndGet();
                    }

                    // Update the current question circle with an X mark
                    if (currentIndex.get() < maxIndicators) {
                        StackPane container = (StackPane) progressIndicators.getChildren().get(currentIndex.get());
                        Text xmark = new Text("✗");
                        xmark.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                        xmark.setFill(Color.RED);
                        container.getChildren().add(xmark);
                    }

                    // Show incorrect answer feedback
                    showAnswerFeedback(false, questions.get(currentIndex.get()).getCorrectAnswer());

                    //show game over
                    if (remainingLives.get() == 0) {
                        showGameOver(primaryStage, categoryName, difficulty, returnScene);
                    } else {

                        // Move to next question
                        currentIndex.incrementAndGet();
                        loadQuestion.run();
                    }
                }

            }
        });

        // Handle quit button click
        quitButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quit Quiz");
            alert.setHeaderText("Are you sure you want to quit?");
            alert.setContentText("Your progress will be lost.");

            alert.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK) {
                    primaryStage.setScene(returnScene);
                    primaryStage.setTitle("GO!! Test your knowledge☺ " + playerName);
                }
            });
        });
    }


    private void showQuizImageScene(Stage primaryStage, List<QuestionImage> questions,
                                    String categoryName, String difficulty, Scene returnScene) {
        currentScore = 0;
        totalQuestions = questions.size();
        AtomicInteger currentIndex = new AtomicInteger(0);

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        if (difficulty.equals("Easy")) {
            root.setStyle("-fx-background-color: #69a4e3;");
        } else if (difficulty.equals("Medium")) {
            root.setStyle("-fx-background-color: #efd571;");
        } else {
            root.setStyle("-fx-background-color: #e33b3b;");
        }

        // Top area - Quiz title and progress
        HBox topArea = new HBox(150);
        Label titleLabel = new Label(categoryName + " - " + difficulty);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Lives display - Hearts
        HBox livesDisplay = new HBox(5);
        livesDisplay.setAlignment(Pos.CENTER);

        ImageView heart1 = new ImageView(new Image(getClass().getResource("/images/heart-full.png").toExternalForm()));
        heart1.setFitWidth(30);
        heart1.setFitHeight(30);

        ImageView heart2 = new ImageView(new Image(getClass().getResource("/images/heart-full.png").toExternalForm()));
        heart2.setFitWidth(30);
        heart2.setFitHeight(30);

        livesDisplay.getChildren().addAll(heart1, heart2);

        // Question progress indicators (circles)
        HBox progressIndicators = new HBox(10);
        progressIndicators.setAlignment(Pos.CENTER);

        int maxIndicators = Math.min(questions.size(), 5);
        Circle[] questionCircles = new Circle[maxIndicators];

        for (int i = 0; i < maxIndicators; i++) {
            Circle circle = new Circle(12);
            circle.setFill(Color.LIGHTGRAY);
            circle.setStroke(Color.GRAY);

            StackPane circleContainer = new StackPane();
            circleContainer.getChildren().add(circle);

            if (i == 0) {
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLUE);
            }
            questionCircles[i] = circle;
            progressIndicators.getChildren().add(circleContainer);
        }

        topArea.getChildren().addAll(livesDisplay, titleLabel, progressIndicators);
        topArea.setAlignment(Pos.CENTER);
        root.setTop(topArea);

        // Center area - Question image, text and options
        ImageView questionImageView = new ImageView();
        questionImageView.setFitWidth(200);  // Increased size for better visibility
        questionImageView.setFitHeight(200);
        questionImageView.setPreserveRatio(true);

        Label questionLabel = new Label();
        questionLabel.setWrapText(true);
        questionLabel.setFont(Font.font("Arial", 18));  // Matching font size

        ToggleGroup group = new ToggleGroup();
        VBox optionsBox = new VBox(15);  // Increase spacing to match showQuizScene
        optionsBox.setPadding(new Insets(10));

        VBox centerBox = new VBox(20, questionImageView, questionLabel, optionsBox);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(20));  // Add padding to match showQuizScene
        root.setCenter(centerBox);

        // Bottom area - Navigation buttons
        HBox bottomArea = new HBox(20);

        Button nextButton = new Button("Next Question");
        nextButton.setFont(Font.font("Arial", 16));
        nextButton.setDisable(true);

        Button quitButton = new Button("Quit Quiz");
        quitButton.setFont(Font.font("Arial", 16));

        bottomArea.getChildren().addAll(quitButton, nextButton);
        bottomArea.setAlignment(Pos.CENTER_RIGHT);
        root.setBottom(bottomArea);

        // Keep track of remaining lives
        AtomicInteger remainingLives = new AtomicInteger(2);

        Runnable loadQuestion = () -> {
            if (currentIndex.get() < questions.size()) {
                QuestionImage q = questions.get(currentIndex.get());
                questionLabel.setText((currentIndex.get() + 1) + ". " + q.getQuestion());

                // Load the image if present
                if (q.hasImage()) {
                    try {
                        Image img = new Image(getClass().getResourceAsStream(q.getImagePath()));
                        questionImageView.setImage(img);
                        questionImageView.setVisible(true);  // Make sure image is visible
                    } catch (Exception e) {
                        System.err.println("Image not found: " + q.getImagePath());
                        questionImageView.setImage(null);
                        questionImageView.setVisible(false);  // Hide image view if no image
                    }
                } else {
                    questionImageView.setImage(null);
                    questionImageView.setVisible(false);  // Hide image view if no image
                }

                group.getToggles().clear();
                optionsBox.getChildren().clear();
                nextButton.setDisable(true);

                for (String option : q.getOptions()) {
                    RadioButton rb = new RadioButton(option);
                    rb.setToggleGroup(group);
                    rb.setFont(Font.font("Arial", 16));
                    rb.setUserData(option);
                    optionsBox.getChildren().add(rb);

                    // Enable next button when an option is selected
                    rb.setOnAction(e -> nextButton.setDisable(false));
                }

                // Update progress indicators
                for (int i = 0; i < maxIndicators; i++) {
                    Circle circle = questionCircles[i];
                    if (i < currentIndex.get()) {
                        StackPane container = (StackPane) progressIndicators.getChildren().get(i);
                        if (container.getChildren().size() == 1) {
                            boolean wasCorrect = i < currentIndex.get() &&
                                    (i >= currentIndex.get() - currentScore);
                            Text mark = new Text(wasCorrect ? "✓" : "✗");
                            mark.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                            mark.setFill(wasCorrect ? Color.GREEN : Color.RED);
                            container.getChildren().add(mark);
                        }
                    } else if (i == currentIndex.get()) {
                        circle.setFill(Color.WHITE);
                        circle.setStroke(Color.BLUE);
                    } else {
                        circle.setFill(Color.LIGHTGRAY);
                        circle.setStroke(Color.GRAY);
                    }
                }
            } else {
                showQuizResults(primaryStage, categoryName, difficulty, returnScene);
            }
        };

        // Handle next button click
        nextButton.setOnAction(e -> {
            RadioButton selectedButton = (RadioButton) group.getSelectedToggle();
            if (selectedButton != null) {
                String selectedAnswer = (String) selectedButton.getUserData();
                boolean isCorrect = selectedAnswer.equals(questions.get(currentIndex.get()).getCorrectAnswer());

                if (isCorrect) {
                    currentScore++;
                    if (currentIndex.get() < maxIndicators) {
                        StackPane container = (StackPane) progressIndicators.getChildren().get(currentIndex.get());
                        Text checkmark = new Text("✓");
                        checkmark.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                        checkmark.setFill(Color.GREEN);
                        container.getChildren().add(checkmark);
                    }
                    showAnswerFeedback(true, questions.get(currentIndex.get()).getCorrectAnswer());
                    currentIndex.incrementAndGet();
                    loadQuestion.run();
                } else {
                    if (remainingLives.get() > 0) {
                        ImageView heartToEmpty = remainingLives.get() == 2 ? heart2 : heart1;
                        heartToEmpty.setImage(new Image(getClass().getResource("/images/heart-empty.png").toExternalForm()));
                        remainingLives.decrementAndGet();
                    }
                    if (currentIndex.get() < maxIndicators) {
                        StackPane container = (StackPane) progressIndicators.getChildren().get(currentIndex.get());
                        Text xmark = new Text("✗");
                        xmark.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                        xmark.setFill(Color.RED);
                        container.getChildren().add(xmark);
                    }
                    showAnswerFeedback(false, questions.get(currentIndex.get()).getCorrectAnswer());

                    if (remainingLives.get() == 0) {
                        showGameOver(primaryStage, categoryName, difficulty, returnScene);
                        return;
                    } else {
                        // Move to next question even when incorrect (but still have lives)
                        currentIndex.incrementAndGet();
                        loadQuestion.run();
                    }
                }
            }
        });

        // Handle quit button click
        quitButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quit Quiz");
            alert.setHeaderText("Are you sure you want to quit?");
            alert.setContentText("Your progress will be lost.");

            alert.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK) {
                    primaryStage.setScene(returnScene);
                    primaryStage.setTitle("GO!! Test your knowledge☺ " + playerName);
                }
            });
        });

        // Load first question
        loadQuestion.run();

        Scene scene = new Scene(root, 800, 600);  // Match size with showQuizScene
        primaryStage.setScene(scene);
        primaryStage.setTitle(categoryName + " Quiz - " + difficulty);  // Match title format
    }


    private void showAnswerFeedback(boolean isCorrect, String correctAnswer) {
        // Create a custom dialog instead of using Alert
        Stage feedbackStage = new Stage();
        feedbackStage.initModality(Modality.APPLICATION_MODAL);

        // Create layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Set background based on answer correctness
        layout.setStyle(isCorrect ?
                "-fx-background-color: linear-gradient(to bottom, #a8e063, #56ab2f);" :
                "-fx-background-color: linear-gradient(to bottom, #ff9966, #ff5e62);");

        // Add emoji/icon
        Text emoji = new Text(isCorrect ? "✓" : "✗");
        emoji.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        emoji.setFill(isCorrect ? Color.DARKGREEN : Color.DARKRED);

        // Add message
        Label headerLabel = new Label(isCorrect ? "Correct!" : "Oops!");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setTextFill(isCorrect ? Color.DARKGREEN : Color.DARKRED);

        Label messageLabel = new Label(isCorrect ?
                "Great job! Your answer is correct!" :
                "That's not the right answer.");
        messageLabel.setFont(Font.font("Arial", 16));

        // For wrong answers, show the correct answer
        Label correctAnswerLabel = null;
        if (!isCorrect) {
            correctAnswerLabel = new Label("Correct answer: " + correctAnswer);
            correctAnswerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        }

        // Add continue button
        Button continueButton = new Button("Continue");
        continueButton.setFont(Font.font("Arial", 16));
        continueButton.setOnAction(e -> feedbackStage.close());
        continueButton.setStyle("-fx-background-radius: 20; -fx-padding: 8 20 8 20;");

        // Add elements to layout
        if (isCorrect) {
            layout.getChildren().addAll(emoji, headerLabel, messageLabel, continueButton);
        } else {
            layout.getChildren().addAll(emoji, headerLabel, messageLabel, correctAnswerLabel, continueButton);
        }

        // Create scene
        Scene scene = new Scene(layout, 400, isCorrect ? 200 : 250);
        feedbackStage.setScene(scene);
        feedbackStage.setTitle(isCorrect ? "Correct Answer" : "Incorrect Answer");
        feedbackStage.showAndWait();
    }

    // Replace your current showGameOver method with this improved version:

    private void showGameOver(Stage primaryStage, String categoryName, String difficulty, Scene returnScene) {
        // Create a modal dialog
        Stage gameOverStage = new Stage();
        gameOverStage.initModality(Modality.APPLICATION_MODAL);

        // Create layout with animation
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #ff6b6b, #c62828);");

        // Game Over text with animation
        Label gameOverLabel = new Label("GAME OVER");
        gameOverLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        gameOverLabel.setTextFill(Color.WHITE);

        // Add pulsing animation to the Game Over text
        ScaleTransition pulse = new ScaleTransition(Duration.seconds(0.8), gameOverLabel);
        pulse.setFromX(1.0);
        pulse.setFromY(1.0);
        pulse.setToX(1.1);
        pulse.setToY(1.1);
        pulse.setCycleCount(Animation.INDEFINITE);
        pulse.setAutoReverse(true);
        pulse.play();

        // Score display
        Label scoreLabel = new Label("Your score: " + currentScore + "/" + totalQuestions);
        scoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        scoreLabel.setTextFill(Color.WHITE);

        // Message about lives
        Label livesLabel = new Label("You've used all your lives!");
        livesLabel.setFont(Font.font("Arial", 18));
        livesLabel.setTextFill(Color.WHITE);

        // Buttons
        Button showResultsButton = new Button("Show Results");
        showResultsButton.setFont(Font.font("Arial", 16));
        showResultsButton.setStyle("-fx-background-color: white; -fx-text-fill: #c62828; -fx-background-radius: 20; -fx-padding: 10 25 10 25;");

        Button tryAgainButton = new Button("Try Again");
        tryAgainButton.setFont(Font.font("Arial", 16));
        tryAgainButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 10 25 10 25;");

        // Button actions
        showResultsButton.setOnAction(e -> {
            gameOverStage.close();
            showQuizResults(primaryStage, categoryName, difficulty, returnScene);
        });

        tryAgainButton.setOnAction(e -> {
            gameOverStage.close();
            if (categoryName.equals("Logo")){
                List<QuestionImage>questionImages=quizManager.getImageQuestions(currentCategory,difficulty);
                showQuizImageScene(primaryStage, questionImages, currentCategory, difficulty, returnScene);
            }
            else{
                List<Question> questions = quizManager.getQuestions(currentCategory, difficulty);
                showQuizScene(primaryStage, questions, currentCategory, difficulty, returnScene);
            }


        });

        // Container for buttons
        HBox buttonBox = new HBox(20, tryAgainButton, showResultsButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add all elements to layout
        layout.getChildren().addAll(gameOverLabel, livesLabel, scoreLabel, buttonBox);

        // Create scene
        Scene gameOverScene = new Scene(layout, 500, 350);
        gameOverStage.setScene(gameOverScene);
        gameOverStage.setTitle("Game Over");
        gameOverStage.showAndWait();
    }

    private void showQuizResults(Stage primaryStage, String categoryName, String difficulty, Scene returnScene) {
        // Create result screen
        StackPane mainContainer = new StackPane();

        // Background with gradient based on performance
        double percentage = (double) currentScore / totalQuestions * 100;
        String gradientStyle;

        if (percentage >= 80) {
            gradientStyle = "-fx-background-color: linear-gradient(to bottom, #a8e063, #56ab2f);"; // Green gradient
        } else if (percentage >= 50) {
            gradientStyle = "-fx-background-color: linear-gradient(to bottom, #ffb347, #ffcc33);"; // Orange gradient
        } else {
            gradientStyle = "-fx-background-color: linear-gradient(to bottom, #ff9966, #ff5e62);"; // Red gradient
        }

        mainContainer.setStyle(gradientStyle);

        // Main content container with some transparency
        VBox resultLayout = new VBox(20);
        resultLayout.setAlignment(Pos.CENTER);
        resultLayout.setPadding(new Insets(50));
        resultLayout.setMaxWidth(600);
        resultLayout.setMaxHeight(500);
        resultLayout.setStyle("-fx-background-color: rgba(255, 255, 255, 0.85); -fx-background-radius: 20;");

        // Results title with animation
        Label titleLabel = new Label("Quiz Results");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        titleLabel.setTextFill(Paint.valueOf("#333333"));

        // Add scaling animation to title
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.7), titleLabel);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.play();

        // Quiz details
        Label quizDetailsLabel = new Label(categoryName + " - " + difficulty + " Level");
        quizDetailsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Player name
        Label playerNameLabel = new Label("Player: " + playerName);
        playerNameLabel.setFont(Font.font("Arial", 18));

        // Score visualization - Circle progress indicator
        StackPane scoreVisual = new StackPane();

        // Outer circle (background)
        Circle outerCircle = new Circle(70);
        outerCircle.setFill(Color.LIGHTGRAY);

        // Inner circle (score)
        Circle innerCircle = new Circle(70);

        // Create a clip for the inner circle based on percentage
        Rectangle clip = new Rectangle(0, 0, 140, 140 * (percentage / 100.0));
        clip.setTranslateY(70 - 70 * (percentage / 100.0));
        innerCircle.setClip(clip);

        // Color the inner circle based on performance
        if (percentage >= 80) {
            innerCircle.setFill(Color.GREEN);
        } else if (percentage >= 50) {
            innerCircle.setFill(Color.ORANGE);
        } else {
            innerCircle.setFill(Color.RED);
        }

        // Score text
        Text scoreText = new Text(currentScore + "/" + totalQuestions);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Percentage text
        Text percentageText = new Text(String.format("%.0f%%", percentage));
        percentageText.setFont(Font.font("Arial", 18));
        percentageText.setTranslateY(30);

        scoreVisual.getChildren().addAll(outerCircle, innerCircle, scoreText, percentageText);

        // Performance message with animation
        Label performanceLabel = new Label();
        performanceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        performanceLabel.setWrapText(true);
        performanceLabel.setTextAlignment(TextAlignment.CENTER);

        // Determine performance message based on percentage
        if (percentage >= 90) {
            performanceLabel.setText("Excellent! You're a " + categoryName + " expert!");
            performanceLabel.setTextFill(Paint.valueOf("#006400")); // Dark green
        } else if (percentage >= 70) {
            performanceLabel.setText("Great job! You know your " + categoryName + " well!");
            performanceLabel.setTextFill(Paint.valueOf("#008000")); // Green
        } else if (percentage >= 50) {
            performanceLabel.setText("Good effort! Keep learning about " + categoryName + "!");
            performanceLabel.setTextFill(Paint.valueOf("#FFA500")); // Orange
        } else {
            performanceLabel.setText("Keep practicing! You'll get better at " + categoryName + "!");
            performanceLabel.setTextFill(Paint.valueOf("#FF0000")); // Red
        }

        /**Animation*/
        // Add fade-in animation to performance text
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.5), performanceLabel);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setDelay(Duration.seconds(0.5));
        fadeIn.play();

        // Buttons for next actions with style
        Button tryAgainButton = new Button("Try Again");
        tryAgainButton.setFont(Font.font("Arial", 16));
        tryAgainButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 10 20 10 20;");

        Button newQuizButton = new Button("Choose New Quiz");
        newQuizButton.setFont(Font.font("Arial", 16));
        newQuizButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 10 20 10 20;");

        // Container for buttons
        HBox buttonsBox = new HBox(20, tryAgainButton, newQuizButton);
        buttonsBox.setAlignment(Pos.CENTER);

        // Add all components to the layout
        resultLayout.getChildren().addAll(
                titleLabel,
                quizDetailsLabel,
                playerNameLabel,
                scoreVisual,
                performanceLabel,
                buttonsBox
        );

        // Add layout to container
        mainContainer.getChildren().add(resultLayout);

        // Create scene
        Scene resultScene = new Scene(mainContainer, 800, 600);
        primaryStage.setScene(resultScene);
        primaryStage.setTitle("Quiz Results - " + playerName);

        // Button event handlers
        tryAgainButton.setOnAction(e -> {
            if(categoryName.equals("Logo")){
                List<QuestionImage>questionImages=quizManager.getImageQuestions(currentCategory,difficulty);
                showQuizImageScene(primaryStage, questionImages, currentCategory, difficulty, returnScene);
            }
            else {
                List<Question> questions = quizManager.getQuestions(currentCategory, difficulty);
                showQuizScene(primaryStage, questions, currentCategory, difficulty, returnScene);
            }
        });

        newQuizButton.setOnAction(e -> {
            primaryStage.setScene(returnScene);
            primaryStage.setTitle("GO!! Test your knowledge☺ " + playerName);
        });

        // Add some confetti effect animation for good scores
        if (percentage >= 70) {
            createConfettiEffect(mainContainer);
        }
    }

    private void createConfettiEffect(Pane container) {
        Random random = new Random();

        // Create 50 confetti particles
        for (int i = 0; i < 50; i++) {
            // Random confetti piece
            Rectangle confetti = new Rectangle(10, 10);

            // Random color
            Color color = Color.rgb(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)
            );
            confetti.setFill(color);
            confetti.setRotate(random.nextInt(360));

            // Random position at top
            confetti.setTranslateX(random.nextInt(800));
            confetti.setTranslateY(-random.nextInt(100));

            container.getChildren().add(confetti);

            // Create falling animation
            TranslateTransition fall = new TranslateTransition(
                    Duration.seconds(2 + random.nextDouble() * 3), confetti);
            fall.setToY(700);
            fall.setInterpolator(Interpolator.EASE_IN);

            // Rotation during fall
            RotateTransition rotate = new RotateTransition(
                    Duration.seconds(1 + random.nextDouble() * 2), confetti);
            rotate.setByAngle(360 * (random.nextInt(4) + 1));
            rotate.setCycleCount(Animation.INDEFINITE);

            // Play animations
            fall.play();
            rotate.play();
        }
    }
    public class AudioManager {
        private static MediaPlayer mediaPlayer;

        public static void startBackgroundMusic() {
            if (mediaPlayer == null) {
                Media media = new Media(AudioManager.class.getResource("/videos/background.mp3").toExternalForm());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.setVolume(0.5);
                mediaPlayer.play();
            }
        }

        public static void stopMusic() {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}