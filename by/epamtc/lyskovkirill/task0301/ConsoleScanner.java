package by.epamtc.lyskovkirill.task0301;

import java.util.Scanner;

public class ConsoleScanner {
    private static Scanner scanner = new Scanner(System.in);

    public static int enterInteger() {
        System.out.println("Введите целое число..");
        int ret = 0;
        while (scanner.hasNext()) {
            try {
                ret = Integer.parseInt(scanner.next());
                break;
            } catch (Exception e) {
                System.out.println("Попробуйте ввести число снова");
            }
        }
        return ret;
    }

    public static double enterDouble() {
        System.out.println("Введите число..");
        double ret = 0;
        while (scanner.hasNext()) {
            try {
                ret = Double.parseDouble(scanner.next());
                break;
            } catch (Exception e) {
                System.out.println("Попробуйте ввести число снова");
            }
        }
        return ret;
    }


}
