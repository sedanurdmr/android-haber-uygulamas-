package com.example.sedanur.haber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Sedanur on 20.05.2018.
 */

public class gecis extends AppCompatActivity {
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gecis);

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        TextClock saat=(TextClock)findViewById(R.id.saat);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gec=new Intent(gecis.this,kullanicigiris.class);
                startActivity(gec);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecc=new Intent(gecis.this,uyegiris.class);
                startActivity(gecc);
            }
        });
    }
}
