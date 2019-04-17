package entity.Impl.Matrix;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;

public class ComposedMatrix implements IMatrix {

    private final List<IMatrix> matrixes = new ArrayList<IMatrix>();

    /**
     * Group iInitialisator.
     */
    public ComposedMatrix() {
    }

    /**
     * Obtain collections for start group initialisation.
     * @param matrixes
     */
    public ComposedMatrix(List<IMatrix> matrixes) {
        this.matrixes.addAll(matrixes);
    }

    @Override
    public int getRowsAmount() {
        int result = 0;
        for (IMatrix matrix: this.matrixes) {
            result =
                    Math.max(result, matrix.getRowsAmount()) == result ?
                    result :
                    matrix.getRowsAmount();
        }

        return result;
    }

    @Override
    public int getColumnsAmount() {
        int result = 0;
        for (IMatrix matrix: this.matrixes) {
            result += matrix.getRowsAmount();
        }

        return result;
    }

    @Override
    public double getValue(int row, int col) {
        return 0;
    }

    @Override
    public void setValue(int row, int col, double value) {

    }

    @Override
    public void print(IPrinter printer) {

    }

}
