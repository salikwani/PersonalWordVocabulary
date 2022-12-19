package com.example.word_vocabulary;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        VocabularyPage page = new VocabularyPage();
        root.getChildren().add(page.root);
        Scene scene = new Scene(root, 425, 200);
        stage.setTitle("Personal Word Vocabulary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}