package com.siva.platzigram.actividades.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siva.platzigram.R;
import com.siva.platzigram.adapter.PictureAdapterRecyclerView;
import com.siva.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);
        RecyclerView picturesRecycler = (RecyclerView)view.findViewById(R.id.pictureprofileRecycler);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //Perimte hacer scroll de manera vertical
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.razapitbull.com/wp-content/uploads/2013/12/Perro-pitbull-atado.jpg", "Valentín Rivera", "4 días", "3 Me Gusta"));
        pictures.add(new Picture("https://misanimales.com/wp-content/uploads/2015/01/american-pitbull-terrier-3.jpg", "Lucero Rivera", "6 días", "2 Me Gusta"));
        pictures.add(new Picture("https://t2.ea.ltmcdn.com/es/images/9/8/2/img_razas_de_perros_pitbull_20289_paso_5_600.jpg", "Pedro Rivera", "43 días", "1 Me Gusta"));
        pictures.add(new Picture("https://i2.wp.com/www.lanetanoticias.com/wp-content/uploads/2016/09/cachoror-pitbull.jpg?fit=1600%2C1067", "Asucena Rivera", "9 días", "30 Me Gusta"));
        pictures.add(new Picture("https://comoadiestraraunperro.com/wp-content/uploads/2015/11/pit-bull.jpg", "Jair Rivera", "4 días", "96 Me Gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upBoton, View view){
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        //para que el toolbar pueda verse bien en versiones anteriores a lollipop
        //ocupamos casteo para obtener el toolbar desde el fragment
        //solo sirve para fragments
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBoton);
    }

}
