public class Cerchio
{
   /*
       Construttore della classe Cerchio: centro (x,y) e raggio
   */
   public Cerchio (double x, double y, double radius)
   {
      this.x = x;
      this.y = y;
      this.rc = radius;
   }

   /*
       Verifica se questo cerchio e il cerchio c sono coincidenti, 
       ovvero se hanno tutti i punti in comune
   */

   public boolean isCoincident(Cerchio c)
   {
      return x == c.getX() && y == c.getY() && radius == c.getRadius();
   }


   /*
       verifica se questo cerchio e' interno al cerchio c o se
       il cerchio c e' interno a questo cerchio
   */
   public boolean isEncircled(Cerchio c)
   {
	//... completare
   return calculateDistance(x, c.getX(), y, c.getY()) < Math.abs(r - c.getRadius());
   }

   /*
      verifica se questo cerchio e il cerchio c sono esterni, ovvero non
      sono contenuti uno nell'altro e non hanno alcun punto in comune
   */
   public boolean isExternal(Cerchio c)
   {
	   return calculateDistance(x, c.getX(), y, c.getY()) > Math.abs(r + c.getRadius());
   }
          


   /*
      verifica se questo cerchio e il cerchio c sono secanti, 
      ovvero se hanno almeno un punto in comune.
   */
   public boolean isSecant(Cerchio c)
   {
      return calculateDistance(x, c.getX(), y, c.getY()) < Math.abs(r + c.getRadius()) && calculateDistance(x, c.getX(), y, c.getY()) > Math.abs(r - c.getRadius());
   }
          


   /*
      Verifica se questo cerchio e il cerchio c sono tangenti,
      ovvero se hanno un solo punto in comune
   */
   public boolean isTangential(Cerchio c)
   {
      return  (calculateDistance(x, c.getX(), x, c.getY()) == Math.abs(r - c.getRadius) || calculateDistance(x, c.getX(), x, c.getY()) == Math.abs(r + c.getRadius)) && !isCoincident(c);
   }

   //distanza tra due punti
   private double calculateDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x2 - x1), 2)  + Math.pow((y2 - y1), 2));
   }

   public double getX(){ return x;}
   public double getY(){ return y;}
   public double getRadius(){ return r;}

   private double x;
   private double y;
   private double r;

}