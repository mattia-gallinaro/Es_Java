public class SubstringGeneratorREC {
    public static void main(String[] args){
        if(args.length != 1){
            throw new IllegalArgumentException();
        }
        String[] res = substringsREC(args[0]);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

    public static String[] substringsREC(String s){
        if(s == null){
            throw new IllegalArgumentException();
        }

        if(s.length() == 0){
            return new String[0];
        }
        if(s.length() == 1){
            String[] res = new String[1];
            res[0] = s;
            return res;
        }
        String[] tmp = new String[s.length()];
        String[] done = substringsREC(s.substring(1));

        for(int i = 1; i < s.length() + 1; i++){
            tmp[i - 1] = s.substring(0, i);
        }
        String[] tot = new String[tmp.length + done.length];
        for(int i = 0; i < done.length; i++){
            tot[i] = done[i];
        }
        for(int j = done.length; j < tot.length; j++){
            tot[j] = tmp[j - done.length];
        }
        return tot;
    }
}
