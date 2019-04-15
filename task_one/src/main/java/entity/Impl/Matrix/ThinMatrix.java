package entity.Impl.Matrix;

import entity.Impl.Printers.ConsolePrinter;
import entity.Impl.Vectors.ThinVector;
import entity.Interfaces.IPrinter;

public class ThinMatrix extends AMatrix {

    public ThinMatrix(int rows, int columns) {
        super(new ThinVector(), rows, columns);
    }

    public void print(IPrinter printer) {
        printer.DrawBorder(this);

        for (int i = 0; i < getRowsAmount(); i++) {
            for (int j = 0; j < getColumnsAmount(); j++) {
                if (getValue(i, j) == 0) {
                    continue;
                }

                printer.DrawBorderCell(this, i, j);
                printer.DrawValue(this, i, j, getValue(i, j));
            }
        }

    }

}
