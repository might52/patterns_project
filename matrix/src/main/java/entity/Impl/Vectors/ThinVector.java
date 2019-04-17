package entity.Impl.Vectors;

import entity.Interfaces.IVector;

import java.util.HashMap;
import java.util.Map;

public class ThinVector implements IVector {

    private final Map<Integer, Double> someVector = new HashMap<Integer, Double>();

    public void setComponent(int component, double value) {
        this.someVector.put(component, value);
    }

    public double getComponent(int component) {
        if (this.someVector.keySet().contains(component)) {
            return this.someVector.get(component);
        }

        return 0;
    }

    public int getVectorSize() {
        return someVector.size();
    }


}
