/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication.resultswriter;

import gameprocess.GameSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Администратор
 */
public class ResultsWriter {

    private GameSession gameSession;

    public ResultsWriter() {

    }

    public ResultsWriter(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public void writeResultsToFile(String pathToFile) {

        try {
            FileWriter resultsWriter = new FileWriter(new File(pathToFile));
            resultsWriter.write(gameSession.getHumanPlayer().getName() + "    " + gameSession.getScore() + "\n");
            resultsWriter.flush();
            resultsWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeResultsToDefaultFile() {
        try {
            FileWriter resultsWriter = new FileWriter(new File("records.txt"));
            resultsWriter.write(gameSession.getHumanPlayer().getName() + "    " + gameSession.getScore() + "\n");
            resultsWriter.flush();
            resultsWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeResultsToFile(GameSession gameSession, String pathToFile) {
        try {
            FileWriter resultsWriter = new FileWriter(new File(pathToFile));
            resultsWriter.write(gameSession.getHumanPlayer().getName() + "    " + gameSession.getScore() + "\n");
            resultsWriter.flush();
            resultsWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeResultsToDefaultFile(GameSession gameSession) {
        try {
            FileWriter resultsWriter = new FileWriter(new File("records.txt"));
            resultsWriter.write(gameSession.getHumanPlayer().getName() + "    " + gameSession.getScore() + "\n");
            resultsWriter.flush();
            resultsWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(ResultsWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
