import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class SuperListener implements ActionListener 
{
 Program p;

 SuperListener(Program p) 
 { 
  this.p = p; 
 }

 public void actionPerformed(ActionEvent e) 
 {
  p.licz(e.getActionCommand());
  p.requestFocus(); 
 }
}
