package com.myapplicaton1.week1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
public class login extends AppCompatActivity {

  private Toolbar actionbarLogin;
 public void init(){
     actionbarLogin=findViewById(R.id.actionbarLogin);
    setSupportActionBar(actionbarLogin);
    getSupportActionBar().setTitle("Giriş Yap");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
}
