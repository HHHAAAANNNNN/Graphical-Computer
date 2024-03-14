import java. awt.*;
import java.awt.geom.*;

public class GeneralPathCar32 extends Frame {
    GeneralPathCar32(){
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke base = new BasicStroke(4.0f);
        g2d.setStroke(base);

        Stroke dashed = new BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        GeneralPath gp2 = new GeneralPath();

        gp2.moveTo(50, 300);
        gp2.lineTo(100, 300);
        gp2.quadTo(125, 330, 150, 300); 
        gp2.lineTo(250, 300);
        gp2.quadTo(275, 330, 300, 300);
        gp2.lineTo(330, 300);
        gp2.quadTo(330, 280, 320, 280);
        gp2.lineTo(310, 220);
        gp2.quadTo(310, 200, 290, 200);
        gp2.lineTo(150, 200);
        gp2.quadTo(140, 200, 140, 205);
        gp2.lineTo(100, 245);
        gp2.quadTo(95, 250, 90, 250);
        gp2.lineTo(60, 250);
        gp2.quadTo(50, 250, 50, 255);
        gp2.lineTo(50, 300);
        //
        g2d.draw(gp2);
        g2d.setStroke(new BasicStroke(1.0f));
        Coordinate(400, 400, g2d);
    }

    public static void Coordinate(int xmax, int ymax, Graphics2D g2d){
        int xOffset = 35;
        int yOffset = 60;
        int step = 40;
        String s;

        Font f = g2d.getFont();
        g2d.setFont(new Font("sansserif", Font.PLAIN, 9));

        //add notes for x-axis
        g2d.drawLine(xOffset, yOffset, xmax, yOffset);
        for (int i=xOffset+step; i<=xmax; i=i+step){
        g2d.drawLine(i, yOffset-2, i, yOffset+2);
        g2d.drawString(String.valueOf(i), i-7, yOffset-7);
        }

        //add notes for y-axis
        g2d.drawLine(xOffset, yOffset, xOffset, ymax);
        s ="  ";
        for (int i=yOffset+step; i<=ymax; i=i+step){
        g2d.drawLine(xOffset-2,i,xOffset+2,i);
        if (i>99){s="";}
        g2d.drawString(s+String.valueOf(i),xOffset-20,i+5);
        }

        g2d.setFont(f);
  }

  public static void main(String[] argv){
    GeneralPathCar32 GPC = new GeneralPathCar32();
    GPC.setTitle("Tugas 3.2");
    GPC.setSize(500, 500);
    GPC.setVisible(true);
  }
}