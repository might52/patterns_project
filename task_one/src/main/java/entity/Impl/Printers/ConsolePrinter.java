package entity.Impl.Printers;

import entity.Interfaces.IMatrix;
import entity.Interfaces.IPrinter;

public class ConsolePrinter implements IPrinter {

    private boolean showBorder = true;
    public ConsolePrinter(boolean showBorder){
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

    public void DrawBorderCell(IMatrix matrix, int row, int col) {
        StringBuilder tabs = new StringBuilder("");
        for (int i = 0; i < col; i++) {
            tabs.append("\t");
        }
        System.out.println(tabs + "|```|");
        System.out.print(tabs + "|,,,|");
    }

    public void DrawValue(IMatrix matrix, int row, int col, double val) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                if (row == i && col == j) {
                    stringBuilder.append(String.format(" %.2f \n", val));
                }
//                else {
//                    stringBuilder.append(" ");
//                }
            }

//            stringBuilder.append("\n");
        }

        System.out.print(stringBuilder);
    }
}
