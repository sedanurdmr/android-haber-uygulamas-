package com.example.sedanur.haber;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Sedanur on 29.05.2018.
 */

public class uyehaber extends AppCompatActivity {
    ListView uyehaberler;
    private veritabani database;
    int ID[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uyehaber);

        database = new veritabani(this);
        uyehaberler=(ListView) findViewById(R.id.uyehaberler);
        Listele();
    }

    private void Listele() {
        StringBuilder builder = new StringBuilder();
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.query("haber", new String[]{"hid", "hbaslik", "htür", "hicerik"}, null, null, null, null, null);
        final String dizi[] = new String[cursor.getCount()];
        ID = new int[cursor.getCount()];
        int sayac = 0;
        for (cursor.moveToNext(); !cursor.isAfterLast(); cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("hid"));
            String baslik = cursor.getString(cursor.getColumnIndex("hbaslik"));
            String tur = cursor.getString(cursor.getColumnIndex("htür"));
            String icerik = cursor.getString(cursor.getColumnIndex("hicerik"));
            builder.append(id).append(" ").append(baslik).append(" ").append(tur).append(" ").append(icerik).append("/n");
            dizi[sayac] = baslik;
            ID[sayac]= Integer.parseInt(id);
            sayac += 1;
        }
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dizi);
        uyehaberler.setAdapter(adapter);

        uyehaberler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(uyehaber.this, haberdetay.class);
                startActivity(intent.putExtra("id", ID[i]));
            }
        });
    }
}
