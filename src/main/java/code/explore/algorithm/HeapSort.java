package code.explore.algorithm;

/**
 * 用数组实现二叉树 不使用数组的第一个元素
 * 父节点个数：（数组长度-1）/2
 * 父节点索引：父节点个数到1
 * 左儿子：父节点索引*2
 * 右儿子：父节点索引*2+1
 * <p>
 * 堆排序：大顶堆  不断缩小树的大小
 */
public class HeapSort {
    public static void sort(int[] array) {
        int size = array.length;
        while (size > 2) {
            //从下往上所有父节点
            for (int i = (size-1) / 2; i >= 1; i--) {
                //选出最大儿子
                int maxIndex = i * 2; //左儿子
                if (maxIndex + 1 < size && array[maxIndex + 1] > array[maxIndex]) {//右儿子不一定存在，要先判断maxIndex+1<array.length
                    maxIndex = maxIndex + 1;
                }
                //最大的儿子和父亲比较
                if (array[maxIndex] > array[i]) {
                    array[maxIndex] = array[maxIndex] ^ array[i];
                    array[i] = array[maxIndex] ^ array[i];
                    array[maxIndex] = array[maxIndex] ^ array[i];
                }
            }
            //经过一轮循环，最大的数已经是根节点 根节点和最后一个节点交换
            array[1] = array[1] ^ array[size-1];
            array[size - 1] = array[1] ^ array[size-1];
            array[1] = array[1] ^ array[size-1];

            //树的大小减一
            size--;
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
