package sortAlgorithm;

public class CompString {

	public static boolean CompOrderString(String a, String b) { // retorna true se a primeira String for primeiro
																// albafeticamente que a segunda string. TRUE = A <= B

		if (a == b)
			return false;
		if (a == null)
			return false;
		else if (b == null)
			return true;

		int i = 0; // index de percorrer o vetor
		String tam = a + b; // String auxiliar para criação do loop com a soma do tamanho das duas strings.

		a = a.toLowerCase();
		b = b.toLowerCase();

		for (int k = 0; k <= tam.length(); k++) {
			char aux_a;
			char aux_b;
			int ascii_a;
			int ascii_b;

			aux_a = a.charAt(i);
			aux_b = b.charAt(i);

			ascii_a = (int) aux_a;
			ascii_b = (int) aux_b;

			if (ascii_a < ascii_b) {
				return true;
			} else if (ascii_b < ascii_a) {
				return false;
			} else if (ascii_a == ascii_b) {
				i++;
				if (i >= a.length())
					return true;
				else if (i >= b.length())
					return false;
			}
		}
		return false;
	}
}
