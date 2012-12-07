import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class InfoWindowAdapter extends WindowAdapter 
{
 InfoWindow w;

 InfoWindowAdapter(InfoWindow w) 
 {
  this.w = w; 
 }

 public void windowClosing(WindowEvent e) 
 {
  w.setVisible(false);
 }
}
