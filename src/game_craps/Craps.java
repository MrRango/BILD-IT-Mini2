/*
 * (Game: craps) Craps is a popular dice game played in casinos. Write a program
 * to play a variation of the game, as follows:
 * Roll two dice. Each die has six faces representing values 1, 2, …, and 6, respectively.
 * Check the sum of the two dice. If the sum is 2, 3, or 12 (called craps), you
 * lose; if the sum is 7 or 11 (called natural), you win; if the sum is another value
 * (i.e., 4, 5, 6, 8, 9, or 10), a point is established. Continue to roll the dice until either
 * a 7 or the same point value is rolled. If 7 is rolled, you lose. Otherwise, you win.
 * Your program acts as a single player.
 */

package game_craps;

public class Craps {

	public static void main(String[] args) {

		boolean uslov = true;

		// bacanje kociki
		int kocka1 = (int) (Math.random() * 6 + 1);
		int kocka2 = (int) (Math.random() * 6 + 1);

		System.out.println("Dobili ste: " + kocka1 + " i " + kocka2);

		int zbir = kocka1 + kocka2;
		// u zavisnosti koji su brojevi dobijeni, proglasava se pobjednik, ili
		// se ide na dodatno bacanje
		if (zbir == 7 || zbir == 11) {
			System.out.println("Pobijedili ste");
		} else if (zbir == 2 || zbir == 3 || zbir == 12) {
			System.out.println("Izgubili ste");
		} else {
			// dodatno bacanje kocki, ponavlja se dok se ne dobije pobjednik
			do {
				System.out.println("Ponovo bacanje kocki! Ako dobojete " + zbir
						+ ", pobijedili ste, a ako dobijete 7, izgubili ste!");
				kocka1 = (int) (Math.random() * 6 + 1);
				kocka2 = (int) (Math.random() * 6 + 1);

				System.out.println("Dobili ste: " + kocka1 + " i " + kocka2);

				if (kocka1 + kocka2 == 7) {
					System.out.println("Izgubili ste");
					uslov = false;
				}
				if (kocka1 + kocka2 == zbir) {
					System.out.println("Pobijedili ste");
					uslov = false;
				}

			} while (uslov);

		}

	}

}
