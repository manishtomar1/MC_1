package com.example.manis.mc_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by hp on 3/10/2018.
 */


public class Manage_Page_Adapter extends FragmentStatePagerAdapter {

    private String[] TABARRAY = new String[]{"ALL STUDENTS","INDIVIDUAL","REQUESTS"};
    final int TABNUMBER = 3;
    public Manage_Page_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABARRAY[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0: Log.d("inside","all Studets Fragment");
                    return new All_Students_fragment();

            case 1:
                    return new Individual_fragment();

            case 2:
                    return new Requests_fragment();


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TABNUMBER;
    }
}
