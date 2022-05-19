package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ViewPageActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager2 pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        tabs = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.pager);

        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());


        pager.setAdapter(new ViewPagerAdapter(this, fragments));

        new TabLayoutMediator(tabs, pager,
                (tab, position) -> tab.setText("TAB"+(position+1))
        ).attach();

    }
}