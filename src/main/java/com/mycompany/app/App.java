package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;


import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


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
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value2 = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value2);
            }
            System.out.println(inputList2);

            String input3 = req.queryParams("input3");
            java.util.Scanner sc3 = new java.util.Scanner(input3);
            sc3.useDelimiter("[;\r\n]+");
            java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
            while (sc3.hasNext())
            {
                String value3 = sc3.next().replaceAll("\\s","");
                inputList3.add(value3);
            }
            System.out.println(inputList3);


            String input4 = req.queryParams("input4").replaceAll("\\s","");
            int input4AsInt = Integer.parseInt(input4);

            String input5 = req.queryParams("input5").replaceAll("\\s","");
            int input5AsInt = Integer.parseInt(input5);

            String[] realInputList3 = inputList3.toArray(new String[0]);

            String[] result = App.swapStrings(inputList, inputList2, realInputList3, input4AsInt, input5AsInt);

            Map map = new HashMap();
            map.put("result", Arrays.toString(result));
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}

