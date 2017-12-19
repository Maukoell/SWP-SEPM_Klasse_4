package data;

import java.util.Arrays;
import java.util.Scanner;

import db.MySQLConnection;
/**
 *  Pfad für Datenbank in SQLite Klasse
 * @author user
 *
 */
public class Main {

	private Kartenzaehler k = new Kartenzaehler();
	private static double einPaar = 0;
	private static double zweiPaar = 0;
	private static double tripple = 0;
	private static double poker = 0;
	private static double fullHouse = 0;
	private static double flush = 0;
	private static double royalFlush = 0;
	private static double straightFlush = 0;
	private static double straight = 0;
	private static int registrationDate = 0;
	private static int beginDateTimeOfTest = 0;
	private static int endDateTimeOfTest = 0;
//	private static int[] test = {1,1,1,1,3};
	
	

	
	public void ziehen() {
		beginDateTimeOfTest = (int) (System.currentTimeMillis() / 1000L);
		for (int i = 0; i < 999999; i++) {
			k.ziehvorgang();
			int[] gezogeneKarten = k.ziehen(5, 52);
			Arrays.sort(gezogeneKarten);
			
			if (KartenCheck.checkEinPaar(gezogeneKarten) && !KartenCheck.checkTriple(gezogeneKarten) && !KartenCheck.checkTwoPair(gezogeneKarten)) {
				einPaar++;
			}
			if (KartenCheck.checkTriple(gezogeneKarten) && !KartenCheck.checkPoker(gezogeneKarten) && !KartenCheck.checkFullHouse(gezogeneKarten)) {
				tripple++;
			}
			if (KartenCheck.checkPoker(gezogeneKarten)) {
				poker++;
			}
			if (KartenCheck.checkFullHouse(gezogeneKarten)) {
				fullHouse++;
			}
			if (KartenCheck.checkRoyalFlush(gezogeneKarten)) {
				royalFlush++;
			}
			if (KartenCheck.checkTwoPair(gezogeneKarten) && !KartenCheck.checkFullHouse(gezogeneKarten)) {
				zweiPaar++;
			}
			if (KartenCheck.checkStraightFlush(gezogeneKarten) && !KartenCheck.checkRoyalFlush(gezogeneKarten)) {
				straightFlush++;
			}
			if (KartenCheck.checkAlleFarbenGleich(gezogeneKarten) && !KartenCheck.checkStraightFlush(gezogeneKarten)) {
				flush++;
			}
			if (KartenCheck.checkStrasse(gezogeneKarten) && !KartenCheck.checkStraightFlush(gezogeneKarten) && !KartenCheck.checkRoyalFlush(gezogeneKarten)) {
				straight++;
			}
		}
		
		System.out.println("Es wurden 1.000.000 mal Karten gezogen.");
		System.out.println("Davon waren folgende Kombinationen enthalten:");
		System.out.println();
		System.out.printf("Ein Paar: \t\t%d Mal vorgekommen. \t Dies entspricht %.4f%%", (int) einPaar, ((einPaar/1000000) * 100));
		System.out.println();
		System.out.printf("Zwei Paar: \t\t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) zweiPaar, ((zweiPaar/1000000) * 100));
		System.out.println();
		System.out.printf("Tripple: \t\t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) tripple, ((tripple/1000000) * 100));
		System.out.println();
		System.out.printf("Poker: \t\t\t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) poker, ((poker/1000000) * 100));
		System.out.println();
		System.out.printf("Full House: \t\t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) fullHouse, ((fullHouse/1000000) * 100));
		System.out.println();
		System.out.printf("Royal Flush: \t\t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) royalFlush, ((royalFlush/1000000) * 100));
		System.out.println();
		System.out.printf("Straight Flush: \t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) straightFlush, ((straightFlush/1000000) * 100));
		System.out.println();
		System.out.printf("Flush: \t\t\t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) flush, ((flush/1000000) * 100));
		System.out.println();
		System.out.printf("Straight: \t\t%d Mal vorgekommen. \t\t Dies entspricht %.4f%%", (int) straight, ((straight/1000000) * 100));
		System.out.println();
		
		endDateTimeOfTest = (int) (System.currentTimeMillis() / 1000L);
		
	}
	
	public static void check(int[] karten) {
		if (KartenCheck.checkEinPaar(karten) && !KartenCheck.checkTriple(karten) && !KartenCheck.checkTwoPair(karten)) {
			System.out.println("Es ist ein Paar vorhanden.");
		}
		if (KartenCheck.checkTriple(karten) && !KartenCheck.checkPoker(karten) && !KartenCheck.checkFullHouse(karten)) {
			System.out.println("Es ist ein Tripple vorhanden.");
		}
		if (KartenCheck.checkPoker(karten)) {
			System.out.println("Es ist ein Poker vorhanden.");
		}
		if (KartenCheck.checkFullHouse(karten)) {
			System.out.println("Ein Full House ist vorhanden.");
		}
		if (KartenCheck.checkRoyalFlush(karten)) {
			System.out.println("Ein Royal Flush ist vorhanden.");
		}
		if (KartenCheck.checkTwoPair(karten) && !KartenCheck.checkFullHouse(karten)) {
			System.out.println("Es sind zwei Paare vorhanden.");
		}
		if (KartenCheck.checkStraightFlush(karten) && !KartenCheck.checkRoyalFlush(karten)) {
			System.out.println("Es ist ein Straight Flush vorhanden.");
		}
		if (KartenCheck.checkAlleFarbenGleich(karten) && !KartenCheck.checkStraightFlush(karten)) {
			System.out.println("Alle Farben sind gleich.");
		}
		if (KartenCheck.checkStrasse(karten) && !KartenCheck.checkStraightFlush(karten) && !KartenCheck.checkRoyalFlush(karten)) {
			System.out.println("Es ist eine Straße vorhanden.");
		}
	}
	
	public static void main(String[] args) {
//		Kartenzaehler zaehler = new Kartenzaehler();
//		int[] gezogeneKarten = zaehler.ziehen(5, 52);
//		Arrays.sort(gezogeneKarten);
//		zaehler.print(test);
//		check(test);
		MySQLConnection.createTables();
		int userId = MySQLConnection.getHighestUserId();
		String name = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie ihren Namen ein:");
		name = s.next();
		System.out.println("Sie werden als " + name + " regestriert.");
		System.out.println();
		registrationDate = (int) (System.currentTimeMillis() / 1000L);
		Main m = new Main();
		m.ziehen();
		MySQLConnection.insertUser(userId+1, name, registrationDate);
		MySQLConnection.insertResults(beginDateTimeOfTest, endDateTimeOfTest, userId+1, (int) einPaar,
				(int) tripple, (int) poker, (int) zweiPaar, (int) flush, (int) straightFlush, (int) royalFlush, (int) fullHouse);
		
		
		
		
		/*
		 * Ein Paar funktioniert
		 * Zwei Paar funktioniert
		 * Tripple funktioniert
		 * Full House
		 * Straight funktioniert
		 * Flush funktioniert
		 * Straight Flush funktioniert
		 * Royal Flush funktioniert
		 */
	}
}
