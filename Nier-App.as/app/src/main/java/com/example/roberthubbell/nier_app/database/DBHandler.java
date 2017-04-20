package com.example.roberthubbell.nier_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Brandon on 4/19/2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "nier";
    // Contacts table name
    private static final String TABLE_CHIP = "chip";
    // Shops Table Columns names
    private static final String KEY_ID = "chip_id";
    private static final String KEY_NAME = "chip_name";
    private static final String KEY_DESC = "chip_description";
    private static final String KEY_ENEMY_ID = "enemy_id";
    private static final String KEY_MAX_EFFECT = "chip_max_effect";
    private static final String KEY_BEST_SETUP = "chip_best_setup";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHIP_TABLE = "CREATE TABLE " + TABLE_CHIP + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
        + KEY_DESC + " TEXT," + KEY_ENEMY_ID + " INTEGER," + KEY_MAX_EFFECT + " TEXT,"
        + KEY_BEST_SETUP + " TEXT)";
        db.execSQL(CREATE_CHIP_TABLE);

        DBFunctions.populateDatabase(this);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHIP);
// Creating tables again
        onCreate(db);
    }

    // Adding new chip
    public void addChip(Chip chip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, chip.getName()); // Chip Name
        values.put(KEY_DESC, chip.getDescription()); // Chip Description
        values.put(KEY_ENEMY_ID, chip.getEnemy_id()); // Enemy ID
        values.put(KEY_MAX_EFFECT, chip.getMax_effect()); // Max effect
        values.put(KEY_BEST_SETUP, chip.getBest_setup()); // Best setup

    // Inserting Row
        db.insert(TABLE_CHIP, null, values);
        db.close(); // Closing database connection
    }

    // Getting one chip
    public Chip getChip(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CHIP, new String[] { KEY_ID,
                        KEY_NAME, KEY_DESC, KEY_ENEMY_ID, KEY_MAX_EFFECT, KEY_BEST_SETUP }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Chip contact = new Chip(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5));
        // return chip
        return contact;
    }
}
