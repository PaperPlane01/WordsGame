/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameprocess;

import vocabularyreader.VocabularyReader;
import gameobjects.Vocabulary;
import gameobjects.Word;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainapplication.resultswriter.ResultsWriter;

/**
 *
 * @author Администратор
 */
public class GameSession {

    /**
     * Player which is to make the next turn.
     */
    private Player currentPlayer;
    /**
     * Computer player.
     */
    private ComputerPlayer computerPlayer;
    /**
     * Human player.
     */
    private HumanPlayer humanPlayer;
    /**
     * The result of player's turn.
     */
    private String turnResult;
    private ArrayList<Word> usedWords;
    /**
     * The score of human player.
     */
    private int humanScore;
    private int turnsCounter;
    private int finalNumberOfTurns;
    private boolean isHumanReachedVictory;

    /**
     * Default constructor.
     */
    public GameSession() {
    }

    /**
     * Constructor with human player's name as a parameter. Sets up a new
     * computer player, an empty array in which used words will be added and
     * turns counter.
     *
     * @param playerName The name of human player.
     */
    public GameSession(String playerName) {
        this.computerPlayer = new ComputerPlayer();
        this.humanPlayer = new HumanPlayer(playerName);
        this.usedWords = (ArrayList<Word>) new ArrayList();
        this.isHumanReachedVictory = false;
    }

    /**
     * Constructor with created <Code>HumanPlayer</Code> object as a parameter.
     * Sets up a new computer player, an empty array in which used words will be
     * added, and turns counter.
     *
     * @param human Created <Code>HumanPlayer</Code> object.
     */
    public GameSession(HumanPlayer humanPlayer) {
        this.computerPlayer = new ComputerPlayer();
        this.humanPlayer = humanPlayer;
        this.usedWords = (ArrayList<Word>) new ArrayList();
    }
    
    public void setFinalNumberOfTurns(int newFinalNumberOfTurns) {
        this.finalNumberOfTurns = newFinalNumberOfTurns;
    }

    /**
     * This method allows computer to make the first turn.
     */
    public void firstComputerTurn() {
        this.turnResult = computerPlayer.makeFirstTurn();
        this.currentPlayer = humanPlayer;
        Word usedWord = new Word(turnResult);
        this.usedWords.add(usedWord);
        this.finalNumberOfTurns = 10;
    }

    /**
     * This method allows human to make a turn.
     * @param word Word entered by human.
     */
    public void nextHumanTurn(Word word) {
        
        if (turnsCounter == finalNumberOfTurns) {
            this.isHumanReachedVictory = true;
        }

        usedWords.add(word);
        humanPlayer.setNextWord(word);
        computerPlayer.giveWord(new Word(humanPlayer.makeNextTurn()));
        currentPlayer = computerPlayer;
        turnsCounter += 1;
        nextComputerTurn();

        if (computerPlayer.isAbleToFindOneLetterDifferentWord()) {
            this.humanScore += 100;
        }
    }

    /**
     * This method allows computer to make a turn.
     */
    public void nextComputerTurn() {

        this.turnResult = computerPlayer.makeNextTurn();
        if (computerPlayer.isAbleToFindOneLetterDifferentWord()) {
            this.usedWords.add(new Word(turnResult));
        }
        currentPlayer = humanPlayer;

    }

    /**
     * This method allows to know which player is to make a turn.
     * @return Current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * This method allows to know the ID of player which is to make a turn.
     * @return <Code>1</Code> if current player is computer, <Code>2</Code> if
     * current player is human.
     */
    public int getCurrentPlayerID() {
        if (currentPlayer == computerPlayer) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * This methid allows to set a new dictionary.
     * @param dictionary New dictionary which is to be set.
     */
    public void setComputerVocabulary(Vocabulary dictionary) {
        computerPlayer.setVocabulary(dictionary);
    }

    /**
     * Allows to set current player by its ID.
     * @param playerID <Cpde>1</Code>: computer, <Code>2</Code>: human.
     */
    public void setCurrentPlayer(int playerID) {
        switch (playerID) {
            case 1:
                currentPlayer = computerPlayer;
                break;
            case 2:
                currentPlayer = humanPlayer;
                break;
            default:
                break;
        }

    }

    /**
     * Allows to receive the latest turn's result.
     * @return Latest turn's result.
     */
    public String getTurnResult() {
        return turnResult;
    }

    /**
     * Allows to receive human player's score.
     * @return Human player's score.
     */
    public int getScore() {
        return this.humanScore;
    }
   

    /**
     * Allows to set new name to the human player. 
     * @param newName New name which is to be set.
     */
    public void setPlayerName(String newName) {
        humanPlayer.setName(newName);
    }

    /**
     * Allows to receive game session's computer player (e. g. to get access to
     * its methods)
     * @return Game session's computer player
     */
    public ComputerPlayer getComputerPlayer() {
        return computerPlayer;
    }

    /**
     * Allows to receive game session's human player (e. g. to get access to
     * its methods)
     * @return Game session's human player
     */
    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }
    
    public void saveResults() {
        ResultsWriter.writeResultsToDefaultFile(this);
    }
    
    public boolean isHumanReachedVictory() {
        return this.isHumanReachedVictory;
    }

}
