package data;

public class KartenCheck {

	public static boolean checkEinPaar(int[] karten) {
		for (int i = 0; i < (karten.length - 1); i++) {
			for (int j = i + 1; j < karten.length; j++) {
				if ((karten[i] % 13) == (karten[j] % 13)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * alle farben gleich 
	 * straße 
	 * paar 
	 * triple
	 * poker
	 * 
	 * karten[5] = {15, 46, 38, 21, 3}; i = 0; j = 1; 15 % 13 == 46 % 13 | 2 == 7 i
	 * = 0; j = 2; 15 % 13 == 38 % 13 | 2 == 12 i = 0; j = 3; 15 % 13 == 21 % 13 | 2
	 * == 8 i = 0; j = 4; 15 % 13 == 3 % 13 | 2 == 3
	 * 
	 * i = 1; j = 2; 46 % 13 == 38 % 13 | 7 == 12 i = 1; j = 3; 46 % 13 == 21 % 13 |
	 * 7 == 8 i = 1; j = 4; 46 % 13 == 3 % 13 | 7 == 3
	 * 
	 * i = 2; j = 2; 46 % 13 == 38 % 13 | 7 == 12
	 */

	public static boolean checkAlleFarbenGleich(int[] karten) {

		if ((karten[0] / 13) == (karten[1] / 13) && (karten[1] / 13) == (karten[2] / 13)
				&& (karten[2] / 13) == (karten[3] / 13) && (karten[3] / 13) == (karten[4] / 13)) {
			return true;
		}
		return false;
	}

	public static boolean checkTriple(int[] karten) {

		for (int i = 0; i < (karten.length - 1); i++) {
			for (int j = i + 1; j < karten.length; j++) {
				for (int k = j + 1; k < karten.length; k++) {
					if ((karten[i] % 13) == (karten[j] % 13) && (karten[j] % 13) == (karten[k] % 13)) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
