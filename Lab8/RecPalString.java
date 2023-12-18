public class RecPalString {
    public static void main(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException();
        }
        System.out.println(checkRecPalString2(args[0]));
    }

    public static boolean checkRecPalString(String s){
        if(s == null){
            throw new IllegalArgumentException();
        }
        if(s.length() <= 1){
            return true;
        }
        if(s.charAt(0) != s.charAt(s.length() -1)){
            return false;
        }
        return checkRecPalString(s.substring(1, s.length() - 1));
    }

    public static boolean checkRecPalString2(String s){
        if(s == null){
            throw new IllegalArgumentException();
        }
        if(s.length() <= 1){
            return true;
        }
        if(Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(s.length() -1))){
            if(s.charAt(0) != s.charAt(s.length() -1)){
                return false;
            }
        }
        if(!Character.isLetter(s.charAt(0))){
            if(s.length() == 1){
                return true;
            }
        }
        if(!Character.isLetter(s.charAt(s.length() -1))){
            if(s.length() == 1){
                return true;
            }
            s = s.substring(0, s.length()- 1);
        }
        return checkRecPalString2(s.substring(1 , s.length()-1));
    }
}
