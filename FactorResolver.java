import java.util.Scanner;

public class FactorResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, p = 1;
        boolean find = false;
        String result = "1";
        do {
            System.out.println("Inserisci un numero");
            n = scanner.nextInt();
        } while (n <= 1);
        if (isPrime(n)) {
            System.out.println(n + " = " + "1 * " + n);
        } else {
            do {
                find = false;
                for (int i = 2; i <= n / 2; i++) {
                    if (!isPrime(i)) {
                        continue;
                    }
                    if (n % i == 0) {
                        result = result + " * " + i;
                        n /= i;
                        p *= i;
                        find = true;
                        break;
                    }
                }
            } while (n > 1 && find == true);

            if (n > 1) {
                result = result + " * " + n;
                p *= n;
            }
            System.out.println(p + " = " +result);
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}