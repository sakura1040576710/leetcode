package sort;

import java.util.Arrays;

/**
 * 计数排序（不重要）
 */
public class JishuSort {

    private static final int OFFSET = 50000;

    public static void sortArray(int[] nums) {
        int len = nums.length;
        // 由于 -50000 <= A[i] <= 50000
        // 因此"桶" 的大小为 50000 - (-50000) = 10_0000
        // 并且设置偏移 OFFSET = 50000，目的是让每一个数都能够大于等于 0
        // 这样就可以作为 count 数组的下标，查询这个数的计数
        int size = 10_0000;

        // 计数数组
        int[] count = new int[size];
        // 计算计数数组
        for (int num : nums) {
            count[num + OFFSET]++;
        }

        // 把 count 数组变成前缀和数组
        for (int i = 1; i < size; i++) {
            count[i] += count[i - 1];
        }

        // 先把原始数组赋值到一个临时数组里，然后回写数据
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);

        // 为了保证稳定性，从后向前赋值
        for (int i = len - 1; i >= 0; i--) {
            int index = count[temp[i] + OFFSET] - 1;
            nums[index] = temp[i];
            count[temp[i] + OFFSET]--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 9, 2, 1, 6};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
    }

}
