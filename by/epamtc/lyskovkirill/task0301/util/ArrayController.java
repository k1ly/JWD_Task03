package by.epamtc.lyskovkirill.task0301.util;

import by.epamtc.lyskovkirill.task03.ConsoleScanner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayController {

    public static int[] scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter size of array..");
        int size = ConsoleScanner.enterInteger(false);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = ConsoleScanner.enterInteger(true);
        }
        return array;
    }

    public static int[] fill() {
        var random = new Random();
        int[] array = new int[random.nextInt(100)];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(1000);
        }
        return array;
    }

    public static int[] read(String file) throws Exception {
        Scanner scanner = new Scanner(file);
        var temp = new ArrayList<Integer>();
        while (scanner.hasNextInt())
            temp.add(scanner.nextInt());
        int[] array = new int[temp.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) temp.toArray()[i];
        }
        return array;
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
