package com.myapplicaton1.week1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class kaydol extends AppCompatActivity {
   private Toolbar kaydolactionbar;
   private EditText textUsername,textEmail,textPassword;
   private Button btnKayıt;
   private FirebaseAuth auth;

    public void init(){
        kaydolactionbar=findViewById(R.id.kaydolactionbar);
        setSupportActionBar(kaydolactionbar);
        getSupportActionBar().setTitle("Kayıt Ol");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth=FirebaseAuth.getInstance();

        textUsername=findViewById(R.id.alankad);
        textEmail=findViewById(R.id.mail);
        textPassword=findViewById(R.id.parolaid);
        btnKayıt=findViewById(R.id.buttonKayıt);

        btnKayıt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                creatNewAccount();
            }
        });
   }
    private void creatNewAccount() {
        String kullanıcıadı=textUsername.getText().toString();
        String email=textEmail.getText().toString();
        String parola=textPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Mail alanı boş olamaz!..", Toast.LENGTH_LONG).show();
            
        }
        else if (TextUtils.isEmpty(parola)){
            Toast.makeText(this, "Parola alanı boş olamaz!..", Toast.LENGTH_LONG).show();
        }
        else
            auth.createUserWithEmailAndPassword(email,parola).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(kaydol.this, "Hesap başarılı bir şekilde oluşturuldu.", Toast.LENGTH_LONG).show();
                        Intent baglantı=new Intent(kaydol.this,login.class);
                        startActivity(baglantı);
                        finish();
                    }
                    else
                        Toast.makeText(kaydol.this, "Hesabınız oluşturulamadı..", Toast.LENGTH_SHORT).show();
                }
            });





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);
        init();
    }
}
