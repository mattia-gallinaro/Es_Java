import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextTester{
	public static void main(){
		Text = new Text();
		try{
			FileReader a = new FileReader(args[0]);
			Scanner sc = new Scanner(a);
			a.useDelimiter("[\\p{JavaWhitespace}\\p{Punct}]+");
			while(a.hasNext()){
				
			}
		}catch(IOException e){
			
		}
	}
}
