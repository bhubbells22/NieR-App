package com.example.roberthubbell.nier_app.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Brandon on 4/19/2017.
 */

public class DBFunctions {

    private static final String TABLE_CHIP = "chip";
    private static final String KEY_ID = "chip_id";
    private static final String KEY_NAME = "chip_name";
    private static final String KEY_DESC = "chip_description";
    private static final String KEY_ENEMY_ID = "enemy_id";
    private static final String KEY_MAX_EFFECT = "chip_max_effect";
    private static final String KEY_BEST_SETUP = "chip_best_setup";

    public static void populateDatabase(DBHandler database){
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(KEY_ID, 1);
        values.put(KEY_NAME, "Down-Attack Up"); // Chip Name
        values.put(KEY_DESC, "Increases power of Down-Attacks"); // Chip Description
        values.put(KEY_ENEMY_ID, 3); // Enemy ID
        values.put(KEY_MAX_EFFECT, "400%"); // Max effect
        values.put(KEY_BEST_SETUP, "One level 8 chip"); // Best setup

        // Inserting Row
        db.insert(TABLE_CHIP, null, values);
        db.close(); // Closing database connection
    }
}
