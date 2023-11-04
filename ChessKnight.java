public class ChessKnight{
    
    public ChessKnight(String pos_in) {
        if(isChessValidSquare(pos_in)){
            pos_act = pos_in;
        }
    }

    public boolean isChessValidSquare(String chessSquare){
        final char MAX_LINE = '8';
        final char MIN_LINE = '1';
        final char MAX_COL = 'h';
        final char MIN_COL = 'a';
        

        if(chessSquare.length() == 2 
            && chessSquare.charAt(0) >= MIN_COL 
            && chessSquare.charAt(0) <= MAX_COL 
            && chessSquare.charAt(1) <= MAX_LINE 
            && chessSquare.charAt(1) >= MIN_LINE ) 
            {
                //System.out.println("i like that pos");
                return true;
            }
        //System.out.println("i do not like that pos");
        return false;
    }

    public boolean isKnightReachableSquare(String chessSquare){
        if(!isChessValidSquare(chessSquare))
        {
            //System.out.println("Ok");
            return false;
        }

        int col_diff = Math.abs(pos_act.charAt(0) - chessSquare.charAt(0));
        int line_diff = Math.abs(pos_act.charAt(1) - chessSquare.charAt(1));


        if((col_diff == 1 && line_diff == 2) || (col_diff == 2 && line_diff == 1))
        {
            //System.out.println("Ok");
            return true;
        }
        return false;
    }

    public void moveToSquare(String toChessSquare){
        if(isKnightReachableSquare(toChessSquare)){
            pos_act = toChessSquare;
        }
    }

    public String toString(){
        return "Cavallo in "+ pos_act;
    }

    private String pos_act;
}