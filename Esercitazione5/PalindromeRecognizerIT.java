public class PalindromeRecognizerIT{
    public static void main(String[] args){
        if(isPalindrome(args[0])){
            System.out.println("La parola "+ args[0]+ " e` palindroma");
        }else{
            System.out.println("La parola "+ args[0]+ " non e` palindroma");
        }
    }
    public static boolean isPalindrome(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() -i -1 )){
                return false;
            }
        }
        return true;
    }
}