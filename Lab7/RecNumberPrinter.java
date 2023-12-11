public class RecNumberPrinter{
    public static void main(String[] args){
        if(args.length > 0){
            int num = 0;
            try{
                num = Integer.parseInt(args[0]);
            }catch(NumberFormatException e){
                num = -1;
            }
            System.out.println(listNumbers(1, num, ""));
        }
    }

    private static String listNumbers(int n, int end , String res){
        if(end <= 0){
            return "bro";
        }
        if(n == end){
            return res +" " + n;
        }
        res = res + " "+ n;
        return listNumbers(n + 1, end, res);
    }
}