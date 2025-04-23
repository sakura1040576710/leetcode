package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 时间复杂度 O(n^1.3)
 * 空间复杂度 O(1)
 * 不稳定排序
 */
public class XierSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        // 希尔排序是插入排序的改进
        // 将数组按h为单位来进行排序 h以此减少到1
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            int sortedIndex = h;
            while (sortedIndex < n) {
                for (int i = sortedIndex; i >= h; i -= h) {
                    if (nums[i] < nums[i - h]) {
                        int tmp = nums[i];
                        nums[i] = nums[i - h];
                        nums[i - h] = tmp;
                    } else {
                        break;
                    }
                }
                sortedIndex++;
            }
            System.out.println(h + " : " + Arrays.toString(nums));
            h = (int) Math.floor(h / 3);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 9, 2, 1, 6};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
