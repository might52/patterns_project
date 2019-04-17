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
        isRow = true;
//        isRow = shaker.get(0).equals(shakedRow);
        System.out.println(isRow);
    }

    public ReorderDecorator(IMatrix matrix) {
        this.matrix = matrix;
        shuffleValues();
        this.iMatrixFunction = new IMatrixFunction<IPrinter, IMatrix>() {
            public void doAction(IPrinter printer, IMatrix matrix) {
                printer.DrawBorder(matrix);
                for (int i = 0; i < matrix.getRowsAmount(); i++) {
                    for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                        if (matrix.getValue(i, j) == 0) {
                            continue;
                        }

                        printer.DrawBorderCell(matrix, i, j);
                        printer.DrawValue(matrix, i, j, matrix.getValue(i, j));
                    }
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

    public double getValue(int row, int col) {
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
