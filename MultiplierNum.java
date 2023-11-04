import java.util.Scanner;

public class MultiplierNum{
    public static void main(String[] args){
        int n = 0;
        int max = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("Inserisci n");
            n = sc.nextInt();
        }while(n <= 0);


        do{
            System.out.println("Inserisci max");
            max = sc.nextInt();
        }while(max <= n);

        System.out.println("\n");

        for(int i = 1; n*i <= max; i++){
            System.out.println(n*i);
        }
    }
}