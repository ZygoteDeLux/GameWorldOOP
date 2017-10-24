package LemGame;

import java.util.*;

public class Prop {

    private String propName;
    private int propValue;
    private String propDescription;

    Prop(String propName, int propValue) {
        this.propName = propName;
        this.propValue = propValue;
    }

    public String getPropName() {
        return propName;
    }

    //ÆNDRET
    public String getPropDescription() {
        return propDescription;
    }

    public void setPropDescription(String popDesripction) {
        this.propDescription = popDesripction;
    }

   
//    Hvad skal den her metode bruges til? TO DO
//    public int getValue() {
//        return propValue;
//    }

    @Override
    public String toString() {
        return "Prop{" + "propName=" + propName + ", propValue=" + propValue + '}';
    }
}
