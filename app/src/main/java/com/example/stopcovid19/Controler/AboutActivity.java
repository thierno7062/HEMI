package com.example.stopcovid19.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.stopcovid19.R;
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void start_about() {
        Intent about =new Intent(this, AboutActivity.class);
        startActivity(about);
    }
    public void start_contact() {
        Intent contact =new Intent(this, ContactActivity.class);
        startActivity(contact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.option_de_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_about:
                start_about();
                return true;
            case R.id.item_contact:
                start_contact();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }



}