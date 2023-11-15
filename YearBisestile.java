import java.util.Scanner;

public class YearBisestile{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	boolean ok = false;
	int num = 0;
	do{
		System.out.println("Inserisci un anno");
		num = sc.nextInt();
	}while(num <= 0);
	
	if(num < 1582){
		if( num % 4 == 0){
		 ok = true;
		}
	}else{
		if( num % 4 == 0){
			ok = true;
		}
		if(num % 100 == 0){
			if(num % 400 != 0){
		 		ok = false;
			}
		}
	}
	if(ok){
	System.out.println("E` un anno bisestile");
	}else{
	System.out.println("non e` un anno bisestile");
	}
	}
}
