package com.example.sedanur.haber;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sedanur on 19.05.2018.
 */

public class veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "veritabani";
    private static final int DATABASE_VERSION = 1;
    private static final String HABER_TABLE = "haber";

    public static final String id = "hid";
    public static final String baslik = "hbaslik";
    public static final String tur = "htür";
    public static final String icerik = "hicerik";

    static final String TABLE_CREATE = "CREATE TABLE " + HABER_TABLE + "("
            + id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + baslik + " TEXT NOT NULL, "
            + tur + " TEXT NOT NULL, "
            + icerik + " TEXT NOT NULL);";

    static final String TABLE_UPGRADE = "DROP TABLE IF EXISTS ";

    public veritabani(Context con) {
        super(con, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(TABLE_UPGRADE + HABER_TABLE);
        onCreate(db);
    }

    public void Ekle(String baslik, String tur, String icerik) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("hbaslik", baslik);
        cv.put("htür", tur);
        cv.put("hicerik", icerik);
        db.insert(HABER_TABLE, null, cv);
        db.close();
    }

    public void Guncelle(String id, String baslik, String icerik) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("hbaslik", baslik);
        cv.put("hicerik", icerik);
        db.update(HABER_TABLE, cv, "hid=" + id, null);
        db.close();
    }

    public void Sil(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(HABER_TABLE, "hid=" + id, null);
        db.close();
    }

    Cursor cursor;

    public String getValueString(String komut, int kolon) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.rawQuery(komut, null);
            cursor.moveToFirst();

            return cursor.getString(kolon);
        } catch (Exception hata) {
            Log.d("hata:getValue:", hata.getMessage().toString());
        } finally {
            cursor.close();
        }
        return "";
    }
}




