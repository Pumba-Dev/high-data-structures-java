import java.util.Random;

public class OrdenarNumeros {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Double Numeros[] = new Double[N];
		for (int i=0; i<N; i++)
			Numeros[i] = new Random().nextDouble();
		
		Insertion.sort(Numeros);
		
		for (int i=0; i<N; i++)
			System.out.println(Numeros[i]);
	}
}