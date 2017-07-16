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

        showToolbar("Home", false, view);
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
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiNf_HCSW0YcSs_Hv7zvLwhUrscsJS3Z5vjasutRbII07JcNDN", "Johan", "4 semanas", "10"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiNf_HCSW0YcSs_Hv7zvLwhUrscsJS3Z5vjasutRbII07JcNDN", "Juan Mosquera", "4 semanas", "10"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiNf_HCSW0YcSs_Hv7zvLwhUrscsJS3Z5vjasutRbII07JcNDN", "Doly", "4 semanas", "10"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiNf_HCSW0YcSs_Hv7zvLwhUrscsJS3Z5vjasutRbII07JcNDN", "Paz", "4 semanas", "10"));
        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiNf_HCSW0YcSs_Hv7zvLwhUrscsJS3Z5vjasutRbII07JcNDN", "Teodoro", "4 semanas", "10"));

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
