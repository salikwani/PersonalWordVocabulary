module com.example.word_dictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.word_vocabulary to javafx.fxml;
    exports com.example.word_vocabulary;
}