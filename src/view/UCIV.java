package view;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.AcoesInterfaceUCIV;

public class UCIV {
	private JPanel painelUCII;
	public GraphPanel graf_tensao;
	private GraphPanel graf_corrente;
	private GraphPanel graf_poten_inst;
	private JTextField txtordem_harm;
	private JTextField txtamplitude_tensao;
	private JTextField txtangulo_tensao;
	private JTextField txtamplitude_corrente;
	private JTextField txtangulo_corrente;
	private JTextField txtpoten_liq;
	private JTextField txtpoten_dist;
	private JTextField txtTPF;
	private List<Double> v_tensao = new ArrayList<>();
	private List<Double> v_corrente = new ArrayList<>();
	private List<Double> v_poInstan = new ArrayList<>();


	
	public UCIV(JFrame telainicial) throws IOException {
		
		criarPainelUCII(telainicial);

	}
	
	
	private void criarPainelUCII(JFrame telaInicial) throws IOException {
		
	
		painelUCII = new JPanel();
		painelUCII.setLayout(null);
		

		JLabel tile_main = new JLabel("UC IV: FLUXO DE POTÊNCIA HARMÔNICO :");
		tile_main.setBounds(500, 0, 350, 40);
		painelUCII.add(tile_main);
		
		
		JLabel input = new JLabel("ENTRADAS:");
		input.setBounds(25, 30, 170, 40);
		painelUCII.add(input);
		
		JLabel output = new JLabel("SAIDAS: ");
		output.setBounds(25, 410, 170, 20);
		painelUCII.add(output);
		
		
		
		txtamplitude_tensao = new JTextField("0");
		txtamplitude_tensao.setBounds(40, 86, 100, 20);
		txtamplitude_tensao.setColumns(10);
		
		txtangulo_tensao = new JTextField("0");
		txtangulo_tensao.setBounds(230, 86, 100, 20);
		txtangulo_tensao.setColumns(10);
		
		txtamplitude_corrente = new JTextField("0");
		txtamplitude_corrente.setBounds(40, 86, 100, 20);
		txtamplitude_corrente.setColumns(10);
		
		txtangulo_corrente = new JTextField("0");
		txtangulo_corrente.setBounds(180, 86, 100, 20);
		txtangulo_corrente.setColumns(10);
		

		txtordem_harm = new JTextField("0");
		txtordem_harm.setBounds(340, 86, 100, 20);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(1000,10,100,30);
		painelUCII.add(voltar);
		voltar.setActionCommand("voltar");
		
		JButton ok3 = new JButton("OK");
		ok3.setBounds(640, 550, 70, 20);
		painelUCII.add(ok3);
		ok3.setActionCommand("ok3");
		
		graf_tensao = new GraphPanel(v_tensao);
		graf_tensao.setBounds(20, 90, 600, 120);
		graf_corrente = new GraphPanel(v_corrente);
		graf_corrente.setBounds(20, 240, 600, 120);
		graf_poten_inst = new GraphPanel(v_poInstan);
		graf_poten_inst.setBounds(20, 500, 600, 120);
		
		
		painelUCII.add(graf_tensao);
		painelUCII.add(graf_corrente);
		painelUCII.add(graf_poten_inst);
		
		JLabel ampli_tensao_label = new JLabel("Amplitude tensão:");
		ampli_tensao_label.setBounds(40, 50, 170, 20);
		
		JLabel angulo_tensao_label = new JLabel("Ângulo de fase: ");
		angulo_tensao_label.setBounds(230, 50, 170, 20);
		
		JLabel ampli_corrente_label = new JLabel("Ampli. da corrente:");
		ampli_corrente_label.setBounds(20, 50, 170, 20);
		
		JLabel angulo_corrente_label = new JLabel("Ângulo de fase: ");
		angulo_corrente_label.setBounds(170, 50, 170, 20);
		
		JLabel l_ordemharm = new JLabel("Ordem Harmonica: ");
		l_ordemharm.setBounds(320, 50, 170, 20);
		
		JPanel painel_tensao = new JPanel();
		painel_tensao.setLayout(null);
		painel_tensao.setBounds(700, 80, 598, 140);
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
	    panel_corrente.add(txtordem_harm);
	    panel_corrente.add(ampli_corrente_label);
	    panel_corrente.add(angulo_corrente_label);
	    panel_corrente.add(l_ordemharm);

	    JButton ok2 = new JButton("OK");
	    ok2.setBounds(500, 86, 70, 20);
	    ok2.setActionCommand("ok2");
	    panel_corrente.add(ok2);
	    
	    JLabel poten_liq_label = new JLabel("Potência líquida: ");
		poten_liq_label.setBounds(800, 450, 170, 40);
		painelUCII.add(poten_liq_label);
		
		txtpoten_liq = new JTextField("0");
		txtpoten_liq.setBounds(1025, 460, 140, 20);
		txtpoten_liq.setColumns(10);
		painelUCII.add(txtpoten_liq);
		
		JLabel lpoten_dist = new JLabel("Potência de distorção:");
		lpoten_dist.setBounds(800,515 ,170, 40);
		painelUCII.add(lpoten_dist);
		
		txtpoten_dist = new JTextField("0");
		txtpoten_dist.setBounds(1025, 525, 140, 20);
		txtpoten_dist.setColumns(10);
		painelUCII.add(txtpoten_dist);
		
		JLabel poten_aparente_label = new JLabel("TPF: ");
		poten_aparente_label.setBounds(800, 580, 170, 40);
		painelUCII.add(poten_aparente_label);
		

		txtTPF = new JTextField("0");
		txtTPF.setBounds(1025, 590, 140, 20);
		txtTPF.setColumns(10);
		painelUCII.add(txtTPF);
		
		
		voltar.addActionListener( new AcoesInterfaceUCIV(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao, graf_tensao,
				txtamplitude_corrente,txtangulo_corrente, graf_corrente, graf_poten_inst, txtordem_harm,txtpoten_dist));
		ok.addActionListener(new AcoesInterfaceUCIV(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao, graf_tensao
				,txtamplitude_corrente,txtangulo_corrente, graf_corrente,graf_poten_inst, txtordem_harm,txtpoten_dist));
		ok2.addActionListener(new AcoesInterfaceUCIV(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao
				, graf_tensao,txtamplitude_corrente,txtangulo_corrente, graf_corrente,graf_poten_inst,txtordem_harm,txtpoten_dist));
		ok3.addActionListener(new AcoesInterfaceUCIV(painelUCII,telaInicial,txtamplitude_tensao,txtangulo_tensao, graf_tensao
				,txtamplitude_corrente,txtangulo_corrente, graf_corrente,graf_poten_inst,txtordem_harm,txtpoten_dist));
		
		telaInicial.add(painelUCII);
		painelUCII.setVisible(true);
	
	}


}
