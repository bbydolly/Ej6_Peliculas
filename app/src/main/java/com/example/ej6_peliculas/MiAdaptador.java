package com.example.ej6_peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends  RecyclerView.Adapter<MiAdaptador.MyViewHolder>{


    //Peliculas array
    ArrayList<Pelicula> pelis;

    //Constructor de MiAdaptador
    public MiAdaptador(ArrayList<Pelicula> pelis) {
        this.pelis = pelis;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View elemento= LayoutInflater.from(parent.getContext()).inflate(R.layout.celda,
                parent, false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh;
    }

    private int selectedPos=RecyclerView.NO_POSITION;

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pelicula peli=this.pelis.get(position);
        //Text View
        holder.getTituloPeli().setText(peli.getTitulo());
        holder.getNombreDirector().setText(peli.getDirector());
        holder.getClasificacion().setImageResource(peli.getClasi()); // es portada
        holder.getFotoPrincipal().setImageResource(peli.getPortada());

        if (selectedPos == position)
            holder.itemView.setBackgroundResource(R.color.seleccionado);
        else holder.itemView.setBackgroundResource(R.color.colorcelda);
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    //Inner class
    public class MyViewHolder extends RecyclerView.ViewHolder {


        //Propiedades de la clase
        private TextView nombreDirector;
        private TextView tituloPeli;
        private ImageView clasificacion;
        private ImageView fotoPrincipal;

        public MyViewHolder(View viewElemento) {
            super(viewElemento);
            this.nombreDirector = viewElemento.findViewById(R.id.tvNombreAutor);
            this.tituloPeli = viewElemento.findViewById(R.id.tvTituloPeli);
            this.fotoPrincipal = viewElemento.findViewById(R.id.ivCartelPeli);
            this.clasificacion = viewElemento.findViewById(R.id.ivLogo);
        }

        public TextView getNombreDirector() {
            return nombreDirector;
        }

        public TextView getTituloPeli() {
            return tituloPeli;
        }

        public ImageView getClasificacion() {
            return clasificacion;
        }
        public ImageView getFotoPrincipal() {
            return fotoPrincipal;
        }
    }
}
