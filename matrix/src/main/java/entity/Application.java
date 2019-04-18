package entity;

import entity.Impl.Matrix.ComposedMatrix;
import entity.Impl.Matrix.ReorderDecorator;
import entity.Impl.Matrix.ThinMatrix;
import entity.Impl.Matrix.UsualMatrix;
import entity.Impl.Printers.ConsolePrinter;
import entity.Interfaces.IMatrix;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

    private static void fourthTask() {
        IMatrix thinMatrix = new ThinMatrix(2,3);
        InitMatrix.fillMatrix(thinMatrix, 3,6);
        IMatrix usualMatrix = new UsualMatrix(2,3);
        InitMatrix.fillMatrix(usualMatrix, 3,6);
        ComposedMatrix composedMatrix = new ComposedMatrix(Arrays.asList(usualMatrix, thinMatrix));
        composedMatrix.print(new ConsolePrinter(true));
    }
}



