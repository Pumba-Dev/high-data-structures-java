package abstract_data_type;

public class PilhaString {
	StringPilhaNode topo;
	int nodeQuantity;

	public PilhaString() {
		this.topo = null;
		this.nodeQuantity = 0;
	}

	public String Top() {
		if (topo != null)
			return topo.getItem();
		return null;
	}

	public int getSize() {
		return nodeQuantity;
	}

	public void Push(String novo) {
		StringPilhaNode new_add = new StringPilhaNode(novo);
		new_add.setAnt(topo);
		topo = new_add;
		nodeQuantity++;
	}

	public String Pop() {
		if (topo == null) {
			return null;
		} else {
			String deleted = topo.getItem();
			topo = topo.getAnt();
			nodeQuantity--;
			return deleted;
		}
	}

	public void PopAll() {
		while (topo != null) {
			topo = topo.getAnt();
			nodeQuantity--;
		}
	}
}
