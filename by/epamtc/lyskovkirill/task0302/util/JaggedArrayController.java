package by.epamtc.lyskovkirill.task0302.util;

import by.epamtc.lyskovkirill.task03.ConsoleScanner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JaggedArrayController {

    public static int[][] scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter size of array..");
        int size = ConsoleScanner.enterInteger(false);
        int[][] jaggedArray = new int[size][];
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println("Please enter size of row in the array..");
            int rowSize = ConsoleScanner.enterInteger(false);
            jaggedArray[i] = new int[rowSize];
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = ConsoleScanner.enterInteger(true);
            }
        }
        return jaggedArray;
    }

    public static int[][] fill() {
        var random = new Random();
        int[][] jaggedArray = new int[random.nextInt(100)][];
        for (int i = 0; i < jaggedArray.length; i++) {
            jaggedArray[i] = new int[random.nextInt(100)];
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = new Random().nextInt(1000);
            }
        }
        return jaggedArray;
    }

    public static void print(int[][] jaggedArray) {
        for (int[] ints : jaggedArray) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
