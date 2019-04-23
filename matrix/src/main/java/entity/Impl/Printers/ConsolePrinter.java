package entity.Impl.Printers;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IPrinter;

public class ConsolePrinter implements IPrinter {

    private boolean showBorder;

    public ConsolePrinter(){
        this.showBorder = false;
    }

    public ConsolePrinter(boolean showBorder){
        this.showBorder = showBorder;
    }

    public ConsolePrinter(boolean showBorder, String symbol){
        this.showBorder = showBorder;
    }

    public void DrawBorder(IMatrix matrix) {
        if (!showBorder) {
            return;
        }

        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            for (int count = 0; count < matrix.getColumnsAmount(); count++) {
                System.out.print("|```|");
            }

            System.out.println();
            for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                System.out.print("|,,,|");
            }

            System.out.println();
        }

        System.out.println();
    }

    @Override
    public void DrawEmptyRow() {
        System.out.println();
    }

    public void DrawValue(IMatrix matrix, int row, int col, double val) {
        if (this.showBorder) {
            System.out.print(String.format("|\t %.2f \t|", val));
        }
        else {
            System.out.print(String.format("\t %.2f \t", val));
        }
    }

}
