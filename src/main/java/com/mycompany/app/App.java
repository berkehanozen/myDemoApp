package com.mycompany.app;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public static boolean search(ArrayList<Integer> array, ArrayList<Integer> array2, int e, int f) {
        System.out.println("inside search");
        if (array == null || array2 == null) return false;

        boolean checkE = false;
        boolean checkF = false;
        boolean arr1 = false;
        boolean arr2 = false;
        for (Integer anArray : array) {
            if (anArray == e) {
                checkE = true;
            }
            if (anArray == f) {
                checkF = true;
            }
        }
        if(checkE && checkF)
            arr1 = true;

        checkE = false;
        checkF = false;

        for (Integer anArray2 : array2) {
            if (anArray2 == e) {
                checkE = true;
            }
            if (anArray2== f) {
                checkF = true;
            }
        }

        if(checkE && checkF)
            arr2 = true;

        return arr1 && arr2;
    }
}
