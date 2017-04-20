/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class representing dictionary.
 * 
 */
public class Vocabulary {
    /**
     * Collection of words contained in dictionary.
     */
    private ArrayList<Word> words;
    /**
     * Number of words in dictionary.
     */
    private int size;

    
    /**
     * Default construtcor.
     */
    public Vocabulary() {
        this.words = new ArrayList();
    }

    /**
     * Constructor which creates a dictionary from collection of words.
     * @param words Colletction of words which is to be converted to dictionary.
     */
    public Vocabulary(ArrayList<Word> words) {
        this.words = words;
        this.size = words.size();
    }
    
    /**
     * Constructor which creates a dictionary from array of words.
     * @param words Array of words which is to be converted to dictionary.
     */
    public Vocabulary(Word[] words) {
        this.words = new ArrayList();
        
        for (int i = 0; i <= words.length; i++) {
            this.words.add(words[i]);
        }
        
        this.size = words.length;
    }
    
    
    public boolean contains(Word word) {
        boolean result = false;
        if (this.words.contains(word)) {
            System.out.println(word);
            result = true;
        }
        
        return result;
    }
    
    /**
     * Allows to add word to the dictionary.
     * @param word Word which is to be added to the dictionary.
     */
    public void addWord(Word word) {
        this.words.add(word);
        this.size = words.size();
    }

    /**
     * Allows to receive all words contained in dictionary.
     * @return All words contained in dictionary.
     */
    public ArrayList<Word> getWords() {
        return words;
    }
   

    /**
     * Allows to set a new collection of words of the dictionary.
     * @param words New collection of words which is to be set.
     */
    public void setWords(ArrayList<Word> words) {
        this.words = words;
        this.size = words.size();
    }
    
    /**
     * Allows to receive a word with a specific index. 
     * @param index Index of the word.
     * @return Word with a specific index. 
     */
    public Word getWordAt(int index) {
        return this.words.get(index);
    }
    
    /**
     * Allows to receive word with a random index. 
     * @return Word with a random index. 
     */
    public Word getRandomWord() {
        Random r = new Random(System.currentTimeMillis());
        int wordIndex = r.nextInt(size - 1);
        
        return getWordAt(wordIndex);
    }
    
    
    /**
     * Allows to know how many words are in the dictionary.
     * @return Number of words contained in the dictionary.
     */
    public int getSize() {
        return size;
    }
    
    
    
}
