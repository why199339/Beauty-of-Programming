package part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class K_Big_Nums_in_a_Array {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 4;
//		int[] result = getKBig_partition(nums, k);
		int[] result = getKBig_heap(nums, k);
		System.out.println(Arrays.toString(result));
	}

	public static int[] getKBig_heap(int[] nums, int k) {
		int[] result = new int[k];
		if (nums == null || nums.length == 0 || k < 0) {
			return null;
		}
		if (nums.length <= k) {
			return nums;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (list.size() != k) {
				list.add(nums[i]);
			} else {
				Collections.sort(list);
				if (list.get(k - 1) > nums[i]) {
					list.remove(k - 1);
					list.add(nums[i]);
				}
			}
		}
		for (int i = 0; i < k; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static int[] getKBig_partition(int[] nums, int k) {
		int[] result = new int[k];
		if (nums == null || nums.length == 0 || k < 0) {
			return null;
		}
		if (nums.length <= k) {
			return nums;
		}
		int start = 0;
		int end = nums.length - 1;
		int index = partition(nums, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				index = partition(nums, start, index - 1);
			} else {
				index = partition(nums, index + 1, end);
			}
		}
		for (int i = 0; i < k; i++) {
			result[i] = nums[i];
		}
		return result;
	}

	private static int partition(int[] nums, int start, int end) {
		int index = (int) (start + (end - start + 1) * Math.random());
		int temp = nums[index];
		nums[index] = nums[end];
		nums[end] = temp;
		int small = start - 1;
		for (int i = start; i < end; i++) {
			if (nums[i] < nums[end]) {
				small++;
				if (small != i) {
					temp = nums[i];
					nums[i] = nums[small];
					nums[small] = temp;
				}
			}
		}
		small++;
		temp = nums[small];
		nums[small] = nums[end];
		nums[end] = temp;
		return index;
	}
}
