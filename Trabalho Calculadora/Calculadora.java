import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class Calculadora implements ActionListener {

	static Calculadora c = new Calculadora();

	static JFrame janela = new JFrame();

	static JLabel valor1 = new JLabel();
	static JLabel valor2 = new JLabel();
	static JLabel resultado = new JLabel();

	static JTextField caixa1 = new JTextField(20);
	static JTextField caixa2 = new JTextField(20);
	static JTextField resultadoDigitar = new JTextField(20);

	static JButton soma = new JButton();
	static JButton subtracao = new JButton();
	static JButton divisao = new JButton();
	static JButton multiplicacao = new JButton();
	static JButton limpar = new JButton();
	static JButton sair = new JButton();
	static JButton igual = new JButton();

	int resultadoFinal = 0;
 
	public static void main (String args[]) {
	
		//Janela
		janela.setSize(300,400);
		janela.setTitle("Calculadora");

		//Text dos rótulos
		valor1.setText("Valor 1: ");
		valor2.setText("Valor 2: ");
		resultado.setText("Resultado: ");

		//Texto dos botões
		soma.setText("+");
		subtracao.setText("-");
		divisao.setText("/");
		multiplicacao.setText("*");
		limpar.setText("Limpar");
		sair.setText("Sair");
		igual.setText("=");

		//Adição dos itens na janela
		janela.add(valor1);
		janela.add(caixa1);
		janela.add(valor2);
		janela.add(caixa2);
		janela.add(resultado);
		janela.add(resultadoDigitar);
		janela.add(soma);
		janela.add(subtracao);
		janela.add(divisao);
		janela.add(multiplicacao);
		janela.add(limpar);
		janela.add(sair);
		janela.add(igual);

		//Adicionando as funções dos botões 
		soma.addActionListener(c);
		subtracao.addActionListener(c);
		divisao.addActionListener(c);
		multiplicacao.addActionListener(c);
		igual.addActionListener(c);
		limpar.addActionListener(c);
		sair.addActionListener(c);

		janela.setLayout(new FlowLayout());
		janela.setVisible(true);
	}

	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource().equals(soma)) {
			try {
				resultadoFinal = (Integer.parseInt(caixa1.getText()) + Integer.parseInt(caixa2.getText()));

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Numero invalido, digite novamente!","Erro",JOptionPane.PLAIN_MESSAGE);
			}
		}

		if (evento.getSource().equals(subtracao)) {
			try {
				resultadoFinal = (Integer.parseInt(caixa1.getText()) - Integer.parseInt(caixa2.getText()));

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Numero invalido, digite novamente!","Erro",JOptionPane.PLAIN_MESSAGE);
			}
		}

		if (evento.getSource().equals(divisao)) {
			try {
				resultadoFinal = (Integer.parseInt(caixa1.getText()) / Integer.parseInt(caixa2.getText()));

			} catch (NumberFormatException erro1) {
				JOptionPane.showMessageDialog(null, "Numero invalido, digite novamente!","Erro",JOptionPane.PLAIN_MESSAGE);
			} catch (ArithmeticException erro2) {
				JOptionPane.showMessageDialog(null, "Divisao nao pode ser por 0! Digite novamente.","Erro",JOptionPane.PLAIN_MESSAGE);
			}
		}

		if (evento.getSource().equals(multiplicacao)) {
			try {
				resultadoFinal = (Integer.parseInt(caixa1.getText()) * Integer.parseInt(caixa2.getText()));

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Numero invalido, digite novamente!","Erro",JOptionPane.PLAIN_MESSAGE);
			}
		}

		if (evento.getSource().equals(igual)) {
			resultadoDigitar.setText(Integer.toString(resultadoFinal));

			try {
				testaNumero(resultadoFinal);
			} catch (NegaException erro) {
				caixa1.setText("");
				caixa2.setText("");
				resultadoDigitar.setText("");
				caixa1.requestFocus();
			} 
		}

		if (evento.getSource().equals(limpar)) {
			caixa1.setText("");
			caixa2.setText("");
			resultadoDigitar.setText("");
			caixa1.requestFocus();
		}

		if (evento.getSource().equals(sair)) {
			System.exit(0);
		}
	}

	public static void testaNumero (int numero) throws NegaException{
		if (numero < 0) {
			throw new NegaException(numero);
		}
	}
}