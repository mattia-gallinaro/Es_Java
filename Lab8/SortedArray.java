import java.util.NoSuchElementException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class SortedArray {
    /*
     * Crea un oggetto SortedArray vuoto
     */
    public SortedArray()
    { 
        array = new int[1];
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
        if(count == (array.length -1)){
            array = resizeArray(array);
        }
        for(int i = 0; i < count; i++){
            if(value < array[i]){
                System.arraycopy(array, i, array, i+1, array.length - i );
            }
            array[i] = value;
        }
    }

    private int[] resizeArray(int[] array){
        int[] new_arr = new int[2*array.length];
        System.arraycopy(array, 0, new_arr, 0 , array.length);
        return new_arr;
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
        return array[count+1];
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
            return binarySearch(array, 0, count, value);
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
            s = s + array[i];
        }
        return s;
    }
    private int[] array;
    private int count;
}

class IntSorter{
    public static void main(String[] args){
        if(args.length != 2){
            throw new IllegalArgumentException();
        }
    }
}