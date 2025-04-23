package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定排序
 */
public class InsertSort {

    /**
     * [3, 4, 1, 5, 9, 2, 1, 6]
     * [3, 4, 1, 5, 9, 2, 1, 6]
     * [3, 4, 1, 5, 9, 2, 1, 6]
     * [1, 3, 4, 5, 9, 2, 1, 6]
     * [1, 3, 4, 5, 9, 2, 1, 6]
     * [1, 3, 4, 5, 9, 2, 1, 6]
     * [1, 2, 3, 4, 5, 9, 1, 6]
     * [1, 1, 2, 3, 4, 5, 9, 6]
     * [1, 1, 2, 3, 4, 5, 6, 9]
     */
    public static void sort(int[] nums) {
        int n = nums.length;
        int sortedIndex = 0;
        // 维护 [0, sortedIndex) 是有序数组
        while (sortedIndex < n) {
            // 将 nums[sortedIndex] 插入到有序数组 [0, sortedIndex) 中
            for (int i = sortedIndex; i > 0; i--) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                } else {
                    break;
                }
            }
            sortedIndex++;
            System.out.println(Arrays.toString(nums));
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 9, 2, 1, 6};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
