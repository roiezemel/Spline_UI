package PathPlanning;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ViewMap extends JPanel {

    LinkedList<int[]> grid = new LinkedList<>();

    public ViewMap() {
        load();
        JFrame frame = new JFrame("View Map");
        frame.add(this);
        frame.setVisible(true);
        frame.setSize(grid.get(0).length, grid.size());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        repaint();
    }

    private void load() {
        File file = new File("src/PathPlanning/map.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                int[] bLine = new int[line.length()];
                for (int i = 0; i<bLine.length; i++) {
                    bLine[i] = Integer.parseInt(line.charAt(i) + "");
                }
                grid.add(bLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        for (int i = 0; i<grid.size(); i++) {
            for (int j = 0; j<grid.get(i).length; j++) {
                g2d.setColor(grid.get(i)[j] == 0?Color.gray: Color.BLACK);
                g2d.fillRect(j, i, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        new ViewMap();
    }


}
