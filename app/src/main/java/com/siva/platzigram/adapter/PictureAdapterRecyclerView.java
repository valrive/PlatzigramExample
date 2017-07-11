package com.siva.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.siva.platzigram.R;
import com.siva.platzigram.actividades.PictureDetailActivity;
import com.siva.platzigram.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by valentín Rivera on 06/07/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    //el arreglo de pictures
    private ArrayList<Picture> pictures;
    //el resource será el layout carview por separado
    private int resource;
    //la actividad desde dónde se está llamando PictureAdapterRecyclerView
    // el obj Activity nos va a ayudar cuando queramos poner la imagen
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    //Inicializará la clase PictureViewHolder
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Mostramos el layout en pantalla y convertimos un xml en un view
        //resource es mi cardView Picture.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    //Aquí se realiza el paso de datos
    public void onBindViewHolder(PictureViewHolder holder, final int position) {
        Picture picture = pictures.get(position);
        //https://square.github.io/picasso/#download
        //Picasso.with(activity).load(picture.getPicture()).placeholder(R.drawable.heart).error(R.drawable.logotipo_buap).into(holder.pictureCard);
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);
        holder.usernameCard.setText(picture.getUsername());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                //Hacemos una validación ya que las transiciones no funcionanen SDK < 5 y provoca crash
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transitionName_Pictura)).toBundle());
                }
                else
                //Toast.makeText(activity, "" + position, Toast.LENGTH_SHORT).show();
                //intent.putExtra("", position);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }



    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;
        // checkbox

        public PictureViewHolder(View itemView) {
            super(itemView);
            //itemView es el cardView que recibimos como parametro
            pictureCard = (ImageView)itemView.findViewById(R.id.pictureCard);
            usernameCard = (TextView)itemView.findViewById(R.id.usernameCard);
            timeCard = (TextView)itemView.findViewById(R.id.timeCard);
            likeNumberCard = (TextView)itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
