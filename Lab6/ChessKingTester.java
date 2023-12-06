class ChessKing{
    public ChessKing(String initialString) {
        if(isChessValidSquare(initialString)){
            pos = initialString;
        }
    }

    public void moveToSquare(String toChessSquare){
        if(isKingReachableSquare(toChessSquare)){
            pos = toChessSquare;
        }
    }

    private boolean isChessValidSquare(String initialString){
        return  initialString.length() == 2 && initialString.charAt(0) >= 'a' && initialString.charAt(0) <= 'h' && initialString.charAt(1) >='1' && initialString.charAt(1) <= '8';
    }

    private boolean isKingReachableSquare(String new_pos){
        if(isChessValidSquare(new_pos)){
            int dif_col = Math.abs(new_pos.charAt(0) - pos.charAt(0));
            int dif_line = Math.abs(new_pos.charAt(1) - pos.charAt(1));
            return (dif_col + dif_line) <= 2 && dif_col <= 1 && dif_line <=	1;
        }
        return false;
    }
    
    public String toString(){
        return "Re in "+ pos; 
    }

    private String pos;
}


public class ChessKingTester
{
   public static void main(String[] args)
   {
      final String INITIAL_CHESS_SQUARE = "f5";
      final String MOVE1 = "f6";
      final String MOVE2 = "e6";
      final String MOVE3 = "e5";
      final String MOVE4 = "e4";
      final String MOVE5 = "f6";

      ChessKing b1 = new ChessKing(INITIAL_CHESS_SQUARE);     
      System.out.println(b1);
      
      b1.moveToSquare(MOVE1);
      System.out.println(b1);
      
      b1.moveToSquare(MOVE2);
      System.out.println(b1); 
           
      b1.moveToSquare(MOVE3);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE4);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE5);  // casa non raggiungibile
      System.out.println(b1);
      
      b1.moveToSquare("abc");  // casa non valida
      System.out.println(b1);                     

      b1.moveToSquare("p9");  // casa non valida
      System.out.println(b1);           
   }

}