package entity.Impl.Printers;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IPrinter;

public class HTMLPrinter implements IPrinter {

    private boolean showBorder = true;

    public HTMLPrinter(boolean showBorder){
        this.showBorder = showBorder;
    }

   public void DrawBorder(IMatrix matrix) {
        System.out.println(String.format("Painting the border for matrix %s in html", matrix.getClass().getName()));
    }

    public void DrawBorderCell(IMatrix matrix, int row, int col) {
        System.out.println(String.format("Painting the cell (row = %s, col=%s) for matrix %s in html", row, col, matrix.getClass().getName()));
    }

    public void DrawValue(IMatrix matrix, int row, int col, double val) {
        System.out.println(String.format("Painting the value=%s for cell (row = %s, col=%s) for matrix %s in html", val, row, col, matrix.getClass().getName()));
    }

    public void DrawEmptyRow() {
        System.out.println(String.format("Painting the empty row"));
    }

}
