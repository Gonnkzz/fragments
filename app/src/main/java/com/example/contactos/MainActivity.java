package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contacto> contactos = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();

        contactos.add(new Contacto("Juan Jose", "97112625561","juanJose@gmail.com"));
        contactos.add(new Contacto("Jese Ivan", "96316142625","jeseIvan@gmail.com"));
        contactos.add(new Contacto("Juana Crisina", "97112625561","juanaCristina@gmail.com"));
        contactos.add(new Contacto("Heydi", "97112625561","heidy@gmail.com"));

        for (Contacto contacto : contactos){
            nombres.add(contacto.getName());
        }

        ListView listaContactos = findViewById(R.id.lstContactos);
        listaContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));

        listaContactos.setOnItemClickListener((adapterView, view, i, l)->{
            Intent intent = new Intent(this, ContactoDetalle.class);
            intent.putExtra("KEY_EXTRA_CONTACTO", contactos.get(i));
            startActivity(intent);
            finish();
        });
        //nombres = contactos.stream().map(item-> item.getName()).collect(Collectors.toList());

    }
}