import java.util.Scanner;

public class StudentManager{
    public static void main(String[] args){
        boolean done = false;
        Scanner scanner = new Scanner(System.in);
        Student[] student = new Student[1];
        int count = 0;
        String name = "";
        while(!done){
            System.out.println("Inserisci cognome voto orale e voto scritto es -> (Cracco 18 21)");
            name = scanner.nextLine();
            try{
                getStudent(name);
                if(count == student.length){
                    student = resize(student);
                }
                student[count] = getStudent(name);
                count += 1;
            }catch(IllegalArgumentException e){
                System.out.println("Hai inserito i dati nel modo errato");
                done = true;
            }
        }
        for(int i = 0; i < student.length; i++){
            System.out.println(student[i].getName());
        }
        done = false;
        while(!done){
            System.out.println("Inserisci Q per terminare l'inserimento\nInserisci S per cercare il cognome di uno studente");
            String s = scanner.nextLine();
            if(s.equalsIgnoreCase("Q")){
                done = true;
            }else if(s.equalsIgnoreCase("S")){
                System.out.println("Inserisci il cognome di uno studente");
                String se = scanner.nextLine();
                if(searchStud(student, se) == -1){
                    System.out.println("Il cognome inserito non e` presente");
                }else{
                    System.out.println("Media dello studente: "+ stamp_media(student[searchStud(student , se)]));
                }
            }
        }
        scanner.close();
    }


    private static Student getStudent(String name){
        
        String[] all_names = name.split(" ");
        
        if(all_names.length  % 3 != 0){
            throw new IllegalArgumentException();
        }
        try{
            Integer.parseInt(all_names[1]); 
            Integer.parseInt(all_names[2]);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return new Student(all_names[0],  Integer.parseInt(all_names[1]),  Integer.parseInt(all_names[2]));
    }

    private static int searchStud(Student[] student, String name){
        for(int i = 0; i < student.length; i++){
            if(student[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private static String stamp_media(Student student){
        return Integer.toString(student.getMedia());
    } 

    private static Student[] resize(Student[] student){
        Student[] studs = new Student[student.length + 1];
        for(int i = 0; i < student.length; i++){
            studs[i] = student[i];
        }
        return studs;
    }
}

class Student{
    public Student(String name, int prov_orale, int prov_scritta){
        name_stud = name;
        this.prov_orale = prov_orale;
        this.prov_scritta = prov_scritta;
    }

    public int getProv_orale(){
        return prov_orale;
    }

    public int getProv_scritt(){
        return prov_scritta;
    }

    public String getName(){
        return name_stud;
    }

    public int getMedia(){
        return (prov_orale + prov_scritta)/2;
    }
    private int prov_scritta;
    private int prov_orale;
    private String name_stud;
}