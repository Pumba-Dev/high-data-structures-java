import javax.swing.JOptionPane;

public class ClienteBag {

	public static void main(String[] args) {
		Bag <Integer> bag = new Bag<Integer>();
		while (true) {
			String num = JOptionPane.showInputDialog("Digite valor inteiro? <0-sair>");
			int n = Integer.parseInt(num);
			if (n!=0) {
				bag.add(n);
			} else break;
		}
		String out="";
		for (int it:bag) {
			out += it;
			out += "\n";
		}
		JOptionPane.showMessageDialog(null, out);
	}
}
