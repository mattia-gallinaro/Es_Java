import java.util.Scanner;

public class ManipolazioneString{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = "";
		int pos_rag = 0;
		boolean flag = false;
		System.out.println("Scrivi una sequenza di caratteri");
		s = sc.nextLine();
		sc.close();
		
		while(pos_rag < s.length()){
		 	if(s.charAt(pos_rag) != s.charAt(s.length() - pos_rag - 1)){
		 		flag = true;
		 		break;
		 	}
		 	pos_rag++;
		}
		if(flag){
			System.out.println("La sequenza di caratteri non e` palindroma");
		}else{
			System.out.println("La sequenza di caratteri e` palindroma");
		}
	}

}
