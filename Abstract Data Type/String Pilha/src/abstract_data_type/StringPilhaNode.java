package abstract_data_type;

public class StringPilhaNode {
	private String item;
	private StringPilhaNode ant;
	
	public StringPilhaNode(String item) {
		setItem(item);
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	public StringPilhaNode getAnt() {
		return ant;
	}

	public void setAnt(StringPilhaNode ant) {
		this.ant = ant;
	}	
	
}
