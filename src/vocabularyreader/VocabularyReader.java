/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocabularyreader;

import gameobjects.Vocabulary;
import gameobjects.Word;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Администратор
 */
public class VocabularyReader {
    
    /**
     * This method allows to generate a dictionary from file.
     * @param path Path to the file.
     * @return Generated dictionary.
     * @throws IOException 
     */
    public static Vocabulary generateVocabularyFromFile(String path) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        ArrayList<Word> words = new ArrayList();
        List<String> lines = new ArrayList();

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        
        
        for (int i = 0; i < lines.size(); i++) {
            Word word = new Word(lines.get(i));
            words.add(word);
        }
        
        Vocabulary dictionary = new Vocabulary(words);
        return dictionary;
    }
    
}
