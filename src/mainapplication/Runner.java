/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import gameobjects.Word;
import gameprocess.GameSession;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Администратор
 */
public class Runner extends JApplet {

    public static GameSession currentSession;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        currentSession = new GameSession("Default");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartingForm().setVisible(true);
            }
        });
    }
}
