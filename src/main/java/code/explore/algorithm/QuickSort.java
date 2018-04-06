package code.explore.algorithm;

public class QuickSort {
    public static void sort(int[] array){
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array,int left,int right){
       if(left<right){
           int middle = unitSort(array, left, right);
           quickSort(array,left,middle-1);
           quickSort(array,middle+1, right);
       }
       return;
    }

    private static int unitSort(int[] array,int left,int right){
        int flag=array[left];
        while(left<right){
            while(left<right){
                if(array[right]<flag){
                    array[left]=array[right];
                    break;
                }
                right--;
            }
            while(left<right){
                if(array[left]>=flag){
                    array[right]=array[left];
                    break;
                }
                left++;
            }
        }
        array[right]=flag;
        return right;
    }
    
    public static void main(String[] args) {
        int[] array = {5,6,3,1,8,4,9,0,23,6};
        sort(array);
        for(int i = 0 ; i < array.length ;i++){
            System.out.println(array[i]);
        }
    }
}
