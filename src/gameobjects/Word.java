/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class representing a word.
 * @author User
 */
public class Word implements Cloneable {
    /**
     * Collection of word's letters.
     */
    private ArrayList<Letter> letters;
    /**
     * Number of letters contained in the word.
     */
    private int size;

    /**
     * Default constructor.
     */
    public Word() {
        this.letters = new ArrayList();
        this.size = 0;
    }

    /**
     * Constructor with collection of <Code>Letter</Code> object as parameter.
     * @param letters Constructor with collection of <Code>Letter</Code> object.
     */
    public Word(ArrayList<Letter> letters) {
        this.letters = letters;
        this.size = letters.size();
    }
    
    /**
     * Constructor with string representation of the word as parameter.
     * @param word String representation of the word.
     */
    public Word(String word) {
        this.letters = new ArrayList();
        for (int i = 0; i < word.length(); i++) {
            Character letterAsChar = new Character(word.charAt(i));
            Letter letter = new Letter(letterAsChar);
            this.letters.add(letter);
        }
        this.size = word.length();
    }

    /**
     * Allows co clone existing <Code>Word</Code> object.
     * @return A copy of this object.
     * @throws CloneNotSupportedException 
     */
    @Override
    public Word clone() throws CloneNotSupportedException {
        return new Word(this.letters);
    }
    
    

    /**
     * Allows to receive all letters contained in the word.
     * @return Collection of letters contained in the word.
     */
    public ArrayList<Letter> getLetters() {
        return letters;
    }

    /**
     * Allows to set new collection of letters. 
     * @param newLetters New collection of letters. 
     */
    public void setLetters(ArrayList<Letter> newLetters) {
        this.letters = newLetters;
    }

    /**
     * Allows to know the size of the word.
     * @return Size of the word.
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Allows to receive a letter with a specific index. 
     * <b>NOTE:</b> indexes numeration begins from 0.
     * @param index Index of the letter.
     * @return Letter with a specific index.
     */
    public Letter getLetterAt(int index) {
        return letters.get(index);
    }
    
    /**
     * Allows to set a new letter at the specific index. Takes <Code>Letter</Code>
     * object as parameter.
     * @param index Index of the letter which is to be edited.
     * @param newLetter New value which is to be set.
     */
    public void setLetterAt(int index, Letter newLetter) {
       this.getLetterAt(index).setValue(newLetter.getValue()); 
    }
    
    /**
     * Allows to set a new letter at the specific index. Takes <Code>Character</Code>
     * object as parameter.
     * @param index Index of the letter which is to be edited.
     * @param newLetterValue New value which is to be set.
     */
    public void setLetterAt(int index, Character newLetterValue) {
        this.getLetterAt(index).setValue(newLetterValue);
    }
    
    /**
     * Allows to know whether these to words are one-letter-different or not.
     * @param firstWord First word.
     * @param secondWord Second word.
     * @return <Code>True</Code> if these to words are one-letter-different,
     * <Code>False</Code> if not.
     */
    public static boolean areOneLetterDifferent(Word firstWord, Word secondWord) {
        int difference = 0;
        int count = 0;
        
        while (count != firstWord.getSize()) {
            if (firstWord.getLetterAt(count).equals(secondWord.getLetterAt(count))) {
                count++;
            }
            else {
                difference++;
                count++;
            }
            if (difference == 2) {
                break;
            }
        }
        
        if (difference == 1) {
            return true;
        }
        else {
            return false;
        }
        
        
        
    }
    
    
    /**
     * Allows to receive string representation of the <Code>Word</Code> object.
     * @return String representation of the <Code>Word</Code> object.
     */
    @Override
    public String toString() {
        String result = "";
        
        for (int i = 0; i < size; i++) {
            result = result + this.getLetterAt(i).toString();
        }
        
        return result;
    }
    
    /**
     * Allows to know whether this word equals to other word.
     * <b>NOTE:</b> this method will soon be replaced by <Code>equals(Object obj)</Code>
     * method.
     * @param other 
     * @return <Code>True</Code> if this word equals to other word, <Code>False</Code>
     * if not.
     */
    public boolean equalsTo(Word other) {
        boolean result = true;
        for (int i = 0; i < this.size; i++) {
            if (!this.getLetterAt(i).equals(other.getLetterAt(i))) {
                result = false;
            }
        }
        
        return result;
    }

   
    /**
     * Allows to receive a unique hascode.
     * <b>NOTE:</b> not fully implemented yet.
     * @return Unique hashcode.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Allows to know whether this <Code>Word</Code> object equals to other object.
     * @param obj Object which is to be compared with this <Code>Word</Code> object.
     * @return <Code>True</Code> if his <Code>Word</Code> object equals to other object,
     * <Code>False</Code> if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (this.size != other.size) {
            return false;
        }
        if (!Objects.equals(this.letters, other.letters)) {
            return false;
        }
        return true;
    }
 
}
