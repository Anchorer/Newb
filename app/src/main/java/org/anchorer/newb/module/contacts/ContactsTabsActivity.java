package org.anchorer.newb.module.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.anchorer.newb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactsTabsActivity: Display Tabs of
 * Created by Anchorer on 16/4/28.
 */
public class ContactsTabsActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_tabs);
        initViews();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_contacts_toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.activity_contacts_viewpager);
        CustomPagerAdapter mAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(ContactsFragment.getInstance(20));
        mAdapter.addFragment(ContactsFragment.getInstance(5));
        mViewPager.setAdapter(mAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.activity_contacts_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * Custom PagerAdapter
     */
    class CustomPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public CustomPagerAdapter(FragmentManager manager) {
            super(manager);
            mFragments = new ArrayList<>();
        }

        public void addFragment(Fragment fragment) {
            mFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "TAB " + (position + 1);
        }
    }
}
