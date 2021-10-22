package by.epamtc.lyskovkirill.task0302.util;

public class JaggedArraySorter {

    public static void sortBySum(int[][] jaggedArray) {
        bubbleSort(jaggedArray, new ArrayRowEvaluator() {
            @Override
            public int evaluateRow(int[] arrayRow) {
                int result = 0;
                for (int i : arrayRow) {
                    result += i;
                }
                return result;
            }
        });
    }

    public static void sortByMax(int[][] jaggedArray) {
        bubbleSort(jaggedArray, new ArrayRowEvaluator() {
            @Override
            public int evaluateRow(int[] arrayRow) {
                int result = arrayRow.length > 0 ? arrayRow[0] : 0;
                for (int i : arrayRow) {
                    if (i > result)
                        result = i;
                }
                return result;
            }
        });
    }

    public static void sortByMin(int[][] jaggedArray) {
        bubbleSort(jaggedArray, new ArrayRowEvaluator() {
            @Override
            public int evaluateRow(int[] arrayRow) {
                int result = arrayRow.length > 0 ? arrayRow[0] : 0;
                for (int i : arrayRow) {
                    if (i < result)
                        result = i;
                }
                return result;
            }
        });
    }

    private static void bubbleSort(int[][] array, ArrayRowEvaluator sorter) {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (sorter.evaluateRow(array[j]) > sorter.evaluateRow(array[j + 1])) {
                    int[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }
}