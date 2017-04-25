/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication.resultswriter;

import gameprocess.GameSession;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Администратор
 */
public class ResultsWriter {

    private GameSession gameSession;

    /**
     * Default constructor
     */
    public ResultsWriter() {

    }

    /**
     * Constructor with GameSession object as parameter.
     * @param gameSession GameSession object which results will be recorded.
     */
    public ResultsWriter(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    /**
     * Writes results to specified file.
     * @param pathToFile Path to file.
     */
    public void writeResultsToFile(String pathToFile) {
        try {
            StringBuffer result = new StringBuffer();
            result.append(gameSession.getHumanPlayer().getName());
            result.append("    ");
            result.append(gameSession.getScore());
            BufferedWriter resultOutput = new BufferedWriter(new FileWriter(pathToFile, true));
            resultOutput.newLine();
            resultOutput.append(result);
        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Writes results to default file.
     */
    public void writeResultsToDefaultFile() {
        try {
            StringBuffer result = new StringBuffer();
            result.append(gameSession.getHumanPlayer().getName());
            result.append("    ");
            result.append(gameSession.getScore());
            BufferedWriter resultOutput = new BufferedWriter(new FileWriter("records.txt", true));
            resultOutput.newLine();
            resultOutput.append(result);
        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Writes results to specified file. 
     * @param gameSession Game session which results are to be recorded.
     * @param pathToFile Path to file.
     */
    public static void writeResultsToFile(GameSession gameSession, String pathToFile) {
        try {
            StringBuffer result = new StringBuffer();
            result.append(gameSession.getHumanPlayer().getName());
            result.append("    ");
            result.append(gameSession.getScore());
            BufferedWriter resultOutput = new BufferedWriter(new FileWriter(pathToFile, true));
            resultOutput.newLine();
            resultOutput.append(result);
        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Writes results to default file.
     * @param gameSession Game session which results are to be recorded.
     */
    public static void writeResultsToDefaultFile(GameSession gameSession) {
        try {
            StringBuffer result = new StringBuffer();
            result.append(gameSession.getHumanPlayer().getName());
            result.append("    ");
            result.append(gameSession.getScore());
            BufferedWriter resultOutput = new BufferedWriter(new FileWriter("records.txt", true));
            resultOutput.newLine();
            resultOutput.append(result);
        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

