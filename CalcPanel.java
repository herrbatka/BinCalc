import java.awt.* ;
import java.awt.event.* ;
import java.applet.Applet;

public class CalcPanel extends Panel
 {
   Button p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;

  CalcPanel(Program p)
  {
    setLayout( new GridLayout(4,1) );
    Color colorA = new Color(0xBEBEF3);
    Color colorB = new Color(0xA2BAC6);

    p.wyswietl = new Label("", Label.RIGHT);
    //p.wyswietl.setFont(new Font("Arial", Font.PLAIN, p.wyswietl.getPreferredSize().height));  //nie działa w aplecie
    add(p.wyswietl);

    SuperListener sl = new SuperListener(p);

    Panel ster1 = new Panel();

    ster1.setLayout( new GridLayout(1,4));
    p0 = new Button("0");
    p0.setActionCommand("0");
    p0.addActionListener(sl);
    p0.setBackground(colorA);
    ster1.add(p0);
    p1 = new Button("1");
    p1.setActionCommand("1");
    p1.addActionListener(sl);
    p1.setBackground(colorB);
    ster1.add(p1);
    p3 = new Button("+");
    p3.setActionCommand("+");
    p3.addActionListener(sl);
    p3.setBackground(colorA);
    ster1.add(p3);
    p2 = new Button("=");
    p2.setActionCommand("=");
    p2.addActionListener(sl);
    p2.setBackground(colorB);
    ster1.add(p2);
    add(ster1);

    Panel ster2 = new Panel();
    ster2.setLayout( new GridLayout(1,4));
    p4 = new Button("-");
    p4.setActionCommand("-");
    p4.addActionListener(sl);
    p4.setBackground(colorB);
    ster2.add(p4);
    p6 = new Button("*");
    p6.setActionCommand("*");
    p6.addActionListener(sl);
    p6.setBackground(colorA);
    ster2.add(p6);
    p7 = new Button("/");
    p7.setActionCommand("/");
    p7.addActionListener(sl);
    p7.setBackground(colorB);
    ster2.add(p7);
    p5 = new Button("%");
    p5.setActionCommand("%");
    p5.addActionListener(sl);
    p5.setBackground(colorA);
    ster2.add(p5);
    add(ster2);

    Panel ster3 = new Panel();
    ster3.setLayout( new GridLayout(1,3));
    p8 = new Button("");
    p8.setActionCommand("");
    p8.setBackground(colorA);
    p8.setEnabled(false);
    ster3.add(p8);
    add(ster3);
    p9 = new Button("c");
    p9.setActionCommand("c");
    p9.addActionListener(sl);
    p9.setBackground(colorB);
    ster3.add(p9);
    p10 = new Button("i");
    p10.setActionCommand("i");
    p10.addActionListener(sl);
    p10.setBackground(colorA);
    ster3.add(p10);
    p11 = new Button("");
    p11.setActionCommand("");
    p11.setBackground(colorB);
    p11.setEnabled(false);
    ster3.add(p11);
    add(ster3);
 }

 public void dopasujrozmiar()
 {
  p0.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p1.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p2.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p3.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p4.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p5.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p6.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p7.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p8.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p9.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p10.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
  p11.setFont(new Font("Arial", Font.PLAIN, p0.getHeight()/2));
 }
}
