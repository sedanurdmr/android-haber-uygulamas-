package com.example.sedanur.haber;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sedanur on 29.05.2018.
 */

public class uyegiris extends AppCompatActivity {
    Button btngiris,btnuyeol;
    EditText uye,sifre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uyegiris);

        uye=(EditText)findViewById(R.id.uye);
        sifre=(EditText)findViewById(R.id.sifre);
        btngiris=(Button)findViewById(R.id.btngiris);
        btnuyeol=(Button)findViewById(R.id.btnuyeol);

        btnuyeol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent ( uyegiris.this, uyeol.class );
                startActivity ( i );
            }
        });

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kullaniciadi = uye.getText ().toString ();
                String sifresi = sifre.getText ().toString ();
                switch (view.getId ()) {
                    case R.id.btngiris:
                        if ( sifresi.isEmpty () || kullaniciadi.isEmpty () ) {
                            Toast.makeText ( uyegiris.this, "Alanları boş bırakmayınız", Toast.LENGTH_SHORT ).show ();
                        }
                        verit db = new verit ( getApplicationContext () );
                        String kontrol = db.KaydiKontrolEt ( kullaniciadi );
                        if ( sifresi.equals ( kontrol ) ) {
                            Toast.makeText ( uyegiris.this, "Giriş yapıldı", Toast.LENGTH_SHORT ).show ();
                            Intent gir = new Intent ( getApplicationContext (), uyehaber.class );
                            startActivity ( gir );
                        } else {
                            Toast.makeText ( uyegiris.this, "Kullanıcı Adı veya Şifre Yanlış Girildi", Toast.LENGTH_SHORT ).show ();
                        }
                        break;
                    case R.id.btnuyeol:
                        Intent intent = new Intent ( getApplicationContext (), uyeol.class );
                        startActivity ( intent );
                }
            }
        });
    }
}
