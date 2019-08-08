package com.myapplicaton1.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button girisbtn,kaydolbtn;
    private FirebaseUser varolan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        girisbtn=findViewById(R.id.button);
        kaydolbtn=findViewById(R.id.button2);

        girisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "GİRİŞ EKRANINA YÖNLENDİRİLİYORSUNUZ..", Toast.LENGTH_SHORT).show();
                Intent intentlogin =new Intent(MainActivity.this,login.class);
                startActivity(intentlogin);
            }
        });
        kaydolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentkaydol=new Intent(MainActivity.this,kaydol.class);
                startActivity(intentkaydol);
            }
        });

    }

    @Override
    protected void onStart() {
        if(varolan==null){
            Intent kayıt=new Intent(MainActivity.this,kaydol.class);
            startActivity(kayıt);
            finish();
        }
        super.onStart();
    }
}
