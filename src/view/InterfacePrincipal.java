package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controler.AcoeInterfacePrincipal;

public class InterfacePrincipal extends JFrame {

	private JPanel Painelmain;

	/**
	 * Launch the application.
	 */
public InterfacePrincipal(JFrame telaInicial) throws IOException{
		
	CriarInterfacePrincipal(telaInicial);
		
		
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void CriarInterfacePrincipal(JFrame telaInicial) throws IOException{
		
		JButton UCII = new JButton("Simulação1");
		UCII.setBounds(190,100,400,30);
		
		JButton UCIII = new JButton("Simulação2");
		UCIII.setBounds(190,200,400,30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		Painelmain = new JPanel();
		Painelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Painelmain);
		Painelmain.setLayout(null);
		
		UCII.setActionCommand("simulacao1");
		UCIII.setActionCommand("simulacao2");
		UCII.addActionListener(new AcoeInterfacePrincipal(Painelmain,telaInicial));;
		UCIII.addActionListener(new AcoeInterfacePrincipal(Painelmain,telaInicial));;
		telaInicial.add(Painelmain);
		Painelmain.add(UCII);
		Painelmain.add(UCIII);
		
		telaInicial.setVisible(true);
		
	}

}
