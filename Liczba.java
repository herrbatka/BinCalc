import java.util.*;
//dodać obsługę liczb ujemnych tu lub w pliku
public class Liczba 
{
 public int n;
 public boolean minus = false;

 Liczba() 
 {
  this.n = 0;
 }

 Liczba(int n) throws LiczbaException 
 {
  if(n<0) {this.minus=true;}
  this.n = n;
 }

 Liczba(String n, int podstawa) throws LiczbaException 
 {
  String[] tablica = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
  int i,j;
  int temp=0;
  int potega=1;
  //???
  if(n.startsWith("-")) {this.minus=true;n=n.substring(1,n.length());}
  if(podstawa>tablica.length || podstawa<2) {throw new LiczbaException("Nieporawny system liczbowy");}
  for(i=n.length()-1; i>=0; i--)
  {
   for(j=0; j<podstawa; j++)
   {
    if(n.substring(i,i+1).equals(tablica[j]))
    {
     temp += j*potega;
     break;
    }
    if(j==podstawa-1) {throw new LiczbaException("Źle zapisana liczba");}
   }
   potega*=podstawa;
  }
  this.n = temp;
  if(minus) {this.n=this.n*(-1);}
 }

 public String zapis(int podstawa) throws LiczbaException 
 {
  if(podstawa<2 || podstawa>16) {throw new LiczbaException("Nieporawny system liczbowy");}
  int liczba = this.n;
  if(minus) {liczba = liczba*(-1);}
  if(liczba==0) {return "0";}
  int reszta=0;
  String wynik="";
  String temp="";
  while(liczba!=0)
  {
   reszta = liczba%podstawa;
   if(reszta>9)
   {
    switch (reszta) 
    {
     case 10:
      temp="A";
      break;
     case 11:
      temp="B";
      break;
     case 12:
      temp="C";
      break;
     case 13:
      temp="D";
      break;
     case 14:
      temp="E";
      break;
     case 15:
      temp="F";
      break;
    }
   }
   else
   {
    temp = Integer.toString(reszta);
   }
   wynik = temp + wynik;
   liczba= (liczba-reszta)/podstawa;
  }
  if(minus) {wynik="-"+wynik;}
  return wynik;
 }

}

