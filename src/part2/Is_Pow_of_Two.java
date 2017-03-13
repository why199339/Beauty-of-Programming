package part2;

public class Is_Pow_of_Two {

	public static void main(String[] args) {
		System.out.println(isPowOfTwo(16));
		System.out.println(isPowOfTwo(10));
	}

	public static boolean isPowOfTwo(int n) {
		return (n > 0) && ((n & (n - 1)) == 0);
	}
}
