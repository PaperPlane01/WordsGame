/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import gameobjects.Word;
import gameobjects.Vocabulary;
import java.util.ArrayList;

/**
 * Class representing computer player.
 * @author User
 */
public class ComputerPlayer extends Player {

    /**
     * Word given to computer.
     */
    private Word givenWord;
    /**
     * Word which is one-letter-different from given.
     */
    private Word resultWord;
    /**
     * Contains words which have benn used by human player and computer player.
     */
    private ArrayList<Word> usedWords;
    /**
     * Vocabulary of computer player.
     */
    private Vocabulary vocabulary;
    /**
     * Returned result.
     */
    private String result;
    /**
     * Indicates if computer is able to find one-letter-different word. 
     */
    private boolean isAbleToFindOneLetterDifferentWord;

    /**
     * Default constructor.
     */
    public ComputerPlayer() {
        this.usedWords = (ArrayList<Word>) new ArrayList();
    }

    /**
     * Allows computer to make the first turn.
     * @return Random word from the vocabulary.
     */
    public String makeFirstTurn() {
        return new String(vocabulary.getRandomWord().toString());
    }

    /**
     * Allows to give a word to the computer.
     * @param word Given word.
     */
    public void giveWord(Word word) {
        this.givenWord = word;
    }
    
    /**
     * This method sets the result of processing of the given word.
     */
    @Override
    public void getResult() {

        if (usedWords.contains(givenWord)) {
            this.result = new String("This word has already been used." + 
                    "Please try another one.");
            return;
        }
        
        if (givenWord.getSize() != 5) {
            this.result = new String("The word should contain 5 letters.");
            return;
        }
        
        if (!vocabulary.contains(givenWord)) {
            this.result = new String("I don't have such word in my vocabulary. \n"
                    + "Please try another one.");
            System.out.println(givenWord);
            return;
        }
        
        if ((usedWords.size() != 0) && (!Word.areOneLetterDifferent(givenWord, resultWord))) {
            this.result = new String("This word is not one-letter-different from " +
                    resultWord.toString());
            return;
        }
        
        usedWords.add(givenWord);
        
        for (int i = 0; i < vocabulary.getSize(); i++) {
            Word comparedWord = vocabulary.getWordAt(i);
            this.isAbleToFindOneLetterDifferentWord = false;

            if ((Word.areOneLetterDifferent(givenWord, comparedWord)) &&
                    !usedWords.contains(comparedWord)) {
                this.usedWords.add(comparedWord);
                this.resultWord = comparedWord;
                this.result = new String(comparedWord.toString());
                this.isAbleToFindOneLetterDifferentWord = true;
                break;
            }

            this.result = new String("I couldn't find one-letter-different word :(");

        }
    }

    /**
     * This method allows computer to make the next turn
     * @return Result of the turn. 
     */
    @Override
    public String makeNextTurn() {
        getResult();
        return this.result;
    }
    
    /**
     * Indicates if computer is able to find one-letter-different word.
     * @return <Code>True</Code> if computer is able to find one-letter-different word,
     * <Code>False</Code> if not.
     */
    public boolean isAbleToFindOneLetterDifferentWord() {
        return this.isAbleToFindOneLetterDifferentWord;
    }
    
    /**
     * Allows to set a new vocabulary.
     * @param vocabulary New vocabulary which is to be set.
     */
    public void setVocabulary(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    } 

    
}

