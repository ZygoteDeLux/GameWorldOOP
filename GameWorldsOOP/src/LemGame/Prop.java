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

    
    // 
    @Override
    public String toString() {
        return "Prop{" + "propName=" + propName + ", propValue=" + propValue + '}';
    }
}
