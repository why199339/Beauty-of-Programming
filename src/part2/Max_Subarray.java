package part2;

public class Max_Subarray {

	public static void main(String[] args) {

	}

	public static int maxSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] < 0) {
				temp = nums[i];
			} else {
				temp += nums[i];
			}
			max = Math.max(max, temp);
		}
		return max;
	}
}
