package by.epamtc.lyskovkirill.task0302.runner;

import by.epamtc.lyskovkirill.task0302.util.JaggedArrayController;
import by.epamtc.lyskovkirill.task0302.util.JaggedArraySorter;

public class Main {

    public static void main(String[] args) {
        int[][] jaggedArray = JaggedArrayController.fill();

        JaggedArraySorter.sortBySum(jaggedArray);
        System.out.println("Jagged array sorted by sum of row elements:");
        JaggedArrayController.print(jaggedArray);

        JaggedArraySorter.sortByMax(jaggedArray);
        System.out.println("Jagged array sorted by max element in row:");
        JaggedArrayController.print(jaggedArray);

        JaggedArraySorter.sortByMin(jaggedArray);
        System.out.println("Jagged array sorted by min element in row:");
        JaggedArrayController.print(jaggedArray);
    }
}
