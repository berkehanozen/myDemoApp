package com.mycompany.app;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

public class App {
    public static String[] swapStrings(ArrayList<Integer> array, ArrayList<Integer> array2, String[] str, int array1Index, int array2Index) {
        System.out.println("inside search");
        if (array == null || array2 == null || str == null) return null;

        if(array1Index >= array.size() || array2Index >= array2.size()) return null;

        int stringIndex1 = array.get(array1Index);
        int stringIndex2 = array2.get(array2Index);

        if(stringIndex1 >= str.length || stringIndex2 >= str.length) return null;

        while(Math.abs(stringIndex1 - stringIndex2) > 0){
            String temp = str[stringIndex1];
            str[stringIndex1] = str[stringIndex2];
            str[stringIndex2] =  temp;
            if(Math.abs(stringIndex1 - stringIndex2) == 1)
                break;
            if(stringIndex1 < stringIndex2){
                stringIndex1++;
                stringIndex2--;
            }
            else{
                stringIndex1--;
                stringIndex2++;
            }
        }
        return str;
    }
}

