public interface Dictionary extends Container
{  // l'inserimento va sempre a buon fine; se la 
   // chiave non esiste, la coppia key/value viene
   // aggiunta al dizionario; se la chiave esiste già,
   // il valore ad essa associato viene sovrascritto
   // con il nuovo valore; se key è null viene
   // lanciata IllegalArgumentException
   void insert(Comparable key, Object value);
   // la rimozione della chiave rimuove anche
   // il corrispondente valore dal dizionario
   // e lancia DictionaryItemNotFound se le
   // chiave non esiste
   void remove(Comparable key);
   // la ricerca per chiave restituisce soltanto
   // il valore ad essa associato nel dizionario
   // e lancia DictionaryItemNotFound se la
   // chiave non esiste
   Object find(Comparable key);
}
//Eccezione che segnala il mancato ritrovamento di una chiave
class DictionaryItemNotFoundException extends RuntimeException {  }
