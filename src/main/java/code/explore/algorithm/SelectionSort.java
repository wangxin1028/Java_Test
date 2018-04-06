package code.explore.algorithm;

public class SelectionSort {
    public static void sort(int[] array){
        for(int i = 0 ; i < array.length-1 ; i++){
            int min = array[i];
            int minIndex = i;
            for(int j = i+1 ; j < array.length ; j++){
                if(array[j]<min){
                    min = array[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                array[i] = array[i] ^ array[minIndex];
                array[minIndex] = array[i] ^ array[minIndex];
                array[i] = array[i] ^ array[minIndex];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,6,3,1,8,4,9,0,23,6};
        sort(array);
        for(int i = 0 ; i < array.length ;i++){
            System.out.println(array[i]);
        }
    }
}
