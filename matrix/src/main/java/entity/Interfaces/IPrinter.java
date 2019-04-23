package entity.Interfaces;

public interface IPrinter {
    void DrawBorder(IMatrix matrix);
    void DrawValue(IMatrix matrix, int row, int col, double val);
    void DrawEmptyRow();
}
