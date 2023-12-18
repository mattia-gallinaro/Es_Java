public class RecursiveSubstringFinder{
    private static int pos = 0;
    public static void main(String[] args){
        System.out.println(recursiveSubstringFinderComp("sii","o"));
    }

    public static int recursiveSubstringFinder(String s, String sub){
        if(sub.length() > s.length() || pos + sub.length() > s.length()) {
            return -1;
        } 
        if(s.substring(pos, pos + sub.length()).equals(sub)){
            return pos;
        }
        pos+=1;
        return recursiveSubstringFinder(s, sub);
    }

    public static int recursiveSubstringFinderComp(String s, String sub){
        if(sub.length() > s.length()) {
            return -1;
        } 
        if(s.substring(0, sub.length()).equals(sub)){
            return 0;
        }else{
            int pos = recursiveSubstringFinderComp(s.substring(1, s.length()), sub);
            if(pos == -1){
                return -1;
            }else{
                return pos + 1;
            }
        }
    }
}