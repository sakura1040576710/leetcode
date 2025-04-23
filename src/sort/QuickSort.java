package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(logn)
 * 不稳定排序
 */
public class QuickSort {

    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid);
            quickSort(nums, mid + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = left + new Random().nextInt(right - left + 1);
        swap(nums, left, pivot);
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, j, left);
        System.out.println(pivot + " : " + Arrays.toString(nums));
        return j;
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
