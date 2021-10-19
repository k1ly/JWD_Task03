package by.epamtc.lyskovkirill.task0301.runner;

import by.epamtc.lyskovkirill.task0301.entity.ArrayOverflowException;
import by.epamtc.lyskovkirill.task0301.entity.Array;

public class Main {

    public static void main(String[] args) {
        Array arr = new Array(10, 8, 5, 13, 21, 77, 43,4234, 221, 888, 532, 890, 791);
        try {
            System.out.println(arr.arrayLength());
            System.out.println(arr);
            System.out.println(arr.findMinElement());
            System.out.println(arr.findMaxElement());
            System.out.println(new Array(arr.findSimpleNumbers()));
            System.out.println(new Array(arr.findFibonacciNumbers()));
            System.out.println(new Array(arr.findThreeCharactersElements()));
        } catch (ArrayOverflowException e) {
            System.out.println(e);
        }
    }
}