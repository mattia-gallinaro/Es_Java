import java.util.Scanner;

public class TrisTester{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        String rep = "";
        while(!done){
            System.out.println("Inserisci Q per uscire dal programma,\n oppure scrivi qualcos'altro per giocare a tris");
            rep = scanner.nextLine();
            if(rep.equalsIgnoreCase("Q")){
                done = true;
            }else{
                Tris t = new Tris();
                while(t.getCount() < 9){
                    boolean insert = false;
                    while(!insert && t.getCount() < 9){
                        System.out.println("Giocatore 1 , inserisci le coordinate \n in cui vuoi posizionare x \n con questo formato \"0 1\"");
                        rep = scanner.nextLine();
                        try{
                            String[] line = rep.split(" ");
                            int row = Integer.parseInt(line[0]);
                            int column = Integer.parseInt(line[1]);
                            if(!t.setCharInPosition(row, column, 'x')){
                                System.out.println("Posizione gia` occupata");
                            }else{
                                insert = true;
                                System.out.println(t);
                            }
                        }catch(NumberFormatException e){
                            System.out.println("Devi inserire due numeri es -> 0 1");
                        }catch(IllegalArgumentException e){
                            System.out.println("Devi inserire due numeri compresi tra 0 e 2 es -> 0 1");
                        }
                    }
                    if(t.getCount() >= 5){
                        if(t.isWinning('x') || t.isWinning('o')){
                            break;
                        }
                    }
                    insert = false;
                    while(!insert && t.getCount() < 9){
                        System.out.println("Giocatore 2 , inserisci le coordinate \n in cui vuoi posizionare o \n con questo formato \"0 1\"");
                        rep = scanner.nextLine();
                        try{
                            String[] line = rep.split(" ");
                            int row = Integer.parseInt(line[0]);
                            int column = Integer.parseInt(line[1]);
                            if(!t.setCharInPosition(row, column, 'o')){
                                System.out.println("Posizione gia` occupata");
                            }else{
                                insert = true;
                                System.out.println(t);
                            }
                        }catch(NumberFormatException e){
                            System.out.println("Devi inserire due numeri es -> 0 1");
                        }catch(IllegalArgumentException e){
                            System.out.println("Devi inserire due numeri compresi tra 0 e 2 es -> 0 1");
                        }
                    }
                    if(t.getCount() >= 5){
                        if(t.isWinning('x') || t.isWinning('o')){
                            break;
                        }
                    }
                }
                if(t.isWinning('x')){
                    System.out.println("Ha vinto il giocatore 1");
                }else if(t.isWinning('o')){
                    System.out.println("Ha vinto il giocatore 2");
                }else{
                    System.out.println("Non ha vinto nessuno");
                }
            }
        }
    }
}