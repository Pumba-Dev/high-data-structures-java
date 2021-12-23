

public class Q1 {
	public static void main(String[] args) {
		String nomes[] = new String[10];
		int x = -1;
		do {
		System.out.println("Digite um nome: ");
		String nomeEncontrar = StdIn.readLine();
		
		for(int i = 0;i<10;i++) {
			nomes[i] = "nome"+ i;
		}
		int index = -1;
		for(int i = 0; i < 10;i++) {
			if (nomes[i].equals(nomeEncontrar)) {
				index = i;
				break;
			}
		}
		if(index == -1)
			System.out.println("Nao encontrado");
		else
			System.out.println("Encontrado no indice " + index);
		System.out.println("Parar: 0 - Sim , outro valor: Naos");
		x = StdIn.readInt();
	}while(x != 0);
	}
}
