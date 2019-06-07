package com.example.sedanur.haber;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sedanur on 29.05.2018.
 */

public class verit extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="kullanicilar_db";

    private static final String TABLE_NAME ="kullanici_bilgi";

    private final String SUTUN_ID = "kullanici_id";
    private final String SUTUN_KULLANICI_ADI = "kullanici_adi";
    private final String SUTUN_SIFRE = "kullanici_sifre";

    public verit(Context context)
    {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String TABLO = "CREATE TABLE " + TABLE_NAME +
            "(" + SUTUN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SUTUN_KULLANICI_ADI + " TEXT, " +
            SUTUN_SIFRE + " TEXT " + ")";

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLO);
    }
    String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public long KayıtEkle(uyelerclass k1)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(SUTUN_KULLANICI_ADI,k1.getIsım());
        cv.put(SUTUN_SIFRE,k1.getSifre());
        long kontrol=db.insert(TABLE_NAME,null,cv);
        db.close();
        return kontrol;
    }

    public  String KaydiKontrolEt(String gelenad)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query ( TABLE_NAME, null, SUTUN_KULLANICI_ADI+"=?", new String[]{gelenad}, null, null, null );
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "Kayıt Bulunamadı";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex(SUTUN_SIFRE));
        cursor.close();
        return password;
    }
}


