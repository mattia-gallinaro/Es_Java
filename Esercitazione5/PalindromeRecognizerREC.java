public class PalindromeRecognizerREC{
    public static void main(String[] args){
        System.out.println(isPalindromeREC("ab"));
    }
    public static boolean isPalindromeREC(String s){
        if(s.equals("") || s.length() == 1) return true;
        if(s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindromeREC(s.substring(1, s.length() - 1));
    }
}