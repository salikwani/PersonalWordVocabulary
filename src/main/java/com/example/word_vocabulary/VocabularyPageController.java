package com.example.word_vocabulary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class VocabularyPageController {
    private VocabularySaver database;
    @FXML
    TextField search;
    @FXML
    TextField word;
    @FXML
    TextField meaning;
    @FXML
    public void searchButton(MouseEvent event) throws IOException, ClassNotFoundException {
        try{
            database = new VocabularySaver();
            database.deserializeHashMap();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(search.getText().toLowerCase());

            if(search.getText().equals("")){
                alert.setContentText("Please Enter a Word to Search");
                alert.showAndWait();
            }
            else if(database.getVocabularyList().containsKey(search.getText().toLowerCase())){
                alert.setContentText(database.getVocabularyList().get(search.getText().toLowerCase()));
                alert.showAndWait();
            }
            else {
                alert.setContentText("The Word is not Present in Your 'Personal Word Vocabulary'");
                alert.showAndWait();
            }
        }
        catch(IOException ex){
            database.serializeHashMap();
        }
    }
    @FXML
    public void add(MouseEvent event) throws IOException, ClassNotFoundException {
        database = new VocabularySaver();
        database.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(word.getText().equals("") || meaning.getText().equals("")){
            alert.setHeaderText("");
            alert.setContentText("Please Enter Word/Meaning to Add Word to Your Personal Word Vocabulary");
            alert.showAndWait();
        }
        else if(database.getVocabularyList().containsKey(word.getText().toLowerCase())){
            if(meaning.getText().toLowerCase().equals(database.getVocabularyList().get(word.getText().toLowerCase()))){
                alert.setHeaderText("");
                alert.setContentText("Word Already Exists in Your Personal Word Vocabulary");
                alert.showAndWait();
            }
            else{
                database.getVocabularyList().put(word.getText().toLowerCase(),meaning.getText().toLowerCase());
                database.serializeHashMap();

                alert.setHeaderText("Meaning Updated");
                alert.setContentText("Meaning of the Word Has Been Updated in Your Personal Word Vocabulary");
                alert.showAndWait();
            }
        }
        else {
            database.getVocabularyList().put(word.getText().toLowerCase(),meaning.getText().toLowerCase());
            database.serializeHashMap();

            alert.setHeaderText("New Word Added");
            alert.setContentText("New Word has been Added to Your 'Personal Word Vocabulary'");
            alert.showAndWait();
        }
    }
    @FXML
    public void size(MouseEvent event) throws IOException, ClassNotFoundException {
        database = new VocabularySaver();
        database.deserializeHashMap();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        String a = String.valueOf("There are "+database.getVocabularyList().size()+" Words in Your Personal Vocabulary");
        alert.setContentText(a);
        alert.showAndWait();
    }
}
