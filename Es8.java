import java.util.Scanner;

public class Es8{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Inserisci il tuo nome");
	String name = sc.next();
	String tmp = "";
	for(int i = 0; i < name.length() + 4; i++)
		tmp += "-";
		
	System.out.println(tmp);
	System.out.println("| " + name + " |");
	System.out.println(tmp);
	}
}
