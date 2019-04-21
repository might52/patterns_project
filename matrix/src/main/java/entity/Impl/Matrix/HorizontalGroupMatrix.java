package entity.Impl.Matrix;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IMatrixFunction;
import entity.Interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HorizontalGroupMatrix implements IMatrix {

    private final List<IMatrix> matrixes = new ArrayList<IMatrix>();

    private final IMatrixFunction iMatrixFunction = new IMatrixFunction<IPrinter, IMatrix>() {
        public void doAction(IPrinter printer, IMatrix matrix) {
            printer.DrawBorder(matrix);
            for (int i = 0; i < matrix.getRowsAmount(); i++) {
                for (int j = 0; j < matrix.getColumnsAmount(); j++) {
//                    if (matrix.getValue(i, j) == 0) {
//                        continue;
//                    }
                    printer.DrawBorderCell(matrix, i, j);
                    printer.DrawValue(matrix, i, j, matrix.getValue(i, j));
                }
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
            this.matrixes.addAll(matrixes);
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
//            System.out.println(String.format("\n colSumm: %s [row - %s, col - %s]", colSumm, row, col));
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
//            System.out.println(String.format("\n colSumm: %s [row - %s, col - %s]", colSumm, row, col));
            if (col <= colSumm - 1) {
                if (row > matrix.getRowsAmount() - 1) {
                    continue;
                }

                System.out.println(
                        String.format(
                                "\nset value colSumm: %s [row - %s, col - %s, val - %s]",
                                colSumm,
                                row,
                                colSumm - col - 1,
                                value
                        )
                );

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
