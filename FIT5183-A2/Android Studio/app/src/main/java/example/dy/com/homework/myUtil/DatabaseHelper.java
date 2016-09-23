package example.dy.com.homework.myUtil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import example.dy.com.homework.entity.Step;
import example.dy.com.homework.entity.User;

/**
 * Created by dy on 2016/4/19.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Set database properties
    public static final String DATABASE_NAME = "Health";
    public static final int DATABASE_VERSION = 1;


    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.CREATE_STATEMENT);
        db.execSQL(Step.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Step.TABLE_NAME);
        onCreate(db);
    }

    public boolean addUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.COLUMN_ID, u.getId());
        values.put(User.COLUMN_NAME, u.getName());
        values.put(User.COLUMN_PASSWORD, StringUtils.getPasswordEncryption(u.getPassword()));
        values.put(User.COLUMN_REGISTRATION, StringUtils.getCurTime());
        values.put(User.COLUMN_LATITUDE, StringUtils.getPosition().get("latitude"));
        values.put(User.COLUMN_LONGITUDE, StringUtils.getPosition().get("longitude"));
        Long res = db.insert(User.TABLE_NAME, null, values);
        System.out.println("add res->" + res);
        db.close();
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUser(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + User.TABLE_NAME +
                " WHERE " + User.COLUMN_NAME + " = " + "'" + name + "'", null);

        if (cursor.moveToFirst()) {
            db.close();
            return true;
        } else {
            db.close();
            return false;
        }
    }


    public List<User> findAllUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + User.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                User u = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getDouble(4), cursor.getDouble(5));
                list.add(u);
            } while (cursor.moveToNext());
        }

        System.out.println("get user from sqlite");
        for (User u : list) {
            System.out.println(u);
        }
        db.close();
        return list;
    }


    public List<Step> getStep(String id, String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Step> list = new ArrayList<>();
        String sql = "SELECT * FROM " + Step.TABLE_NAME + " WHERE " + Step.COLUMN_DATE + " LIKE '" + date
                + "%' AND " + Step.COLUMN_USERID + " = '" + id + "' ORDER BY " + Step.COLUMN_DATE;
        System.out.println(sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Step s = new Step(cursor.getInt(2), cursor.getString(3));
                list.add(s);
            } while (cursor.moveToNext());
        }

        System.out.println("get user from sqlite");
        for (Step step : list) {
            System.out.println(step);
        }
        db.close();
        return list;
    }

    public boolean addStep(String step, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Step.COLUMN_USERID, id);
        values.put(Step.COLUMN_STEPS, step);
        values.put(Step.COLUMN_DATE, StringUtils.getCurTime());
        long res = db.insert(Step.TABLE_NAME, null, values);
        db.close();
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void addData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 3; i < 10; i++) {
            ContentValues values = new ContentValues();
            int tstep = (int) (Math.random() * 100);
            String time = "2016-04-28 0" + String.valueOf(i) + ":30:48";
            values.put(Step.COLUMN_USERID, id);
            values.put(Step.COLUMN_STEPS, tstep);
            values.put(Step.COLUMN_DATE, time);
            long res = db.insert(Step.TABLE_NAME, null, values);

        }
        for(int i = 10; i < 14; i++){
            ContentValues values = new ContentValues();
            int tstep = (int)(Math.random()*100);
            String time = "2016-04-28 "+String.valueOf(i)+":30:48";
            values.put(Step.COLUMN_USERID, id);
            values.put(Step.COLUMN_STEPS, tstep);
            values.put(Step.COLUMN_DATE, time);
            long res = db.insert(Step.TABLE_NAME, null, values);

        }
        db.close();
        System.out.println("add finish");
    }

    public List<Step> findAllStep() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Step> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Step.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Step u = new Step(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3));
                list.add(u);
            } while (cursor.moveToNext());
        }

        System.out.println("get step from sqlite");
        for (Step u : list) {
            System.out.println(u);
        }
        db.close();
        return list;
    }

    public HashMap<String, Double> getPosition(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        HashMap<String, Double> map = new HashMap<>();
        String sql = "SELECT * FROM " + User.TABLE_NAME + " WHERE " + User.COLUMN_ID + " = '" + id + "'";
        System.out.println("position sql->" + sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            map.put(User.COLUMN_LATITUDE, cursor.getDouble(4));
            map.put(User.COLUMN_LONGITUDE, cursor.getDouble(5));
        }
        return map;
    }


}
