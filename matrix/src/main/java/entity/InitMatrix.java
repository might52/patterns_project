package entity;

import entity.Impl.Matrix.ThinMatrix;
import entity.Interfaces.IMatrix;

import java.util.Random;


public class InitMatrix {

    private static final Random random = new Random();

    public static void fillMatrix(IMatrix matrix, int notNullAmount, double MaxValue){
        int notNullEncounter = 0;
        double minValue = -MaxValue;
        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                double val = minValue + (Math.random() * (MaxValue - minValue));
                if (val != 0 && notNullEncounter < notNullAmount) {
                    matrix.setValue(i, j, val);
                    notNullEncounter++;
                } else {
                    if (matrix instanceof ThinMatrix) {
                        continue;
                    }

                    matrix.setValue(i, j, 0);
                }
            }
        }

    }
/*    public static double round(double value, int places) {
      double val = round(minValue + (Math.random() * (MaxValue - minValue)), 2);
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }*/
}
