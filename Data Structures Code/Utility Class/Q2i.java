
public class Q2i {

	public static void main(String[] args) {
		System.out.println("Comparacao de numeros!!");
		int maior, menor, i, n;
		double media = 0;
		System.out.println("Quantidade de numeros: ");
		n = StdIn.readInt();
		int x[] = new int[10];
		System.out.println("Informe os numeros da comparacao: ");
		for(i = 0;i<n;i++){
			x[i] = StdIn.readInt();
		}
		menor = x[0];
		maior = x[0];
		for(i = 0;i<n;i++) {
			media = x[i] + media;
			if(x[i]>maior)
				maior=x[i];
			if(x[i]<menor)
				menor=x[i];
		}
		media = media/n;
		
		for(i = 0; i < n; i++) {
			System.out.println("Numero: "+x[i]+" Desvio: "+(x[i]-media));
		}
		
		System.out.println("O maior numero digitado e: "+maior);
		System.out.println("O menor numero digitado e: "+menor);
		System.out.println("A media e : " + media);
		
	}

}
