import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class ErrorWindow extends Frame implements ActionListener
{
 public ErrorWindow(String title, String tekst)
 {
  super(title);
  pack();
  setLayout(new BorderLayout());
  setSize(200,150);
  Label komunikat = new Label(tekst, Label.CENTER);
  komunikat.setBounds(0,0,200,150); 
  add("Center", komunikat); 
  Button ok = new Button("OK");
  ok.addActionListener(this);
  ok.setBackground(Color.RED);
  setBackground(Color.YELLOW);
  add("South", ok);
  addWindowListener(new KalkulatorWindowAdapter());
  setVisible(true);
 }

 public void actionPerformed(ActionEvent e) 
 {
  System.exit(0);
 }
}
