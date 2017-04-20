/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.util.Objects;

/**
 * Class desdcibing a single letter.
 * @author User
 */
public class Letter {
    /**
     * Value of the letter.
     */
    private Character value;

    /**
     * Default constructor.
     */
    public Letter() {
    }

    /**
     * Constructor with <Code>Character</Code> object as a parameter.
     * @param value <Code>Character</Code> equivalent of the letter.
     */
    public Letter(Character value) {
        this.value = value;
    }
    
    
    /**
     * Allows to receive value of the letter.
     * @return Character value of the letter.
     */
    public Character getValue() {
        return value;
    }

    /**
     * Allows to set a new value using <Code>Character</Code> object.
     * @param newValue New walue.
     */
    public void setValue(Character newValue) {
        this.value = newValue;
    }
    
    /**
     * Allows to set new value using <Code>Letter</Code> object.
     * @param newValue New value.
     */
    public void setValue(Letter newValue) {
        this.value = newValue.getValue();
    }
    
    /**
     * Allows to receive string representation of the letter.
     * @return String representation of the letter.
     */
    @Override
    public String toString() {
        return this.value.toString();
    }

    

    /**
     * Allows to receive letter's unique hascode.
     * <b>NOT IMPLEMENTED YET</b>
     * @return Letter's hashcode.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Allows to know wheter this letter equals to another object
     * @param obj Object which is to be compared with this letter.
     * @return <Code>True</Code> if this letter equals to another object,
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
        final Letter other = (Letter) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
