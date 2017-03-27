package part2;

import java.util.Arrays;

public class Min_and_Max_Num_in_Array {

	public static void main(String[] args) {
		int[] nums = { 5, 6, 8, 3, 7, 9 };
		System.out.println(Arrays.toString(minMax_simplest(nums)));
		System.out.println(Arrays.toString(minMax_better(nums)));
		System.out.println(Arrays.toString(minMax_better_2(nums)));
		System.out.println(Arrays.toString(minMax_divide_and_conquer(nums, 0, nums.length - 1)));
	}

	// #compare = 2n
	public static int[] minMax_simplest(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int min = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			} else if (nums[i] > max) {
				max = nums[i];
			}
		}
		return new int[] { min, max };
	}

	// #compare = 1.5n£¬ broke the origin nums
	public static int[] minMax_better(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		if (nums.length == 1) {
			return new int[] { nums[0], nums[0] };
		}
		for (int i = 0; i < nums.length; i += 2) {
			if (nums[i] < nums[i + 1]) {
				int temp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = temp;
			}
		}
		int max = nums[0];
		int min = nums[1];
		for (int i = 2; i < nums.length; i += 2) {
			if (nums[i] > max) {
				max = nums[i];
			}
			if (nums[i + 1] < min) {
				min = nums[i + 1];
			}
		}
		return new int[] { min, max };
	}

	// #compare = 1.5n£¬ do not broke the origin nums
	public static int[] minMax_better_2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		if (nums.length == 1) {
			return new int[] { nums[0], nums[0] };
		}
		int max = Math.max(nums[0], nums[1]);
		int min = Math.min(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i += 2) {
			int bigger = Math.max(nums[i], nums[i + 1]);
			int smaller = Math.min(nums[i], nums[i + 1]);
			if (bigger > max) {
				max = bigger;
			}
			if (smaller < min) {
				min = smaller;
			}
		}
		return new int[] { min, max };
	}

	// #compare = 1.5n - 2
	public static int[] minMax_divide_and_conquer(int[] nums, int low, int high) {
		if (high - low <= 1) {
			if (nums[high] < nums[low]) {
				return new int[] { nums[high], nums[low] };
			} else {
				return new int[] { nums[low], nums[high] };
			}
		}
		int max = nums[low];
		int min = nums[low];
		int mid = low + (high - low) / 2;
		int[] left = minMax_divide_and_conquer(nums, low, mid);
		int[] right = minMax_divide_and_conquer(nums, mid + 1, high);
		min = Math.min(left[0], right[0]);
		max = Math.max(left[1], right[1]);
		return new int[] { min, max };
	}
}
