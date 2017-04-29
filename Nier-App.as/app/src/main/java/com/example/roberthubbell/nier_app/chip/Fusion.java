package com.example.roberthubbell.nier_app.chip;

import android.content.Context;

/**
 * Created by Brandon on 4/28/2017.
 */

public class Fusion {

    private Context context;
    private Chip chipA;
    private Chip chipB;
    private Chip result;
    private boolean empty;

    public Fusion(Context context, Chip chipA, Chip chipB){
        empty = false;
        this.chipA = chipA;
        this.chipB = chipB;

        int resultLevel = chipA.getLevel()+1;
        int level = chipA.getLevel();
        if(level == 0) //chips of level 0 are treated as level 1 in the formula
            level = 1;
        int resultSize = (chipA.getSize() + chipB.getSize() + level)/2;
        if((chipA.getSize() + chipB.getSize() + level) % 2 != 0)
            resultSize++;
        result = new Chip(context, chipA.getId(), resultLevel, resultSize);
    }
    //constructor to do nothing
    public Fusion(Context context){
        empty = true;
    }

    public boolean empty(){
        return empty;

    }

    public boolean isGoodFusion(){
        //returns true if the resulting fusion is a good fusion
        int level = result.getLevel();
        int resultSize = result.getSize();
        if(level == 1)
            return resultSize <= 9;
        if(level == 2)
            return resultSize <= 9;
        if(level == 3)
            return resultSize <= 10;
        if(level == 4)
            return resultSize <= 11;
        if(level == 5)
            return resultSize <= 13;
        if(level == 6)
            return resultSize <= 15;
        if(level == 7)
            return resultSize <= 18;
        if(level == 8)
            return resultSize <= 21;

        return false;
    }
    public void fuse(){
        chipA.decreaseCount();
        chipB.decreaseCount();
        result.increaseCount();
    }

    public Chip getChipA() {
        return chipA;
    }


    public Chip getChipB() {
        return chipB;
    }


    public Chip getResult() {
        return result;
    }

}
