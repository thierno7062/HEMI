package com.example.stopcovid19.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stopcovid19.R;

public class MainActivity extends AppCompatActivity {
    private Button btn_commencer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_commencer=(Button)findViewById(R.id.btn_start);
        btn_commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
                
            }
        });
    }
    public void start(){
        Intent accueil=new Intent(this, HomeActivity.class);
        startActivity(accueil);
    }

}