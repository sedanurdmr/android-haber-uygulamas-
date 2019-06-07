package com.example.sedanur.haber;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private veritabani database = new veritabani(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText baslik = (EditText) findViewById(R.id.baslik);
        final EditText icerik = (EditText) findViewById(R.id.icerik);
        final EditText tur = (EditText) findViewById(R.id.tur);

        Button btnekle = (Button) findViewById(R.id.btnekle);
        Button don=(Button)findViewById(R.id.don);
        Button cikis=(Button) findViewById(R.id.cikis);

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git=new Intent(MainActivity.this,gecis.class);
                startActivity(git);
            }
        });

        don.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git=new Intent(MainActivity.this,haberler.class);
                startActivity(git);
            }
        });

        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veritabani veritabani=new veritabani(MainActivity.this);
                veritabani.Ekle(baslik.getText().toString(),icerik.getText().toString(),tur.getText().toString());
                Toast.makeText(getApplicationContext(), "Haber Kaydedildi.", Toast.LENGTH_LONG).show();
            }
        });
    }
}

