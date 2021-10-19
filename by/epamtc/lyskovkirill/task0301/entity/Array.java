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

    public Array(String file) {
        try {
            var temp = new ArrayList<Integer>();
            Scanner s = new Scanner(file);
            while (s.hasNextInt())
                temp.add(s.nextInt());
            array = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                array[i] = (int) temp.toArray()[i];
            }
        } catch (Exception e) {
            array = new int[0];
        }
        setSortedArray(true, true);
    }

    public void fillRandomArray() {
        var random = new Random();
        int size = 10 + random.nextInt(20);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
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
            sortedArray = sortArray(sortedArray);
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

    private static int[] sortArray(int[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            for (int right = 0; right < arr.length; right++) {
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (arr[c] > arr[c + gap]) {
                        swap(arr, c, c + gap);
                    }
                }
            }
            gap = gap / 2;
        }
        return arr;
    }

    public void bubbleSort() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
            }
        }
    }

    public void selectionSort(){
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
    }

    public void insertionSort(){
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
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
                "{array=\n";
        for (int i = 0; i < array.length; i++) {
            string += array[i];
            if (i < array.length - 1) string += ",";
            string += "\n";
        }
        string += '}';
        return string;
    }
}
