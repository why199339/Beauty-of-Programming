package part2;

public class Number_Of_1 {

	public static void main(String[] args) {
		System.out.println(count_1(5));
		System.out.println(count_2(5));
		System.out.println(count_3(5));
	}

	// O(n), O(1)
	public static int count_1(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				count++;
			}
			n = n / 2;
		}
		return count;
	}

	// O(n), O(1)
	public static int count_2(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 0x01) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}

	// O(m), O(1), m is the number of 1
	public static int count_3(int n) {
		int count = 0;
		while (n > 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	// O(1)
	public static int count_4(int n) {
		int[] countTable = {};
		return countTable[n];
	}
}
