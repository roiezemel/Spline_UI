package frcsplines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FileManager {

    private String path;

    public FileManager(){}

    /**
     *
     * @param path Can be passed with "default" to load the points from a default path (current directory).
     */
    public FileManager(String path){
        this.path = validatePath(path);
    }

    /**
     *
     * @param path Can be passed with "default" to load the points from a default path (current directory).
     */
    public void setPath(String path){
        this.path = validatePath(path);
    }

    /**
     * Saves the points in a local txt file.
     * @param points
     */
    public void save(ArrayList<Point> points){
        try {
            Formatter formatter = new Formatter(path);
            for (Point p : points) {
                formatter.format("%s", p.x + "\r\n");
                formatter.format("%s", p.y + "\r\n");
            }
            formatter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the points from a local txt file.
     * @param splineType The spline type to load the points into.
     */
    public Spline load(String splineType){
        File file = new File(path);
        ArrayList<Point> points = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                points.add(new Point(Double.parseDouble(sc.next()), Double.parseDouble(sc.next())));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        switch (splineType) {
            case "BSpline":
                return new BSpline(points);
            case "HermiteSpline":
                try {
                    return new HermiteSpline(points);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Unresolved splineType! Available: BSpline, HermiteSpline");
        }
        return null;
    }

    /**
     * @param path
     * @return
     */
    private String validatePath(String path){
        return path.equals("default")?"src/frcsplines/points.txt":path + (path.endsWith(".txt")?"":".txt");
    }

}
