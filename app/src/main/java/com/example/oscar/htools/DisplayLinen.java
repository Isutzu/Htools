// Description: This class will save the value of the SeekBar Progress to a SharePreferences file.
//              This action will happen in the onStopTrackingTouch callback method.
package com.example.oscar.htools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayLinen extends AppCompatActivity
{


    SeekBar seekbar;
    TextView tv;
    TextView tvTitleQueen;
    SharedPreferences sp;
    int viewPosition;

    static ArrayList<Labels> mArrayListLabels = new ArrayList<>();


    @Override
    protected void onCreate( Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.linen);

        Intent intent = getIntent();
        final String floorNumber = intent.getStringExtra("floor");
        String floorNumberWithSpace = floorNumber.substring(0,floorNumber.length()- 1) + " " +
                        floorNumber.substring(floorNumber.length()-1) ;
        getSupportActionBar().setTitle(floorNumberWithSpace);
        viewPosition = intent.getIntExtra("viewPosition",0);

        if(viewPosition < 4)
        {
             sp = getSharedPreferences(floorNumber,Context.MODE_PRIVATE);
             getIds9to6(sp);
        }
        else
        {
            sp = getSharedPreferences(floorNumber,Context.MODE_PRIVATE);
            getIds5to2(sp);

        }


        for (int j = 0; j< mArrayListLabels.size(); j++)
        {

            final Labels idData = mArrayListLabels.get(j);
            idData.setFloorNumber(floorNumber);
            if(viewPosition > 3)
            {
                if(idData.getType_name().equals("queen"))
                {
                    tvTitleQueen = findViewById(R.id.tv_title_king_queen);
                    tvTitleQueen.setText("Queen");
                }
                else if(idData.getType_name().equals("fitted_queen"))
                {
                    tvTitleQueen = findViewById(R.id.tv_title_fitted_king_queen);
                    tvTitleQueen.setText("Queen Cajon");
                }


            }

            seekbar = findViewById(idData.getSeekbar_id());
            seekbar.setProgress(idData.getValue());

            tv = findViewById(idData.getTextview_id());
            tv.setText(idData.getValue()+"");


            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b)
                {
                    tv = findViewById(idData.getTextview_id());

                    tv.setText(i +"");
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar)
                {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar)
                {

                    SharedPreferences.Editor editor = sp.edit();
                    String label = idData.getType_name();
                    int progressValue = seekBar.getProgress();// important to display list report

                    idData.setValue(seekBar.getProgress());
                    editor.putInt(label,progressValue);
                    editor.apply();

                    Log.v("FLOOR",idData.getFloorNumber());
                    Log.v("LABEL",label);
                    Log.v("VALUE",seekBar.getProgress()+"");

                }
            });
        }


    }

    private void getIds5to2(SharedPreferences sp)
    {
        mArrayListLabels.add(new Labels(R.id.seekbar_flat,R.id.tv_flat,
                "full", sp.getInt("full",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_fitted_flat,R.id.tv_fitted_flat,
                "fitted_full",sp.getInt("fitted_full",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_king,R.id.tv_king,
                "queen",sp.getInt("queen",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_fitted_king,R.id.tv_fitted_king,
                "fitted_queen", sp.getInt("fitted_queen",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_king_pillow,R.id.tv_king_pillow,
                "king_pillow", sp.getInt("king_pillow",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_standard_pillow,R.id.tv_standard_pillow,
                "standard_pillow", sp.getInt("standard_pillow",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_bath_towel,R.id.tv_bath_towel,
                "bath_towel", sp.getInt("bath_towel",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_bath_matt,R.id.tv_bath_matt,
                "bath_matt", sp.getInt("bath_matt",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_hand_towel,R.id.tv_hand_towel,
                "hand_towel", sp.getInt("hand_towel",0)));
    }


    private void getIds9to6(SharedPreferences sp)
    {
        mArrayListLabels.add(new Labels(R.id.seekbar_flat,R.id.tv_flat,
                "full", sp.getInt("full",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_fitted_flat,R.id.tv_fitted_flat,
                "fitted_full",sp.getInt("fitted_full",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_king,R.id.tv_king,
                "king",sp.getInt("king",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_fitted_king,R.id.tv_fitted_king,
                "fitted_king", sp.getInt("fitted_king",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_king_pillow,R.id.tv_king_pillow,
                "king_pillow", sp.getInt("king_pillow",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_standard_pillow,R.id.tv_standard_pillow,
                "standard_pillow", sp.getInt("standard_pillow",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_bath_towel,R.id.tv_bath_towel,
                "bath_towel", sp.getInt("bath_towel",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_bath_matt,R.id.tv_bath_matt,
                "bath_matt", sp.getInt("bath_matt",0)));

        mArrayListLabels.add(new Labels(R.id.seekbar_hand_towel,R.id.tv_hand_towel,
                "hand_towel", sp.getInt("hand_towel",0)));

    }

    public static ArrayList<Labels>getDataLabels()
    {
        return mArrayListLabels;
    }
}
