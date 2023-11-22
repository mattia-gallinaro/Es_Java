import java.util.Scanner;

public class PrimeNumbers{
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    int n = 0;
	    boolean flag = false;
	    String res = "";
	    do{
	    	System.out.println("Inserisci un numero maggiore di 1");
	    	try{
	    	 n = Integer.parseInt(sc.nextLine());
	    	}catch(Exception e){
	    	System.out.println("Inserisci un numero maggiore di 1");	    	
	    	}
	    }while(n <= 0);
	    sc.close();
	    
	    for(int j = n; j >= 1; j--){
	     	int m = 2;
	     	flag = false;
	    	while(m <= Math.sqrt(j)){
	    	    if(j % m == 0){
	    	    	flag = true;
	    	    	break;
	    	    }
	    	    m++;
	    	}
	    	if(!flag){
	    	   res =  j + "\n";
	    	}
	    }
	    System.out.println(res);
	}

}
