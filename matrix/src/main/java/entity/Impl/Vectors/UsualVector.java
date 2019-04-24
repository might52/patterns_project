package entity.Impl.Vectors;

import entity.Interfaces.IVector;

import java.util.*;

public class UsualVector implements IVector {

    private final List<Double> someVector = new ArrayList<Double>();

    public void setComponent(int component, double value) {
        this.someVector.add(component, value);
        if (this.someVector.size() -1  > component) {
            this.someVector.remove(component + 1);
        }
    }

    public Double getComponent(int component) {
        return this.someVector.get(component);
    }

    public int getVectorSize() {
        return someVector.size();
    }

}
