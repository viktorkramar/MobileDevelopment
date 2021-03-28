package ua.kpi.comsys.io8316;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class DrawingDiagramFragment extends Fragment {
    private static final String ORANGE = "#FF8000";
    private static final String GREEN = "#00FF00";
    private static final String BLACK = "#000000";
    private static final int ORANGE_VALUE = 30;
    private static final int GREEN_VALUE = 30;
    private static final int BLACK_VALUE = 40;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.drawing_diagram_fragment, container, false);

        PieChart pieChart= view.findViewById(R.id.chart1);
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor(ORANGE));
        colors.add(Color.parseColor(GREEN));
        colors.add(Color.parseColor(BLACK));
        pieEntries.add(new PieEntry(ORANGE_VALUE, ""));
        pieEntries.add(new PieEntry(GREEN_VALUE, ""));
        pieEntries.add(new PieEntry(BLACK_VALUE, ""));
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(colors);
        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(true);
        pieChart.setData(pieData);
        pieDataSet.setDrawValues(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.invalidate();

        return view;
    }
}
