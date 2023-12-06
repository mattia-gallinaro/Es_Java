import java.util.Scanner;

public class SubString{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = "";
        String s2 = "";
        boolean flag = false;
        System.out.println("Inserisci la prima stringa");
        s1 = scanner.nextLine();
        System.out.println("Inserisci la seconda stringa");
        s2 = scanner.nextLine();
        if(s2.length() == 0){
            flag = true;
        }
        for(int i = 0; i < s1.length() && flag != true; i++){
            flag = false;
            if(s1.length() - i < s2.length()){
                break;
            }
            if(s1.charAt(i) == s2.charAt(0)){
                flag = true;
                for(int j = 0; j < s2.length(); j++){
                    if(s2.charAt(j) != s1.charAt(i + j)){
                        flag = false;
                    }
                }
            }
            if(flag == true)
                break;
        }
        if(flag == false){
            System.out.println("La stringa s2 non e` una sottosequenza di s1");
        }else{
            System.out.println("La stringa s2 e` una sottosequenza di s1");
        }
    }
}