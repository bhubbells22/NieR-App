package com.example.roberthubbell.nier_app.chip;

import android.content.Context;

import com.example.roberthubbell.nier_app.database.DatabaseAccess;

/**
 * Created by Brandon on 4/24/2017.
 */

public class Chip {

    private int id;
    private String name;
    private String description;
    private int level;
    private int size;
    private int count;
    private int enemy_id;
    private String max_effect;
    private String best_setup;
    private Context context;

    //This is the general constructor, used for showing information
    public Chip(Context context, int id){
        this.id=id;
        this.level=0;
        this.size=0;
        this.count=0;
        this.context = context;

        //Open database to get rest of elements
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();


        this.name = databaseAccess.getName(id);
        this.description = databaseAccess.getDescription(id);
        this.enemy_id = databaseAccess.getEnemyId(id);
        this.max_effect = databaseAccess.getMaxEffect(id);
        this.best_setup = databaseAccess.getBestSetup(id);




        databaseAccess.close();

    }

    //This is the constructor used for manipulating held chips
    public Chip(Context context, int id, int level, int size){
        this.context = context;
        this.id=id;
        this.level=level;
        this.size=size;

        //Open database to get rest of elements
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();

        if(databaseAccess.hasChip(id, level, size)){
            this.count = databaseAccess.getCount(id, level, size);
        }
        else{
            this.count = 0;
        }

        this.name = databaseAccess.getName(id);
        this.description = databaseAccess.getDescription(id);
        this.enemy_id = databaseAccess.getEnemyId(id);
        this.max_effect = databaseAccess.getMaxEffect(id);
        this.best_setup = databaseAccess.getBestSetup(id);




        databaseAccess.close();

    }

    public void increaseCount(){
        //Increase the number of chips a user has
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();

        //add the chip to the database if it doesn't exist
        if(!databaseAccess.hasChip(id, level, size)){
            databaseAccess.insertChip(id, level, size);
        }

        databaseAccess.changeCount(id, level, size, 1);
        count++;
        databaseAccess.close();

    }

    public boolean decreaseCount(){
        //Decrease the number of chips a user has
        //Deletes the chip and returns "true" if the chip is empty
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();

        count -= 1;
        //remove the chip from database if count is 0
        if(count==0){
            databaseAccess.deleteChip(id, level, size);
            databaseAccess.close();
            return true;
        }

        databaseAccess.changeCount(id, level, size, -1);
        databaseAccess.close();
        return false;

    }

    public boolean inDb(){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        if(databaseAccess.hasChip(id, level, size)){
            databaseAccess.close();
            return true;
        }

        databaseAccess.close();
        return false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getEnemy_id() {
        return enemy_id;
    }

    public void setEnemy_id(int enemy_id) {
        this.enemy_id = enemy_id;
    }

    public String getMax_effect() {
        return max_effect;
    }

    public void setMax_effect(String max_effect) {
        this.max_effect = max_effect;
    }

    public String getBest_setup() {
        return best_setup;
    }

    public void setBest_setup(String best_setup) {
        this.best_setup = best_setup;
    }
}
