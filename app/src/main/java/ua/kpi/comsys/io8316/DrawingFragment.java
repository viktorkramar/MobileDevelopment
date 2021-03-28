package ua.kpi.comsys.io8316;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DrawingFragment extends Fragment {
    private static final int NUMBER_OF__PAGES = 2;
    private static final String[] PAGE_TITLES = new String[]{"Graph", "Diagram"};
    private static final int[] TAB_ICONS = {R.drawable.ic_graph, R.drawable.ic_diagram};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.drawing_fragment, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.pager2);
        FragmentStateAdapter pagerAdapter = new DrawingFragment.MyPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout2);
        new TabLayoutMediator(tabLayout, viewPager,(tab, position) -> {
            tab.setText(PAGE_TITLES[position]);
            tab.setIcon(TAB_ICONS[position]);
        }).attach();
        return view;
    }

    private static class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 1: {
                    return new DrawingDiagramFragment();
                }
                case 0:
                default:
                    return new DrawingGraphFragment();
            }
        }

        @Override
        public int getItemCount() {
            return NUMBER_OF__PAGES;
        }
    }

}
