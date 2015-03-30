package net.braingang.bluetoothlab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.Locale;

/**
 * Created by gsc on 3/29/15.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {
    public static final String LOG_TAG = SectionPagerAdapter.class.getName();

    public SectionPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Log.i(LOG_TAG, "getItem:" + position);

        switch(position) {
            case 0:
                return BleScanFragment.newInstance("arg1", "arg2");
            case 1:
                return FragmentOne.newInstance("arg1", "arg2");
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.i(LOG_TAG, "getPageTitle:" + position);

        Locale locale = Locale.getDefault();

        switch(position) {
            case 0:
                return "Section 0".toUpperCase();
            case 1:
                return "Section 1".toUpperCase();
        }

        return null;
    }
}
