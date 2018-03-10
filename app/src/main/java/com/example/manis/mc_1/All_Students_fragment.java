package com.example.manis.mc_1;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class All_Students_fragment extends android.support.v4.app.Fragment {


    public All_Students_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.all_students_fragment, container,
                false);
        Spinner mSpinner=(Spinner)rootView.findViewById(R.id.spinner_degree);

        String[] mDegrees=getResources().getStringArray(R.array.Degrees);
        Log.d("Fragment","Inside all students fragment **********");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.text,R.id.text_view_spinner_layout, mDegrees);

        mSpinner.setAdapter(adapter);


        //Drop Down for Branch

        Spinner mSpinner_Branch=(Spinner)rootView.findViewById(R.id.spinner_branch);

        String[] mBranch=getResources().getStringArray(R.array.Branch);
        Log.d("Fragment","Inside all students fragment **********");
        ArrayAdapter<String> mBranchAdapter=new ArrayAdapter<String>(getActivity(),R.layout.text,R.id.text_view_spinner_layout, mBranch);

        mSpinner_Branch.setAdapter(mBranchAdapter);


        //Drop Down for Gender

        Spinner mSpinner_Gender=(Spinner)rootView.findViewById(R.id.spinner_gender);

        String[] mGender=getResources().getStringArray(R.array.Gender);
        Log.d("Fragment","Inside all students fragment **********");
        ArrayAdapter<String> mGenderAdapter=new ArrayAdapter<String>(getActivity(),R.layout.text,R.id.text_view_spinner_layout, mGender);

        mSpinner_Gender.setAdapter(mGenderAdapter);


        //Drop Down for Jobs in Hand

        Spinner mSpinner_JobsInHand=(Spinner)rootView.findViewById(R.id.spinner_jobsInHand);

        String[] mJobsBool=getResources().getStringArray(R.array.Boolean_Yes_No);
        Log.d("Fragment","Inside all students fragment **********");
        ArrayAdapter<String> mJobInHandAdapter=new ArrayAdapter<String>(getActivity(),R.layout.text,R.id.text_view_spinner_layout, mJobsBool);

        mSpinner_JobsInHand.setAdapter(mJobInHandAdapter);


        return rootView;
    }

}
