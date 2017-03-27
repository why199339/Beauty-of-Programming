package part2;

import java.util.Arrays;

public class RightShift {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int k = 4;
		// rightShift_bad(nums, k);
		rightShift_good(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	public static void rightShift_good(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	private static void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

	public static void rightShift_bad(int[] nums, int k) {
		k = k % nums.length;
		while (k > 0) {
			int temp = nums[nums.length - 1];
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = temp;
			k--;
		}
	}
}
