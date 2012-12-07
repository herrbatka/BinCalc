import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class CalcKeyListener implements KeyListener
{
 Program p;

 CalcKeyListener(Program p) 
 { 
  this.p = p; 
 }

 @Override
 public void keyPressed(KeyEvent evt)
 {}

 @Override
 public void keyReleased(KeyEvent evt)
 {
  if(evt.getKeyChar() == '1')
  {
   p.licz("1");
  }
  else if(evt.getKeyChar() == '0')
  {
   p.licz("0");
  }
  else if(evt.getKeyChar() == '+')
  {
   p.licz("+");
  }
  else if(evt.getKeyChar() == '-')
  {
   p.licz("-");
  }
  else if(evt.getKeyChar() == '*')
  {
   p.licz("*");
  }
  else if(evt.getKeyChar() == '/')
  {
   p.licz("/");
  }
  else if(evt.getKeyChar() == '%')
  {
   p.licz("%");
  }
  else if(evt.getKeyChar() == 'c')
  {
   p.licz("c");
  }
  else if(evt.getKeyChar() == 'i')
  {
   p.licz("i");
  }
  else if(evt.getKeyChar() == '=')
  {
   p.licz("=");
  }
  else if(evt.getKeyCode() == 10) //enter
  {
   p.licz("=");
  }
  else if(evt.getKeyCode() == 27) //esc
  {
   try
   {
    System.exit(0);
   }
   catch(Exception ex) {}
  }
 }

 @Override
 public void keyTyped(KeyEvent evt)
 {}
}

