package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定排序
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        int sortedIndex = 0;
        while (sortedIndex < n) {
            int minIndex = sortedIndex;
            for (int i = minIndex; i < n; i++) {
                if (nums[minIndex] > nums[i]) {
                    minIndex = i;
                }
            }

            // 与选择排序不同 [直接交换]
            // 冒泡排序将[sortedIndex..minIndex]的依次向后移动
            int minVal = nums[minIndex];
            for (int i = minIndex; i > sortedIndex; i--) {
                nums[i] = nums[i - 1];
            }
            nums[sortedIndex++] = minVal;
            System.out.println(Arrays.toString(nums));
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 9, 2, 1, 6};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
