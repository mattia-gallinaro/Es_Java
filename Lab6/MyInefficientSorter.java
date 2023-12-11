import java.util.Scanner;

public class MyInefficientSorter{
    public static void main(String[] args){
        int[] arr = new int[1000];
        int k = 0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            arr[k] = sc.nextInt();
            k++;
        }
        int[] arr_appog = new int[arr.length];
        for(int i = 0; i < arr_appog.length; i++){
            int index = minInd(arr);
            arr_appog[i] = arr[index];
            arr = removeElement(arr ,index);
        }
        stamp_res(arr_appog);
    }

    private static int minInd(int[] arr){
        int min = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[min])
                min = i;
        }
        return min;
    }

    private static int[] removeElement(int[] arr, int index_el){
        int[] arr_res = new int[arr.length -1];
        arr[index_el] = arr[arr.length -1];
        for(int i = 0; i < arr_res.length ; i++ , j++){
            if(i == index_el){
                i++;
                arr_res[j] = arr[i];
            }
        }
        return arr_res;
    }

    private static void stamp_res(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}