package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(n)
 * 稳定排序
 */
public class MergeSort {

    public static void sort(int[] nums) {
        msort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    public static void msort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            msort(nums, left, mid, tmp);
            msort(nums, mid + 1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int c1 = left, c2 = mid + 1;
        int pos = left;
        while (c1 <= mid && c2 <= right) {
            if (nums[c1] >= nums[c2]) {
                tmp[pos++] = nums[c2++];
            } else {
                tmp[pos++] = nums[c1++];
            }
        }
        while (c1 <= mid) {
            tmp[pos++] = nums[c1++];
        }
        while (c2 <= right) {
            tmp[pos++] = nums[c2++];
        }
        while (left <= right) {
            nums[left] = tmp[left];
            left++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 9, 2, 1, 6};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
