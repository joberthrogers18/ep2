package view;

import java.io.IOException;

import javax.swing.JFrame;


public class Main {
	public static void main(String [] args) throws IOException{
		JFrame telaInicial = new JFrame();
		telaInicial = new JFrame("Aprenda QEE");
		telaInicial.setSize(1330, 750);
		telaInicial.setLocationRelativeTo(null);
		telaInicial.setResizable(false);
		new InterfacePrincipal(telaInicial);
		
		
	}
}
