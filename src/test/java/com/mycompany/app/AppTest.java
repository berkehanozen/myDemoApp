package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;

public class AppTest
        extends TestCase
{

    public void testSuccessful() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(0,1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18));
        String[] str = new String[]{"ahmet","mehmet","ali","selim","mahmut","riza","suleyman","murat","oguz","kerem"};
        String[] str2 = new String[]{"ahmet","mehmet","ali","selim","kerem","oguz","murat","suleyman","riza","mahmut"};
        assertTrue(Arrays.equals(new App().swapStrings(array, array2, str, 9, 2), str2));
    }

    public void testNotSuccessful() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(0,1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18));
        String[] str = new String[]{"ahmet","mehmet","ali","selim","mahmut","riza","suleyman","murat","oguz","kerem"};
        String[] str2 = new String[]{"ahmet","mehmet","ali","selim","mahmut","riza","suleyman","oguz","murat","kerem"};
        assertFalse(Arrays.equals(new App().swapStrings(array, array2, str, 9, 3), str2));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18));
        String[] str = new String[]{"ahmet","mehmet","ali","selim","mahmut","riza","suleyman","murat","oguz","kerem"};
        assertEquals(new App().swapStrings(array, array2, str, 2, 1), null);
    }

    public void testNull() {
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(3, 8, 5, 1));
        String[] str = new String[]{"ahmet","mehmet","ali","selim","mahmut","riza","suleyman","murat","oguz","kerem"};
        assertEquals(new App().swapStrings(null, array2, str, 1, 2), null);
    }

    public void testIndexOutOFBounds() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(0,1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18));
        String[] str = new String[]{"ahmet","mehmet","ali","selim","mahmut","riza","suleyman","murat","oguz","kerem"};
        assertEquals(new App().swapStrings(null, array2, str, 11, 2), null);
    }


}


