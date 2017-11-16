package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.FormaCorrente;
import model.FormaTensao;
import model.Harmonicos;
import model.Potencias;
import view.GraphPanel;
import view.InterfacePrincipal;

public class AcoesInterfaceUCIV implements ActionListener{
	private JPanel painelUCII;
	private JFrame telaInicial;
	public JTextField txtamplitude_tensao;
	private JTextField txtangulo_tensao;
	FormaTensao tensao = new FormaTensao();
	Harmonicos harmonico = new Harmonicos();
	Potencias potencia = new Potencias();
	private GraphPanel graficotensao;
	public JTextField txtamplitude_corrente;
	private JTextField txtangulo_corrente;
	FormaCorrente graf_corrente = new FormaCorrente();
	Potencias pot_intantanea = new Potencias();
	private GraphPanel graficocorrente;
	private GraphPanel graficopotinst;
	private JTextField ordemharm;
	private JTextField poten_d;
	private JTextField txtTPF;
	// Associações
	
	public AcoesInterfaceUCIV(JPanel painelUCII,JFrame telaInicial,JTextField txtamplitude_tensao,JTextField txtangulo_tensao, GraphPanel grafico_tensao
			,JTextField txtamplitude_corrente,JTextField txtangulo_corrente, GraphPanel grafico_corrente, GraphPanel grafico_poteninst,JTextField ordemharm,
			JTextField poten_d, JTextField txtTPF) throws IOException{
		this.painelUCII=painelUCII;
		this.telaInicial=telaInicial;
		this.txtamplitude_tensao =txtamplitude_tensao;
		this.txtangulo_tensao = txtangulo_tensao;
		this.graficotensao = grafico_tensao;
		this.txtamplitude_corrente =txtamplitude_corrente;
		this.txtangulo_corrente = txtangulo_corrente;
		this.graficocorrente = grafico_corrente;
		this.graficopotinst = grafico_poteninst;
		this.ordemharm = ordemharm;
		this.poten_d = poten_d;
		this.txtTPF = txtTPF;
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		String comando = e.getActionCommand();
		
		if(comando.equals("voltar")){
				painelUCII.setVisible(false);
			try {
				new InterfacePrincipal(telaInicial);
			} catch (IOException e1) {
				 //TODO Auto-generated catch block
				e1.printStackTrace();
			
		}
	}
			
		else if(comando.equals("ok")) {
			double amplitude_ten = 0 , angulo_ten = 0;
			
			amplitude_ten = Double.parseDouble(txtamplitude_tensao.getText());
            angulo_ten = Double.parseDouble(txtangulo_tensao.getText());
            List<Double> lista = tensao.formaGrafico(amplitude_ten, angulo_ten);
			
            if(amplitude_ten < 0 || amplitude_ten > 220 || angulo_ten < -180 || angulo_ten > 180){
           	JOptionPane.showMessageDialog(null, "\t\tTENSÃO\nAngulo ou Amplitude inválida \n\n"
           		            	+ "           LIMITES:\n 0 > Amplitude > 220 \n -180 > Angulo < 180"); 
           	 
            }
            else {
			
             
			GraphPanel grafico_tensao = new GraphPanel(lista);
			grafico_tensao.setBounds(20, 90, 600, 120);
	        
	        graficotensao.setVisible(false);
	        painelUCII.add(grafico_tensao);
	        
	        grafico_tensao.revalidate();
	        grafico_tensao.repaint();
	        
          }
						
		}
		else if(comando.equals("ok2")) {
			double amplitude_cor,angulo_cor,ordemh;
			
			 amplitude_cor = Double.parseDouble(txtamplitude_corrente.getText());
             angulo_cor = Double.parseDouble(txtangulo_corrente.getText());
             ordemh = Double.parseDouble(ordemharm.getText());
             
             List<Double> lista = harmonico.FormaOnda(amplitude_cor, angulo_cor, ordemh);            
             
             if(amplitude_cor < 0 || amplitude_cor > 220 || angulo_cor < -180 || angulo_cor > 180 || ordemh < 0 || ordemh > 15) {
            	 JOptionPane.showMessageDialog(null, "Angulo, Amplitude ou Ordem Harmonicas inválida \n\n"
 		            	+ "           LIMITES:\n 0 >= Amplitude <= 220 \n -180 >= Angulo <= 180 \n 0 >= ordem <= 15");
             }
             else {
             
					GraphPanel grafico_corrente = new GraphPanel(lista);
					grafico_corrente.setBounds(20, 240, 600, 120);
			        
			        graficocorrente.setVisible(false);
			        painelUCII.add(grafico_corrente);
			        
			        grafico_corrente.revalidate();
			        grafico_corrente.repaint();
					
             }
		}
		else if(comando.equals("ok3")) {
			double amplitude_cor, angulo_cor,amplitude_ten, angulo_ten, ordemh;
		    int poten_dist;

			 amplitude_ten = Double.parseDouble(txtamplitude_tensao.getText());
             angulo_ten = Double.parseDouble(txtangulo_tensao.getText());
			 amplitude_cor = Double.parseDouble(txtamplitude_corrente.getText());
             angulo_cor = Double.parseDouble(txtangulo_corrente.getText());
             ordemh = Double.parseDouble(ordemharm.getText());
                  
             poten_dist = (int) potencia.Paparente(amplitude_ten, amplitude_cor);
             
             poten_d .setText(poten_dist + "    voltAmpere");
             txtTPF.setText(harmonico.tPF(0, poten_dist)+ "");
        
             
             List<Double> lista = harmonico.potenciaInstharm(amplitude_ten, angulo_ten, amplitude_cor, angulo_cor, ordemh);
             
 			graficopotinst.setVisible(false); 
			GraphPanel grafico_potenciainst = new GraphPanel(lista);
			grafico_potenciainst.setBounds(20, 430, 600, 120);
			painelUCII.add(grafico_potenciainst);
	       
	        
	       grafico_potenciainst.revalidate();
	       grafico_potenciainst.repaint();
	        
	        
			
		}
	}
}
