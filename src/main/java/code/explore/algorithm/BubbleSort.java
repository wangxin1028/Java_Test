package code.explore.algorithm;

public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    array[j] = array[j] ^ array[j+1];
                    array[j+1] = array[j] ^ array[j+1];
                    array[j] = array[j] ^ array[j+1];
                }
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
