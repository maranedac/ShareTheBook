package cl.mac.sharethebook.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cl.mac.sharethebook.views.tabs.MyBooksFragment;
import cl.mac.sharethebook.views.tabs.SharedBooksFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return MyBooksFragment.newInstance();
            case 1:
                return SharedBooksFragment.newInstance();
            default:
                return MyBooksFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Mis Libros";
            case 1:
                return "Libros Publicados";

        }
        return null;
    }
}
