package part2;

public class Max_Multiply_in_Array {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(maxMultiply(nums));
	}

	public static int maxMultiply(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int[] result = new int[nums.length];
		int max = nums[0];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = nums[i - 1] * result[i - 1];
		}
		int temp = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			temp = temp * nums[i + 1];
			result[i] = result[i] * temp;
			if (result[i] > max) {
				max = result[i];
			}
		}
		return max;
	}
}
