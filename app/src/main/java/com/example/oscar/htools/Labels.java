package com.example.oscar.htools;

// Description: Contains the Resources id's of the seekbar and Textview
// The TextView text will change accordingly to the Seekbar progress
// The type_name field will be used as a key to store the value of the Seekbar progress in a SharedPreference file
// which be name by the floor number . The floor number is equal to the item position in the RecyclerView

public class Labels
{
    int seekbar_id;
    int textview_id;
    int value;
    String type_name;

    public String getFloorNumber()
    {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber)
    {
        this.floorNumber = floorNumber;
    }

    String floorNumber;


//    Integer arrayTextAndBar[][]={
//            {
//                    R.id.seekbar_flat,
//                    R.id.tv_flat,
//            },
//            {
//                    R.id.seekbar_fitted_flat,
//                    R.id.tv_fitted_flat,
//            },
//            {
//                    R.id.seekbar_king,
//                    R.id.tv_king,
//            },
//
//            {
//                    R.id.seekbar_fitted_king,
//                    R.id.tv_fitted_king,
//            },
//
//            {
//                    R.id.seekbar_king_pillow,
//                    R.id.tv_king_pillow,
//            },
//            {
//                    R.id.seekbar_standard_pillow,
//                    R.id.tv_standard_pillow,
//            },
//
//            {
//                    R.id.seekbar_bath_towel,
//                    R.id.tv_bath_towel,
//            },
//            {
//                    R.id.seekbar_bath_matt,
//                    R.id.tv_bath_matt,
//            },
//            {
//                    R.id.seekbar_hand_towel,
//                    R.id.tv_hand_towel,
//            }
//
//
//    };
//


    public  Labels(int seekbar_id,int textview_id, String type_name, int value)
    {
            this.seekbar_id = seekbar_id;
            this.textview_id = textview_id;
            this.type_name = type_name;
            this.value = value;
    }

    public Labels()
    {
        super();
    }



    String  labelsList[] ={
        "full",
        "fitted_full",
        "king",
        "fitted_king",
            "queen",
            "fitted_queen",
        "king_pillow",
        "standard_pillow",
        "bath_towel",
        "bath_math",
        "hand_towel",
    };

    String[] floorsList ={
      "Piso9.xml",
      "Piso8.xml",
      "Piso7.xml",
      "Piso6.xml",
      "Piso5.xml",
      "Piso4.xml",
      "Piso3.xml",
      "Piso2.xml",
    };



    public String[] getLabelsList()
    {
        return labelsList;
    }

    public String[] getfloorsList()
    {
        return floorsList;
    }

    public int getSeekbar_id()
    {
        return seekbar_id;
    }

    public void setSeekbar_id(int seekbar_id)
    {
        this.seekbar_id = seekbar_id;
    }

    public int getTextview_id()
    {
        return textview_id;
    }

    public void setTextview_id(int textview_id)
    {
        this.textview_id = textview_id;
    }

    public String getType_name()
    {
        return type_name;
    }

    public void setType_name(String type_name)
    {
        this.type_name = type_name;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue()
    {
        return  value;
    }
}
