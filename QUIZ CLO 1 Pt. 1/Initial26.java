import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Line2D.Double;
import java.util.Date;

public class Initial26 extends Frame{

    public Initial26(){
      addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke base = new BasicStroke(10.0f);
        g2d.setStroke(base);

        //letter F
        int[] xf = new int[7];
        int[] yf = new int[7];

        xf[1] =  50;
        yf[1] =  50;
    
        xf[2] =  50;
        yf[2] = 300;
    
        xf[3] = 50;
        yf[3] = 50;
    
        xf[4] = 200;
        yf[4] = 50;

        xf[5] = 50;
        yf[5] = 150;

        xf[6] = 200;
        yf[6] = 150;

        //letter N
        int[] xn = new int[7];
        int[] yn = new int[7];
        xn[1] =  50;
        yn[1] =  50;
    
        xn[2] =  50;
        yn[2] = 300;
    
        xn[3] = 50;
        yn[3] = 50;
    
        xn[4] = 200;
        yn[4] = 300;

        xn[5] = 200;
        yn[5] = 50;

        xn[6] = 200;
        yn[6] = 300;

      //draw the letter F
        Line2D.Double qf1;
        Line2D.Double qf2;
        Line2D.Double qf3;
        qf1 = new Double(xf[1], yf[1], xf[2], yf[2]);
        qf2 = new Double(xf[3], yf[3], xf[4], yf[4]);
        qf3 = new Double(xf[5], yf[5], xf[6], yf[6]);

        g2d.draw(qf1);
        g2d.draw(qf2);
        g2d.draw(qf3);

        sustain(1000);

        //giving the morph
        double x[] = new double[xn.length];
        double y[] = new double[x.length];
        double alpha;

        int steps = 500;
        double stepsDouble = steps;
        for (int i=1; i<=steps; i++){
          alpha = i/stepsDouble;
    
          //Computation of the convex combinations for the five pairs of points.
          for (int j=1; j<x.length; j++)
          {
            x[j] = (1-alpha)*xf[j] + alpha*xn[j];
            y[j] = (1-alpha)*yf[j] + alpha*yn[j];
          }
    
          //Generation of the two quadratic lines defined by the control points given by the convex combinations.
          qf1 = new Double(x[1],y[1],x[2],y[2]);
          qf2 = new Double(x[3],y[3],x[4],y[4]);
          qf3 = new Double(x[5],y[5],x[6],y[6]);
    
          //Clear the window.
          clearWindow(g2d);
    
          //Draw the two quadratic lines.
          g2d.draw(qf1);
          g2d.draw(qf2);
          g2d.draw(qf3);
    
          //A short waiting time until the next frame is drawn.
          sustain(10);
    
        }
        }
    

    public static void sustain(long t)
    {
      long finish = (new Date()).getTime() + t;
      while( (new Date()).getTime() < finish ){}
    }

    public static void clearWindow(Graphics2D g)
    {
      g.setPaint(Color.white);
      g.fill(new Rectangle(0,0,270,470));
      g.setPaint(Color.black);
    }

    public static void main(String[] argv){
      Initial26 f = new Initial26();
      f.setTitle("Tugas 2.6");
      f.setSize(500, 500);
      f.setVisible(true);
    }
  
  }
