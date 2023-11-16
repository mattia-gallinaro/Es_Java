import java.util.Scanner;
import java.lang.Exception;

public class TriangularNumberGenerator{
    public static void main(String[] args){
        int n = 0, sum= 0, k = 1;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Inserisci un numero maggiore o uguale ad 1 ");
            try{
                n = Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                n = 0;
            }
        }while(n <= 0);

        do{
            sum += k;
            k += 1;
            System.out.println(sum);
        }while(k <= n);

    }
}