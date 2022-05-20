package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Almacenamiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacenamiento);

        //Se obtiene el boton que se ha creado en el XML para generar un evento en este caso el de guardar
        Button bntGuardar  = findViewById(R.id.btnGuardar);


        //Se crea la funcion de click para guardar la informacion que se escriba en el Edit Text
        bntGuardar.setOnClickListener(view -> {
            saveSharePrefers();
            getSharedPrefrs();
        });
    }

    private void getSharedPrefrs() {
        SharedPreferences sharedPreferences = getSharedPreferences("Contacts", Context.MODE_PRIVATE);
        String nombre = sharedPreferences.getString("Nombre","");
        String telefono = sharedPreferences.getString("Telefono","");
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, telefono, Toast.LENGTH_SHORT).show();
    }

    public void saveInfoFileIO() {
        try {
            EditText edtNombre = findViewById(R.id.edtNombre); //Se obtiene la información del texto que se escribe en el Edit Text
            FileOutputStream fileOutputStream = openFileOutput("contact.txt", Context.MODE_PRIVATE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                fileOutputStream.write(edtNombre.getText().toString().getBytes(StandardCharsets.UTF_8)); //No existe una sobre carga en la que se pueda mandar un String es por ello que se
                //transforma en bytes
            }
            fileOutputStream.close(); //Se cierra el archivo que se esta editando para que no genere errores
            edtNombre.setText("");
            Toast.makeText(this,"Se ha realizado correctamente",Toast.LENGTH_LONG).show();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSharePrefers(){
        SharedPreferences sharedPreferences = getSharedPreferences("contacts", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        EditText edtNombre = findViewById(R.id.edtNombre);
        EditText edtTelefono = findViewById(R.id.telefono);
        editor.putString("Nombre",edtNombre.getText().toString());
        editor.putString("Telefono",edtTelefono.getText().toString());
        editor.apply();
    }
}