package entity.Impl.Matrix;

import entity.Impl.Vectors.ThinVector;

public class ThinMatrix extends AMatrix {

    public ThinMatrix(int rows, int columns) {
        super(new ThinVector(), rows, columns);
        super.isPrintEmpty = false;
    }

}