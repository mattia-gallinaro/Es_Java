import java.util.NoSuchElementException;

public class Text implements Container
{
    /*
        costruisce un contenitore di testo vuoto
    */
    public Text()
    { 
    	text = new String[10];
    	nWord =0;
    } 

    /*
      ... metodi di Container da realizzare ...
    */

	public void isEmpty(){
		return nWord == 0;
	}
	
	public void makeEmpty(){
		text  = new String[10];
		nWord = 0;
	}
    /*
        restituisce il numero di elementi presenti nel contenitore
    */
    public int size()
    { 
    	return nWord; 
    } 

    /*
        aggiunge la parola aWord in coda all'elenco
        se l'elenco e' pieno, ridimensiona l'elenco.
    */
    public void add(String aWord)
    { 
    	if(nWord == text.length -1){
    		resize(text.length * 2);
    	} 
    } 

	private void resize(int newSize)
	{
		String[] newArr = new String[newSize];
		System.arrayCopy(text, 0, newArr, 0 ,text.length -1);
		text = newArr;
	}
    /*
        ordina per fusione l'elenco delle parole.
    */
    public void sort()
    { ... } //completare

    /*
        restituisce l'ultima parola dell'elenco, rimuovendola
        Lancia NoSuchElementException se l'elenco e' vuoto
    */
    public String removeLast() throws NoSuchElementException
    { 
    	if(isEmpty()){
    		throw new NoSuchElementException();
    	} 
    } 
    private String[] text;
    private int nWord;
}

