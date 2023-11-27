import java.util.Scanner;
import java.util.Locale;
class Triangolo {
   /*
    * Construttore della classe Triangolo
    */
   public Triangolo(double la, double lb, double lc) {
      if(la > 0.0 && lb > 0.0 && lc > 0.0 && lc < la + lb && la < lc + lb && lb < la + lc){
         a = la;
         b = lb;
         c = lc;
         boolean done = true;
         while(done){
            done = false;
            if(a > b){
               double tmp = a;
               a = b;
               b = tmp;
               done = true;
            }
            if(b > c){
               double tmp = b;
               b = c;
               c = tmp;
               done = true;
            }
         }
      }else{
         a = 0;
         b = 0;
         c = 0;
      }
   }

   /*
    * restituisce informazioni sul triangolo. le informazioni sono relative
    * ai lati: equilatero, isoscele, scaleno.
    * agli angoli: acutangolo, rettangolo, ottusangolo.
    * Esempio: per il triangolo di lati 3, 4, 5 restituisce la stringa
    * "scaleno rettangolo".
    */
   public String info() {
      String res = "Non e` un triangolo";
      if(c < a + b){
         if(c == a && c == b && a == b){
            res = "equilatero acutangolo";
         }
         else if(c == a || c == b || a == b){
            res = "isoscele";
         }
         else{
            res = "scaleno";
         }
         if(!res.contentEquals("equilatero acutangolo")){
            if(c*c < a*a + b*b){
               res += " acutangolo";
            }else if(c*c == a*a + b*b){
               res += " rettangolo";
            }else{
               res += " ottusangolo";
            }
         };
      }
      return res;
   }

   /*
    * restituisce una stringa contenente una descrizione testuale dell'oggetto
    * nel formato T(a, b, c)
    * Esempio "T(3, 4, 5)"
    */
   public String toString() {
      return "T(" + a + ", " + b + ", " + c + ")";
   }

   /*
    * calcola e restituisce l'area del triangolo.
    * Usa la formula di Erone:
    * area * area = p * (p - a) * (p - b) * (p - c)
    * dove p e` il semiperimetro, ovvero p = (a + b + c) / 2
    */
   public double area() {
      if(info().equals("Non e` un triangolo")){
         return 0;
      }
      return Math.sqrt(semi_p() * (semi_p() - a) * (semi_p() - b) * (semi_p() - c));
   }

   public double semi_p() {
      return (a + b + c) / 2;
   }

   /*
    * calcola e restituisce l'altezze del triangolo relativa al lato maggiore:
    */
   public double h() {
      if(info().equals("Non e` un triangolo")){
         return 0;
      }
      return 2 * area() / c;  
   }

   private double a;
   private double b;
   private double c;
}


public class TriangoloTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      in.useLocale(Locale.US);

      // lettura dei dati da Standard Input
      System.out.print ("Introduci lati a, b, c: ");
      double a = in.nextDouble();
      double b = in.nextDouble();
      double c = in.nextDouble();

      // creazione di una istanza del triangolo
      Triangolo triangolo = new Triangolo(a, b, c);

      // emissione a Standard Output dell'elaborazione
      System.out.println(triangolo +  ": " + triangolo.info());
      System.out.println("area = " + triangolo.area());
      System.out.println("h = " + triangolo.h());
   }
}