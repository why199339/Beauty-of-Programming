package part2;

import java.util.Arrays;
import java.util.HashSet;

public class Two_Sum {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 7 };
		int sum = 12;
		System.out.println(Arrays.toString(twoSum(nums, sum)));
		System.out.println(Arrays.toString(twoSum_2(nums, sum)));
	}

	// O(n), O(n)
	public static int[] twoSum(int[] nums, int sum) {
		if (nums == null) {
			return null;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(sum - nums[i])) {
				return new int[] { nums[i], sum - nums[i] };
			}
			set.add(nums[i]);
		}
		return null;
	}

	// O(n*logn), O(1)
	public static int[] twoSum_2(int[] nums, int sum) {
		if (nums == null) {
			return null;
		}
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == sum) {
				return new int[] { nums[i], nums[j] };
			} else if (nums[i] + nums[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
		return null;
	}
}
