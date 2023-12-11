import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Prima stringa :");
        String s1 = sc.nextLine();
        System.out.println("Seconda stringa :");
        String s2 = sc.nextLine();
        String res = "";
        String tmp_res = "";
        if (res.equals(s2)) {
            System.out.println("La stringa piu`grande trovata e`" + res);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                for (int j = 0; j < s1.length(); j++) {
                    tmp_res = "";
                    if(s1.charAt(j) == s2.charAt(i)) {
                        for(int k = 0; i + k < s2.length() && j + k < s1.length() ;k++){
                            if(s2.charAt(i + k) == s1.charAt(j + k)){
                                tmp_res = tmp_res + "" + s1.charAt(j + k);
                            }else{
                                break;
                            }
                        }
                        if(tmp_res.length() > res.length()){
                            res = tmp_res;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}