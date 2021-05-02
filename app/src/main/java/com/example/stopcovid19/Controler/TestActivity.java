package com.example.stopcovid19.Controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stopcovid19.Model.DBHelper;
import com.example.stopcovid19.Model.info_personnelles;
import com.example.stopcovid19.R;
public class TestActivity extends AppCompatActivity {
    private Button btn_enregistrer;
    private EditText nom,prenom,mail,age,address,phone;

    DBHelper h=new DBHelper(TestActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        //-------------------------
        btn_enregistrer=(Button)findViewById(R.id.btn_register);
        nom=(EditText)findViewById(R.id.et_nom);
        prenom=(EditText)findViewById(R.id.et_reg_prenom);
        mail=(EditText)findViewById(R.id.et_reg_email);
        age=(EditText)findViewById(R.id.et_reg_age);
        address=(EditText)findViewById(R.id.et_reg_address);
        phone=(EditText)findViewById(R.id.et_reg_phone);


        btn_enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nom.getText().toString().isEmpty() && !prenom.getText().toString().isEmpty()
                        && !mail.getText().toString().isEmpty() && !age.getText().toString().isEmpty()
                        && !address.getText().toString().isEmpty() && !phone.getText().toString().isEmpty())
                {
                    info_personnelles p = new info_personnelles(nom.getText().toString(), prenom.getText().toString(),
                            mail.getText().toString(), Integer.parseInt(age.getText().toString()),
                            address.getText().toString(), Integer.parseInt(phone.getText().toString()));
                    h.insertProduct(p);
                    Intent i = new Intent(TestActivity.this, QCMActivity.class);
                    startActivity(i);

                    Toast.makeText(TestActivity.this,"Veillez répondre au questionnaire suivant par OUI ou NON",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(TestActivity.this,"erreur!!!!!!Veillez remplir tous les champ d'abord",Toast.LENGTH_LONG).show();
                }
            }
        });
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