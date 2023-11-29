import java.util.Scanner;

public class SubSequence{
	public static void main(String[] args){
		String s1 = "", s2 = "";
		boolean flag =  true , letter_found = false;
		int last_point = -1, count =0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci la prima stringa");
		s1 = sc.nextLine();
		System.out.println("Inserisci la seconda stringa");
		s2 = sc.nextLine();

		for(int i = 0; i < s2.length(); i++){
			letter_found = false;
			for(int j = last_point + 1; j < s1.length() ;j++){
				if(s1.charAt(j) == s2.charAt(i)){
					last_point = j;
					count += 1;
					letter_found = true;
					break;
				}
			}
			if((s1.length() - last_point - 1) < (s2.length() - count -1) || letter_found == false ){
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("Sono sottosequenze");
		}else{
			System.out.println("Non sono sottosequenze");
		}
		
	}
}
