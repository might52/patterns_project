package entity.Impl.Matrix;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IMatrixFunction;
import entity.Interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HorizontalGroupMatrix implements IMatrix {

    private final List<IMatrix> matrixes = new ArrayList<IMatrix>();

    public List<IMatrix> getMatrixes() {
        return matrixes;
    }

    public final IMatrixFunction iMatrixFunction = new IMatrixFunction<IPrinter, IMatrix>() {
        public void doAction(IPrinter printer, IMatrix matrix) {
            printer.DrawBorder(matrix);
            for (int i = 0; i < matrix.getRowsAmount(); i++) {
                for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                    if (matrix.getValue(i, j) == 0) {
                        continue;
                    }
                    printer.DrawValue(matrix, i, j, matrix.getValue(i, j));
                }
                printer.DrawEmptyRow();
            }
        }
    };

    /**
     * Group iInitialisator.
     */
    public HorizontalGroupMatrix() {
    }

    /**
     * Obtain collections for start group initialisation.
     * @param matrixes
     */
    public HorizontalGroupMatrix(List<IMatrix> matrixes) {
        if (matrixes != null) {
            for (IMatrix matrix : matrixes) {
                this.matrixes.add(matrix);
            }
        }
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
            result += matrix.getColumnsAmount();
        }

        return result;
    }

    @Override
    public double getValue(int row, int col) {
        int colSumm = 0;
        for (IMatrix matrix : this.matrixes){
            colSumm += matrix.getColumnsAmount();
            if (col <= colSumm - 1) {
                if (row > matrix.getRowsAmount() - 1) {
                    return 0;
                }

                return matrix.getValue(row, colSumm - col - 1);
            }
        }

        return -100;
    }

    @Override
    public void setValue(int row, int col, double value) {
        int colSumm = 0;
        for (IMatrix matrix : this.matrixes){
            colSumm += matrix.getColumnsAmount();
            if (col <= colSumm - 1) {
                if (row > matrix.getRowsAmount() - 1) {
                    continue;
                }

                matrix.setValue(row, colSumm - col - 1, value);
                break;
            }
        }
    }

    public void addMatrix(IMatrix matrix) {
        if (!Objects.isNull(matrix)) {
            this.matrixes.add(matrix);
        }
    }

    @Override
    public void print(IPrinter printer) {
        this.iMatrixFunction.doAction(printer, this);
    }

}
