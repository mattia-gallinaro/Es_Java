public class Padlock{
    public Padlock(){
        combination = "0000";
        isOpen = true;
    }

    public Padlock(String pw){
        combination = pw;
        isOpen = true;
    }

    public void close(){
        isOpen = false;
    }

    public void open(String pw){
        if(combination.equals(pw)){
            isOpen = true;
        }
    }

    public void setPasswd(String oldPw,String newPw){
        if(newPw != null && !newPw.equals("") && combination.equals(oldPw)){
            combination = newPw;
        }
    }

    public String toString(){
        if(isOpen){
            return "Padlock OPEN";
        }else{
            return "Padlock CLOSED";
        }
    }

    private String combination;
    private boolean isOpen;
}