package part2;

public class Max_Subarray_2dimention {

	public static void main(String[] args) {

	}

	public static int maxSubarray(int[][] nums) {
		int finalMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int max = colSum(nums, i, j, 0);
				int temp = colSum(nums, i, j, 0);
				for (int col = 0; col < nums[0].length; col++) {
					temp = Math.max(colSum(nums, i, j, col) + temp, colSum(nums, i, j, col));
					max = Math.max(temp, max);
				}
				finalMax = Math.max(max, finalMax);
			}
		}
		return finalMax;
	}

	private static int colSum(int[][] nums, int i, int j, int col) {
		int sum = 0;
		for (int index = i; index <= j; index++) {
			sum += nums[index][col];
		}
		return sum;
	}
}
