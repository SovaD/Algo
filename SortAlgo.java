package com.company;

import java.util.List;

public class SortAlgo {
    public int[] bubbleSort(int[] myArray) {

        int temp = 0;  //  temporary element for swapping
        int counter = 0;  //  element to count quantity of steps

        for (int i = 0; i < myArray.length; i++) {
            counter = i + 1;
            for (int j = 1; j < (myArray.length - i); j++) {

                if (myArray[j - 1] > myArray[j]) {
                    //  swap array’s elements using temporary element
                    temp = myArray[j - 1];
                    myArray[j - 1] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        System.out.println("Steps quantity, non optimized = " + counter);
        return myArray;
    }
    public int[] insertionSort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            // Вытаскиваем значение элемента
            int value = array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            array[i + 1] = value;
        }
        return array;
    }
    public void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
               array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    public void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public void selectionSort( int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minElementIndex] > arr[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
    }
    public void shellSort(int arrayToSort[]) {
        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }
    }
    public int[] shuttleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {       //  primary pass
            if (array[i] > array[i + 1]) {
                int j = i - 1;
                int temp = array[i + 1];    //  small value to move back
                array[i + 1] = array[i];
                while (j >= 0 && array[j] > temp) {    //  go back
                    array[j + 1] = array[j];    //  shuttle values forward
                    j = j - 1;
                }    //  end secondary pass
                array[j + 1] = temp;    //  insert small value further back
            }            //  else no secondary pass
        }        //  end all passes
        return array;
    }
    //Рекурсивная функция.
    private int factorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        result = n * factorial(n - 1);
        return result;
    }

    //Линейная функция
    int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }

    int pairSum(int a, int b) {
        return a + b;
    }
    void printPairs(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++)
            for (int j = 0; j < nums.size(); j++)
                System.out.println(nums.get(i) + nums.get(j));
    }


    void sumAndProduct(List<Integer> nums) {
        var sum = 0;
        var product = 1;

        for (int num:nums) {

            sum += num;
        }

        for (int num:nums) {
            product *= num;
        }
        System.out.println("Sum is "+ sum);
        System.out.println("Product is "+  product);
    }
}
