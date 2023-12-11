public class StringReverser{
    public static void main(String[] args){
        if(args.length > 0){
            System.out.println(reverseString(args[0], "", args[0].length() - 1));
        }
    }
    private static String reverseString(String start_str, String res, int pos){
        if(pos == 0){
            return res + start_str.charAt(pos);
        }
        return reverseString(start_str, res + start_str.charAt(pos), pos - 1 );
    }
}