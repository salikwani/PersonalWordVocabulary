package com.example.word_vocabulary;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class VocabularyPage {
    public AnchorPane root;
    VocabularyPage() throws IOException{
        root = FXMLLoader.load(getClass().getResource("VocabularyPage.fxml"));
    }
}
