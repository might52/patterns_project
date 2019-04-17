package entity;

import entity.Interfaces.IMatrix;

public class MatrixStats {

    private IMatrix matrix;

    public MatrixStats(IMatrix matrix) {
        this.matrix = matrix;
    }

    public double getSumm() {
        double summ = 0;
        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                summ += matrix.getValue(i, j);
            }
        }

        return summ;
    }

    public double getMaxValue() {
        double maxValue = 0;
        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                if (maxValue < matrix.getValue(i, j)) {
                    maxValue = matrix.getValue(i, j);
                }
            }
        }

        return maxValue;
    }

    public double getAverage() {
        return getSumm() / (matrix.getRowsAmount() * matrix.getColumnsAmount());
    }

    public int getNotNullAmount() {
        int notNull = 0;
        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                if (matrix.getValue(i, j) != 0) {
                    notNull++;
                }
            }
        }

        return notNull;
    }
}
