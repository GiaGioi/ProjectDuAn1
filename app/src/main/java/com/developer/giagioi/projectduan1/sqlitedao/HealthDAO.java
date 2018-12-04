package com.developer.giagioi.projectduan1.sqlitedao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.developer.giagioi.projectduan1.database.DatabaseHelper;
import com.developer.giagioi.projectduan1.model.AddDog;
import com.developer.giagioi.projectduan1.model.Health;

import java.util.ArrayList;
import java.util.List;

public class HealthDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "AddHealth";
    public static final String SQL_HEALTH = "CREATE TABLE Health (idPet text primary key, namepet text , chungloai text, soluong int, tinhtrang text);";
    public static final String TAG = "AddHeath";

    public HealthDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int insertHealth(Health health) {
        ContentValues values = new ContentValues();
        values.put("namepet", health.getNamePet());
        values.put("chungloai", health.getChungLoai());
        values.put("soluong", health.getSoLuong());
        values.put("tinhtrang", health.getTinhTrang());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<Health> getAllHealth() {
        List<Health> health = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Health ee = new Health();
            ee.setNamePet(c.getString(0));
            ee.setChungLoai(c.getString(1));
            ee.setSoLuong(c.getInt(2));
            ee.setTinhTrang(c.getString(3));
            health.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return health;
    }

    public Health getHealth(String idHealth) {
        List<Health> health = new ArrayList<>();
        Health ee = new Health();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {

            ee.setNamePet(c.getString(0));
            ee.setChungLoai(c.getString(1));
            ee.setSoLuong(c.getInt(2));
            ee.setTinhTrang(c.getString(3));
            health.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return ee;
    }

    public int updateHealth(String idPet,String Namepet,String ChungLoai, int Soluong,String Tinhtrang) {
        ContentValues values = new ContentValues();
        values.put("idPet",idPet);
        values.put("namepet",Namepet);
        values.put("chungloai",ChungLoai);
        values.put("soluong",Soluong );
        values.put("tinhtrang", Tinhtrang);
        int result = db.update(TABLE_NAME, values, "idpet=?", new
                String[]{idPet});
        if (result == 0) {
            return -1;
        }
        return 1;

    }



    //delete
    public int deleteHealthByID(String idhealth) {
        int result = db.delete(TABLE_NAME,"idhealth=?",new String[]{idhealth});
        if (result == 0)
            return -1;
        return 1;
    }
}
