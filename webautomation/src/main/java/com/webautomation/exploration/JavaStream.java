package com.webautomation.exploration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {

    public static void main(String[] args) {
        
        List <Integer> arrayList = Arrays.asList(1,2,4,5,6,7,8,9,10,5,5,5,555,5,5);

        List <Integer> resultList = new ArrayList<>();

        for (int i = 0; i < arrayList.size()-1; i++) {
            
            if (arrayList.get(i) == 5) {
                resultList.add(arrayList.get(i));
            }
        }

        for (int i = 0; i < resultList.size()-1; i++) {
            System.out.println("test " + resultList.get(i));
        }
        
        
        //menggunakan java stream
        resultList = arrayList.stream().filter(number -> number.equals(5)).collect(Collectors.toList());


        System.out.println("Stream : "+ resultList);
    }

    

}
