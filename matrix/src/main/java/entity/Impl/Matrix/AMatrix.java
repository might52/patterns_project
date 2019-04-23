package entity.Impl.Matrix;

import entity.Interfaces.*;

public abstract class AMatrix implements IMatrix {

    private int rows;
    private int columns;

    private final IVector vector;

    protected Boolean isPrintEmpty = true;

    protected IMatrixFunction<IPrinter, IMatrix> iMatrixFunction;

    protected AMatrix(IVector vector, int rows, int columns) {
        this.vector = vector;
        this.rows = rows;
        this.columns = columns;

        iMatrixFunction = new IMatrixFunction<IPrinter, IMatrix>() {
            public void doAction(IPrinter printer, IMatrix matrix) {
                printer.DrawBorder(matrix);
                for (int i = 0; i < getRowsAmount(); i++) {
                    for (int j = 0; j < getColumnsAmount(); j++) {
                        if (getValue(i, j) == 0 && !isPrintEmpty) {
                            continue;
                        }
                        printer.DrawValue(matrix, i, j, getValue(i, j));
                    }
                    printer.DrawEmptyRow();
                }
            }
        };
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

    public void print(IPrinter printer){
        iMatrixFunction.doAction(printer, this);
    }

}