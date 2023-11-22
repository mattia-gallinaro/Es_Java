import java.util.Scanner;

public class ScomposizioneFat{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = 0, p = 2, res = 1;
		String result = "1"; 
		do{
			System.out.println("Inserisci un numero positivo");
			try{
				n = Integer.parseInt(sc.nextLine());
			}catch(Exception e){
				System.out.println("Inserimento non corretto");
			}
		}while(n <= 0);
		sc.close();
		
		while(p <= n/2){
			if(isPrime(p)){
				while(n % p == 0){
					result = result + " * " + p;
					n /= p;
					res *= p;
				}
			}
			p++;
		}
		
		if(n > 1){
			result = result + " * " + n;
			res *= n;
		}
		System.out.println(res + " = " + result);
	}
	
	public static boolean isPrime(int val){
		for(int n = 2; n <= val/2 ; n++){
			if(val % n == 0){
				return false;
			}
		}
		return true;
	}
}
