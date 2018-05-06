package com.example.dico2.digitalcoordinator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class ScreenSlidePagerActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        Intent testargs = getIntent();
        int ssn = testargs.getIntExtra(ScreenSlidePageFragment.PATIENT_OBJECT, 0);

                // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), ssn);



        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private int ssn;
        public ScreenSlidePagerAdapter(FragmentManager fm, int ssn) {
            super(fm);
            this.ssn = ssn;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ScreenSlidePageFragment();
            Bundle args = new Bundle();



            args.putInt(ScreenSlidePageFragment.ARG_OBJECT, position + 1);
            args.putInt(ScreenSlidePageFragment.PATIENT_OBJECT, this.ssn);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {
            Patient patient = Data.getInstance().getPatient(this.ssn);
            int size = Data.getInstance().getHospital().suggestedUnits(patient).size();
            return size;
        }
    }
}