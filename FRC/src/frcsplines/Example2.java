package frcsplines;

public class Example2 {

    public static void main(String[] args) {

        /**
         * No graphics example to load the data from the saved file and get the motor's velocities.
         */

        FileManager fm = new FileManager("default");
        Spline spline = fm.load("BSpline"); // Loads saved points.

        // Create VelocitiesAdapter:
        VelocitiesAdapter vs = new VelocitiesAdapter(spline, 15, 0.5);
        System.out.println(vs.getNumPoints());

        double[][] toSave = new double[vs.getNumPoints()-1][2];

        // Print velocities:
        for (int i : vs.iterate()){
            double[] ves = vs.velocity(i, i < (vs.getNumPoints()-1) / 2?50:50);
            toSave[i] = ves;
            System.out.println("Right speed: " + ves[0]);
            System.out.println("Left speed: " + ves[1] + "\n");
        }

        vs.saveCSV(toSave, "src/velocities.csv");
    }

}
