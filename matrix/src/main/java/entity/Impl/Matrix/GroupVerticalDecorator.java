package entity.Impl.Matrix;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IMatrixFunction;
import entity.Interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;


public class GroupVerticalDecorator implements IMatrix {
    private final IMatrix matrix;

    private IMatrixFunction iMatrixFunction;

    private List<IMatrix> matrixes = new ArrayList<>();

    private boolean isRow = true;

    public GroupVerticalDecorator(IMatrix matrix) {
        this.matrix = matrix;
        if (matrix instanceof HorizontalGroupMatrix) {
            this.matrixes = ((HorizontalGroupMatrix) matrix).getMatrixes();
        }

        this.iMatrixFunction = new IMatrixFunction<IPrinter, IMatrix>() {
            public void doAction(IPrinter printer, IMatrix matrix) {
                printer.DrawBorder(matrix);
                for (IMatrix matr : matrixes) {
                    matr.print(printer);
                }
            }
        };
    }

    public int getRowsAmount() {
        return matrix.getColumnsAmount();
    }

    public int getColumnsAmount() {
        return matrix.getRowsAmount();
    }

    public Double getValue(int row, int col) {
        return matrix.getValue(col, row);
    }

    public void setValue(int row, int col, double value) {
        matrix.setValue(col, row, value);
    }

    @Override
    public void print(IPrinter printer) {
        this.iMatrixFunction.doAction(printer, this);
//        matrix.print(printer);
    }
}
