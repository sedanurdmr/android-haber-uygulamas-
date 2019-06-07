package com.example.sedanur.haber;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sedanur on 29.05.2018.
 */

public class kullanicigiris extends AppCompatActivity {
    EditText kadi, ksifre;
    Button btngiris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kullanicigiris);

        kadi = (EditText) findViewById(R.id.kadi);
        ksifre = (EditText) findViewById(R.id.ksifre);
        btngiris = (Button) findViewById(R.id.btngiris);

        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pd = new ProgressDialog(kullanicigiris.this);
                pd.setTitle("Doluyor...");
                pd.setMessage("Giriş Yapılıyor...");
                pd.setCancelable(false);
                pd.show();

                validate(kadi.getText().toString(), ksifre.getText().toString());
                Intent gec = new Intent(kullanicigiris.this, MainActivity.class);
                startActivity(gec);
            }
        });
    }

    private void validate(String k, String s) {
        if ((k == "s") && (s == "1")) {
            Intent gec = new Intent(kullanicigiris.this, MainActivity.class);
            startActivity(gec);
        }
    }
}
