package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		
		JButton UCII = new JButton("Fluxo de Potência Fundamental");
		UCII.setBounds(450,300,400,30);
		
		JButton UCIII = new JButton("Distorção Harmonica");
		UCIII.setBounds(450,400,400,30);
		
		JButton UCIV = new JButton("Fluxo de Potência Harmonico");
		UCIV.setBounds(450,500,400,30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		Painelmain = new JPanel();
		Painelmain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Painelmain);
		Painelmain.setLayout(null);
		
		JLabel titulo = new JLabel("APRENDA QEE/SIMULAÇÕES");
		Painelmain.add(titulo);
		titulo.setFont(new Font("Dialog", Font.CENTER_BASELINE,30));
		titulo.setBounds(430, 100, 600, 30);
		
		UCII.setActionCommand("simulacao1");
		UCIII.setActionCommand("simulacao2");
		UCIV.setActionCommand("simulacao3");
		UCII.addActionListener(new AcoeInterfacePrincipal(Painelmain,telaInicial));;
		UCIII.addActionListener(new AcoeInterfacePrincipal(Painelmain,telaInicial));;
		UCIV.addActionListener(new AcoeInterfacePrincipal(Painelmain,telaInicial));;
		telaInicial.add(Painelmain);
		Painelmain.add(UCII);
		Painelmain.add(UCIII);
		Painelmain.add(UCIV);
		
		telaInicial.setVisible(true);
		
	}

}
