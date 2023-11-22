import java.util.Scanner;

public class MediaDeviazione{
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String s = "";
    	double sum = 0.0, sum_quad = 0.0, add = 0.0 , res_med = 0.0 , res_dev = 0.0;
    	int num =  0;
    	boolean test = true;
    	do{
    	    System.out.println("Inserisci un numero oppure premi Q per terminare l'inserimento");
    	    s = sc.nextLine();
    	    if(s.equalsIgnoreCase("Q")){
    	    	test = false;
    	    }
    	    else{
    	    	try{
    	    	    add = Double.parseDouble(s);
    	    	    num++;
    	    	    sum += add;
    	    	    sum_quad += Math.pow(add, 2);
    	    	}catch(Exception e){
    	    		System.out.println("Inserimento non corretto");
    	    	}
    	    }
    	}while(test);
    	
    	if(num == 1){
    		res_med = sum;
    		
    	}else if(num != 0){
    		res_med = sum/num;
    		res_dev = (sum_quad - (sum * sum)/num)/(num-1);
    	}
    	System.out.println("Media valori e`: " + res_med);
    	System.out.println("Deviazione standard e`: " + res_dev);    	
    }

}
