package part2;

public class Num_of_One_From_1_to_n {

	public static void main(String[] args) {
		System.out.println(count_bruteForce(12));
		System.out.println(count_better(12));
	}

	// O(len)
	public static int count_better(int n) {
		int count = 0;
		int factor = 1;
		int lowerNum = 0;
		int curNum = 0;
		int higherNum = 0;
		while (n / factor != 0) {
			lowerNum = n - (n / factor) * factor;
			curNum = (n / factor) % 10;
			higherNum = n / (factor * 10);
			switch (curNum) {
			case 0:
				count += higherNum * factor;
				break;
			case 1:
				count += higherNum * factor + lowerNum + 1;
				break;
			default:
				count += (higherNum + 1) * factor;
				break;
			}
			factor *= 10;
		}
		return count;
	}

	// O(N * longN)
	public static int count_bruteForce(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j != 0) {
				if (j % 10 == 1) {
					count++;
				}
				j /= 10;
			}
		}
		return count;
	}

}
