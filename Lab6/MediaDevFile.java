import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MediaDevFile{
	public static void main(String[] args){
		String path = "input_test.txt";
		String line = "";
		double sum_quad = 0.0, res_med = 0.0 , res_dev = 0.0;
		int num = 0;
		try{
			FileReader fd = new FileReader(path);
			Scanner sc = new Scanner(fd);
			while(sc.hasNextLine()){
				line = sc.nextLine();
				try{
					double l = Double.parseDouble(line);
					res_med += l;
					sum_quad += l * l; 
					num += 1;
				}catch(Exception e){
					System.out.println("Valore nel file non corretto");
				}
			}
			if(num > 1){
    			res_dev = (sum_quad - (res_med * res_med)/num)/(num-1);
    			res_med = res_med/num;
			}
			System.out.println("Media valori e`: " + res_med);
    		System.out.println("Deviazione standard e`: " + res_dev);
		}catch(IOException e){
			System.out.println("Impossibile accedere al file");
		}
	}
}
