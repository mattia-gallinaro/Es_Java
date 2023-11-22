import java.util.Scanner;

public class MassimoDivisore{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int m = 0, n =0;
	do{ 
		System.out.println("Inserisci un numero m positivo maggiore di 1");
		try{
		    m = Integer.parseInt(sc.nextLine());
		}
		catch(Exception e){
		    System.out.println("inserimento non corretto");
		}
		
	}while(m <= 1);
	
	do{ 
		System.out.println("Inserisci un numero n positivo minore di m");
		try{
		    n = Integer.parseInt(sc.nextLine());
		}
		catch(Exception e){
		    System.out.println("inserimento non corretto");
		}
		
	}while(m <= n);
	sc.close();
	
	while((m % n) != 0){
		int tmp = m + 1;
		m = n + 0;
		n = (tmp - 1) % n;
	}
	
	System.out.println("L'MCD tra i 2 numeri e` : "+ n);
	}

}
