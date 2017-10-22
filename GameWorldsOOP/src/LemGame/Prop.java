package LemGame;

import java.util.*;

public class Prop {

    private String propName;
    private int propValue;

    Prop(String propName, int propValue) {
        this.propName = propName;
        this.propValue = propValue;
    }

    @Override
    public String toString() {
        return "Prop{" + "propName=" + propName + ", propValue=" + propValue + '}';

    }
//    Hvad skal den her metode bruges til? TO DO
//    public int getValue() {
//        return propValue;
//    }
}
