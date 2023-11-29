import java.util.Scanner;

public class SubSequence{
	public static void main(String[] args){
		String s1 = "", s2 = "";
		boolean flag =  true;
		int last_point = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci la prima stringa");
		s1 = sc.nextLine();
		System.out.println("Inserisci la seconda stringa");
		s2 = sc.nextLine();
		for(int i = 0; i < s2.length(); i++){
			for(last_point = last_point; last_point < s1.length() ;last_point++){
				if(s1.charAt(last_point) == s2.charAt(i)){
					break;
				}
			}
			if((s1.length() - last_point) < (s2.length() - i)){
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("Sono sottostringhe");
		}else{
			System.out.println("Non sono sottostringhe");
		}
		
	}
}
