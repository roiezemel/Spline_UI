package frcsplines;

import java.util.ArrayList;

public interface Spline {

    double interpolate_X(double percent);

    double interpolate_Y(double percent);

    double getLength();

    ArrayList<Point> getPoints();

}
