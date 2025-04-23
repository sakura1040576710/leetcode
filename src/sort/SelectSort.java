package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 不稳定排序
 */
public class SelectSort {

    /**
     * [3, 4, 1, 5, 9, 2, 1, 6]
     * [1, 4, 3, 5, 9, 2, 1, 6]
     * [1, 1, 3, 5, 9, 2, 4, 6]
     * [1, 1, 2, 5, 9, 3, 4, 6]
     * [1, 1, 2, 3, 9, 5, 4, 6]
     * [1, 1, 2, 3, 4, 5, 9, 6]
     * [1, 1, 2, 3, 4, 5, 9, 6]
     * [1, 1, 2, 3, 4, 5, 6, 9]
     * [1, 1, 2, 3, 4, 5, 6, 9]
     */
    public static void sort(int[] nums) {
        int n = nums.length;

        // sortedIndex 是一个分割线
        // 索引 < sortedIndex 的元素都是已排序的
        // 索引 >= sortedIndex 的元素都是未排序的
        int sortIndex = 0;
        while(sortIndex < n) {
            // 找到未排序部分 [sortedIndex, n) 中的最小值
            int minIndex = sortIndex;
            for(int i = sortIndex; i < n; ++i) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            int tmp = nums[sortIndex];
            nums[sortIndex] = nums[minIndex];
            nums[minIndex] = tmp;
            sortIndex++;
            System.out.println(Arrays.toString(nums));
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 9, 2, 1, 6};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
