//Es 5 lab 2

public class NotazionePos{
    public static void main(String[] args){
        int num =  123456;
        String result  = "";

        result = " "+  num % 10 + result;
        num /= 10;
        result = " "+  num % 10 + result;
        num /= 10;
        result = " "+  num % 10 + result;
        num /= 10;
        result = " "+  num % 10 + result;
        num /= 10;
        result = " "+  num + result;



        System.out.println(result);
    }
}