package game_craps;

public class ChanceOfWinning {

	public static void main(String[] args) {
		
		int brojPobjeda = 0;
		
		for(int i = 0; i < 10000; i++){
			boolean uslov = true;

			// bacanje kociki
			int kocka1 = (int) (Math.random() * 6 + 1);
			int kocka2 = (int) (Math.random() * 6 + 1);
			int zbir = kocka1 + kocka2;
			// u zavisnosti koji su brojevi dobijeni, proglasava se pobjednik, ili
			// se ide na dodatno bacanje
			if (zbir == 7 || zbir == 11) {
				System.out.println("Pobijedili ste");
				brojPobjeda++;
			} else if (zbir == 2 || zbir == 3 || zbir == 12) {
				System.out.println("Izgubili ste");
			} else {
				// dodatno bacanje kocki, ponavlja se dok se ne dobije pobjednik
				do {
					kocka1 = (int) (Math.random() * 6 + 1);
					kocka2 = (int) (Math.random() * 6 + 1);

					if (kocka1 + kocka2 == 7) {
						System.out.println("Izgubili ste");
						uslov = false;
					}
					if (kocka1 + kocka2 == zbir) {
						System.out.println("Pobijedili ste");
						brojPobjeda++;
						uslov = false;
					}

				} while (uslov);

			}
		}
		
		System.out.println("Od 10000 pokusaja, pobijedili ste : " + brojPobjeda);
		
	}
}
