package com.example.roberthubbell.nier_app.database;

/**
 * Created by Brandon on 4/24/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public String getName(int id) {
        String name="";
        Cursor cursor = database.rawQuery("SELECT chip_name from chip where chip_id = " + id, null);
        cursor.moveToFirst();
        name = cursor.getString(0);
        cursor.close();
        return name;
    }

    public String getDescription(int id) {
        String name="";
        Cursor cursor = database.rawQuery("SELECT chip_description from chip where chip_id = " + id, null);
        cursor.moveToFirst();
        name = cursor.getString(0);
        cursor.close();
        return name;
    }

    public int getEnemyId(int id) {
        int enemyId;
        Cursor cursor = database.rawQuery("SELECT enemy_id from chip where chip_id = " + id, null);
        cursor.moveToFirst();
        enemyId = cursor.getInt(0);
        cursor.close();
        return enemyId;
    }

    public String getMaxEffect(int id) {
        String name="";
        Cursor cursor = database.rawQuery("SELECT chip_max_effect from chip where chip_id = " + id, null);
        cursor.moveToFirst();
        name = cursor.getString(0);
        cursor.close();
        return name;
    }

    public String getBestSetup(int id) {
        String name="";
        Cursor cursor = database.rawQuery("SELECT chip_best_setup from chip where chip_id = " + id, null);
        cursor.moveToFirst();
        name = cursor.getString(0);
        cursor.close();
        return name;
    }

    public int getCount(int id, int level, int size) {
        int count;
        Cursor cursor = database.rawQuery("SELECT chip_count from user_chip where chip_id = " + id + " and chip_level = " + level + " and chip_size = " + size, null);
        cursor.moveToFirst();
        count = cursor.getInt(0);
        cursor.close();
        return count;
    }

    public boolean hasChip(int id, int level, int size){
        int count;
        Cursor cursor = database.rawQuery("SELECT count(chip_id) from user_chip where chip_id = " + id + " and chip_level = " + level + " and chip_size = " + size, null);
        cursor.moveToFirst();
        count = cursor.getInt(0);
        cursor.close();

        return count > 0;
    }
    public void changeCount(int id, int level, int size, int change){
        database.execSQL("UPDATE user_chip SET chip_count = chip_count + " + change + " WHERE chip_id = " + id + " and chip_level = " + level + " and chip_size = " + size);
    }

    public void deleteChip(int id, int level, int size){
        database.execSQL("DELETE FROM user_chip WHERE chip_id = " + id + " and chip_level = " + level + " and chip_size = " + size);
    }

    public void insertChip(int id, int level, int size){
        database.execSQL("INSERT INTO user_chip (chip_id, chip_level, chip_size, chip_count) VALUES (" + id + ", " + level + ", " + size + ", 0)");
    }

    public String getEnemyName(int id){
        String name="";
        Cursor cursor = database.rawQuery("SELECT enemy_name from enemy where enemy_id = " + id, null);
        cursor.moveToFirst();
        name = cursor.getString(0);
        cursor.close();
        return name;

    }

    public String getLocationName(int id){
        String name="";
        Cursor cursor = database.rawQuery("select location_description from location " +
                "join enemy on enemy.location_id = location.location_id " +
                "where enemy_id = " + id, null);
        cursor.moveToFirst();
        name = cursor.getString(0);
        cursor.close();
        return name;
    }

}