package com.example.diegovillalta.myconcerts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;


import com.google.android.gms.maps.SupportMapFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enable Local Datastore.

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("My Concerts"));
        tabLayout.addTab(tabLayout.newTab().setText("Maps"));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }




    public class MyAdapter extends FragmentPagerAdapter{


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
      //  @Override
       // public CharSequence getPageTitle(int position) {

       //     if (position == 0) {

      //          return "MyConcerts";
      //      } else {
       //         return "Map";
      //      }

     //   }
        @Override
        public Fragment getItem(int i) {

            if (i == 0) {
                return new NewsFragment();
            } else {
               Fragment mapFragment = new SupportMapFragment();
                return mapFragment;
            }



        }



        @Override
        public int getCount() {
            return 2;
        }
    }


}
