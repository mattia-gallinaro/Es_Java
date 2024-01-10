public class SortedArrayDictionary extends ArrayDictionary{
	public void insert(Comparable key, Object value){
		if (key == null)  throw new IllegalArgumentException();
        try 
        { remove(key); } //elimina l'elemento se gia` presente 
        catch (DictionaryItemNotFoundException e) 
        {} //... ovvero l'elemento viene sovrascritto se gia` presente
        if (vSize == v.length) 
            v = resize(2*vSize);
        Pair p = new Pair(key, value);
        // sposta a destra di un posto tutti gli el. a
        // sin. di temp e > di temp, partendo da destra
        for (j = size -1; j > 0 && temp.compareTo(v[j-1]) < 0; j--){
           v[j] = v[j-1];
           v[j] = temp; // inserisci temp in posizione
        }
	}
	
	public void remove(Comparable key)
	{
		int index = binarySearch(key, 0 , vSize);
		if(index == -1){
			throw new DictionaryItemNotFoundException();
		}else{
			for(int i = index; i < vSize -1; i++){
				v[i] = v[i+1];
			}
			vSize--;
		}
	}
	/*public void remove(Comparable key)
    {   
    	v[linearSearch(key)] = v[--vSize];    
    }*/
    /*public Object find(Comparable key)
    {   
    	return v[linearSearch(key)].getValue();
    }
    private int linearSearch(Comparable key) //metodo ausiliario
    {   for (int i = 0; i < vSize; i++)
            if (v[i].getKey().compareTo(key) == 0)
            //oppure if (v[i].getKey().equals(key)), se il
            //metodo equals e` stato realizzato correttamente
                return i;
        throw new DictionaryItemNotFoundException(); 
    }*/
    
	public Object find(Comparable key){
		int index = binarySearch(key, 0, vSize);
		if(index == -1){
			throw new DictionaryItemNotFoundException();
		}else{
			return v[index].getValue();
		}
	}
	
	private int binarySearch(Comparable key, int from , int to){
		if(from > to){
			return -1;
		}
		int mid = (from + to) /2;
		if(v[mid].getKey().compareTo(key) == 0){
			return mid;
		}else if (v[mid].getKey().compareTo(key) < 0){
			return binarySearch(key, mid + 1, to);
		}else{
			return binarySearch(key, from, mid -1);
		}
	}
}
