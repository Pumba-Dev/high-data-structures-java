package abstract_data_type;

public class IntPilhaNode {
	private int item;
	private IntPilhaNode ant;
	
	public IntPilhaNode(int item) {
		setItem(item);
	}
	
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}

	public IntPilhaNode getAnt() {
		return ant;
	}

	public void setAnt(IntPilhaNode ant) {
		this.ant = ant;
	}	
	
}
