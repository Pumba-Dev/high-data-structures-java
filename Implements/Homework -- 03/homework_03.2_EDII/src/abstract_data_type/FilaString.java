package abstract_data_type;

public class FilaString {
	private StringFilaNode start;
	private StringFilaNode end;
	private int size;

	public FilaString() {
		this.start = null;
		this.start = null;
		this.size = 0;
	}

	public int Size() {
		return this.size;
	}

	public void Add(String item) {
		if (item != null) {
			StringFilaNode newNode = new StringFilaNode(item);
			if (size == 0) {
				this.start = newNode;
				this.end = newNode;
			} else {
				this.end.setProx(newNode);
				this.end = newNode;
			}
			if (this.end == newNode)
				this.size++;
		} else
			return;

	}

/*	private StringNode GetPreviousNode(String item) {
		StringNode current = this.start;
		while (current.getProx().getItem() != item) {
			current = current.getProx();
		}
		return current;
	}

	public String Remove(String item) {
		StringNode previousNode = GetPreviousNode(item);
		StringNode node4Remove = previousNode.getProx();
		String item4Remove = this.start.getItem();

		if (this.size == 0)
			return null;
		else if (this.size == 1) {
			this.start = null;
			this.end = null;
		} else if (this.start.getItem() == item) {
			this.start = this.start.getProx();
		} else if (this.end.getItem() == item) {
			previousNode.setProx(node4Remove.getProx());
			this.end = previousNode;
		} else {
			previousNode.setProx(node4Remove.getProx());
		}
		this.size--;
		return item4Remove;
	}*/

	public String StartRemove() {
		String item = this.start.getItem();
		this.start = this.start.getProx();
		this.size--;
		return item;
	}
	
	public String toString() {
		String array = "";
		StringFilaNode node = this.start;
		while(node != null) {
			array += node.getItem();
			array += "\n";
			node = node.getProx();
		}
		return array;
	}
}
