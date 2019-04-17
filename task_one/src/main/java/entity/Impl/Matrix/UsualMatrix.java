package entity.Impl.Matrix;

import entity.Impl.Vectors.UsualVector;
import entity.Interfaces.IPrinter;

public class UsualMatrix extends AMatrix {

    public UsualMatrix(int rows, int columns) {
        super(new UsualVector(), rows, columns);
    }
}
