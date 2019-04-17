package entity.Impl.Matrix;

import entity.Impl.Vectors.ThinVector;
import entity.Interfaces.IMatrix;
import entity.Interfaces.IMatrixFunction;
import entity.Interfaces.IPrinter;

public class ThinMatrix extends AMatrix {

    public ThinMatrix(int rows, int columns) {
        super(new ThinVector(), rows, columns);

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

}