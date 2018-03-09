package com.example.manis.mc_1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.Calendar;

public class Admin_Job_Post extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static final String[] DEGREES = new String[]{"B.Tech","M.Tech","Ph.D"};
    private EditText mCompanyName, mLastDateToApply, mDegree, mCGPA, mLocation;
    private Button mPost;
    private String required;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__job__post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         required = getString(R.string.required);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //EventDate DatePicker

        final EditText ET_EVENT_DATE = (EditText)findViewById(R.id.edit_text_Event_Date);

        ET_EVENT_DATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mCurrentDate = Calendar.getInstance();
                int mYear = mCurrentDate.get(Calendar.YEAR);
                int mMonth = mCurrentDate.get(Calendar.MONTH);
                int mDay = mCurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(Admin_Job_Post.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        ET_EVENT_DATE.setText(i2+"/"+(i1+1)+"/"+i);

                    }
                },mYear,mMonth,mDay);
                mDatePicker.show();


            }
        });




        //LastDate DatePicker

        final EditText ED_LAST_DATE = (EditText)findViewById(R.id.Edit_text_Last_Date);

        ED_LAST_DATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mCurrentDate = Calendar.getInstance();
                int mYear = mCurrentDate.get(Calendar.YEAR);
                int mMonth = mCurrentDate.get(Calendar.MONTH);
                int mDay = mCurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(Admin_Job_Post.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        ED_LAST_DATE.setText(i2+"/"+(i1+1)+"/"+i);

                    }
                },mYear,mMonth,mDay);
                mDatePicker.show();


            }
        });


        MultiAutoCompleteTextView mText_view_Degrees = (MultiAutoCompleteTextView)findViewById(R.id.AC_text_view_Degrees);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.text,DEGREES);

        mText_view_Degrees.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mText_view_Degrees.setAdapter(mAdapter);



        mCompanyName = (EditText) findViewById(R.id.edit_text_Company_Name);
        mLastDateToApply = (EditText)findViewById(R.id.Edit_text_Last_Date);
        mDegree = (EditText)findViewById(R.id.AC_text_view_Degrees);
        mCGPA = (EditText)findViewById(R.id.CGPARequired);

        mPost = (Button)findViewById(R.id.Button_Post);
        mLocation = (EditText)findViewById(R.id.edit_text_Location);

       mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCompanyName.getText().length() == 0) {
                    Log.d("Inside OnClick", "Inside onClick Company Name empty");
                    mCompanyName.setError(required);
                }
                else
                {
                    mCompanyName.setError(null);
                }


                if (mLastDateToApply.getText().length() == 0) {
                    Log.d("Inside OnClick", "Inside onClick LastDate empty");
                    mLastDateToApply.setError(required);
                }
                else
                {
                    mLastDateToApply.setError(null);
                }



                if (mDegree.getText().length() == 0) {
                    Log.d("Inside OnClick", "Inside onClick Degree empty");
                    mDegree.setError(required);
                }
                else
                {
                    mDegree.setError(null);
                }


                if (mCGPA.getText().length() == 0) {
                    Log.d("Inside OnClick", "Inside onClick Cgpa empty");
                    mCGPA.setError(required);
                }
                else
                {
                    mCGPA.setError(null);
                }


                if (mLocation.getText().length() == 0) {
                    Log.d("Inside OnClick", "Inside onClick Location empty");
                    mLocation.setError(required);
                }
                else
                {
                    mLocation.setError(null);
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin__job__post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
