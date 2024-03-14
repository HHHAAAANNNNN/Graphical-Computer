import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SolarSystem22 extends JPanel implements ActionListener {

    int xmin = -200;
    int xmax = 200;
    int ymin = -200;
    int ymax = 200;
    int step = 50;
    private int angle = 0;

    public SolarSystem22() {
        Timer timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(0, 250, 500, 250); // X-axis
        g.drawLine(250, 0, 250, 500); // Y-axis

        // Draw tick marks for X-axis
        int xStep = 500 / (xmax - xmin);
        for (int x = xmin; x <= xmax; x = x + step) {
            int xPos = xStep * (x - xmin) + 50; // Adjust for padding
            g.drawLine(xPos, 245, xPos, 255);
            if (x != 0) { // Don't label origin
                g.drawString(String.valueOf(x), xPos - 5, 270); // Adjust label position
            }
        }

        // Draw tick marks for Y-axis
        int yStep = 500 / (ymax - ymin);
        for (int y = ymax; y >= ymin; y = y - step) {
            int yPos = (y - ymin) * yStep + 50; // Adjust for padding
            g.drawLine(500 / 2 - 5, yPos, 500 / 2 + 5, yPos);
            if (y != 0) { // Don't label origin
                g.drawString(String.valueOf(-y), 500 / 2 + 10, yPos - 5); // Adjust label position
            }
        }

        // Add the Sun
        g.setColor(Color.orange);
        int SunCenterX = 500 / 2; // Adjust for center position
        int SunCenterY = 250; // Adjust for center position
        int SunRadius = 40;
        g.fillOval(SunCenterX - SunRadius, SunCenterY - SunRadius, SunRadius * 2, SunRadius * 2);

        // Add the planet
        int orbitRadius = 200; // Distance from sun center to planet center
        double radians = Math.toRadians(angle);
        int PlanetCenterX = (int) (SunCenterX + orbitRadius * Math.cos(radians));
        int PlanetCenterY = (int) (SunCenterY + orbitRadius * Math.sin(radians));

        g.setColor(Color.black);
        int PlanetRadius = 10;
        g.fillOval(PlanetCenterX - PlanetRadius, PlanetCenterY - PlanetRadius, PlanetRadius * 2, PlanetRadius * 2);

        // Show where the Planet after 1/3 of its orbit
        g.setColor(Color.black);
        double radians2 = Math.toRadians(240);
        int PlanetCenterX2 = (int) (SunCenterX + orbitRadius * Math.cos(radians2));
        int PlanetCenterY2 = (int) (SunCenterY + orbitRadius * Math.sin(radians2));
        int PlanetRadius2 = 15;
        g.drawOval(PlanetCenterX2 - PlanetRadius2, PlanetCenterY2 - PlanetRadius2, PlanetRadius2 * 2, PlanetRadius2 * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle = (angle - 1) % 365;
        repaint();
    }

    public static void main(String[] argv) {
        JFrame frame = new JFrame("Tugas 2.2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        SolarSystem22 panel = new SolarSystem22();
        frame.add(panel);
        frame.setVisible(true);
    }
}