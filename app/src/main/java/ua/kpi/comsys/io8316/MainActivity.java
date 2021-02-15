package ua.kpi.comsys.io8316;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private static final int NUMBER_OF__PAGES = 2;
    private static final String[] PAGE_TITLES = new String[]{"Page 1", "Page 2"};
    private static final int[] TAB_ICONS = {R.drawable.ic_home, R.drawable.ic_two};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager = findViewById(R.id.pager);
        FragmentStateAdapter pagerAdapter = new MyPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,(tab, position) -> {
            tab.setText(PAGE_TITLES[position]);
            tab.setIcon(TAB_ICONS[position]);
        }).attach();
    }

    private static class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 1: {
                    return new FragmentTwo();
                }
                case 0:
                default:
                    return new FragmentOne();
            }
        }

        @Override
        public int getItemCount() {
            return NUMBER_OF__PAGES;
        }
    }
}