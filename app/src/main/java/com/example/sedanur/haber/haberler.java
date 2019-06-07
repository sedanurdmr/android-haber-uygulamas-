package com.example.sedanur.haber;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Sedanur on 20.05.2018.
 */

public class haberler extends AppCompatActivity {
    ListView haberler;
    private veritabani database;
    int ID[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haberler);

        database = new veritabani(this);
        haberler = (ListView) findViewById(R.id.haberler);

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
            ID[sayac] = Integer.parseInt(id);
            sayac += 1;
        }
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dizi);
        haberler.setAdapter(adapter);

        haberler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(haberler.this, detay.class);
                startActivity(intent.putExtra("id", ID[i]));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Listele();
    }
}
