import java.util.Random;

public class FindMinRec {
    public static void main(String[] args){
        int dim = 0;
        int n = 0;
        if(args.length != 2){
            throw new IllegalArgumentException();
        }
        try{
            dim = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
            if(dim < 1|| n < 1){
                throw new IllegalArgumentException();
            }
        }catch(NumberFormatException e){
            System.out.println("Argomenti inseriti errati");
        }
        int[] arr = generateArr(dim, n);
        //StampArr(arr);
        System.out.println(findMin(arr, 0, 0));
    }
    /*public static void StampArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        } 
    }*/
    public static int[] generateArr(int dim, int max){
        Random rand = new Random();

        int[] res = new int[dim];
        for(int i = 0; i < dim; i++){
            res[i] = rand.nextInt(max) + 1;
        }
        return res;
    }
    public static int findMin(int[] arr, int min, int pos){
        if(pos == arr.length){
            return min;
        }
        if(arr[min] > arr[pos]){
            min = pos;
        }
        return findMin(arr, min, pos + 1);
    }
}
