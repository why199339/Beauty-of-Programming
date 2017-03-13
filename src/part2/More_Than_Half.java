package part2;

public class More_Than_Half {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 3 };
		System.out.println(find(nums));
	}

	public static int find(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int count = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				result = nums[i];
				count = 1;
				continue;
			}
			if (nums[i] == result) {
				count++;
			} else {
				count--;
			}
		}
		return result;
	}
}
