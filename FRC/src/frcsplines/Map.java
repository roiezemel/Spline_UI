package frcsplines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Formatter;
import java.util.LinkedList;

public class Map extends JPanel implements MouseListener, MouseMotionListener {

    boolean save = false;
    String savePath = "src/PathPlanning/map.txt";
    Image map = getImage("fieldImage.jpg");
    LinkedList<Rectangle> recs = new LinkedList<>();
    int[] dragged = null;
    int[] eraser = null;
    int mouseX;
    int mouseY;

    public Map(){

        map.getWidth( this);
        map.getHeight(this);
        wait(1000);

        JFrame frame = new JFrame("Map");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(map.getWidth(this), map.getHeight(this) + 30);
        frame.setVisible(true);
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (save) {
                    try {
                        Formatter file = new Formatter(savePath);
                        for (int i = 0; i < frame.getHeight(); i++) {
                            for (int j = 0; j < frame.getWidth(); j++) {
                                boolean intersects = false;
                                for (Rectangle rect : recs) {
                                    if (rect.intersects(new Rectangle(j, i, 1, 1))) {
                                        intersects = true;
                                        break;
                                    }
                                }
                                file.format("%s", intersects ? 1 : 0);
                            }
                            file.format("%s", "\r\n");
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * Wait for milliSeconds.
     *
     * @param milliSeconds
     */
    private void wait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an Image object.
     *
     * @param path
     * @return
     */
    public Image getImage(String path) {
        Image tempImage = null;
        try {
            URL imageURL = FRCNavigator.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        return tempImage;
    }

    private Rectangle getRect(int[] rect) {
        int x1 = rect[0] < rect[2]?rect[0]:rect[2];
        int y1 = rect[1] < rect[3]?rect[1]:rect[3];
        int x2 = rect[0] > rect[2]?rect[0]:rect[2];
        int y2 = rect[1] > rect[3]?rect[1]:rect[3];
        return new Rectangle(x1, y1, x2 - x1, y2 - y1);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map, 0, 0, this);

        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(4));
        if (dragged != null) {
            g2d.draw(getRect(dragged));
            g2d.setColor(new Color(1f, 0.1f, 0, 0.5f));
            g2d.fill(getRect(dragged));
        }

        for (Rectangle rect : recs) {
            g2d.setColor(Color.red);
            g2d.draw(rect);
            g2d.setColor(new Color(1f, 0.1f, 0, 0.5f));
            g2d.fill(rect);
        }

        if (eraser != null) {
            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(Color.blue);
            g2d.draw(getRect(eraser));
            g2d.setColor(new Color(0, 0.3f, 1f, 0.5f));
            g2d.fill(getRect(eraser));
        }

        g2d.setColor(Color.gray);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        g2d.drawLine(mouseX, 0, mouseX, map.getHeight(this) + 30);
        g2d.drawLine(0, mouseY, map.getWidth(this), mouseY);
    }

    private void erase() {
        for (int i = recs.size()-1; i>=0; i--) {
            if (getRect(eraser).intersects(recs.get(i))) {
                recs.remove(i);
                break;
            }
        }
    }

    public static void main(String[] args){
        new Map();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            eraser = new int[] {e.getX(), e.getY(), e.getX() + 1, e.getY() + 1};
            erase();
            repaint();
        }
        else
            dragged = new int[] {e.getX(), e.getY(), 0, 0};
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (dragged != null) {
            recs.add(getRect(dragged));
            dragged = null;
        }
        if (eraser != null) {
            eraser = null;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragged != null) {
            dragged[2] = e.getX();
            dragged[3] = e.getY();
        }

        if (eraser != null) {
            eraser[2] = e.getX();
            eraser[3] = e.getY();
            erase();
        }

        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }
}
