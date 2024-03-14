import java.awt.*;
import java.awt.geom.*;

public class GeneralPathCar21 extends Frame {
    GeneralPathCar21(){
    addWindowListener(new MyFinishWindow());
  }

  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

    BasicStroke base = new BasicStroke(4.0f);
    g2d.setStroke(base);

    GeneralPath gp2 = new GeneralPath();

    //starts from upper-left
    gp2.moveTo(70, 150);
    gp2.lineTo(70, 250);
    gp2.curveTo(70, 250, 70, 300, 120, 300);
    gp2.lineTo(320, 300);
    gp2.curveTo(320, 300, 370, 300, 370, 250);
    gp2.lineTo(370, 150);
    gp2.curveTo(370, 150, 370, 100, 320, 100);
    gp2.lineTo(120, 100);
    gp2.curveTo(120, 100, 70, 100, 70, 150);

    //draw the rectangle lines and the coordinates
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
    GeneralPathCar21 GPC21 = new GeneralPathCar21();
    GPC21.setTitle("Tugas 2.1");
    GPC21.setSize(500, 500);
    GPC21.setVisible(true);
  }
}