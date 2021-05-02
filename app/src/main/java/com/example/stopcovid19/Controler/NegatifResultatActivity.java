package com.example.stopcovid19.Controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.stopcovid19.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NegatifResultatActivity extends AppCompatActivity {
    private Button btn_accueil2;

    private FloatingActionButton fab1;
    private static final int PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negatif_resultat);

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkPermission()) {
                Log.e("permission", "Permission already granted.");
            } else {
                requestPermission();
            }
        }
        btn_accueil2=(Button)findViewById(R.id.bt_accueil_2);
        btn_accueil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accueil();
            }
        });


    }
    public void accueil() {
        Intent inf =new Intent(this, HomeActivity.class);
        startActivity(inf);
    }


    public boolean checkPermission() {

        int CallPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
        int ContactPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS);

        return CallPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ContactPermissionResult == PackageManager.PERMISSION_GRANTED;

    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(NegatifResultatActivity.this, new String[]
                {
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.CALL_PHONE
                }, PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {


            case PERMISSION_REQUEST_CODE:
                fab1 = (FloatingActionButton)findViewById(R.id.fab);


                if (grantResults.length > 0) {

                    boolean CallPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean ReadContactsPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;


                    if (CallPermission && ReadContactsPermission) {

                        Toast.makeText(NegatifResultatActivity.this,
                                "Permission accepted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(NegatifResultatActivity.this,
                                "Permission denied", Toast.LENGTH_LONG).show();

                        fab1.setEnabled(false);





                    }
                    break;
                }
        }

    }
    public void call1(View view) {
        final String phoneNum = "777610764";

        String dial = "tel:" + phoneNum;
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

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