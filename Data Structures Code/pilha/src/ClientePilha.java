import java.lang.Object;

public class ClientePilha {

	public static void main(String[] args) {
	      StackRA<String> pilha;
	      pilha = new StackRA<String>();

	      do {
	         String str = StdIn.readString();
	         if (!str.equals("-")) {
	            pilha.push(str);
	            System.out.println("Tamanho: "+pilha.tamanhoVetor());
	         }
	         else if (!pilha.isEmpty()) 
	                 System.out.println(pilha.pop() + " ");
	      } while (!StdIn.isEmpty());
	      System.out.println("(" + pilha.size() + " left on stack)");
   }
}
