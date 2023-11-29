import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class YearBis {
    public static void main(String[] args) {
        //FileReader f = new FileReader(args[0]);
        System.out.println(args[0]);
        String s = "test per'me";
        Scanner sc = new Scanner(s);
        sc.useDelimiter("'|\\s");
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
        System.out.println(sc.delimiter());
        sc.reset();
        System.out.println(sc.delimiter());
        /*boolean ok = false;
        int num = 0;
        do {
            System.out.println("Inserisci un anno");
            num = sc.nextInt();
        } while (num <= 0);

        if (num < 1582) {
            if (num % 4 == 0) {
                ok = true;
            }
        } else {
            if (num % 4 == 0) {
                ok = true;
            }
            if (num % 100 == 0) {
                if (num % 400 != 0) {
                    ok = false;
                }
            }
        }
        if (ok) {
            System.out.println("E` un anno bisestile");
        } else {
            System.out.println("non e` un anno bisestile");
        }*/
    }
}