public class SubstringGeneratorIT{
    public static void main(String[] args){

        String s = "";
        for(int i=0; i<args[0].length() ; i++){
            for(int j=i; j<args[0].length(); j++){
                s = s + " " + args[0].substring(i, j + 1);
            }
        }
        System.out.println(s);
    }
}