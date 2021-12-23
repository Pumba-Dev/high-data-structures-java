public class StackRA<Item> {

   private Item[] a;
   private int n;

   // construtor
   public StackRA() {
      a = (Item[]) new Object[2];
      n = 0;
   }

   // a pilha mora em a[0..N-1]
   
   public boolean isEmpty() {
      return n == 0;
   }
   
   public void push(Item item) { 
      if (n == a.length)
         resize(2 * a.length);
      a[n++] = item;
   }

   public Item pop() {
      Item item = a[--n];
      if (n > 0 && n == a.length/4)
         resize(a.length/2);
      return item;
   }
   
   public int size() {
	   return n;
   }
   public int tamanhoVetor() {
	   return a.length;
   }

   private void resize(int max) {
      Item[] temp;
      temp = (Item[]) new Object[max];
      for (int i = 0; i < n; i++)
         temp[i] = a[i];
      a = temp;
   }
}