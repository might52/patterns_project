package entity;

import entity.Impl.Matrix.ReorderDecorator;
import entity.Impl.Matrix.ThinMatrix;
import entity.Impl.Matrix.UsualMatrix;
import entity.Impl.Printers.ConsolePrinter;
import entity.Impl.Printers.HTMLPrinter;
import entity.Interfaces.IMatrix;

public class Application {

    public static void main(String[] args) {

        IMatrix usualMatrix = new UsualMatrix(2,3);
        IMatrix thinMatrix = new ThinMatrix(2,3);

        InitMatrix.fillMatrix(usualMatrix, 3,6);
        InitMatrix.fillMatrix(thinMatrix, 3,6);

        MatrixStats statUsual = new MatrixStats(usualMatrix);
        MatrixStats statThin = new MatrixStats(thinMatrix);

        System.out.println(String.format("Using matrix = %s", usualMatrix.getClass().getName()));
        usualMatrix.print(new ConsolePrinter(), true);
        System.out.println(String.format("Summ %s", statUsual.getSumm()));
        System.out.println(String.format("Averege %s", statUsual.getAverage()));
        System.out.println(String.format("Maximum %s", statUsual.getMaxValue()));
        System.out.println(String.format("NotNull %s", statUsual.getNotNullAmount()));
        System.out.println();

        System.out.println(String.format("Using matrix = %s", thinMatrix.getClass().getName()));
        thinMatrix.print(new ConsolePrinter(), false);
        System.out.println(String.format("Summ %s", statThin.getSumm()));
        System.out.println(String.format("Averege %s", statThin.getAverage()));
        System.out.println(String.format("Maximum %s", statThin.getMaxValue()));
        System.out.println(String.format("NotNull %s", statThin.getNotNullAmount()));
        System.out.println();

        IMatrix ownMatrix = usualMatrix;

        usualMatrix = new ReorderDecorator(usualMatrix);
        System.out.println(String.format("Using decorator = %s", usualMatrix.getClass().getName()));
        System.out.println(String.format("Printing using decorator = %s", usualMatrix.getClass().getName()));
        usualMatrix.print(new ConsolePrinter(), true);

        usualMatrix = ownMatrix;
        System.out.println(String.format("Using previous matrix = %s", usualMatrix.getClass().getName()));
        usualMatrix.print(new ConsolePrinter(), true);

    }

}



