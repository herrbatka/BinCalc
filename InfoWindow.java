import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class InfoWindow extends Frame
{
 public InfoWindow(String title, String tekst)
 {
  super(title);
  pack();
  setLayout(new BorderLayout());
  setSize(200,150);
  Label komunikat = new Label(tekst, Label.CENTER);
  komunikat.setBounds(0,0,200,150); 
  add("Center", komunikat); 
  setBackground(Color.GREEN);
  addWindowListener(new InfoWindowAdapter(this));
 }
}
