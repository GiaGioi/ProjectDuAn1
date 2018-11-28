package com.developer.giagioi.projectduan1.sqlitedao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.developer.giagioi.projectduan1.database.DatabaseHelper;
import com.developer.giagioi.projectduan1.model.Vaccin;

import java.util.ArrayList;
import java.util.List;

public class VaccinDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "AddVaccin";
    public static final String SQL_VACCIN = "CREATE TABLE AddVaccin (idpet text primary key, namepet text, loaithucan text, soluong int);";
    public static final String TAG = "VaccinDAO";

    public VaccinDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int insertVaccin(Vaccin vaccin) {
        ContentValues values = new ContentValues();
        values.put("namepet", vaccin.getTenVatNuoi());
        values.put("loaithucan", vaccin.getLoaiThucAn());
        values.put("soluong", vaccin.getSoLuong());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<Vaccin> getAllVaccin() {
        List<Vaccin> vaccins = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Vaccin ee = new Vaccin();
            ee.setTenVatNuoi(c.getString(0));
            ee.setSoLuong(c.getInt(1));
            ee.setLoaiThucAn(c.getString(2));
            vaccins.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return vaccins;
    }

    public Vaccin getVaccin(String idVaccin) {
        List<Vaccin> vaccins = new ArrayList<>();
        Vaccin ee = new Vaccin();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {

            ee.setTenVatNuoi(c.getString(0));
            ee.setSoLuong(c.getInt(1));
            ee.setLoaiThucAn(c.getString(2));
            vaccins.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return ee;
    }

    public int updateVaccin(String idPet, String Namepet, int Soluong, String LoaiThucAn) {
        ContentValues values = new ContentValues();
        values.put("idpet", idPet);
        values.put("namepet",Namepet);
        values.put("soluong",Soluong );
        values.put("loaithucan", LoaiThucAn);
        int result = db.update(TABLE_NAME, values, "idpet=?", new
                String[]{idPet});
        if (result == 0) {
            return -1;
        }
        return 1;

    }



    //delete
    public int deleteVaccin(String idvaccin) {
        int result = db.delete(TABLE_NAME,"idvaccin=?",new String[]{idvaccin});
        if (result == 0)
            return -1;
        return 1;
    }

}
