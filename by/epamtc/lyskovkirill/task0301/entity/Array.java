package by.epamtc.lyskovkirill.task0301.entity;

import java.util.*;

public class Array {
    private int[] array;
    private int[] sortedArray;

    public Array() {
        array = new int[0];
        setSortedArray(true, false);
    }

    public Array(int length) {
        array = new int[length = Math.max(length, 0)];
        setSortedArray(true, false);
    }

    public Array(int... ints) {
        array = ints;
        setSortedArray(true, true);
    }

    public Array(Collection<Integer> ints) {
        this(ints.size());
        for (int i = 0; i < ints.size(); i++) {
            array[i] = (int) ints.toArray()[i];
        }
        setSortedArray(true, true);
    }

    private void setSortedArray(boolean createNewSortedArray, boolean feelSortedArray) {
        if (createNewSortedArray)
            sortedArray = new int[array.length];
        if (feelSortedArray) {
            for (int i = 0; i < array.length; i++) {
                sortedArray[i] = array[i];
            }
            selectionSort(sortedArray);
        }
    }

    public int get(int index) throws ArrayOverflowException {
        if (index < 0 || index >= array.length)
            throw new ArrayIndexOutOfBoundsException(": Array index " + index + " out of bounds");
        return this.array[index];
    }

    public void set(int num, int index) throws ArrayOverflowException {
        if (index < 0 || index >= array.length)
            throw new ArrayIndexOutOfBoundsException(": Array index " + index + " out of bounds");
        boolean isEqual = array[index] == num;
        this.array[index] = num;
        if (!isEqual)
            setSortedArray(false, true);
    }

    public void refreshArray(int newLength) throws NegativeArraySizeException {
        if (newLength < 0)
            throw new NegativeArraySizeException();
        this.array = new int[newLength];
        setSortedArray(true, false);
    }

    public void adjustArrayLength(int length) throws ArrayOverflowException {
        if (length > array.length)
            throw new ArrayOverflowException(": Array overflow");
        var temp = new int[length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        this.array = temp;
        setSortedArray(true, true);
    }

    public void clear() {
        this.array = new int[array.length];
        setSortedArray(true, false);
    }

    public int arrayLength() {
        return array.length;
    }

    public void insertionSort() {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public void selectionSort() {
        selectionSort(this.array);
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;
            swap(array, i, min_idx);
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }

    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public int binarySearch(int key) {
        int low = 0;
        int high = arrayLength() - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key > sortedArray[mid]) {
                low = mid + 1;
            } else if (key < sortedArray[mid]) {
                high = mid - 1;
            } else if (key == sortedArray[mid]) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int findMaxElement() throws ArrayOverflowException {
        if (array.length == 0)
            throw new ArrayOverflowException();
        return array[array.length - 1];
    }

    public int findMinElement() throws ArrayOverflowException {
        if (array.length == 0)
            throw new ArrayOverflowException();
        return sortedArray[0];
    }

    public int[] findSimpleNumbers() {
        var temp = new ArrayList<Integer>();
        for (int i = 0, simple = 2; simple < sortedArray[array.length - 1] && i < array.length; i++) {
            while (sortedArray[i] > simple) {
                simple = calculateNextSimple(simple);
            }
            if (sortedArray[i] == simple)
                temp.add(sortedArray[i]);
        }
        var ret = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ret[i] = (int) temp.toArray()[i];
        }
        return ret;
    }

    private int calculateNextSimple(int simple) {
        boolean isSimple = false;
        while (!isSimple) {
            simple++;
            isSimple = true;
            for (int i = 2; i <= simple / 2; i++) {
                if (simple % i == 0) {
                    isSimple = false;
                    break;
                }
            }
        }
        return simple;
    }

    public int[] findFibonacciNumbers() {
        var temp = new ArrayList<Integer>();
        for (int i = 0, fibonacci1 = 0, fibonacci2 = 0; fibonacci2 < sortedArray[array.length - 1] && i < array.length; i++) {
            while (sortedArray[i] > fibonacci2) {
                int fibonacci = fibonacci2;
                fibonacci2 += fibonacci == 0 ? 1 : fibonacci1;
                fibonacci1 = fibonacci;
            }
            if (sortedArray[i] == fibonacci2)
                temp.add(sortedArray[i]);
        }
        var ret = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ret[i] = (int) temp.toArray()[i];
        }
        return ret;
    }

    public int[] findThreeCharactersElements() {
        var temp = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (sortedArray[i] > 99 && sortedArray[i] < 1000) {
                int character1 = sortedArray[i] / 100;
                int character2 = sortedArray[i] / 10 % 10;
                int character3 = sortedArray[i] % 100;
                if (character1 != character2 && character1 != character3 && character2 != character3)
                    temp.add(sortedArray[i]);
            }
        }
        var ret = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ret[i] = (int) temp.toArray()[i];
        }
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return this.array.equals(array.array);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (var i : array) {
            hash += i;
        }
        return hash;
    }

    @Override
    public String toString() {
        String string = getClass().getName() +
                "{array= ";
        for (int i = 0; i < array.length; i++) {
            string += array[i];
            if (i < array.length - 1) string += ", ";
        }
        string += '}';
        return string;
    }
}
