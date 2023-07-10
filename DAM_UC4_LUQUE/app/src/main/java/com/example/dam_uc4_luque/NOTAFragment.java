package com.example.dam_uc4_luque;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class NOTAFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private List<Nota> notaList;
    private MyNOTARecyclerViewAdapter adapterNotas;

    private NotasInteractionListener mListener;

    public NOTAFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NOTAFragment newInstance(int columnCount) {
        NOTAFragment fragment = new NOTAFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            notaList = new ArrayList<>();
            notaList.add(new Nota("UC4","Estudiar para la evaluación de la UC4 - Caso: Notas y Listas", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Recordar", "He aparcado el coche en la calle República Argentina, no olvidarme en el parque",false, android.R.color.holo_green_light));
            notaList.add(new Nota("cumpleaños (fiesta)","no olvidar las velas", true, android.R.color.holo_orange_light));
            adapterNotas = new MyNOTARecyclerViewAdapter(notaList, mListener);
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NotasInteractionListener){
            mListener = (NotasInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "Debe implementarse NotasInteractionListener");
        }
    }



}