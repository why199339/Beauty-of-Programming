package part2;

public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd_mod(42, 30));
		System.out.println(gcd_minus(42, 30));
		System.out.println(gcd_best(42, 30));
	}

	public static int gcd_mod(int m, int n) {
		if (n == 0) {
			return m;
		}
		return gcd_mod(n, m % n);
	}

	public static int gcd_minus(int m, int n) {
		if (m < n) {
			return gcd_minus(n, m);
		}
		if (n == 0) {
			return m;
		}
		return gcd_minus(m - n, n);
	}

	// O(log(max(m,n)))
	public static int gcd_best(int m, int n) {
		if (m < n) {
			return gcd_best(n, m);
		}
		if (n == 0) {
			return m;
		}
		if ((m & 1) == 0) {
			if ((n & 1) == 0) {
				return (gcd_best(m >> 1, n >> 1) << 1);
			} else {
				return gcd_best(m >> 1, n);
			}
		} else {
			if ((n & 1) == 0) {
				return gcd_best(m, n >> 1);
			} else {
				return gcd_best(n, m - n);
			}
		}
	}
}
