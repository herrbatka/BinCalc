import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class Program extends Applet 
{
  Label wyswietl;
  String dzialanie = ""; 
  int bufor; 
  boolean buforempty = true;
  boolean wyswietlwynik = false;
  boolean blokada = false;
  public int h=200;
  InfoWindow inf;
  CalcPanel panel;

  public void start()
  {
   this.inf = new InfoWindow("Info", "Informacje\nKalkulator operujacy\nna liczbach binarnych");
   wyswietl.setFont(new Font("Arial", Font.PLAIN, wyswietl.getWidth()/13));
   panel.dopasujrozmiar();
  }

  public void init() 
  {
   this.setFocusable(true);
   this.addKeyListener(new CalcKeyListener(this));
   setLayout(new BorderLayout());
   panel = new CalcPanel(this);
   add("Center", panel);
  }

  public int wylicz(String dzialanie, int liczba) throws DzielZero
  {
   if(buforempty) {return liczba;}
   if(dzialanie == "+")
   {
    return bufor + liczba;
   }
   if(dzialanie == "-")
   {
    return bufor - liczba;
   }
   if(dzialanie == "*")
   {
    return bufor * liczba;
   }
   if(dzialanie == "/")
   {
    if(liczba == 0) {blokada = true; throw new DzielZero();}
    return (int)(Math.floor(bufor / liczba));
   }
   if(dzialanie == "%")
   {
    if(liczba == 0) {blokada = true; throw new DzielZero();}
    return bufor % liczba;
   }
   else
   {
    return 0;
   }
  }
  
  public void wynik()
  {
     try
     {
      if(wyswietl.getText()=="-") {return;}
      Liczba l;
      try
      {
       l = new Liczba(wyswietl.getText(), 2);
       int n;
       try
       {
        n = wylicz(dzialanie, l.n);
       }
       catch(DzielZero ex)
       {
        wyswietl.setText("Syntax Error");
        return;
       }
       Liczba l2 = new Liczba(n);
       if(testdlugosci(l2.zapis(2)))
       {
        wyswietl.setText(l2.zapis(2));
       }
      }
      catch(Exception ex) {}
      bufor = 0;
      buforempty = true;
      wyswietlwynik = true;
     }
     catch(Exception ex) {}
  }

  public boolean testdlugosci(String a)
  {
    if(a.length()>=21 && a.startsWith("-"))
    {
     wyswietl.setText("E " + a.substring(0,21));//??
     blokada = true;
     return false;
    }
    if(a.length() >= 20 && !a.startsWith("-"))
    {
     wyswietl.setText("E "+a.substring(0,20));//??
     blokada = true;
     return false;
    }
    return true;
  }

  public void licz(String polec) 
  {
   if(polec == "=" && !blokada)
   {
    wynik();
   }
   else if(polec == "i")
   {
    inf.setVisible(true);
   }
   else if(polec == "c")
   {
    wyswietl.setText("");
    bufor = 0;
    buforempty = true;
    wyswietlwynik = false;
    blokada = false;
   }
   else if((polec == "1" || polec == "0") && !blokada)
   {
    if(wyswietlwynik == true)
    {
     Liczba l;
     try
     {
      l = new Liczba(wyswietl.getText(), 2);
      bufor = l.n;
     }
     catch(Exception ex) {}
     buforempty = false;
     wyswietlwynik = false;
     wyswietl.setText("");
    }
    if(!testdlugosci(wyswietl.getText())) {return;}
    if(wyswietl.getText() == "0") {return;}
    if((wyswietl.getText() != "-" && wyswietl.getText() != "") || polec != "0")
    {
     wyswietl.setText(wyswietl.getText() + polec);
    }
    else if(wyswietl.getText() == "" && polec == "0")
    {
     wyswietl.setText(polec);
    }
   }
   else if(!blokada)
   {
    if(wyswietl.getText() == "-") {return;}
    if(wyswietl.getText() == "")
    {
     if(polec == "-")
     {
      wyswietl.setText("-");
      return;
     }
     else
     {
      return;
     }
    }
    /*if(wyswietlwynik && polec == "-")
    {
     Liczba l;
     try
     {
      l = new Liczba(wyswietl.getText(), 2);
      bufor = l.n;
     }
     catch(Exception ex) {}
     buforempty = false;
     wyswietlwynik = false;
     wyswietl.setText("-");
     return;
    }*/

    if(!buforempty && wyswietl.getText()!="")
    {
     wynik();
    }
    else if(wyswietl.getText()!="" && !wyswietlwynik)
    {
     try
     {
      Liczba l;
      try
      {
       l = new Liczba(wyswietl.getText(), 2);
       bufor = l.n;
      }
      catch(Exception ex) {}
      wyswietlwynik  = true;
      //wyswietl.setText("");
      buforempty = false;
     }
     catch(Exception ex) {}
    }
    dzialanie = polec;
   }
  }

  public static void main(String[] args)
  {
    int h=200;
    int w=150;
    try
    {
     h=Integer.parseInt(args[0]); 
    }
    catch (NumberFormatException ex) {} 
    catch(ArrayIndexOutOfBoundsException ex) {}
    try
    {
     w=Integer.parseInt(args[1]); 
    }
    catch (NumberFormatException ex) {} 
    catch(ArrayIndexOutOfBoundsException ex) {}
    if(h<200 || w<150 || h>640 || w>480)
    {
     ErrorWindow e = new ErrorWindow("Błąd", "Program nie może działać\nw tym rozmiarze!");
    }
    else
    {
     Frame f = new Frame();
     f.setSize(h,w);
     f.setResizable(false);
     f.addWindowListener(new KalkulatorWindowAdapter());
     Program p = new Program();
     f.addKeyListener(new CalcKeyListener(p));
     p.h = h;
     f.add(p);
     p.init();
     f.setVisible(true);
     p.start();
    }
  }
}
