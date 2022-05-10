package com.example.contactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ContactoDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_detalle);
        Bundle extras = getIntent().getExtras();
        Contacto data = (Contacto) extras.get("KEY_EXTRA_CONTACTO");

        TextView txtName = findViewById(R.id.name);
        TextView txtPhoneNumber = findViewById(R.id.phoneNumber);
        TextView txtEmail = findViewById(R.id.email);

        txtName.setText(data.getName());
        txtPhoneNumber.setText(data.getPhoneNumber());
        txtEmail.setText(data.getEmail());

        LinearLayout llPhoneNumber = findViewById(R.id.llPhoneNumber);
        LinearLayout llEmail = findViewById(R.id.llEmail);

        llPhoneNumber.setOnClickListener(view ->{
                Intent i = new Intent(Intent.ACTION_DIAL);
                String telephone = txtPhoneNumber.getText().toString();
                i.setData(Uri.parse("tel:" + telephone));
                startActivity(i);
        });

        llEmail.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            String email = txtEmail.getText().toString();

            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, email);
            startActivity(i);
        });
        registerForContextMenu(txtName);

    }

  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent i = new Intent((this, MainActivity.class));
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate((R.menu.oprtions_menu), menu);
        return true;
       // return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.miAbout:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miSetting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return  true;
        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate((R.menu.oprtions_menu),menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.miAbout:
                Toast.makeText(this, "About", Toast.LENGTH_LONG).show();
                break;
            case R.id.miSetting:
                Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return  true;
    }
}