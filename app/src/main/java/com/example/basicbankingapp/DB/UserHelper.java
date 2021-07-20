package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(9999,'Kuldeep Singh', 'kuldeep@gmail.com','5674','9995641276', 15600)");
        db.execSQL("insert into " + TABLE_NAME + " values(5271,'Sanjana Varshney', 'Sanjana@gmail.com','1258','8993511238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1235,'Surya Yadav', 'surya@gmail.com','8901','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3921,'Sukirti Bajpayi', 'sukirti@gmail.com','9952','7473640038', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(564,'Shivani Kumari', 'shivani@gmail.com','3669','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(697,'Piyush Joshi', 'piyush@gmail.com','9985','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7630,'Vrinda  Kumari', 'vrinda@gmail.com','1707','9876543211', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2573,'Saloni Maheshwari', 'saloni@gmail.com','9922','9564821539', 4400)");
        db.execSQL("insert into " + TABLE_NAME + " values(1065,'Riya Ajmera', 'riya@gmail.com','6752','9307885238', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2990,'Shivani Chaudhary', 'shivani@gmail.com','4450','9235491201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(6221,'manuraj Sharma', 'manuraj@gmail.com','1656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'manvendra Kumar', 'manvendra@gmail.com','1223','9756901909', 11100)");
        db.execSQL("insert into " + TABLE_NAME + " values(1721,'Vishal Singh', 'vishal@gmail.com','5566','9099541001', 4400)");
        db.execSQL("insert into " + TABLE_NAME + " values(9112,'Gaurav Yadav', 'gaurav@gmail.com','1136','9954642205', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7675,'Vivek Rathore', 'vivek@gmail.com','4492','7453641266', 1110)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}