public class ChessRook{
    public ChessRook(String initialSquare){
        if(isChessValidSquare(initialSquare)){
            pos = initialSquare;
        }
    }

    public void moveToSquare(String toChessSquare){
        if(isChessValidSquare(toChessSquare) && isRookValidSquare(toChessSquare)){
            pos = toChessSquare;
        }
    }

    private boolean isChessValidSquare(String checkPos){
        if(checkPos.length() == 2 && (checkPos.charAt(0) >=  'a' && checkPos.charAt(0) <= 'h') && (checkPos.charAt(1) >= '1' && checkPos.charAt(1) <= '8')){
            return true;
        }
        return false;
    }

    private boolean isRookValidSquare(String checkPos){
        return checkPos.charAt(0) == pos.charAt(0) || checkPos.charAt(1) == pos.charAt(1);
    }
    public String toString(){
        return "Torre in "+ pos;
    }
    public String pos;
}