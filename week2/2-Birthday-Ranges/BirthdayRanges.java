package week2;

public class BirthdayRanges {
	public static void main(String[] args) {
		int[] birthdays = { 1, 1, 1, 4, 5, 6, 7, 8, 10, 44, 101, 101, 102, 123 };
		int[][] ranges = { {1, 60 }, { 40, 90 }, { 100, 110 }, { 300, 365 },
		 { 1, 365 } };

		int[] result = new int[ranges.length];
		result = birthdays_count(birthdays, ranges);

		for (int e : result)
			System.out.println(e);
	}

	public static int[] birthdays_count(int[] birthdays, int[][] ranges) {
		int[] numberOfPeople = new int[ranges.length];

		for (int i = 0; i < ranges.length; ++i) {
			numberOfPeople[i] = getNumberOfBirthdaysInRange(birthdays,
					ranges[i][0], ranges[i][1]);
		}

		return numberOfPeople;

	}

	private static int getNumberOfBirthdaysInRange(int[] birthdays, int lo,
			int hi) {
		return findIndex(birthdays, hi) - findIndex(birthdays, lo);

	}

	private static int findIndex(int[] birthdays, int element) {
		int left = 0;
		int right = birthdays.length - 1;

		while (left < right) {

			double interpolConst = (double) (element - birthdays[left])
					/ (double) (birthdays[right] - birthdays[left]);

			int middle = left
					+ (int) Math.round((interpolConst * (right - left)));

			if (interpolConst > 1)
				return right + (int)Math.floor((interpolConst));

			if (interpolConst < 0)
				return left + (int)Math.ceil(interpolConst);

			if (element < birthdays[middle])
				right = middle - 1;
			else if (element > birthdays[middle])
				left = middle + 1;
			else
				return middle;
		}
		return left + 1; // birthday[left] == birthday[right] == element
	}
}
