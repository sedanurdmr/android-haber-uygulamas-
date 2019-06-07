package com.example.sedanur.haber;

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

public class uyeol extends AppCompatActivity {
    EditText uye,sifre;
    Button btngiris;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uyeol);

        uye=(EditText)findViewById(R.id.uye);
        sifre=(EditText)findViewById(R.id.sifre);
        btngiris=(Button)findViewById(R.id.btngiris);

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId ()){
                    case R.id.btngiris:
                        String kullaniciadi = uye.getText().toString();
                        String sifresi = sifre.getText().toString();
                        try {
                            if (kullaniciadi.isEmpty()||sifresi.isEmpty())
                                Toast.makeText ( getApplicationContext (), "Alanları boş bırakmayınız", Toast.LENGTH_SHORT ).show ();
                            else
                            {
                                uyelerclass k1 = new uyelerclass(kullaniciadi, sifresi);
                                verit db = new verit(getApplicationContext());
                                long id = db.KayıtEkle(k1);
                                if (id == -1)
                                {
                                    Toast.makeText(uyeol.this, "Kayıt yapılamadı", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(uyeol.this, "Kayıt yapıldı", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(uyeol.this, "Hata\n" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                Intent i=new Intent ( uyeol.this, uyegiris.class );
                startActivity ( i );
            }
        });
    }
}
