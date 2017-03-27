package part2;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci_simplest(10));
		System.out.println(fibonacci_better(10));
		System.out.println(fibonacci_formula(10));
	}

	public static int fibonacci_simplest(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci_simplest(n - 1) + fibonacci_simplest(n - 2);
	}

	// O(n)
	public static int fibonacci_better(int n) {
		int[] result = { 0, 1 };
		if (n < 2) {
			return result[n];
		}
		int fibMinusOne = 1;
		int fibMinusTwo = 0;
		int fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibMinusTwo + fibMinusOne;
			fibMinusTwo = fibMinusOne;
			fibMinusOne = fibN;
		}
		return fibN;
	}

	public static int fibonacci_formula(int n) {
		double A = Math.sqrt(5) / 5;
		double x1 = Math.pow((1 + Math.sqrt(5)) / 2, n);
		double x2 = Math.pow((1 - Math.sqrt(5)) / 2, n);
		return (int) (A * x1 - A * x2);
	}

	// (Fn Fn-1) = (Fn-1 Fn-2) * A = (Fn-2 Fn-3) * A^2 = ... = (F1 F0) * A^n-1,
	// A= [[1,1],[1,0]]
	public static int fibonacci_divide_and_conquer(int n) {
		return 0;
	}
}
