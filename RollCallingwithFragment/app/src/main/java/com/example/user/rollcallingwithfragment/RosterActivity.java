package com.example.user.rollcallingwithfragment;

import android.app.Activity;
import android.os.Bundle;



public class RosterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);
//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction().add(R.id.container, new RosterFragment()).commit();
//        }
    }
}
