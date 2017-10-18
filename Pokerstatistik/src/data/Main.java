package data;

public class Main {

	private int[][] alleZahlen = new int[99][6];
	private Kartenzaehler k = new Kartenzaehler();
	
	public void ziehen() {
		for (int i = 0; i < alleZahlen.length; i++) {
			k.ziehvorgang();
			int[] gezogeneKarten = k.getGezogeneKarten();
			alleZahlen[i][1] = gezogeneKarten[0];
			alleZahlen[i][2] = gezogeneKarten[1];
			alleZahlen[i][3] = gezogeneKarten[2];
			alleZahlen[i][4] = gezogeneKarten[3];
			alleZahlen[i][5] = gezogeneKarten[4];
		}
	}
	
	public static void check(int[] karten) {
		if (KartenCheck.checkEinPaar(karten)) {
			System.out.println("Es ist ein Paar vorhanden.");
		}
		if (KartenCheck.checkTriple(karten)) {
			System.out.println("Es ist ein Tripple vorhanden.");
		}
		if (KartenCheck.checkPoker(karten)) {
			System.out.println("Es ist ein Poker vorhanden.");
		}
		if (KartenCheck.checkStrasse(karten)) {
			System.out.println("Es ist eine Straße vorhanden.");
		}
		if (KartenCheck.checkAlleFarbenGleich(karten)) {
			System.out.println("Alle Farben sind gleich.");
		}
		if (KartenCheck.checkFullHouse(karten)) {
			System.out.println("Ein Full House ist vorhanden.");
		}
		if (KartenCheck.checkRoyalFlush(karten)) {
			System.out.println("Ein Royal Flush ist vorhanden.");
		}
		if (KartenCheck.checkTwoPair(karten)) {
			System.out.println("Es sind zwei Paare vorhanden.");
		}
	}
	
	public static void main(String[] args) {
		Kartenzaehler zaehler = new Kartenzaehler();
		int[] gezogeneKarten = zaehler.ziehen(5, 52);
		int[] test = {1,2,3,4,5};
		zaehler.print(test);
		check(test);
		
	}
}
