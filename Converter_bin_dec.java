import java.util.Scanner;

//legge un numero da riga di comando (buffer di input) e poi lo converte in binario

public class Converter_bin_dec{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double number = getNumberFratto(scanner);

        System.out.println(convert_number(number, ""));
    }

    public static int getNumberDecimale(Scanner scanner){
        System.out.println("Inserisci un numero decimale");
        int number = scanner.nextInt();
        if(number >= 0 && number <= 255) return number;
        return getNumberDecimale(scanner);

    }

    public static double getNumberFratto(Scanner scanner){
        System.out.println("Inserisci un numero decimale");
        double number = scanner.nextDouble();
        if(number > 0.0 && number < 1.0) return number;
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

    public static String convert_number_fratto(double number, String number_bin) {
        if(number > 1.0){
            return number_bin = Integer.toString(number % 2) + number_bin;
        }else if(number == 1.0){
            return number_bin = '1' + number_bin;
        }
        //if(checkDoubleNumbers())
        number_bin = Integer.toString(number % 2) + number_bin;
        number /= 2;
        return convert_number(number, number_bin);
    }

    public static boolean checkDoubleNumbers(String s, int counter, char c){
        if(counter > s.length())return false;//non ci sono doppioni
        if(s[counter] == c)return true;
        counter+= 1;
        return checkDoubleNumbers(s, counter, c);
    }
}

class Convert_bin_with_virg{
    public boolean checkDoubleNumbers(String s, int counter, char c){
        if(counter > s.length())return false;//non ci sono doppioni
        if(s[counter] == c)return true;
        counter+= 1;
        return checkDoubleNumbers(s, counter, c);
    }
}