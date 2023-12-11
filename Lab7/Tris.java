public class Tris {
    /*
     * costruttore che crea (ma non visualizza!)
     * la scacchiera con i puntini
     */
    public Tris() {
        scacchiera = new char[3][3];
        for (int i = 0; i < scacchiera.length; i++) {
            for (int j = 0; j < scacchiera[i].length; j++) {
                scacchiera[i][j] = '.';
            }
        }
    }

    /*
     * restituisce una stringa da usare per visualizzare la scacchiera
     * (deve contenere anche i caratteri per andare a capo al termine
     * di ognuna delle tre righe)
     */
    public String toString() {
        return "|" + scacchiera[0][0] + "" + scacchiera[0][1] + "" + scacchiera[0][2] + "|\n" +
                "|" + scacchiera[1][0] + "" + scacchiera[1][1] + "" + scacchiera[1][2] + "|\n" +
                "|" + scacchiera[2][0] + "" + scacchiera[2][1] + "" + scacchiera[2][2] + "|\n";
    }

    /*
     * imposta la posizione [row][column] al valore c;
     * lancia IllegalArgumentException se le coordinate sono errate;
     * restituisce false se e solo se la posizione era gia' occupata
     */
    public boolean setCharInPosition(int row, int column, char c) {
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            throw new IllegalArgumentException();
        } else {
            if (scacchiera[row][column] != '.') {
                return false;
            } else {
                scacchiera[row][column] = c;
                return true;
            }
        }
    }

    /*
     * restituisce il carattere presente nella posizione [row][column];
     * lancia IllegalArgumentException se le coordinate sono errate
     */
    public char getCharInPosition(int row, int column) {
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            throw new IllegalArgumentException();
        } else {
            return scacchiera[row][column];
        }
    }

    /*
     * restituisce il numero di posizioni occupate nella scacchiera
     */
    public int getCount() {
        int count = 0;
        for (int i = 0; i < scacchiera.length; i++) {
            for (int j = 0; j < scacchiera[i].length; j++) {
                if (scacchiera[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * restituisce true se e solo se esiste nella scacchiera una
     * configurazione vincente per il carattere c
     */
    public boolean isWinning(char c) {
        // ciclo per controllare le righe
        boolean win = true;
        for (int i = 0; i < scacchiera.length; i++) {
            win = true;
            if (scacchiera[i][0] == c) {
                for (int j = 0; j < scacchiera[i].length - 1 && win == true; j++) {
                    if (scacchiera[i][j] != scacchiera[i][j + 1]) {
                        win = false;
                    }
                }
            }else{
                win = false;
            }
            if (win)
                return win;
        }

        //per controllare le colonne
        for (int i = 0; i < 3; i++) {
            win = true;
            if (scacchiera[0][i] == c) {
                for (int j = 0; j < 2 && win == true; j++) {
                    if (scacchiera[j][i] != scacchiera[j + 1][i]) {
                        win = false;
                    }
                }
            }else{
                win = false;
            }
            if (win)
                return win;
        }
        
        //per controllare le diagonali
        if(scacchiera[0][0] == c && scacchiera[1][1] == c && scacchiera[2][2] == c){
            return true;
        }
        if(scacchiera[2][0] == c && scacchiera[1][1] == c && scacchiera[2][0] == c){
            return true;
        }
        return false;
    }

    private char[][] scacchiera;
}