package com.developer.giagioi.projectduan1.sqlitedao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.developer.giagioi.projectduan1.database.DatabaseHelper;
import com.developer.giagioi.projectduan1.model.AddDog;

import java.util.ArrayList;
import java.util.List;

public class AddDogDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "AddDog";
    public static final String SQL_DOG = "CREATE TABLE AddDog (namepet text primary key, chungloai text, soluong int, gioitinh text, tinhtrang text);";
    public static final String TAG = "AddDogDAO";

    public AddDogDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    //insert
    public long insertAddDog(AddDog addDog) {
        ContentValues values = new ContentValues();
        values.put("namepet", addDog.getNamePet());
        values.put("chungloai", addDog.getChungLoai());
        values.put("soluong", addDog.getSoLuong());
        values.put("gioitinh", addDog.getGioiTinh());
        values.put("tinhtrang", addDog.getTinhTrang());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<AddDog> getAllAddDog() {
        List<AddDog> addDogs = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            AddDog ee = new AddDog();
            ee.setNamePet(c.getString(0));
            ee.setChungLoai(c.getString(1));
            ee.setSoLuong(c.getInt(2));
            ee.setGioiTinh(c.getString(3));
            ee.setTinhTrang(c.getString(4));
            addDogs.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return addDogs;
    }

    public AddDog getAddDog(String idAddDog) {
        List<AddDog> addDogs = new ArrayList<>();
        AddDog ee = new AddDog();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {

            ee.setNamePet(c.getString(0));
            ee.setChungLoai(c.getString(1));
            ee.setSoLuong(c.getInt(2));
            ee.setGioiTinh(c.getString(3));
            ee.setTinhTrang(c.getString(4));
            addDogs.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return ee;
    }

    public int updateAddDog(String idPet, String Namepet, int Soluong, String Gioitinh,String Tinhtrang) {
        ContentValues values = new ContentValues();
        values.put("namepet", idPet);
        values.put("chungloai",Namepet);
        values.put("soluong",Soluong );
        values.put("gioitinh", Gioitinh);
        values.put("tinhtrang", Tinhtrang);
        int result = db.update(TABLE_NAME, values, "idpet=?", new
                String[]{idPet});
        if (result == 0) {
            return -1;
        }
        return 1;

    }



    //delete
    public int deleteAddDogByID(String idaddog) {
        int result = db.delete(TABLE_NAME,"namepet=?",new String[]{idaddog});
        if (result == 0)
            return -1;
        return 1;
    }
}
