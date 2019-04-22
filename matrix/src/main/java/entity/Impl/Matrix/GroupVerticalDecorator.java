package entity.Impl.Matrix;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IMatrixFunction;
import entity.Interfaces.IPrinter;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GroupVerticalDecorator implements IMatrix {
    private final IMatrix matrix;

    private IMatrixFunction iMatrixFunction;

    private List<IMatrix> matrices = new ArrayList<>();

    private boolean isRow = true;

    public GroupVerticalDecorator(IMatrix matrix) {
        this.matrix = matrix;
        if (matrix instanceof HorizontalGroupMatrix) {
            this.matrices = ((HorizontalGroupMatrix) matrix).getMatrixes();
        }

        this.iMatrixFunction = new IMatrixFunction<IPrinter, IMatrix>() {
            public void doAction(IPrinter printer, IMatrix matrix) {
                printer.DrawBorder(matrix);
                for (int i = 0; i < matrix.getRowsAmount(); i++) {
                    for (int j = 0; j < matrix.getColumnsAmount(); j++) {
//                        if (matrix.getValue(i, j) == 0) {
//                            continue;
//                        }

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
        if (Collections.EMPTY_LIST == this.matrices){
            this.iMatrixFunction.doAction(printer, this);
        } else {
            for (IMatrix matrix : this.matrices) {
                this.iMatrixFunction.doAction(printer, matrix);
            }
        }
    }
}
