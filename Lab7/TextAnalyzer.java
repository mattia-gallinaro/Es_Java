import java.util.Scanner;

public class TextAnalyzer{
    public static void main(String[] args){
      boolean debug = false;

        
      //lettura da standard input
      Scanner in = new Scanner(System.in);

      //definizione oggetto di classe AnalizzatoreDiTesto
      TextContainer testo = new TextContainer();

      //memorizzazione del testo
      while (in.hasNextLine())
      {   String riga = in.nextLine();
          testo.add(riga);
      }

      //separazione delle parole e verifica relativa. Si consulti la
      //documentazione della classe Pattern e la definizione di espressioni
      //regolari. La notazione [ab] indica di usare come separatore uno dei 
      //caratteri tra a e b. La notazione X+ indica di usare come separatore
      //X, eventualmente ripetuto piu` volte. Quindi l'argomento del metodo
      //splitWords indica di usare come separatore una qualsiasi combinazione
      //dei caratteri ' e \p{JavaWhitespace}  
      TextContainer tSeparato = testo.splitWords("['\\p{javaWhitespace}]+");

      //eliminazione dei caratteri non alfabetici e verifica relativa
      TextContainer tAlfabetico = tSeparato.onlyLetters();

      //conversione in caratteri minuscoli e relativa verifica
      TextContainer tMinuscolo = tAlfabetico.toLowerCase();

      if (debug)
      {   System.out.println("*** Debug: testo con parole separate ***");
          System.out.println(tSeparato);
          System.out.println("*** Debug: testo solo alfabetico ***");
          System.out.println(tAlfabetico);
          System.out.println("*** Debug: testo minuscolo ***");
          System.out.println(tMinuscolo); 
      }

      //stampa del testo originale
      System.out.println("***TESTO ORIGINALE***");
      System.out.println(testo);
      System.out.println("***FINE TESTO ORIGINALE***");

      //analisi del testo
      System.out.println("\n***ANALISI DEL TESTO***");
      System.out.println("Testo di " + tMinuscolo.count() + " parole");
      System.out.println("Prima parola in ordine lessicografico: \"" +
                           tMinuscolo.min() + "\"");
      System.out.println("Prima parola in ordine lessicografico: \"" +
                           tMinuscolo.max() + "\"");
      /*
        l'algoritmo per ordinare le parole secondo la loro frequenza non e`
        efficiente! Studieremo algoritmi efficienti. Per ora elenchiamo
        le parole in ordine decrescente di frequenza seplicemente estraendo
        dal testo la parola di frequenza massima e cancellandola
        successivamente (cancella restituisce l'occorrenza della parola)
      */
      TextContainer tmpTesto = tMinuscolo.copy();

      int maxi = 5;
      int i = 1;
      while (i <= maxi && !tmpTesto.isEmpty())
      {   String tmpStr = tmpTesto.maxFrequency();
          int n = tmpTesto.frequency(tmpStr);
          System.out.println("\nParola piu` frequente n. " + i + ": \"" + 
                              tmpStr + "\" (" + n + " occorrenze)");

          tmpTesto = tmpTesto.remove(tmpStr);
          i++;
          if (debug)
          {
              System.out.println("\n*** Debug: testo dopo rimozione ***");
              System.out.println("*** ha " +tmpTesto.count()+ " parole ***");
              System.out.println(tmpTesto+"\n");
          }
      }
      System.out.println(testo);
    }
}

class TextContainer{
    /*
    costruttore di un contenitore di testo vuoto
    */
    public TextContainer()
    {  
        text = new String[1];
    }

    /*
      verifica se il testo e` vuoto, restituisce
      true se l'oggetto non contiene testo, false altrimenti
    */
    public boolean isEmpty()
    {  
        return text.length == 1;
    }

    /*
      aggiunge la stringa "stringa" in coda al testo. Termina senza errori
      se String stringa e` uguale a null.
    */
    public void add(String stringa)
    {  

        if(stringa != null){
            text[text.length - 1] = stringa;
            text = resizeArr();
        }
    }

    private String[] resizeArr(){
        String[] tmp = new String[text.length + 1];
        for(int i = 0; i < text.length; i++){
            tmp[i] = text[i];
        }
        return tmp;
    }

    /*
     conta e restituisce il numero di stringhe nel testo
    */
    public int count()
    {  
        return text.length -1;   
    }

    /*
     separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
     TextContainer in cui tutte le parole sono separate, e ne restituisce il
     riferimento. Usa l'insieme di delimitatori di default di Scanner, ovvero
     "\p{JavaWhitespace" (si veda la documentazione di Scanner, in particolare
     dei metodi delimiter e useDelimiter, e la documentazione della classe
     Pattern)
    */
    public TextContainer splitWords()
    {  
        TextContainer container = new TextContainer();
        for(int i=0; i < text.length - 1; i++){
            Scanner scanner = new Scanner(text[i]);
            scanner.useDelimiter("\\p{JavaWhitespace}");
            while(scanner.hasNext()){
                container.add(scanner.next());
            }
            scanner.close();
        }
        return container;
    }

    /*
     separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
     TextContainer in cui tutte le parole sono separate, e ne restituisce il
     riferimento. Usa l'insieme di delimitatori specificato dalla stringa delim
     (si veda la documentazione di Scanner, in particolare dei metodi delimiter
     e useDelimiter, e la documentazione della classe Pattern)
    */
    public TextContainer splitWords(String delim)
    {  
        TextContainer container = new TextContainer();
        for(int i=0; i < text.length - 1; i++){
            Scanner scanner = new Scanner(text[i]);
            scanner.useDelimiter(delim );
            while(scanner.hasNext()){
                container.add(scanner.next());
            }
            scanner.close();
        }
        return container;  
    }

    /*
     Crea un nuovo oggetto di di tipo TextContainer in cui tutte le occorrenze
     della stringa "stringa" sono state eliminate.
     - Se la stringa compare piu` volte vengono eliminate tutte le occorrenze.
     - Lancia IllegalArgumentException se il parametro esplicito e` null.
     Attenzione: si devono scandire tutte le stringhe del testo perche`
     la parola da cancellare puo` comparire piu` volte nel testo.
    */
    public TextContainer remove(String stringa)
    {  
      TextContainer container = new TextContainer();
      for(int i  = 0; i < text.length - 1; i++){
        if(!text[i].equals(stringa)){
          container.add(text[i]);
        }
      }
      return container;  
    }

    /*
      Restituisce il numero di occorrenze nel testo della stringa "stringa".
      Lancia IllegalArgumentException se il parametro esplicito e` null.
    */
    public int frequency(String stringa)
    {  
      int count = 0;
      for(int i = 0; i < text.length -1; i++){
        if(text[i].equals(stringa)){
          count++;
        }
      }
      return count;   
    }

    /*
      restituisce la stringa che compare piu` volte nel testo (frequenza massima).
      Se piu` stringhe hanno frequenza massima, ne restituisce una qualsiasi.
      Se il testo e` vuoto restituisce null.
    */
    public String maxFrequency()
    { 
      String max = text[0];
      for(int i = 0; i < text.length - 1; i++){
        if(frequency(max) < frequency(text[i])){
          max = text[i];
        }
      }
      return max;   
    }

    /*
      restituisce la prima stringa del testo in ordine lessicografico.
      Se il testo e` vuoto restituisce null.
    */
    public String min()
    {  
      String min = text[0];
      for(int i = 0; i < text.length - 1; i++){
        if(min.compareTo(text[i]) > 0){
          min = text[i];
        }
      }
      return min;
    }

    /*
      restituisce l'ultima stringa del testo in ordine lessicografico.
      Se il testo e` vuoto restituisce null.
    */
    public String max()
    {  
      String max = text[0];
      for(int i = 0; i < text.length - 1; i++){
        if(max.compareTo(text[i]) < 0){
          max = text[i];
        }
      }
      return max;  
    }

    /*
      trasforma il testo in stringa. Viene inserito un carattere di nuova riga (\n)
      fra le stringhe. Se il testo e` vuoto restituisce la stringa vuota "".
    */
    public String toString()
    {  
      String s = "";
      for (int i = 0; i < text.length - 1; i++){
        s = s + text[i] + "\n";
      } 
      return s;  
    }

    /*
      crea un nuovo oggetto di tipo TextContainer in cui tutti i caratteri non
      alfabetici sono stati eliminati dalle stringhe del testo. Ad esempo elimina
      la punteggiatura, i numeri, le parentesi. Usa il metodo
      java.lang.Character.isLetter(char c)
    */
    //fatto
    public TextContainer onlyLetters()
    {  
      TextContainer cont = new TextContainer();
      String tmp = "";     
      for(int i = 0; i < text.length - 1; i++){
        tmp = text[i];
        for(int j = 0; j < tmp.length(); j++){
          if(!Character.isLetter(tmp.charAt(j))){
            tmp = tmp.substring(0, j) + tmp.substring(j+1, tmp.length());
            j--;
          }
        }
        if(tmp.length() != 0){
          cont.add(tmp);
        }
      }
      return cont;
    }

    /*
     crea un nuovo oggetto di tipo TextContainer nel quale tutti i caratteri
     maiuscoli sono stati convertiti in minuscoli.
    */
    public TextContainer toLowerCase()
    {  
      TextContainer container = new TextContainer();
      for(int i = 0; i < text.length -1; i++){
        container.add(text[i].toLowerCase());
      }
      return container;
    }

    /*
     crea una copia dell'oggetto TextContainer, e ne restituisce il riferimento
    */
    public TextContainer copy()
    {  
      TextContainer container = new TextContainer();
      for(int i = 0; i < text.length -1; i++){
        container.add(text[i]);
      }
      return container;   
    }

    private String[] text;
}