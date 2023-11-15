import java.util.Scanner;

public class OrderString{
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1,s2,s3;
        boolean done = true;
        System.out.println("Inserisci una stringa");
        s1 = sc.nextLine();
        System.out.println("Inserisci una stringa");
        s2 = sc.nextLine();
        System.out.println("Inserisci una stringa");
        s3 = sc.nextLine();
        sc.close();
        do{
        done = false;
        	if(s1.compareTo(s2) >= 0){
           	String tmp = "" + s1;
           	s1 = "" + s2;
           	s2 = "" + tmp;
           	done = true;
        	}
        	if(s2.compareTo(s3) >= 0){
           	String tmp = "" + s2;
           	s2 = "" +s3;
           	s3 = "" + tmp;
           	done = true;
       		}
        }while(done);
        System.out.println(s1 + "\n" + s2 + "\n" + s3);
     }
}
