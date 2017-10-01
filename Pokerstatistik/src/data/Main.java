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
	
	public void check() {
		
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.ziehen();
	}
}
