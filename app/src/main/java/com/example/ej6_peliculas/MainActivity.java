package com.example.ej6_peliculas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


//TODO no funciona
public class MainActivity extends AppCompatActivity {

    Datos d;
    public RecyclerView rv;
    public ArrayList<Pelicula> pelis;
    public MiAdaptador miAdaptador;
    RecyclerView.LayoutManager miLayoutManager;//Determina como se distribuyen las celdas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       d =new Datos();
        pelis= d.rellenaPeliculas();
        //Creo el adaptador, que va a cargar el contenido de cada una de las pelis a mi Celda.xml
        miAdaptador=new MiAdaptador(pelis);
        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(miAdaptador);



        //Crear el adaptador



    }
}