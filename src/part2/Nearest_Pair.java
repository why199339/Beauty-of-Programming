package part2;

import java.util.Arrays;

public class Nearest_Pair {

	public static void main(String[] args) {

	}

	// O(n^2)
	public static double minDifference_simplest(double[] nums) {
		if (nums == null || nums.length < 2) {
			return 0.0;
		}
		double min = Math.abs(nums[0] - nums[1]);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; i < nums.length; j++) {
				double temp = Math.abs(nums[j] - nums[i]);
				if (temp < min) {
					min = temp;
				}
			}
		}
		return min;
	}

	public static double minDifference_sort(double[] nums) {
		if (nums == null || nums.length < 2) {
			return 0.0;
		}
		Arrays.sort(nums);
		double min = Math.abs(nums[0] - nums[1]);
		for (int i = 2; i < nums.length; i++) {
			double temp = nums[i] - nums[i - 1];
			if (temp < min) {
				min = temp;
			}
		}
		return min;
	}

}
