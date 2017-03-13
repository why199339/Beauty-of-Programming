package part2;

public class Factorial_Num_of_End_Zero {

	public static void main(String[] args) {
		System.out.println(count_1(10));
	}

	public static int count_1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j % 5 == 0) {
				count++;
				j = j / 5;
			}
		}
		return count;
	}

	public static int count_2(int n) {
		int count = 0;
		while (n > 0) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}
}
