import java.util.Scanner;

public class PrimeNumberRecognizer{
    public static void main(String[] args){
        int n = 0,p = 0;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Inserisci");
            n = s.nextInt();
        }while(n <= 1);

        for(int i= 2; i < n/2; i++){
            if(n % i == 0){
                p = i;
                break;
            }
        }

        if(p != 0){
            System.out.println("Il numero "+ n +" e` divisibile per "+ p);
        }
        else{
            System.out.println("Il numero "+ n +" e` primo");
        }
    }
}