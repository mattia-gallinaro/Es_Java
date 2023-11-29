import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;

public class TokenString{
	public static void main(String[] args){
		String res = "";
		try{
			FileReader fd = new FileReader("vispateresa.txt");
			Scanner sc = new Scanner(fd);
			PrintWriter pw = new PrintWriter("res.txt");
			String line ="" ;
			while(sc.hasNextLine()){
				line = sc.nextLine();
				String res_line = "";
				Scanner d = new Scanner(line);
				while(d.hasNext()){
					String word = d.next();
					if(word.contains("'")){
						String res_word = "";
						Scanner vir = new Scanner(word);
						vir.useDelimiter("'");
						while(vir.hasNext()){
							String w = vir.next();
							if(w.length() == 1){
								w = w.substring(0).toUpperCase();
							}else{
								w = w.substring(0,1).toUpperCase() + w.substring(1).toLowerCase();
							}
							
							if(vir.hasNext() && res_word.length() == 0){
								res_word = w + "'";
							}else if(vir.hasNext()){
								res_word = res_word + w +"'";
							}else{
								res_word += w ;
							}
						}
						vir.close();
						word = res_word;
					}
					else{
					if(word.length() == 1){
							word = word.substring(0).toUpperCase();
						}else{
							word = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
						}
					}
					if(d.hasNext() && res_line.length() == 0){
						res_line = word + " ";
					}else if(d.hasNext()){
						res_line = res_line + word +" ";
					}else{
						res_line += word;
					}
				}
				d.close();
				pw.println(res_line);
			}
			fd.close();
			sc.close();
			pw.close();
		}catch(IOException e){
			System.out.println("Impossibile aprire il file");
			System.out.println(e.getMessage());
		}
	}
}
