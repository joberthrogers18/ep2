package view;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.AcoeInterfaceUCII;;

public class UCII {
	private JPanel painelUCII;
	public GraphPanel graf_tensao;
	private GraphPanel graf_corrente;
	private GraphPanel graf_poten_inst;
	private TrianguloPoten triangulo_potencia;
	public JTextField txtamplitude_tensao;
	private JTextField txtangulo_tensao;
	private JTextField txtamplitude_corrente;
	private JTextField txtangulo_corrente;
	private JTextField txtpoten_ativa;
	private JTextField txtpoten_reativa;
	private JTextField txtpoten_aparente;
	private JTextField txtfator_poten;
	private List<Double> v_tensao = new ArrayList<>();
	private List<Double> v_corrente = new ArrayList<>();
	private List<Double> v_poInstan = new ArrayList<>();


	
	public UCII(JFrame telainicial) throws IOException {
		
		criarPainelUCII(telainicial);

	}
	
	
	private void criarPainelUCII(JFrame telaInicial) throws IOException {
		
	
		painelUCII = new JPanel();
		painelUCII.setLayout(null);
		

		JLabel tile_main = new JLabel("UC II: FLUXO DE POTÊNCIA FUNDAMENTAL :");
		tile_main.setBounds(500, 0, 350, 40);
		painelUCII.add(tile_main);
		
		
		JLabel input = new JLabel("ENTRADAS:");
		input.setBounds(25, 40, 170, 40);
		painelUCII.add(input);
		
		JLabel output = new JLabel("SAIDAS: ");
		output.setBounds(25, 390, 170, 20);
		painelUCII.add(output);
		
		
		
		txtamplitude_tensao = new JTextField();
		txtamplitude_tensao.setBounds(40, 86, 170, 20);
		txtamplitude_tensao.setColumns(10);
		
		txtangulo_tensao = new JTextField();
		txtangulo_tensao.setBounds(230, 86, 170, 20);
		txtangulo_tensao.setColumns(10);
		
		txtamplitude_corrente = new JTextField();
		txtamplitude_corrente.setBounds(40, 86, 170, 20);
		txtamplitude_corrente.setColumns(10);
		
		txtangulo_corrente = new JTextField();
		txtangulo_corrente.setBounds(230, 86, 170, 20);
		txtangulo_corrente.setColumns(10);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(1000,10,100,30);
		painelUCII.add(voltar);
		voltar.setActionCommand("voltar");
		
		JButton ok3 = new JButton("OK");
		ok3.setBounds(640, 500, 70, 20);
		painelUCII.add(ok3);
		ok3.setActionCommand("ok3");
		
		graf_tensao = new GraphPanel(v_tensao);
		graf_tensao.setBounds(-20, 70, 650, 150);
		graf_corrente = new GraphPanel(v_corrente);
		graf_corrente.setBounds(-20, 240, 650, 150);
		graf_poten_inst = new GraphPanel(v_poInstan);
		graf_poten_inst.setBounds(-20, 430, 650, 150);
		triangulo_potencia = new TrianguloPoten(0,0);
		triangulo_potencia.setBounds(680, 400, 650, 500);
		
		
		painelUCII.add(graf_tensao);
		painelUCII.add(graf_corrente);
		painelUCII.add(graf_poten_inst);
		painelUCII.add(triangulo_potencia);
		
		JLabel ampli_tensao_label = new JLabel("Amplitude tensão:");
		ampli_tensao_label.setBounds(40, 50, 170, 20);
		
		JLabel angulo_tensao_label = new JLabel("Ângulo de fase: ");
		angulo_tensao_label.setBounds(230, 50, 170, 20);
		
		JLabel ampli_corrente_label = new JLabel("Amplitude da corrente:");
		ampli_corrente_label.setBounds(40, 50, 170, 20);
		
		JLabel angulo_corrente_label = new JLabel("Ângulo de fase: ");
		angulo_corrente_label.setBounds(230, 50, 170, 20);
		
		JPanel painel_tensao = new JPanel();
		painel_tensao.setLayout(null);
		painel_tensao.setBounds(700, 50, 598, 140);
		painelUCII.add(painel_tensao);
	    painel_tensao.setBorder(javax.swing.BorderFactory.createTitledBorder("TENSÃO"));
	    painel_tensao.add(txtamplitude_tensao);
	    painel_tensao.add(txtangulo_tensao);
	    painel_tensao.add(ampli_tensao_label);
	    painel_tensao.add(angulo_tensao_label);
	    
	    JButton ok = new JButton("OK");
		ok.setBounds(450, 86, 70, 20);
		painel_tensao.add(ok);
		ok.setActionCommand("ok");
		
	    
	    JPanel panel_corrente = new JPanel();
		panel_corrente.setLayout(null);
		panel_corrente.setBounds(700, 230, 598, 140);
		painelUCII.add(panel_corrente);
	    panel_corrente.setBorder(javax.swing.BorderFactory.createTitledBorder("CORRENTE"));
	    panel_corrente.add(txtamplitude_corrente);
	    panel_corrente.add(txtangulo_corrente);
	    panel_corrente.add(ampli_corrente_label);
	    panel_corrente.add(angulo_corrente_label);

	    JButton ok2 = new JButton("OK");
	    ok2.setBounds(450, 86, 70, 20);
	    ok2.setActionCommand("ok2");
	    panel_corrente.add(ok2);
	    
	    JLabel poten_ativa_label = new JLabel("Potência Ativa: ");
		poten_ativa_label.setBounds(25, 600, 170, 40);
		painelUCII.add(poten_ativa_label);
		
		txtpoten_ativa = new JTextField();
		txtpoten_ativa.setBounds(160, 610, 140, 20);
		txtpoten_ativa.setColumns(10);
		painelUCII.add(txtpoten_ativa);
		
		JLabel poten_reativa_label = new JLabel("Potencia reativa:");
		poten_reativa_label.setBounds(25,640 ,170, 40);
		painelUCII.add(poten_reativa_label);
		
		txtpoten_reativa = new JTextField();
		txtpoten_reativa.setBounds(160, 650, 140, 20);
		txtpoten_reativa.setColumns(10);
		painelUCII.add(txtpoten_reativa);
		
		JLabel poten_aparente_label = new JLabel("Potência Aparente: ");
		poten_aparente_label.setBounds(320, 600, 170, 40);
		painelUCII.add(poten_aparente_label);
		

		txtpoten_aparente = new JTextField();
		txtpoten_aparente.setBounds(475, 610, 140, 20);
		txtpoten_aparente.setColumns(10);
		painelUCII.add(txtpoten_aparente);
		
		JLabel fatot_poten_label = new JLabel("Fator de Potência: ");
		fatot_poten_label.setBounds(320,640 , 170, 40);
		painelUCII.add(fatot_poten_label);
		

		txtfator_poten = new JTextField();
		txtfator_poten.setBounds(475,650 , 140, 20);
		txtfator_poten.setColumns(10);
		painelUCII.add(txtfator_poten);
	    
		voltar.addActionListener(new AcoeInterfaceUCII(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao, graf_tensao,
				txtamplitude_corrente,txtangulo_corrente, graf_corrente, graf_poten_inst,txtpoten_ativa, txtpoten_reativa,txtpoten_aparente,txtfator_poten,triangulo_potencia));
		ok.addActionListener(new AcoeInterfaceUCII(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao, graf_tensao
				,txtamplitude_corrente,txtangulo_corrente, graf_corrente,graf_poten_inst,txtpoten_ativa,txtpoten_reativa,txtpoten_aparente,txtfator_poten,triangulo_potencia));
		ok2.addActionListener(new AcoeInterfaceUCII(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao
				, graf_tensao,txtamplitude_corrente,txtangulo_corrente, graf_corrente,graf_poten_inst,txtpoten_ativa,txtpoten_reativa,txtpoten_aparente,txtfator_poten,triangulo_potencia));
		ok3.addActionListener(new AcoeInterfaceUCII(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao, graf_tensao
				,txtamplitude_corrente,txtangulo_corrente, graf_corrente,graf_poten_inst,txtpoten_ativa,txtpoten_reativa,txtpoten_aparente,txtfator_poten,triangulo_potencia));
		
		telaInicial.add(painelUCII);
		painelUCII.setVisible(true);
	
	}

	
	
	
}
