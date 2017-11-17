package LemGame;

import java.util.*;

public class Prop {
 //instance variables that defines a prop.
    private String propName;
    private int propValue;
    private String propDescription;
    private boolean consumable;

    Prop(String propName, int propValue) { //Constructor that sets a start value for propName and propValue.
        this.propName = propName; // give propName a start value
        this.propValue = propValue; //give propValue a variable a start value
        this.consumable = false;
    }
    
    Prop(String propName, int propValue, boolean consumable) { //Constructor that sets a start value for propName, propValue and consumable.
        this.propName = propName; // give propName a start value
        this.propValue= propValue; //give propValue a variable a start value
    }

    public boolean isConsumable() {
        return consumable;
    }

    public String getPropName() { //return propName
        return propName;
    }

    public String getPropDescription() { //return propDescriptuin
        return propDescription;
    }

    public void setPropDescription(String popDesripction) { //set a new propDescritpion. 
        this.propDescription = popDesripction;
    }

    
    // 
  
}
