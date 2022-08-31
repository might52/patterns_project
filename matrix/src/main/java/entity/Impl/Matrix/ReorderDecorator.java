package entity.Impl.Matrix;


import entity.Interfaces.IMatrix;
import entity.Interfaces.IMatrixFunction;
import entity.Interfaces.IPrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReorderDecorator implements IMatrix {
    private final IMatrix matrix;

    private String shakedRow = "shakedRow";
    private String shakedCol = "shakedCol";

    private IMatrixFunction iMatrixFunction;

    private boolean isRow = true;

    private void shuffleValues(){
        List<String> shaker = new ArrayList();
        shaker.add(shakedRow);
        shaker.add(shakedCol);
        Collections.shuffle(shaker);
    }

    public ReorderDecorator(IMatrix matrix) {
        this.matrix = matrix;
        shuffleValues();
        this.iMatrixFunction = new IMatrixFunction<IPrinter, IMatrix>() {
            public void doAction(IPrinter printer, IMatrix matrix) {
                printer.DrawBorder(matrix);
                for (int i = 0; i < getRowsAmount(); i++) {
                    for (int j = 0; j < getColumnsAmount(); j++) {
                        printer.DrawValue(matrix, i, j, getValue(i, j));
                    }
                    printer.DrawEmptyRow();
                }
            }
        };
    }

    public int getRowsAmount() {
        if (isRow) {
            return matrix.getColumnsAmount();
        }

        return matrix.getRowsAmount();
    }

    public int getColumnsAmount() {
        if (isRow) {
            return matrix.getRowsAmount();
        }

        return matrix.getColumnsAmount();
    }

    public Double getValue(int row, int col) {
        if (isRow){
            return matrix.getValue(col, row);
        }

        return matrix.getValue(row, col);

    }

    public void setValue(int row, int col, double value) {
        if (isRow){
            matrix.setValue(col, row, value);
        }

        matrix.setValue(row, col, value);
    }

    @Override
    public void print(IPrinter printer) {
        this.iMatrixFunction.doAction(printer, this);
    }
}
