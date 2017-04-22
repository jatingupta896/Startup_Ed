package com.animator_abhi.gcethackathon.Post;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.animator_abhi.gcethackathon.Login.Prefs;
import com.animator_abhi.gcethackathon.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
String user="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user= Prefs.getUserId(MainActivity.this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);// Setting ViewPager for each Tabs
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);// Set Tabs inside Toolbar
        tabs.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.action_add:
                startActivity(new Intent(MainActivity.this, Upload_Data.class));
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new CardContentFragment(), "Projects");
        adapter.addFragment(new CompanyFragment(), "Hot Shot");
        adapter.addFragment(new MyProfileFragment(), "My Profile");
        viewPager.setAdapter(adapter);
    }

    public class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
          //  ImageView imv;
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);


        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
