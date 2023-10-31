//Es 7 Lab 2 

import java.util.Scanner;

public class TimeConverterJava{
    public static void main(String[] args){
        final int MIN_HOURS = 60;
        int time_start = 1930;
        int time_end = 2050;
        int min_time_start = (time_start % 100)  + (time_start / 100) * MIN_HOURS;  /*  prende il resto della divisione (che corrispondo ad un valore di minuti tra 0 e 59 )
                                                                                        poi somma ai minuti ottenuti le ore moltiplicate per 60
                                                                                    */
        int min_time_end = (time_end % 100)  + (time_end / 100) * MIN_HOURS; // stessa cosa di quello di prima solo che per il tempo finale
        int diff = min_time_end - min_time_start;
        //int minutes = (int)(timestart / MIN_HOURS);
        //int seconds = (int)(timestart % MIN_HOURS);

        System.out.print("Result : "+ diff / MIN_HOURS + " ore e " + diff % MIN_HOURS + " minuti");

    }
}