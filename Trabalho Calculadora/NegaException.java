package calculadora;

import javax.swing.JOptionPane;

public class NegaException extends Exception {
	NegaException(int numero) {
		JOptionPane.showMessageDialog(null, "Numero negativo!","Aviso",JOptionPane.PLAIN_MESSAGE);
	}
}