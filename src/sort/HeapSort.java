package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(1)
 * 不稳定排序
 */
public class HeapSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        heapify(nums, n);
        for (int i = n - 1; i >= 0; ) {
            swap(nums, 0, i);
            i--;
            sift(nums, 0, i);
        }
    }

    private static void heapify(int[] nums, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            sift(nums, i, n - 1);
        }
    }

    private static void sift(int[] nums, int start, int end) {
        while (2 * start + 1 <= end) {
            int j = 2 * start + 1;
            if (j + 1 <= end && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[j] > nums[start]) {
                swap(nums, start, j);
            } else {
                break;
            }
            start = j;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 9, 2, 1, 6};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
