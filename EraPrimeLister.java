import java.util.Scanner;

public class EraPrimeLister{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n =0 , p=0, i=0,pos_del=0;

        do{
            System.out.println("Inserisci un numero");
            n = scanner.nextInt();
        }while(n <= 1);

        int[] a = new int[n-1];

        for(int j=0; j < a.length ; j++){
            a[j] = j+2;
        }

        while(a[i]*a[i] <= n){
            for(int j = i+1;j<a.length - pos_del; j++){
                if(a[j] % a[i] == 0){
                    for(int k = j; k < a.length - pos_del - 1; k++){
                        a[k] = a[k+1]; 
                    }
                    pos_del +=1;
                }
            }
            i+=1;
        }

        for(int j = 0; j < a.length - pos_del; j++)
            System.out.println(a[j]);
    }
}