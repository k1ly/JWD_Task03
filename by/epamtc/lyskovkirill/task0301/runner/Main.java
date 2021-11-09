package by.epamtc.lyskovkirill.task0301.runner;

import by.epamtc.lyskovkirill.task0301.entity.ArrayOverflowException;
import by.epamtc.lyskovkirill.task0301.entity.Array;
import by.epamtc.lyskovkirill.task0301.util.ArrayController;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(ArrayController.fill());
        try {
            System.out.println("Array length:");
            System.out.println(arr.arrayLength());

            System.out.println("Array:");
            System.out.println(arr);

            System.out.println("Array min element:");
            System.out.println(arr.findMinElement());

            System.out.println("Array max element:");
            System.out.println(arr.findMaxElement());

            System.out.println("Simple numbers in array:");
            ArrayController.print(arr.findSimpleNumbers());

            System.out.println("Fibonacci numbers in array:");
            ArrayController.print(arr.findFibonacciNumbers());

            System.out.println("Three characters elements numbers in array:");
            ArrayController.print(arr.findThreeCharactersElements());

        } catch (ArrayOverflowException e) {
            System.out.println(e);
        }
    }
}
