package com.company;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Main {
  static   SearchAlgo searchAlgo = new SearchAlgo();
    static SortAlgo sortAlgo=new SortAlgo();
enum SEARCH{
    Linear,
    LinearBinary,
    RecursiveBinary,
    Interpolation,
    Exponential,
    JumpPoint
}
    public static void main(String[] args) {
      //  KMPsearch();
        codeTiming();
    }
    public static void KMPsearch(){
        String pattern = "AAABAAA";
        String text = "ASBNSAAAAAABAAAAABAAAAAGAHUHDJKDDKSHAAJF";

        List<Integer> foundIndexes =searchAlgo.performKMPSearch(text, pattern);

        if (foundIndexes.isEmpty()) {
            System.out.println("Pattern not found in the given text String");
        } else {
            System.out.println("Pattern found in the given text String at positions: " +
                    foundIndexes.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
    }
    public static void codeTiming()
    {
        //в данном методе выполним поиск элемента KeyToSearch в списке array[1000] разными методами поиска
        //выполним тайминг методов поиска
        int size = 1000;
        int[] array = new int[]{89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
        printArray(array);
        int keyToSearch = 67;
        for(int i=0;i<6;i++)
        {
            timing(SEARCH.values()[i],array,keyToSearch);
        }
    }
public static void timing(SEARCH algo, int[] array,int keyToSearch)
{  // write your code here
    int[] sortedArray=copyArray(array);
    sortAlgo.quickSort(sortedArray,0,sortedArray.length-1);

    int index=-1;
    long duration=0;
    long startTime=0;
    long endTime = 0;
    switch (algo) {
        case Linear:
            startTime = System.nanoTime();
            index = searchAlgo.linearSearch(array, keyToSearch);
            endTime = System.nanoTime();
            break;
        case JumpPoint:
            startTime = System.nanoTime();
            index = searchAlgo.jumpSearch(sortedArray, keyToSearch);
            endTime = System.nanoTime();
            break;
        case Exponential:
            startTime = System.nanoTime();
            index = searchAlgo.exponentialSearch(sortedArray, keyToSearch);
            endTime = System.nanoTime();
            break;
        case LinearBinary:
            startTime = System.nanoTime();
            index = searchAlgo.binarySearch(sortedArray, keyToSearch);
            endTime = System.nanoTime();
            break;
        case Interpolation:
            startTime = System.nanoTime();
            index = searchAlgo.interpolationSearch(sortedArray, keyToSearch);
            endTime = System.nanoTime();
            break;
        case RecursiveBinary:
            startTime = System.nanoTime();
            index = searchAlgo.recursiveBinarySearch(sortedArray, 0, array.length - 1, keyToSearch);
            endTime = System.nanoTime();
            break;
    }
duration=endTime-startTime;
    printIndex(keyToSearch, index);
    System.out.println(algo.toString()+" search has done at "+((double)duration/1000000)+" ms");
}
    public static void printIndex(int elementToSearch, int index) {
        if (index == -1){
            System.out.println(elementToSearch + " not found.");
        }
        else {
            System.out.println(elementToSearch + " found at index: " + index);
        }
    }



    static int[] copyArray(int[] array)
    { int[] newArray= new int[array.length];
    for(int i=0;i<array.length;i++)
        newArray[i]=array[i];
        return newArray;
    }
    static void fillArray(int[] array)
    {int n=array.length;
        Random rand=new Random();
        for(int i=0;i<n;i++)
            array[i]=rand.nextInt(n);

    }
   static void printArray(int[] array)
   { for(int i=0;i<array.length;i++)
       System.out.print(array[i]+" ");
       System.out.println();
   }

}
