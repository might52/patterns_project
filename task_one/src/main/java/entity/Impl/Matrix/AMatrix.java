package entity.Impl.Matrix;

import entity.Interfaces.IPrinter;
import entity.Interfaces.IMatrix;
import entity.Interfaces.IVector;

import java.util.Enumeration;
// import java.util.function.Supplier;

public abstract class AMatrix implements IMatrix {

    private int rows;
    private int columns;

    private final IVector vector;

    public Enumeration<IMatrix> matrixEnumeration (IMatrix matrix){
        return null;
    }

    protected AMatrix(IVector vector, int rows, int columns) {
        this.vector = vector;
        this.rows = rows;
        this.columns = columns;
    }

    public int getRowsAmount() {
        return this.rows;
    }

    public int getColumnsAmount() {
        return this.columns;
    }

    public double getValue(int row, int col) {
        return vector.getComponent(row * this.getColumnsAmount() + col);
    }

    public void setValue(int row, int col, double value){
        vector.setComponent(row * this.getColumnsAmount() + col, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("AMatrix{rows= %s, columns=%s, vector=%s\n", rows, columns, vector));
        for (int i = 0; i < this.getRowsAmount(); i++) {
            for (int j = 0; j < this.getColumnsAmount(); j++) {
                sb.append(String.format("Row=%s, Column=%s, Value=%s\n", i, j, this.getValue(i ,j)));
            }
        }

        return sb.toString();
    }

    public abstract void print(IPrinter printer);
}
