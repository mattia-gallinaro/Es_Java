public class recSelectionSort {
    public static void main(String[] args){
        int[] arr = new int[]{0,1,5,2,90,1,2,3};
        int[] res = recSelectionSort(arr, 0);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

    public static int[] recSelectionSort(int[] from,int from_pos){
        if(from.length == 0){
            throw new IllegalArgumentException();
        }

        if(from_pos == from.length - 1){
            return from;
        }

        int pos = findMinPos(from , from_pos);
        int tmp = from[pos];

        from[pos] = from[from_pos];
        from[from_pos] = tmp;
        from_pos++;

        return recSelectionSort(from, from_pos);
    }

    private static int findMinPos(int[] arr, int start){
        int min = start;
        for(int i = start + 1; i < arr.length; i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }
}
