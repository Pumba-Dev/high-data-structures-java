public class OrdenarNomes {

	public static void main(String[] args) {
		Stopwatch timer = new Stopwatch();
		String Nomes[] = StdIn.readAllStrings();		
		Insertion.sort(Nomes);
		
		for (int i=0; i<Nomes.length; i++)
			System.out.println(Nomes[i]);

		System.out.println("Tempo total para ordenar: " + timer.elapsedTime());
	}
}