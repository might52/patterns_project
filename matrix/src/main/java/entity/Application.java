package entity;

import entity.Impl.Matrix.*;
import entity.Impl.Printers.ConsolePrinter;
import entity.Interfaces.IMatrix;
import entity.Interfaces.IPrinter;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        // first and second tasks
//        firstSecondThirdTasks();
        //test Reorder
//        thirdTask();
//        fourthTask();
        fourthTaskLast();
    }

    private static void firstSecondThirdTasks(){
        IMatrix usualMatrix = new UsualMatrix(2,3);
        IMatrix thinMatrix = new ThinMatrix(2,3);

        InitMatrix.fillMatrix(usualMatrix, 3,6);
        InitMatrix.fillMatrix(thinMatrix, 3,6);

        MatrixStats statUsual = new MatrixStats(usualMatrix);
        MatrixStats statThin = new MatrixStats(thinMatrix);

        System.out.println(String.format("Using matrix = %s", usualMatrix.getClass().getName()));
        usualMatrix.print(new ConsolePrinter(true));
        statUsual.printStats();

        System.out.println(String.format("Using matrix = %s", thinMatrix.getClass().getName()));
        thinMatrix.print(new ConsolePrinter(true));
        statThin.printStats();

    }

    private static void thirdTask(){
        IMatrix thinMatrix = new ThinMatrix(2,3);
        InitMatrix.fillMatrix(thinMatrix, 3,6);
        System.out.println(String.format("Using matrix = %s", thinMatrix.getClass().getName()));
        thinMatrix.print(new ConsolePrinter(true));

        IMatrix reordered = new ReorderDecorator(thinMatrix);
        System.out.println(String.format("Using matrix = %s", reordered.getClass().getName()));
        reordered.print(new ConsolePrinter(true));

        System.out.println(String.format("Using previous matrix = %s", thinMatrix.getClass().getName()));
        thinMatrix.print(new ConsolePrinter(true));
    }

    private static void setValue(IMatrix matrix, double value){
        for (int i = 0; i < matrix.getRowsAmount(); i++) {
            for (int j = 0; j < matrix.getColumnsAmount(); j++) {
                matrix.setValue(i, j, value);
            }
        }
    }

    private static void fourthTask() {
        IMatrix thinMatrix = new ThinMatrix(2,2);
        InitMatrix.fillMatrix(thinMatrix, 2,1);
        IMatrix usualMatrix1 = new UsualMatrix(2,2);
        InitMatrix.fillMatrix(usualMatrix1, 2,2);
        IMatrix usualMatrix2 = new UsualMatrix(3,1);
        InitMatrix.fillMatrix(usualMatrix2, 3,3);

        HorizontalGroupMatrix horizontalGroupMatrix = new HorizontalGroupMatrix(
                Arrays.asList(
                        thinMatrix,
                        usualMatrix1,
                        usualMatrix2
                )
        );

        MatrixStats statHorizontalGroupMatrix = new MatrixStats(horizontalGroupMatrix);
        statHorizontalGroupMatrix.printStats();

        horizontalGroupMatrix.print(new ConsolePrinter(true));
        ReorderDecorator reorderDecorator = new ReorderDecorator(horizontalGroupMatrix);
        System.out.println(String.format("Reorder for horizontal: %s", horizontalGroupMatrix.getClass().getCanonicalName()));
        reorderDecorator.print(new ConsolePrinter(true));
    }

    private static void fourthTaskLast(){
        IMatrix thinMatrix1 = new ThinMatrix(2,2);
        InitMatrix.fillMatrix(thinMatrix1, 4,1);
        IMatrix usualMatrix1 = new UsualMatrix(4,3);
        InitMatrix.fillMatrix(usualMatrix1, 12,2);
        IMatrix usualMatrix2 = new UsualMatrix(1,3);
        InitMatrix.fillMatrix(usualMatrix2, 3,3);
        setValue(thinMatrix1, 1);
        setValue(usualMatrix1, 2);
        setValue(usualMatrix2, 3);
        HorizontalGroupMatrix horizontalGroupMatrix1 = new HorizontalGroupMatrix(
                Arrays.asList(
                        thinMatrix1,
                        usualMatrix1,
                        usualMatrix2
                )
        );
        System.out.println(String.format("Using matrix = %s", "horizontalGroupMatrix1 for first line"));
        horizontalGroupMatrix1.print(new ConsolePrinter());

        IMatrix usualMatrix3 = new UsualMatrix(2, 4);
        InitMatrix.fillMatrix(usualMatrix3, 8, 4);
        IMatrix usualMatrix4 = new UsualMatrix(2, 3);
        InitMatrix.fillMatrix(usualMatrix4, 6, 5);
        setValue(usualMatrix3, 4);
        setValue(usualMatrix4, 5);
        HorizontalGroupMatrix horizontalGroupMatrix2 = new HorizontalGroupMatrix(
                Arrays.asList(
                        usualMatrix3,
                        usualMatrix4
                )
        );
        System.out.println(String.format("Using matrix = %s", "horizontalGroupMatrix2 for second line"));
        horizontalGroupMatrix2.print(new ConsolePrinter());

        IMatrix usualMatrix5 = new UsualMatrix(1,1);
        InitMatrix.fillMatrix(usualMatrix5, 1, 6);
        setValue(usualMatrix5, 6);

        HorizontalGroupMatrix horizontalGroupMatrix = new HorizontalGroupMatrix(Arrays.asList(horizontalGroupMatrix1, horizontalGroupMatrix2, usualMatrix5));
        System.out.println(String.format("Using matrix = %s", "horizontalGroupMatrix for whole matrixes"));
        horizontalGroupMatrix.print(new ConsolePrinter());

        GroupVerticalDecorator groupVerticalDecorator = new GroupVerticalDecorator(horizontalGroupMatrix);
        System.out.println(String.format("Using matrix = %s", "groupVerticalDecorator"));
        groupVerticalDecorator.print(new ConsolePrinter());

    }
}



