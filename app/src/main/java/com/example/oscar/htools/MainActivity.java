package com.example.oscar.htools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

   private final ArrayList<String> mFloorList = new ArrayList<>();
   private RecyclerView mRecyclerView;
   private HToolsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 9; i > 1; i--){
            mFloorList.add("Piso " + i);
        }

        mRecyclerView =  findViewById(R.id.recyclerview);
        mAdapter = new HToolsAdapter(this, mFloorList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.main_menu :
                startActivity(new Intent(this,ListReport.class));
                return true;

            case R.id.nuevo:
                    clearSharePreferences();

                finish();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in,R.anim.left_out);

                return true;

                default:
                    return super.onOptionsItemSelected(item);

        }


    }

    private void clearSharePreferences()
    {

        File prefsdir = new File(getApplicationInfo().dataDir,"shared_prefs");
       // String path = prefsdir.getCanonicalPath();

        if(prefsdir.exists() && prefsdir.isDirectory())
        {
            String[] list = prefsdir.list();

            for (String item:list)
            {
                String fileName = item.replace(".xml", "");
                SharedPreferences sharedPreferences = getSharedPreferences(fileName,Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().apply();

//               String file = path + "/"+item;
//              Log.v("FILE",file);
//              Log.v("SEPARATOR","---------------------");
//                File deletePrefFile = new File(file);
//                deletePrefFile.delete();
             }
        }
    }


}
