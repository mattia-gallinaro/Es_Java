import java.util.Scanner;

public class CrivelloEratostene{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        int num = 0;
        while(!done){
            System.out.println("Inserisci un numero");
            try{
                num  = Integer.parseInt(scanner.nextLine());
                if(num < 1){
                    System.out.println("Inserisci un numero maggiore di 0");
                }else{
                    done = true;
                }
            }catch(NumberFormatException e){
                System.out.println("valore errato");
            }
        }

        boolean[] numb = new boolean[num - 1];

        for(int i=0; i < numb.length; i++)
            numb[i] = true;

        
        for(int i = 1; i < numb.length; i++){
            if(numb[i] && i > 1){
                for(int j = i + 1; j < numb.length + 1; j++){
                    if(j % i == 0){
                        numb[j - 1] = false;
                    }
                }
            }
        }

        for(int i = 0; i < numb.length; i++){
            if(numb[i])
                System.out.println(i + 1);
        }
    }
}