import java.util.Scanner;

//legge un numero da riga di comando (buffer di input) e poi lo converte in binario

public class Converter_bin_dec{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int number = getNumberDecimale(scanner);

        System.out.println(convert_number(number, ""));
    }

    public static int getNumberDecimale(Scanner scanner){
        System.out.println("Inserisci un numero decimale");
        int number = scanner.nextInt();
        if(number >= 0 && number <= 255) return number;
        return getNumberDecimale(scanner);

    }

    public static String convert_number(int number, String number_bin) {
        if(number <= 1){
            return number_bin = Integer.toString(number % 2) + number_bin;
        }
        number_bin = Integer.toString(number % 2) + number_bin;
        number /= 2;
        return convert_number(number, number_bin);
    }
}