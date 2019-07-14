package com.ashish.earthquake;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EarthquakeMainActivity extends AppCompatActivity {

    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";
    EarthquakeListFragment mEarthquakeListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_main);

        FragmentManager fm = getSupportFragmentManager();
/**
 *  Android will automatically re-add any Fragments that
 * have previously been added after a configuration change,
 * so only add it if this isn't an automatic restart.
 */
        if (savedInstanceState == null) {
            FragmentTransaction ft = fm.beginTransaction();
            mEarthquakeListFragment = new EarthquakeListFragment();
            ft.add(R.id.main_activity_frame,
                    mEarthquakeListFragment, TAG_LIST_FRAGMENT);
            ft.commitNow();
        } else {
            mEarthquakeListFragment =
                    (EarthquakeListFragment)fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }
        Date now = Calendar.getInstance().getTime();
        List<Earthquake> dummyQuakes = new ArrayList<Earthquake>(0);
        dummyQuakes.add(new Earthquake("0", now, "San Jose", null, 7.3, null));
        dummyQuakes.add(new Earthquake("1", now, "LA", null, 6.5, null));
        dummyQuakes.add(new Earthquake("2", now, "Africa", null, 10, null));
        dummyQuakes.add(new Earthquake("3", now, "Manitoba", null, 1, null));
        dummyQuakes.add(new Earthquake("4", now, "NYC", null, 3.4, null));
        dummyQuakes.add(new Earthquake("5", now, "California", null, 5.6, null));
        dummyQuakes.add(new Earthquake("6", now, "Palace", null, 7, null));
        dummyQuakes.add(new Earthquake("7", now, "Place", null, 3.2, null));
        dummyQuakes.add(new Earthquake("8", now, "America", null, 1.6, null));
        dummyQuakes.add(new Earthquake("9", now, "Brazil", null, 2.1, null));
        dummyQuakes.add(new Earthquake("10", now, "Argentina", null, 5.4, null));
        dummyQuakes.add(new Earthquake("11", now, "Canada", null, 4.7, null));
        dummyQuakes.add(new Earthquake("12", now, "Indonesia", null, 8, null));
        dummyQuakes.add(new Earthquake("13", now, "Cali", null, 9, null));
        dummyQuakes.add(new Earthquake("14", now, "Bali", null, 6, null));
        mEarthquakeListFragment.setEarthquakes(dummyQuakes);
    }
}
