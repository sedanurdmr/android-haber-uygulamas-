package com.example.sedanur.haber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Sedanur on 29.05.2018.
 */

public class haberdetay extends AppCompatActivity {
    TextView baslik,tur,icerik;
    Bundle bundle;
    veritabani db;
    int id;
    private veritabani database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haberdetay);

        baslik=(TextView) findViewById(R.id.baslik);
        tur=(TextView) findViewById(R.id.tur);
        icerik=(TextView) findViewById(R.id.icerik);

        database = new veritabani(this);
        db = new veritabani(getApplicationContext());

        bundle = getIntent().getExtras();
        id = bundle.getInt("id");

        Log.d("ID:", String.valueOf(id));

        baslik.setText(db.getValueString("select hbaslik from haber where hid=" + id, 0));
        tur.setText(db.getValueString("select hicerik from haber where hid=" + id, 0));
        icerik.setText(db.getValueString("select htür from haber where hid=" + id, 0));
    }
}
