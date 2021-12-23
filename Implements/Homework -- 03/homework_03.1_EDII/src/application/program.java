package application;

import javax.swing.JOptionPane;

import abstract_data_type.FilaString;

public class program {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String read = "";
		char stop = '-';
		FilaString fila = new FilaString();

		while (true) {
			read = JOptionPane.showInputDialog("Enter a name to add or - to remove: <type 'break' to finish");
			if (read.charAt(0) == stop) {
				fila.StartRemove();
			} else if (read.equalsIgnoreCase("break"))
				break;
			else
				fila.Add(read);
		}

		JOptionPane.showMessageDialog(null, fila);

	}

}
