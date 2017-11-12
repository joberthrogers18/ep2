package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.AcoesInterfaceUCIII;

//import controler.AcoeInterfaceUCII;

public class UCIII {
	private JPanel painelUCIII;
	public GraphPanel graf_compfunda;
	private GraphPanel graf_harmonico1;
	private GraphPanel graf_harmonico2;
	private GraphPanel graf_harmonico3;
	private GraphPanel graf_harmonico4;
	private GraphPanel graf_harmonico5;
	private GraphPanel graf_harmonico6;
	private GraphPanel graf_resultante;
	public JTextField txtamplitude_tensao;
	private JTextField txtangulo_tensao;
	private JTextField txtamplitude_corrente;
	private JTextField txtangulo_corrente;
	private JTextField txtpoten_ativa;
	private JTextField txtpoten_reativa;
	private JTextField txtpoten_aparente;
	private JTextField txtfator_poten;
	private List<Double> v_compfunda = new ArrayList<>();
	private List<Double> v_corrente = new ArrayList<>();
	private List<Double> v_poInstan = new ArrayList<>();


	
	public UCIII(JFrame telainicial) throws IOException {
		
		criarPainelUCII(telainicial);

	}
	
	
	private void criarPainelUCII(JFrame telaInicial) throws IOException {
		
	
		painelUCIII = new JPanel();
		painelUCIII.setLayout(null);
		
		for (float i = 0; i < 100; i = (float) (i + 0.4)) {
	           
			v_compfunda.add((double) (0*i));
        }

		JLabel tile_main = new JLabel("UC III: Distorção Harmonica :");
		tile_main.setBounds(500, 0, 350, 40);
		painelUCIII.add(tile_main);
		
		
		JLabel compo_fundamental = new JLabel("Componente fundamental:");
		compo_fundamental.setBounds(25, 40, 250, 40);
		painelUCIII.add(compo_fundamental);
		
		
		txtamplitude_tensao = new JTextField();
		txtamplitude_tensao.setBounds(40, 86, 170, 20);
		txtamplitude_tensao.setColumns(10);
		
		txtangulo_tensao = new JTextField();
		txtangulo_tensao.setBounds(230, 86, 170, 20);
		txtangulo_tensao.setColumns(10);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(1000,10,100,30);
		painelUCIII.add(voltar);
		voltar.setActionCommand("voltar");
			
		graf_compfunda = new GraphPanel(v_compfunda);
		graf_compfunda.setBounds(40, 70, 500, 100);
		graf_harmonico1 = new GraphPanel(v_compfunda);
		graf_harmonico2 = new GraphPanel(v_compfunda);
		graf_harmonico3 = new GraphPanel(v_compfunda);
		graf_harmonico4 = new GraphPanel(v_compfunda);
		graf_harmonico5 = new GraphPanel(v_compfunda);
		graf_harmonico6 = new GraphPanel(v_compfunda);
		graf_resultante = new GraphPanel(v_compfunda);
		graf_resultante.setBounds(40, 570, 500, 100);
		
		painelUCIII.add(graf_compfunda);
		painelUCIII.add(graf_resultante);
	
		JLabel ampli_tensao_label = new JLabel("Amplitude tensão:");
		ampli_tensao_label.setBounds(40, 50, 170, 20);
		
		JLabel angulo_tensao_label = new JLabel("Ângulo de fase: ");
		angulo_tensao_label.setBounds(230, 50, 170, 20);
		
		JPanel painel_cfund = new JPanel();
		painel_cfund.setLayout(null);
		painel_cfund.setBounds(725, 50, 500, 120);
		painelUCIII.add(painel_cfund);
	    painel_cfund.setBorder(javax.swing.BorderFactory.createTitledBorder("Componente Fundamental"));
	    painel_cfund.add(txtamplitude_tensao);
	    painel_cfund.add(txtangulo_tensao);
	    painel_cfund.add(ampli_tensao_label);
	    painel_cfund.add(angulo_tensao_label);
	    
	    JButton ok = new JButton("OK");
		ok.setBounds(425, 86, 60, 20);
		painel_cfund.add(ok);
		ok.setActionCommand("ok");
		
	    
	    JPanel panel_corrente = new JPanel();
		panel_corrente.setLayout(null);
		panel_corrente.setBounds(30, 180, 1230, 350);
		painelUCIII.add(panel_corrente);
	    panel_corrente.setBorder(javax.swing.BorderFactory.createTitledBorder("HARMONICOS: "));
		 

	    JButton ok2 = new JButton("OK");
		ok2.setBounds(1100, 25, 60, 20);
		panel_corrente.add(ok2);
		ok2.setActionCommand("ok2");
	    
	    JComboBox num_harm = new JComboBox();
	    panel_corrente.add(num_harm);
	    
	    for(int i= 0; i < 7; i++) {
	    	num_harm.addItem(i);
	    }
	    
	    num_harm.setBounds(500,25,100,20);
	    
	    JLabel l_amplitudeh1 = new JLabel("Ampl.1: ");
	    l_amplitudeh1.setBounds(60, 60, 60, 20);
	    panel_corrente.add(l_amplitudeh1);
	    
	    
	    JTextField txt_amplitudeh1 = new JTextField("0");
	    txt_amplitudeh1.setBounds(120, 60, 40, 20);
	    panel_corrente.add(txt_amplitudeh1);
	    txt_amplitudeh1.setEnabled(false);
	    
	    JLabel l_anguloh1 = new JLabel("Ang.1: ");
	    l_anguloh1.setBounds(180, 60, 60, 20);
	    panel_corrente.add(l_anguloh1);
	   
	    JTextField txt_anguloh1 = new JTextField("0");
	    txt_anguloh1.setBounds(230, 60, 40, 20);
	    panel_corrente.add(txt_anguloh1);
	    txt_anguloh1.setEnabled(false);
	    
	    JLabel l_ordemh1 = new JLabel("ordem.1: ");
	    l_ordemh1.setBounds(280, 60, 80, 20);
	    panel_corrente.add(l_ordemh1);
	    
	    JTextField txt_ordem1 = new JTextField("0");
	    txt_ordem1.setBounds(350, 60, 40, 20);
	    panel_corrente.add(txt_ordem1);
	    txt_ordem1.setEnabled(false);
	    
	    JLabel label_har1 = new JLabel("harm.1");
		panel_corrente.add(label_har1);
		label_har1.setBounds(10,90,50,20);
	    
		graf_harmonico1.setBounds(60, 90, 330, 90);
	    panel_corrente.add(graf_harmonico1);
	    
	    JLabel l_amplitudeh2 = new JLabel("Ampl.2: ");
	    l_amplitudeh2.setBounds(60, 210, 60, 20);
	    panel_corrente.add(l_amplitudeh2);
	    
	    JTextField txt_amplitudeh2 = new JTextField("0");
	    txt_amplitudeh2.setBounds(120, 210, 40, 20);
	    panel_corrente.add(txt_amplitudeh2);
	    txt_amplitudeh2.setEnabled(false);
	    
	    JLabel l_anguloh2 = new JLabel("Ang.2: ");
	    l_anguloh2.setBounds(180, 210, 60, 20);
	    panel_corrente.add(l_anguloh2);
	   
	    JTextField txt_anguloh2 = new JTextField("0");
	    txt_anguloh2.setBounds(230, 210, 40, 20);
	    panel_corrente.add(txt_anguloh2);
	    txt_anguloh2.setEnabled(false);
	    
	    JLabel l_ordemh2 = new JLabel("ordem.2: ");
	    l_ordemh2.setBounds(280, 210, 80, 20);
	    panel_corrente.add(l_ordemh2);
	   
	    JTextField txt_ordem2 = new JTextField("0");
	    txt_ordem2.setBounds(350, 210, 40, 20);
	    panel_corrente.add(txt_ordem2);	    
	    txt_ordem2.setEnabled(false);
	    
	    JLabel label_har2 = new JLabel("harm.2");
		panel_corrente.add(label_har2);
		label_har2.setBounds(10,240,50,20);
	    
	    graf_harmonico2.setBounds(60, 240, 330, 90);
	    panel_corrente.add(graf_harmonico2);
	    

	    JLabel l_amplitudeh3 = new JLabel("Ampl.3: ");
	    l_amplitudeh3.setBounds(480, 60, 60, 20);
	    panel_corrente.add(l_amplitudeh3);
	    
	    
	    JTextField txt_amplitudeh3 = new JTextField("0");
	    txt_amplitudeh3.setBounds(540, 60, 40, 20);
	    panel_corrente.add(txt_amplitudeh3);
	    txt_amplitudeh3.setEnabled(false);
	    
	    JLabel l_anguloh3 = new JLabel("Ang.3: ");
	    l_anguloh3.setBounds(590, 60, 60, 20);
	    panel_corrente.add(l_anguloh3);
	   
	    JTextField txt_anguloh3 = new JTextField("0");
	    txt_anguloh3.setBounds(640, 60, 40, 20);
	    panel_corrente.add(txt_anguloh3);
	    txt_anguloh3.setEnabled(false);
	    
	    JLabel l_ordemh3 = new JLabel("ordem.3: ");
	    l_ordemh3.setBounds(700, 60, 80, 20);
	    panel_corrente.add(l_ordemh3);
	    
	    JTextField txt_ordem3 = new JTextField("0");
	    txt_ordem3.setBounds(770, 60, 40, 20);
	    panel_corrente.add(txt_ordem3);
	    txt_ordem3.setEnabled(false);
	   
	    JLabel label_har3 = new JLabel("harm.3");
		panel_corrente.add(label_har3);
		label_har3.setBounds(420,90,50,20);
	    
	    graf_harmonico3.setBounds(480, 90, 330, 90);
	    panel_corrente.add(graf_harmonico3);
	    
	    JLabel l_amplitudeh4 = new JLabel("Ampl.4: ");
	    l_amplitudeh4.setBounds(480, 210, 60, 20);
	    panel_corrente.add(l_amplitudeh4);
	    
	    JTextField txt_amplitudeh4 = new JTextField("0");
	    txt_amplitudeh4.setBounds(540, 210, 40, 20);
	    panel_corrente.add(txt_amplitudeh4);
	    txt_amplitudeh4.setEnabled(false);
	    
	    JLabel l_anguloh4 = new JLabel("Ang.4: ");
	    l_anguloh4.setBounds(590, 210, 60, 20);
	    panel_corrente.add(l_anguloh4);
	   
	    JTextField txt_anguloh4 = new JTextField("0");
	    txt_anguloh4.setBounds(640, 210, 40, 20);
	    panel_corrente.add(txt_anguloh4);
	    txt_anguloh4.setEnabled(false);
	    
	    JLabel l_ordemh4 = new JLabel("ordem.4: ");
	    l_ordemh4.setBounds(700, 210, 80, 20);
	    panel_corrente.add(l_ordemh4);
	    
	    JTextField txt_ordem4 = new JTextField("0");
	    txt_ordem4.setBounds(770, 210, 40, 20);
	    panel_corrente.add(txt_ordem4);
	    txt_ordem4.setEnabled(false);
	    
	    JLabel label_har4 = new JLabel("harm.4");
		panel_corrente.add(label_har4);
		label_har4.setBounds(420,240,50,20);
		
	    graf_harmonico4.setBounds(480, 240, 330, 90);
	    panel_corrente.add(graf_harmonico4);
	    
	    JLabel l_amplitudeh5 = new JLabel("Ampl.5: ");
	    l_amplitudeh5.setBounds(890, 60, 60, 20);
	    panel_corrente.add(l_amplitudeh5);
	    
	    JTextField txt_amplitudeh5 = new JTextField("0");
	    txt_amplitudeh5.setBounds(950, 60, 40, 20);
	    panel_corrente.add(txt_amplitudeh5);
	    txt_amplitudeh5.setEnabled(false);
	    
	    JLabel l_anguloh5 = new JLabel("Ang.5: ");
	    l_anguloh5.setBounds(1000, 60, 60, 20);
	    panel_corrente.add(l_anguloh5);
	   
	    JTextField txt_anguloh5 = new JTextField("0");
	    txt_anguloh5.setBounds(1050, 60, 40, 20);
	    panel_corrente.add(txt_anguloh5);
	    txt_anguloh5.setEnabled(false);
	    
	    JLabel l_ordemh5 = new JLabel("ordem.5: ");
	    l_ordemh5.setBounds(1100, 60, 80, 20);
	    panel_corrente.add(l_ordemh5);
	    
	    JTextField txt_ordem5 = new JTextField("0");
	    txt_ordem5.setBounds(1170, 60, 40, 20);
	    panel_corrente.add(txt_ordem5);
	    txt_ordem5.setEnabled(false);
	    
	    JLabel label_har5 = new JLabel("harm.5");
		panel_corrente.add(label_har5);
		label_har5.setBounds(830,90,50,20);
	    
	    graf_harmonico5.setBounds(890, 90, 330, 90);
	    panel_corrente.add(graf_harmonico5);

	    JLabel l_amplitudeh6 = new JLabel("Ampl.6: ");
	    l_amplitudeh6.setBounds(890, 210, 60, 20);
	    panel_corrente.add(l_amplitudeh6);
	    
	    JTextField txt_amplitudeh6 = new JTextField("0");
	    txt_amplitudeh6.setBounds(950, 210, 40, 20);
	    panel_corrente.add(txt_amplitudeh6);
	    txt_amplitudeh6.setEnabled(false);
	    
	    JLabel l_anguloh6 = new JLabel("Ang.6: ");
	    l_anguloh6.setBounds(1000, 210, 60, 20);
	    panel_corrente.add(l_anguloh6);
	   
	    JTextField txt_anguloh6 = new JTextField("0");
	    txt_anguloh6.setBounds(1050, 210, 40, 20);
	    panel_corrente.add(txt_anguloh6);
	    txt_anguloh6.setEnabled(false);
	    
	    JLabel l_ordemh6 = new JLabel("ordem.6: ");
	    l_ordemh6.setBounds(1100, 210, 80, 20);
	    panel_corrente.add(l_ordemh6);
	    
	    JTextField txt_ordem6 = new JTextField("0");
	    txt_ordem6.setBounds(1170, 210, 40, 20);
	    panel_corrente.add(txt_ordem6);
	    txt_ordem6.setEnabled(false);
	    
	    
	    graf_harmonico6.setBounds(890, 240, 330, 90);
	    panel_corrente.add(graf_harmonico6);
	    
	    
	    voltar.addActionListener(new AcoesInterfaceUCIII(painelUCIII,telaInicial,num_harm, txt_amplitudeh1, txt_anguloh1, txt_ordem1,txt_amplitudeh2, txt_anguloh2, txt_ordem2,
	    						txt_amplitudeh3, txt_anguloh3, txt_ordem3,txt_amplitudeh4, txt_anguloh4, txt_ordem4,txt_amplitudeh5, txt_anguloh5, txt_ordem5,txt_amplitudeh6,
	    						txt_anguloh6, txt_ordem6,txtamplitude_tensao,txtangulo_tensao,graf_compfunda,panel_corrente, graf_harmonico1,graf_harmonico2,graf_harmonico3,
	    						graf_harmonico4,graf_harmonico5,graf_harmonico6));
	    num_harm.addActionListener(new AcoesInterfaceUCIII(painelUCIII,telaInicial,num_harm, txt_amplitudeh1, txt_anguloh1, txt_ordem1,txt_amplitudeh2, txt_anguloh2, txt_ordem2,
				txt_amplitudeh3, txt_anguloh3, txt_ordem3,txt_amplitudeh4, txt_anguloh4, txt_ordem4,txt_amplitudeh5, txt_anguloh5, txt_ordem5,txt_amplitudeh6,
				txt_anguloh6, txt_ordem6,txtamplitude_tensao,txtangulo_tensao,graf_compfunda,panel_corrente, graf_harmonico1,graf_harmonico2,graf_harmonico3,
				graf_harmonico4,graf_harmonico5,graf_harmonico6));
	    ok.addActionListener(new AcoesInterfaceUCIII(painelUCIII,telaInicial,num_harm, txt_amplitudeh1, txt_anguloh1, txt_ordem1,txt_amplitudeh2, txt_anguloh2, txt_ordem2,
				txt_amplitudeh3, txt_anguloh3, txt_ordem3,txt_amplitudeh4, txt_anguloh4, txt_ordem4,txt_amplitudeh5, txt_anguloh5, txt_ordem5,txt_amplitudeh6,
				txt_anguloh6, txt_ordem6,txtamplitude_tensao,txtangulo_tensao,graf_compfunda,panel_corrente, graf_harmonico1,graf_harmonico2,graf_harmonico3,
				graf_harmonico4,graf_harmonico5,graf_harmonico6));
		
	    ok2.addActionListener(new AcoesInterfaceUCIII(painelUCIII,telaInicial,num_harm, txt_amplitudeh1, txt_anguloh1, txt_ordem1,txt_amplitudeh2, txt_anguloh2, txt_ordem2,
				txt_amplitudeh3, txt_anguloh3, txt_ordem3,txt_amplitudeh4, txt_anguloh4, txt_ordem4,txt_amplitudeh5, txt_anguloh5, txt_ordem5,txt_amplitudeh6,
				txt_anguloh6, txt_ordem6,txtamplitude_tensao,txtangulo_tensao,graf_compfunda,panel_corrente, graf_harmonico1,graf_harmonico2,graf_harmonico3,
				graf_harmonico4,graf_harmonico5,graf_harmonico6));
		
	    
	    telaInicial.add(painelUCIII);
		painelUCIII.setVisible(true);
	
	}
	
}
