import java.awt.event.*;

public class MyFinishWindow extends WindowAdapter{
    public void WindowClosing (WindowEvent e){
        System.exit(0);
    }
}