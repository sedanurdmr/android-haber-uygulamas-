package com.example.sedanur.haber;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sedanur on 24.05.2018.
 */

public class detay extends AppCompatActivity {
    EditText txtbaslik, txticerik;
    Bundle bundle;
    veritabani db;
    int id;
    private veritabani database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detay);

        db = new veritabani(getApplicationContext());

        bundle = getIntent().getExtras();
        id = bundle.getInt("id");

        Log.d("ID:", String.valueOf(id));

        txtbaslik = (EditText) findViewById(R.id.txtbaslik);
        txticerik = (EditText) findViewById(R.id.txticerik);

        txtbaslik.setText(db.getValueString("select hbaslik from haber where hid=" + id, 0));
        txticerik.setText(db.getValueString("select htür from haber where hid=" + id, 0));
    }

    public void btnSil(View v) {
        db.Sil(String.valueOf(id));
        finish();
        Toast.makeText(getApplicationContext(), "Silindi.", Toast.LENGTH_SHORT).show();
    }

    public void btnDuzenle(View v) {
        db.Guncelle(String.valueOf(id), txtbaslik.getText().toString(), txticerik.getText().toString());
        Toast.makeText(getApplicationContext(), "Güncellendi.", Toast.LENGTH_SHORT).show();
    }
}


