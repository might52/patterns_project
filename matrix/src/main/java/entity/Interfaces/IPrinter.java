package entity.Interfaces;

public interface IPrinter {
    void DrawBorder(IMatrix matrix);
    void DrawBorderCell(IMatrix matrix, int row, int col);
    void DrawValue(IMatrix matrix, int row, int col, double val);
}
