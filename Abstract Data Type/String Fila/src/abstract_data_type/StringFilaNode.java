package abstract_data_type;

public class StringFilaNode {
	private String item;
	private StringFilaNode prox;
	
	public StringFilaNode(String item) {
		this.item = item;
		this.prox = null;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public StringFilaNode getProx() {
		return prox;
	}

	public void setProx(StringFilaNode prox) {
		this.prox = prox;
	}
	
}
