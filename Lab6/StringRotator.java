import java.util.Scanner;

public class StringRotator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        int num = 0;
        System.out.println("Inserisci una stringa");
        String s = scanner.nextLine();
        String res = "";
        while (!done) {
            System.out.println("Inserisci il numero di rotazione");
            try {
                String line = scanner.nextLine();
                num = Integer.parseInt(line);
                done = true;
            } catch (Exception e) {
                System.out.println("Non hai inserito un numero");
            }
        }
        if (num == 0 || s.length() == 0) {
            System.out.println(s);
        } else {
            while (Math.abs(num) >= s.length()) {
                if (num < 0) {
                    num += s.length();
                } else {
                    num -= s.length();
                }
            }
            if (num < 0) {
                num = s.length() - Math.abs(num); // piuttosto di usare un numero negativo converto le rotazioni di
                                                  // sinistra in rotazioni di destra
            } else if (num == 0) {
                System.out.println(s);
            }
            if(num > 0){
                res = s.substring(s.length() - num, s.length()) + s.substring(0, s.length() - num);
                System.out.println(res);
            }
        }
    }
}