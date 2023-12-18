public class MCDEuclideRec {
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Numero di argomenti inseriti è errato ");
            throw new IllegalArgumentException();
        }
        int m = -1;
        int n = 0;
        try{
            m = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
            if(m <= 0|| n > m){
                System.out.println("argomenti inseriti errati ");
                throw new IllegalArgumentException();
            }
        }catch(NumberFormatException e){
            System.out.println("argomenti inseriti errati ");
            throw new IllegalArgumentException();
        }
        System.out.println("MCD tra m e n : " + recursiveMCD(m, n));
    }

    public static int recursiveMCD(int m , int n){
        if(m % n == 0){
            return n;
        }
        int tmp = m + 0;
		m = n + 0;
		n = (tmp) % n;

        return recursiveMCD(m, n);
    }
}
