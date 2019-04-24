package entity.Interfaces;

public interface IPrinter {
    void DrawBorder(IMatrix matrix);
    void DrawValue(IMatrix matrix, int row, int col, Double val);
    void DrawEmptyRow();
    void setSymbolForNull(String symbol);
}
