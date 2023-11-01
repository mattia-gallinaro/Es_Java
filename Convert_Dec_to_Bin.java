//Es 6 lab 2


public class Convert_Dec_to_Bin{
    public static void main(String[] args){
        double num = 1.32; 

        int part_int = (int)num;
        double decimal_part = num % 10;
        
        String result = "";

        for(int i = 0; i < 5; i++){
            result = part_int % 2 + result;
            part_int = part_int / 2;
        }
        
        for(int i = 0; i < 5; i++){
            if(decimal_part > 1 ){
                decimal_part -= 1;
            }
            result = result + (int)(decimal_part * 2);
            decimal_part *= 2;
        }
        System.out.println(part_int);
        System.out.println(decimal_part);
        System.out.println(result);
    }
}