package com.example.oscar.htools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListReport extends AppCompatActivity
{

    TextView tvReport;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_report);

        tvReport = findViewById(R.id.tv_report);

        File prefsdir = new File(getApplicationInfo().dataDir, "shared_prefs");


        if (prefsdir.exists() && prefsdir.isDirectory())
        {

            String[] list = prefsdir.list();
            String[] listSharePrefNames = new Labels().getfloorsList();
            String[] labelsList = new Labels().getLabelsList();
            displayTotals(listSharePrefNames,list,labelsList,tvReport);

//            for (String item:list)
//            {
//                Log.v("XML FILE==", item);
//                if(item.startsWith("Piso"))
//                {
//                    String fileName = item.replace(".xml", "");
//                    Log.v("PREFERENCE NAME==", fileName);
//                    reportString += fileName + "\n" + "--------------" + "\n";
//
//                   // String sharePrefName = item.replace(".xml", "");
//                    SharedPreferences sp = getSharedPreferences(fileName, Context.MODE_PRIVATE);
//                    Map<String, ?> allEntries = sp.getAll();
//                    if(!allEntries.isEmpty())
//                    {
//                        for (Map.Entry<String, ?> entry : allEntries.entrySet())
//                        {
//                            Log.v(entry.getKey(), entry.getValue().toString());
//                            reportString += entry.getKey() + "--->" + entry.getValue().toString() + "\n";
//
//                        }
//
//                        Log.v("DIVIDER", "---------------------");
//                        reportString += "\n\n";
//                    }
//                }
//
//            }
            // }

//        SharedPreferences  sp = getSharedPreferences("list",Context.MODE_PRIVATE);
//        Map<String,?> allEntries =  sp.getAll();
//        for (Map.Entry<String,?> entry : allEntries.entrySet())
//        {
//                String spName = entry.getValue().toString();
//                Log.v("SHARE NAME",spName);
//
//        }

//        if (!arrayLabels.isEmpty())
//        {
//            for(int i=0; i < arrayLabels.size(); i++)
//            {
//                Labels data = arrayLabels.get(i);
//                String sharePrefName = data.getFloorNumber();
//                String key = data.getType_name();
//                Log.v("PISO NUMERO--------",sharePrefName);
//                SharedPreferences sharedPreferences = getSharedPreferences(
//                        sharePrefName, Context.MODE_PRIVATE);
//                Log.v(key,String.valueOf(sharedPreferences.getInt(key,0)));
//
//            }
//        }

            //  SharedPreferences sharedPreferences = getSharedPreferences("Piso8", Context.MODE_PRIVATE);
//        Map<String,?> allEntries =  sharedPreferences.getAll();
//        for (Map.Entry<String,?> entry : allEntries.entrySet())
//        {
//
//        }
//        int flatValue =  sharedPreferences.getInt("flat",0);
//        int fittedFlatValue = sharedPreferences.getInt("fitted_flat",0);
//        int kingValue = sharedPreferences.getInt("king",0);
//        int fittedKingValue = sharedPreferences.getInt("fitted_king",0);
//
//        flat.setText( flat.getText() +  String.valueOf(flatValue));
//        fittedFlat.setText(fittedFlat.getText() + String.valueOf(fittedFlatValue ));
//        king.setText(king.getText()+  String.valueOf(kingValue));
//        fittedKing.setText(fittedKing.getText() + String.valueOf(fittedKingValue));

            // tvReport.setText(reportString);

        }


    }

    private void displayTotals(String[] listSharePrefNames, String[] list, String[] labelsList,TextView tvReport)
    {
        String report = "";
        Map<String,Integer> totals = new LinkedHashMap<>();
        Map<String,Integer> totals9to6 = new LinkedHashMap<>();
        Map<String,Integer> totals5to2 = new LinkedHashMap<>();



        List<String> fileNames = Arrays.asList(list);
        for(int x=0; x< labelsList.length; x++)
        {
            int total = 0;
            int total9to6 = 0;
            int total5to2 = 0;
            for (String floor: listSharePrefNames)
            {
                if (fileNames.contains(floor))
                {

                    SharedPreferences sp = getSharedPreferences(floor.replace(".xml",""),Context.MODE_PRIVATE);
                    total += sp.getInt(labelsList[x],0);

                    Log.v("TOTAL", total +"");

                    if(floor.equals("Piso9.xml") ||
                            floor.equals("Piso8.xml") ||
                            floor.equals("Piso7.xml") ||
                            floor.equals("Piso6.xml"))
                    {
                        total9to6 += sp.getInt(labelsList[x],0);
                    }
                    else
                    {
                        total5to2 += sp.getInt(labelsList[x],0);
                    }
                }
            }

            totals.put(labelsList[x],total);
            totals9to6.put(labelsList[x],total9to6);
            totals5to2.put(labelsList[x],total5to2);
        }



        report += "\n-------------------------- Listado Total --------------------\n\n";
        int counter = 0;
        for (Map.Entry<String, Integer> entry : totals.entrySet())
        {
            if ( counter > 1)
            {
                report += "\n\n"+(entry.getKey() + "--->" + entry.getValue() + "\n");
                counter = 0;
            }
            else
            {
                report += (entry.getKey() + "--->" + entry.getValue() + "\n");
            }

            counter ++;

        }

        report +="\n\n---------------------- 8 to 6 ------------------------\n\n";

        int counter9to6 = 0;
        for (Map.Entry<String, Integer> entry : totals9to6.entrySet())
        {
            if ( counter9to6 > 1)
            {
                report += "\n\n"+(entry.getKey() + "--->" + entry.getValue() + "\n");
                counter9to6 = 0;
            }
            else
            {
                report += (entry.getKey() + "--->" + entry.getValue() + "\n");
            }

            counter9to6 ++;

        }

        report +="\n\n--------------------------- 5 to 2 ----------------------------\n\n";

        int counter5to2 = 0;
        for (Map.Entry<String, Integer> entry : totals5to2.entrySet())
        {
            if ( counter5to2 > 1)
            {
                report += "\n\n"+(entry.getKey() + "--->" + entry.getValue() + "\n");
                counter5to2 = 0;
            }
            else
            {
                report += (entry.getKey() + "--->" + entry.getValue() + "\n");
            }

            counter5to2 ++;

        }




        tvReport.setText(report);



    }

}
