package entity;

import entity.Impl.Matrix.HorizontalGroupMatrix;
import entity.Impl.Matrix.ReorderDecorator;
import entity.Impl.Matrix.ThinMatrix;
import entity.Impl.Matrix.UsualMatrix;
import entity.Impl.Printers.ConsolePrinter;
import entity.Interfaces.IMatrix;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        // first and second tasks
//        firstSecondThirdTasks();
        //test Reorder
//        thirdTask();
        fourthTask();
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
        InitMatrix.fillMatrix(thinMatrix, 4,1);
        IMatrix usualMatrix1 = new UsualMatrix(2,2);
        InitMatrix.fillMatrix(usualMatrix1, 4,2);
//        IMatrix usualMatrix2 = new UsualMatrix(3,1);
//        InitMatrix.fillMatrix(usualMatrix2, 3,3);
//        IMatrix usualMatrix3 = new UsualMatrix(3,1);
//        InitMatrix.fillMatrix(usualMatrix3, 3,4);

        setValue(thinMatrix, 1);
        setValue(usualMatrix1, 2);
//        setValue(usualMatrix2, 3);
//        setValue(usualMatrix3, 1.0);

        HorizontalGroupMatrix horizontalGroupMatrix = new HorizontalGroupMatrix(
                Arrays.asList(
                        thinMatrix,
                        usualMatrix1
//                        usualMatrix2
                )
        );

//        MatrixStats statHorizontalGroupMatrix = new MatrixStats(horizontalGroupMatrix);
//        statHorizontalGroupMatrix.printStats();

        horizontalGroupMatrix.print(new ConsolePrinter(true));
        horizontalGroupMatrix.setValue(1,0, 4);
        horizontalGroupMatrix.setValue(1,1, 4);
        horizontalGroupMatrix.setValue(1,2, 4);
        horizontalGroupMatrix.setValue(1,3, 4);
        horizontalGroupMatrix.print(new ConsolePrinter(true));
    }
}



