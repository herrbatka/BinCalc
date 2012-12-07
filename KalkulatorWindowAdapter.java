import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class KalkulatorWindowAdapter extends WindowAdapter 
{
 public void windowClosing(WindowEvent e) 
 {
  System.exit(0);
 }
}
