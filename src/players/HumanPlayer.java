/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import gameobjects.Word;

/**
 *
 * @author User
 */
public class HumanPlayer extends Player {

    private String name;
    private Word nextWord;
    private String result;

    public HumanPlayer() {
    }

    public HumanPlayer(String name) {
        this.name = name;
    }

    public void setNextWord(Word word) {
        this.nextWord = word;
    }

    @Override
    public String makeNextTurn() {
        getResult();
        return this.result;
    }

    @Override
    public void getResult() {
        this.result = new String(nextWord.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

}
