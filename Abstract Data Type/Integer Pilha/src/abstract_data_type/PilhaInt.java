package abstract_data_type;

public class PilhaInt {
	IntPilhaNode topo;
	int nodeQuantity;

	public PilhaInt() {
		this.topo = null;
		this.nodeQuantity = 0;
	}

	public int Top() {
		if (topo != null)
			return topo.getItem();
		return -1;
	}

	public int getSize() {
		return nodeQuantity;
	}

	public void Push(int novo) {
		IntPilhaNode new_add = new IntPilhaNode(novo);
		new_add.setAnt(topo);
		topo = new_add;
		nodeQuantity++;
	}

	public int Pop() {
		if (topo == null) {
			return -1;
		} else {
			int deleted = topo.getItem();
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
