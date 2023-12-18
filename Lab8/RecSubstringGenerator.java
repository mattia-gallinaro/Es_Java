public class RecSubstringGenerator {
    public static void main(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException();
        }
        System.out.println(recStringGen("", args[0]));
    }

    public static String recStringGen(String res, String tmp){
        if(tmp.length() == 1){
            return res +" " + tmp;  
        }
        for(int i= 0; i < tmp.length() + 1; i++){
            res += " " +  tmp.substring(0, i);
        }
        return recStringGen(res, tmp.substring(1));
    }
}
