package com.isaac.cincalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String IMPROVEMENT_TABLE = "IMPROVEMENT_TABLE";
    public static final String COLUMN_HELPFUL = "HELPFUL";
    public static final String COLUMN_DECISION_CHANGE = "DECISION_CHANGE";
    public static final String COLUMN_SUGGESTIONS = "SUGGESTIONS";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "improvements.db", null, 1);
    }

    //called the first time when the database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatTableStatement = "CREATE TABLE " + IMPROVEMENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_HELPFUL + " BOOL, " + COLUMN_DECISION_CHANGE + " BOOL, " + COLUMN_SUGGESTIONS + " TEXT)";

        db.execSQL(creatTableStatement);
    }

    //this is called if the database version number changes.
    //It prevents previous user's apps from breaking when you change the database design
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(ImprovementModel improvementModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DECISION_CHANGE, improvementModel.isDecisionChange());
        cv.put(COLUMN_HELPFUL, improvementModel.isHelpful());
        cv.put(COLUMN_SUGGESTIONS, improvementModel.getSuggestions());

        long insert = db.insert(IMPROVEMENT_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
