package entity.Impl.Matrix;

import entity.Impl.Vectors.UsualVector;
import entity.Interfaces.IPrinter;

public class UsualMatrix extends AMatrix {

    public UsualMatrix(int rows, int columns) {
        super(new UsualVector(), rows, columns);
    }

    public void print(IPrinter printer, boolean showBorder){
        if (showBorder){
            printer.DrawBorder(this);
        }

        for (int i = 0; i < getRowsAmount(); i++) {
            for (int j = 0; j < getColumnsAmount(); j++) {
                printer.DrawBorderCell(this, i, j);
                printer.DrawValue(this, i, j, getValue(i, j));
            }
        }

        System.out.println();
    }
}
