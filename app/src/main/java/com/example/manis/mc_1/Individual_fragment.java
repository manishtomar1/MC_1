package com.example.manis.mc_1;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Individual_fragment extends android.support.v4.app.Fragment{


    public Individual_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.individual_fragment, container,
                false);

        //Spinner for search by:
        Spinner mSpinner_searchby=(Spinner)rootView.findViewById(R.id.spinner_searchby);

        String[] mSearchby=getResources().getStringArray(R.array.Searchby);
        ArrayAdapter<String> mSearchbyAdapter=new ArrayAdapter<String>(getActivity(),R.layout.text,R.id.text_view_spinner_layout, mSearchby);

        mSpinner_searchby.setAdapter(mSearchbyAdapter);

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.requests_fragment, container, false);
        return rootView;
    }
}
