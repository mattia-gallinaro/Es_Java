import java.util.Scanner;

public class CheckRealNumbers{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Inserisci un numero a virgola mobile");
	double num1 = (double)(Math.round(100.0 * Double.parseDouble(sc.next())));
	System.out.println("Inserisci un numero a virgola mobile");
	double num2 = (double)(Math.round(100.0 * Double.parseDouble(sc.next())));;
	if(Math.abs(num1-num2) >= 1){
		System.out.println("Non sono uguali");
	}else{
		System.out.println("Sono uguali");
	}
	}
}
