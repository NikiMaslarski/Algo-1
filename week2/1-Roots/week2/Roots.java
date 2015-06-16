package week2;

public class Roots {

	private static double PRECISION = 0.0000000001;

	public static double FindRoot(int number) {
		return RRoot((double) number, 0, (double) number);
	}

	private static double RRoot(double number, double lo, double hi) {
		double middle = (hi + lo) / 2;
		double deviation = number - middle * middle;

		if (Math.abs(deviation) < PRECISION)
			return middle;

		if (deviation < 0)
			return RRoot(number, lo, middle);

		if (deviation > 0)
			return RRoot(number, middle, hi);

		return -1;
	}
}
