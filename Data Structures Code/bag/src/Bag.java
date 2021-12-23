import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

	private Node first;
	private int n;

	private class Node {
		private Item item;
		private Node next;
	}

	public Bag() { // construtor
		first = null;
		n = 0;
	}

	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	private class ListIterator implements Iterator<Item> {

		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}