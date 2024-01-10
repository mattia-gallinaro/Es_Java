import java.util.Scanner;
import java.io.*;

public class SimpleDictionaryTester
{
    public static void main(String[] args) throws IOException
    {   //creazione di un dizionario vuoto

        Dictionary dict = new ArrayDictionary();

        //in alternativa alla istruzione appena scritta, provare ad utilizzare
        //la seguente istruzione, ovvero a creare un oggetto di tipo
        //SortedArrayDictionary:

        //Dictionary dict = new SortedArrayDictionary();
        
        //Inserimento di elementi nel dizionario: leggo dati da file e assumo
        //che il file contenga righe nel formato <numero int> <stringa>
        Scanner infile = new Scanner(new FileReader("coppie.txt")); 
        while (infile.hasNextLine())
        {   Scanner linescan = new Scanner(infile.nextLine());
            int key = Integer.parseInt(linescan.next());
            String value = linescan.next();
            dict.insert(key,value); //inserimento di chiave e valore
        }
        infile.close();

        //ricerca/rimozione dati nel dizionario
        Scanner in = new Scanner(System.in);
        boolean done = false;
        while (!done)
        {   System.out.println("**** Stampa dizionario ****");
            System.out.println(dict); //... ho sovrascritto toString
            System.out.println("\nF=find,R=remove,Q=quit");
            String cmd = in.nextLine();
            if (cmd.equalsIgnoreCase("Q"))
            {    done = true;
                 System.out.println("Arrivederci");
            }
            else if (cmd.equalsIgnoreCase("F"))
            {   System.out.println("Chiave da trovare?");
                int key = Integer.parseInt(in.nextLine());
                try{ //cerca key chiave e restituisce il valore
                    String value = (String)dict.find(key);
                    System.out.println("Valore: " + value);
                    }
                catch(DictionaryItemNotFoundException e)
                {   System.out.println("Chiave non trovata");}
            }
            else if (cmd.equalsIgnoreCase("R"))
            {   System.out.println("Chiave da rimuovere?");
                int key = Integer.parseInt(in.nextLine());
                try{//rimuove la coppia identificata da key
                    dict.remove(key);
                    System.out.println("Chiave rimossa"); 
                    }
                catch(DictionaryItemNotFoundException e)
                {   System.out.println("Chiave non trovata");}
            }
        }
    }
}
