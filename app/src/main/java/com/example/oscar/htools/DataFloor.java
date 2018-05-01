package com.example.oscar.htools;

import java.util.ArrayList;

public class DataFloor
{




    private final ArrayList<String> floorNumbers  = new ArrayList<>();


    ArrayList<String> initialData()
    {
        for (int i = 0; i < 8; i++){
            floorNumbers.add("Piso " +  i);
        }
        return floorNumbers;

    }


}
