package part2;

public class Factorial_Position_of_One {

	public static void main(String[] args) {
		System.out.println(lowestOne_1(3));
		System.out.println(lowestOne_2(3));
	}

	public static int lowestOne_1(int n) {
		int count = 0;
		while (n > 0) {
			n >>= 1;
			count += n;
		}
		return count;
	}

	public static int lowestOne_2(int n) {
		int count = 0;
		int num = n;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return num - count;
	}

}
