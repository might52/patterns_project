package entity.Interfaces;

public interface IMatrix {
    int getRowsAmount();
    int getColumnsAmount();
    Double getValue(int row, int col);
    void setValue(int row, int col, double value);
    void print(IPrinter printer);
}
