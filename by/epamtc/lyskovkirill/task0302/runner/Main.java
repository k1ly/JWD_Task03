package by.epamtc.lyskovkirill.task0302.runner;

import by.epamtc.lyskovkirill.task0302.util.JaggedArray;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	int [][] jaggedArray = new int[5][];
        for (int i = 0; i < jaggedArray.length; i++) {
            jaggedArray[i] = new int[5*i];
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = new Random().nextInt(100);
            }
        }
        var sorted = JaggedArray.sortBySumMatrixEl(jaggedArray);
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.println(sorted [i][j]);
            }
            System.out.println();
        }
        sorted = JaggedArray.sortByIncreasingMaxEl(jaggedArray);
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.println(sorted [i][j]);
            }
            System.out.println();
        }
        sorted = JaggedArray.sortByIncreasingMinEl(jaggedArray);
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.println(sorted [i][j]);
            }
            System.out.println();
        }
    }
}
