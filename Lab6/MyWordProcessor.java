import java.util.Scanner;

public class MyWordProcessor{

    //inizializza il testo a vuoto
    public MyWordProcessor(){
        lines = new String[0];
    }

    //aggiunge una nuova linea in una nuova riga dell'array
    public void add(String line){
        lines = resizeArray(lines, lines.length + 1);
        lines[lines.length - 1] = line;
    }

    //ritorna il numero di righe del testo inserite
    public int size(){
        return lines.length;
    }

    //ritorna il numero di parole del testo
    public int wordSize(){
        int count =0;
        Scanner sc;
        for(int i=0; i<lines.length; i++){
            sc = new Scanner(lines[i]);
            while(sc.hasNext()){
                sc.next();
                count++;
            }
        }
        return count;
    }

    //ritorna un'array più grande  
    private String[] resizeArray(String[] start, int new_length){
        if(start.length == 0) return new String[new_length];
        String[] res =  new String[new_length];
        for(int i = 0; i < start.length; i++){
            res[i] = start[i];
        }
        return res;
    }

    /*private <T> T[] resizeArray(Class<T>[] start, int new_length){
        if(start.length == 0) return new String[new_length];
        T[] res =  new String[new_length];
        for(int i = 0; i < start.length; i++){
            res[i] = start[i];
        }
        return res;
    } */

    //ritorna la parola più grande in ordine lessicografico
    public String maxString(){
        String res = "";
        Scanner sc;
        for(int i = 0; i < lines.length; i++){
            sc = new Scanner(lines[i]);
            while(sc.hasNext()){
                String word = sc.next();
                if(res.compareTo(word) < 0){
                    res = word;
                }
            }
        }
        return res;
    }

    //converte l'array di righe in un array di parole in 
    //cui ogni singola parola occupa una cella del nuovo array e ritorna esso
    public String[] toWords(){
        int num_words = wordSize();
        String[] words = new String[num_words];
        Scanner sc;
        int j = 0;
        for(int i = 0; i < lines.length; i++){
            sc = new Scanner(lines[i]);
            while(sc.hasNext()){
                words[j] = sc.next();
                j++;
            }
        } 
        return words;
    }

    //sostituisce le parole del testo che corrispondono a find con il valore di replace
    //e poi ritorna il conteggio delle sostituzioni effettuate
    public int findAndReplace(String find, String replace){
        int count = 0;
        int rep = 0;
        Scanner sc;
        String line = "";
        for(int i = 0; i < lines.length; i++){
            line = "";
            rep = 0;
            sc = new Scanner(lines[i]);
            while(sc.hasNext()){
                rep++;
                String word = sc.next();
                if(word.equals(find)){
                    word = replace;
                    count++;
                }
                if(rep == 1){
                    line = word + " ";
                }else if(sc.hasNext()){
                    line = line + word + " ";
                }else{
                    line = line + word;
                }
            }
            lines[i] = line;
        }
        return count;
    }

    //ritorna il testo completo in un'unica stringa
    public String toString(){
        String res = "";
        for(int i = 0; i < lines.length; i++){
            res += lines[i] + "\n";
        }
        return res;
    }

    //array che contiene il testo
    //ogni cella corrisponde ad una riga dell'array
    private String[] lines;
}