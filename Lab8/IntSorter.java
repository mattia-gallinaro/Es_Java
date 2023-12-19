import java.util.NoSuchElementException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class SortedArray {
    /*
     * Crea un oggetto SortedArray vuoto
     */
    public SortedArray()
    { 
        array = new int[1];
        count = 0;
    }

    /*
     * verifica se l'array e` vuoto. Prestazioni O(1)
     */
    public boolean isEmpty()
    { 
        return count == 0;
    }

    /*
     * Aggiunge il valore value all'array ordinato, conservando l'ordinamento.
     * Prestazioni O( n) (prima dell'inserimento l'array e' ordinato!)
     */
    public void add(int value)
    { 
        if(count == array.length){
            int[] new_arr = new int[ 2 * array.length ];
            for(int i = 0; i < count; i++){
                new_arr[i] = array[i];
            }
            array = new_arr;
        }
        if(count == 0){
            array[0] = value;
            count++;
            return;
        }
        int i;
        for(i = count; i > 0 && array[i - 1] > value; i--){
            array[i] = array[i - 1];
        }
        array[i] = value;
        count++;
    }

    /*
     * Cancella il valore massimo dall'array, e lo restituisce.
     * Prestazioni O(1). Lancia NoSuchElementException se l'array e' vuoto
     */
    public int removeMax() throws NoSuchElementException
    { 
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        count--;
        return array[count];
    }

    /*
     * Restituisce la media (average) dei valori dell'array
     * Prestazioni O( n)
     */
    public double avg()
    { 
        int sum = 0;
        for(int i=0; i < count; i++){
            sum += array[i];
        }
        return (sum/(double)count);
    }

    /*
     * Cerca un numero value nell'array ordinato (ricerca binaria).
     * Prestazioni O(log n). Restituisce l'indice nell'array dell'intero
     * value se questo viene trovato, altrimenti restituisce il valore -1
     */
    public int search(int value) 
    { 
        if(isEmpty()){
            return -1;
        }else{
            return binarySearch(array, 0, count - 1, value);
        }
    }

    private int binarySearch(int[] array, int start, int end, int value){
        if(start >end){
            return -1;
        }
        int mid = (end + start) / 2;
        if(value == array[mid]){
            return mid;
        }else if (value < array[mid]){
            return binarySearch(array, start, mid - 1, value);
        }else{
            return binarySearch(array, mid + 1, end , value);
        }
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < count; i++){
            s = s + " " + array[i];
        }
        return s;
    }

    public int[] getArray(){
        int[] ar_copy = new int[count];
        System.arraycopy(array, 0, ar_copy, 0, count);
        return ar_copy;
    }
    private int[] array;
    private int count;
}

public class IntSorter{
    public static void main(String[] args){
        if(args.length != 2){
            throw new IllegalArgumentException();
        }
        try {
            int num = Integer.parseInt(args[0]);
            if(num <= 0){
                throw new IllegalArgumentException();
            }
            PrintWriter print = new PrintWriter(args[1]);
            SortedArray srt = new SortedArray();
            Random rand = new Random();
            Scanner sc = new Scanner(System.in);
            for(int i = 0; i < num; i++){
                int n = (rand.nextInt(num) + 1);
                srt.add(n);
            }
            while(true){
                System.out.println("Inserisci un numero per controllare la posizione in cui esso si trova,\n oppure inserisci Q per terminare l'inserimento");
                 
                break;
            }
            int col_size = String.valueOf(num).length();
            int num_rows = num / 10;
            if(num % 10 != 0){
                num_rows += 1;
            }
            for(int i = 0; i < num_rows; i++){
                String line = "";
                for(int j = i * 10 ; j < (i * 10 + 10) && j < num; j++){
                    int s = srt.removeMax();
                    line = line + s;
                    for(int k = 0; k < ( - String.valueOf(s).length() + col_size); k++){
                        line = line + " ";
                    }
                    line = line + " ";
                }
                print.println(line);
            }
            print.close();
        } catch (NumberFormatException e) {
            System.out.println("Numero inserito errato");
        } catch (IOException e) {
            System.out.println("Impossibile aprire il file");
        }
    }
}