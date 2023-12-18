public class FibDoubleSol {
    public static void main(String[] args){
        System.out.println(recursiveFib(7));
        System.out.println(iterativeFib(7));
    }
    public static int recursiveFib(int n){
        if( n <= 0){
            throw new IllegalArgumentException();
        }
        if(n == 2 || n == 1){
            return 1;
        }
        return recursiveFib(n -1) + recursiveFib(n - 2);
    }
    public static int iterativeFib(int n){
        int res = 1;
        if(n <= 0){
            throw new IllegalArgumentException();
        }
        else if(n <= 1){
            return res;
        }else{
            int n1 = 1;
            int n2 = 0;
            for(int i = 2 ; i <= n ; i++){
                res = n1 + n2;
                n2 = n1;
                n1 = res;
            }
        }
        return res;
    }
}
