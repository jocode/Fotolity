package com.example.fotolity.views.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fotolity.R;
import com.example.fotolity.adapter.PictureAdapterRecyclerView;
import com.example.fotolity.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        showToolbar(getResources().getString(R.string.item_home), false, view);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView adapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture, getActivity());
        recyclerView.setAdapter(adapterRecyclerView);

        return view;
    }

    public ArrayList<Picture>  buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://tuspuzzles.es/puzzles/original/atardecer-568470fbef6d4.jpg", "Johan", "4 semanas", "10 Me Gusta"));
        pictures.add(new Picture("https://s-media-cache-ak0.pinimg.com/236x/eb/6b/74/eb6b744cf2c29affa41bcbf4cc7443c4.jpg", "Juan Mosquera", "4 semanas", "2 Me Gusta"));
        pictures.add(new Picture("https://s-media-cache-ak0.pinimg.com/originals/84/e6/a0/84e6a04e1fc11abaf1c79ccde4d2d422.jpg", "Doly", "4 semanas", "1 Me Gusta"));
        pictures.add(new Picture("https://www.tinec.com.mx/wp-content/uploads/2013/10/paisajes-marinos-2107-1080x720.jpg", "Paz", "4 semanas", "6 Me Gusta"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiNf_HCSW0YcSs_Hv7zvLwhUrscsJS3Z5vjasutRbII07JcNDN", "Teodoro", "4 semanas", "20 Me Gusta"));

        return pictures;
    }


    public void showToolbar(String title, boolean upButton, View view){
        /**
         * Es importante colocar estas dos lineas, para que el toolbar tenga soporte en versiones anteriores a Lollipop
         */
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        // Habilitamos el botón de Up en el Toolbar
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


}
