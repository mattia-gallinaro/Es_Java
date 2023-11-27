
class QuadraticEquation
{

  /*
      Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica
      e inizializza i campi di esemplare secondo i valori ricevuti
  */
  public QuadraticEquation(double acoeff, double bcoeff, double ccoeff)
  {
	  a = acoeff;
    b = bcoeff;
    c = ccoeff;
  }



  /*
      Restituisce la prima delle due soluzioni dell'equazione quadratica,
      usando la ben nota formula...
  */
  public double getSolution1()
  {
    if(a!= 0){
      return (-b + Math.sqrt(calculateDelta()))/2*a;
    }
    return -c/b;
  }


  /*
      Restituisce la seconda delle due soluzioni dell'equazione quadratica,
      usando la ben nota formula...
  */
  public double getSolution2()
  {
    return (- b - Math.sqrt(calculateDelta()))/2*a;
  }



  /*
      Restituisce il valore false se l'equazione non ha soluzioni
      (ovvero se il discriminante e` negativo)
  */
  public boolean hasSolutions()
  {
    if ((a == 0 && b == 0 && c != 0) || calculateDelta() < 0){
      return false;
    }
    return true;
  }

  public int numberSolutions(){
    if(hasSolutions()){
      if(a == 0 && b == 0 && c == 0){
        return 3;
      }else if(calculateDelta() > 0 && a != 0){
        return 2;
      }else{
        return 1;
      }
    }
    return 0;
  }

  
  private double calculateDelta(){
    return Math.pow(b, 2) - 4 * a * c;
  }

  private double a;
  private double b;
  private double c;
}

public class QuadraticEquationTester{
  public static void main(String[] args){
    QuadraticEquation q1 = new QuadraticEquation(-2,2,0);
    if(q1.hasSolutions()){
      if(q1.numberSolutions() == 3){
        System.out.println("L'equazione ha infinite soluzioni");
      }else if(q1.numberSolutions() == 2){
        System.out.println("Prima soluzione : " + q1.getSolution1());
        System.out.println("Seconda soluzione : " + q1.getSolution2());
      }else{
        System.out.println("Prima soluzione : " + q1.getSolution1());
      }
    }else{
      System.out.println("L'equazione non ha soluzioni");
    }
  }
}