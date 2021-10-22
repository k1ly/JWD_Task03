package by.epamtc.lyskovkirill.task03;

import java.util.Scanner;

public class ConsoleScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static int enterInteger(boolean canBeNegative) {
        System.out.println("Enter the integer number..");
        int ret = 0;
        while (scanner.hasNext()) {
            try {
                ret = Integer.parseInt(scanner.next());
                if (!canBeNegative && ret < 0) {
                    System.out.println("Try to enter not a negative number");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Try to enter a number again");
            }
        }
        return ret;
    }

    public static String enterString() {
        System.out.println("Enter any string..");
        String ret = null;
        try {
            ret = scanner.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }
}
