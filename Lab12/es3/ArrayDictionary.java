public class ArrayDictionary implements Dictionary
{   public ArrayDictionary()
    {   v = new Pair[INITSIZE];
        makeEmpty();  
    }
    // metodi pubblici
    public boolean isEmpty()
    {   return vSize == 0;  }
    public void makeEmpty()
    {   vSize = 0;  }
    public String toString()
    {   String s = "";
        for (int i = 0; i < vSize; i++)
            s = s + v[i] + "\n";
        return s;
    }
    public void insert(Comparable key, Object value)
    {   if (key == null)  throw new IllegalArgumentException();
        try 
        { remove(key); } //elimina l'elemento se gia` presente 
        catch (DictionaryItemNotFoundException e) 
        {} //... ovvero l'elemento viene sovrascritto se gia` presente
        if (vSize == v.length) 
            v = resize(2*vSize);
        v[vSize++] = new Pair(key, value);
    }
    protected Pair[] resize(int newLength) //metodo ausiliario
    {   if (newLength <v.length) throw new IllegalArgumentException();
        Pair[] newv = new Pair[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }
    public void remove(Comparable key)
    {   v[linearSearch(key)] = v[--vSize];    
    }
    public Object find(Comparable key)
    {   return v[linearSearch(key)].getValue();
    }
    private int linearSearch(Comparable key) //metodo ausiliario
    {   for (int i = 0; i < vSize; i++)
            if (v[i].getKey().compareTo(key) == 0)
            //oppure if (v[i].getKey().equals(key)), se il
            //metodo equals e` stato realizzato correttamente
                return i;
        throw new DictionaryItemNotFoundException(); 
    }
    
    //campi di esemplare
    protected Pair[] v;
    protected int vSize;
    protected final static int INITSIZE = 10;

    //classe interna Pair
    protected class Pair 
    {   //costruttore
        public Pair(Comparable key, Object value)
        {   setKey(key); 
            setValue(value); 
        }
        //metodi pubblici
        public String toString()
        {  return key + " " + value; } 
        public Comparable getKey()
        {  return key; }
        public Object getValue()
        {  return value; }
        public void setKey(Comparable key)
        {  this.key = key; }
        public void setValue(Object value)
        {  this.value = value; } 
        //campi di esemplare
        private Comparable key; 
        private Object value;
    }
}
