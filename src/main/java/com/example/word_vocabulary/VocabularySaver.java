package com.example.word_vocabulary;

import java.io.*;
import java.util.HashMap;

public class VocabularySaver {
    private HashMap<String,String> vocabularyList;
    HashMap<String,String> getVocabularyList(){
        return vocabularyList;
    }
    VocabularySaver(){
         vocabularyList = new HashMap<>();
    }
    void serializeHashMap() throws IOException {
        FileOutputStream fos = new FileOutputStream("VocabularyData");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(vocabularyList);
        oos.close();
        fos.close();
    }
    void deserializeHashMap() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("VocabularyData");
        ObjectInputStream ois = new ObjectInputStream(fis);
        vocabularyList = (HashMap<String,String>) ois.readObject();
    }
}
