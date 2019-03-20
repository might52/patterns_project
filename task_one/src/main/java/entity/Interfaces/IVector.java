package entity.Interfaces;

public interface IVector {
    void setComponent(int component, double value);
    double getComponent(int component);
    int getVectorSize();
}
