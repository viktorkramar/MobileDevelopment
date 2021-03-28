package ua.kpi.comsys.io8316;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.stream.DoubleStream;

public class DrawingGraphFragment extends Fragment {
    private static final int X_MIN = -6;
    private static final int X_MAX = 6;
    private static final double X_STEP = .5;
    private static final int NUMBER = (int) ((X_MAX - X_MIN) /X_STEP + 1);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.drawing_graph_fragment, container, false);
        GraphView graph = view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        DoubleStream.iterate(X_MIN, d -> d + X_STEP)
                .limit(NUMBER)
                .forEach(value -> series.appendData(new DataPoint(value, Math.exp(value)),true,NUMBER));
        series.setColor(Color.rgb(0,80,100));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(5);
        series.setThickness(2);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-8);
        graph.getViewport().setMaxX(8);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(450);
        graph.addSeries(series);
        graph.setTitle("y = e^x");
        graph.setTitleTextSize(50);
        graph.setTitleColor(Color.RED);
        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("X");
        gridLabel.setVerticalAxisTitle("Y");
        return view;
    }
}
