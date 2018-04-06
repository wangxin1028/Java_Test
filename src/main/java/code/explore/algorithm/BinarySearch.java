package code.explore.algorithm;

public class BinarySearch {
    public static int search(int[] array,int target){
        int left = 0;
        int right = array.length-1;
        while(left<=right){
            int middle = (left+right) >> 1;
            if(array[middle]>target){
                right=middle-1;
            }else if(array[middle]<target){
                left=middle+1;
            }else{
                return middle;
            }
        }
        return -right-1;
    }

    public static void main(String[] args) {
        int[] array = {5,6,3,1,8,4,9,0,23,6};
        QuickSort.sort(array);
        for(int i = 0 ; i < array.length ;i++){
            System.out.println(array[i]);
        }
        int index = search(array, 2);
        System.out.println(index);
    }
}
