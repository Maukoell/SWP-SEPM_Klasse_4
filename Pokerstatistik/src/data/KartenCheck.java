package data;

import java.util.Arrays;

/**
 * https://goo.gl/6nXbYL
 * 
 * @author Mauricio Köll
 *
 */
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
	 * alle farben gleich straße paar triple poker (vierling) Rojal Flush
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

	public static boolean checkPoker(int[] karten) {

		for (int i = 0; i < (karten.length - 1); i++) {
			for (int j = i + 1; j < karten.length; j++) {
				for (int k = j + 1; k < karten.length; k++) {
					for (int l = k + 1; l < karten.length; l++) {
						if ((karten[i] % 13) == (karten[j] % 13) && (karten[j] % 13) == (karten[k] % 13)
								&& (karten[k] % 13) == (karten[l] % 13)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static boolean checkStrasse(int[] karten) {

		Arrays.sort(karten);

		if ((karten[0] + 1) == karten[1]) {
			if ((karten[1] + 1) == karten[2]) {
				if ((karten[2] + 1) == karten[3]) {
					if ((karten[3] + 1) == karten[4]) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean checkStraightFlush(int[] karten) {

		if (checkAlleFarbenGleich(karten) && checkStrasse(karten)) {
			return true;
		}

		return false;
	}

	public static boolean checkRoyalFlush(int[] karten) {
		Kartenzaehler k = new Kartenzaehler();
		Arrays.sort(karten);

		if (k.echteKartennummer(karten[0]) == 9) {
			if (k.echteKartennummer(karten[1]) == 10) {
				if (k.echteKartennummer(karten[2]) == 11) {
					if (k.echteKartennummer(karten[3]) == 12) {
						if (k.echteKartennummer(karten[4]) == 13) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static boolean checkFullHouse(int[] karten) {
		int card1 = 0;
		boolean triple = false;
		boolean pair = false;

		if (checkTriple(karten) && !checkPoker(karten)) {
			for (int i = 0; i < (karten.length - 1); i++) {
				for (int j = i + 1; j < karten.length; j++) {
					for (int k = j + 1; k < karten.length; k++) {
						if ((karten[i] % 13) == (karten[j] % 13) && (karten[j] % 13) == (karten[k] % 13)) {
							card1 = i % 13;
							triple = true;
						}
					}
				}
			}
			for (int i = 0; i < (karten.length - 1); i++) {
				for (int j = i + 1; j < karten.length; j++) {
					if ((karten[i] % 13) == (karten[j] % 13) && (karten[i] % 13) != card1) {
						pair = true;
					}
				}
			}
		}

		if (triple && pair) {
			return true;
		}

		return false;
	}

	public static boolean checkTwoPair(int[] karten) {
		int pair1 = 0;

		for (int i = 0; i < (karten.length - 1); i++) {
			for (int j = i + 1; j < karten.length; j++) {
				if ((karten[i] % 13) == (karten[j] % 13)) {
					pair1 = (karten[i] % 13);
				}
			}
		}

		for (int i = 0; i < (karten.length - 1); i++) {
			for (int j = i + 1; j < karten.length; j++) {
				if ((karten[i] % 13) == (karten[j] % 13) && (karten[i] % 13) != pair1) {
					return true;
				}
			}

		}
		return false;
	}
}
