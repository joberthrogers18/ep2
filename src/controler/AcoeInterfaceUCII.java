package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.FormaCorrente;
import model.FormaTensao;
import model.Potencias;
import view.UCII;
import view.GraphPanel;
import view.InterfacePrincipal;
import view.TrianguloPoten;

public class AcoeInterfaceUCII  implements ActionListener {

	private JPanel painelUCII;
	private JFrame telaInicial;
	public JTextField txtamplitude_tensao;
	private JTextField txtangulo_tensao;
	FormaTensao tensao = new FormaTensao();
	private GraphPanel graficotensao;
	private TrianguloPoten triangulo;
	public JTextField txtamplitude_corrente;
	private JTextField txtangulo_corrente;
	FormaCorrente graf_corrente = new FormaCorrente();
	Potencias pot_intantanea = new Potencias();
	private GraphPanel graficocorrente;
	private GraphPanel graficopotinst;
	private JTextField txtpotenciaAtiva;
	private JTextField txtpotenciaReativa;
	private JTextField txtpotenciaAparente;
	private JTextField txtfatorPotencia;
	// Associações
	
	public AcoeInterfaceUCII(JPanel painelUCII,JFrame telaInicial,JTextField txtamplitude_tensao,JTextField txtangulo_tensao, GraphPanel grafico_tensao
			,JTextField txtamplitude_corrente,JTextField txtangulo_corrente, GraphPanel grafico_corrente, GraphPanel grafico_poteninst, JTextField potenAtiva
			,JTextField txtpoten_reativa, JTextField txtpoten_aparente, JTextField txtfator_poten, TrianguloPoten triangulo) throws IOException{
		this.painelUCII=painelUCII;
		this.telaInicial=telaInicial;
		this.txtamplitude_tensao =txtamplitude_tensao;
		this.txtangulo_tensao = txtangulo_tensao;
		this.graficotensao = grafico_tensao;
		this.txtamplitude_corrente =txtamplitude_corrente;
		this.txtangulo_corrente = txtangulo_corrente;
		this.graficocorrente = grafico_corrente;
		this.graficopotinst = grafico_poteninst;
		this.txtpotenciaAtiva = potenAtiva;
		this.txtpotenciaReativa = txtpoten_reativa;
		this.txtpotenciaAparente = txtpoten_aparente;
		this.txtfatorPotencia = txtfator_poten;
		this.triangulo =triangulo;
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
			double amplitude_ten, angulo_ten;
			
			
			 amplitude_ten = Double.parseDouble(txtamplitude_tensao.getText());
             angulo_ten = Double.parseDouble(txtangulo_tensao.getText());
             List<Double> lista = tensao.formaGrafico(amplitude_ten, angulo_ten);
             
			GraphPanel grafico_tensao = new GraphPanel(lista);
			grafico_tensao.setBounds(-20, 70, 650, 150);
	        
	        graficotensao.setVisible(false);
	        painelUCII.add(grafico_tensao);
	        
	        grafico_tensao.revalidate();
	        grafico_tensao.repaint();
						
		}
		else if(comando.equals("ok2")) {
			double amplitude_cor, angulo_cor;
			
			 amplitude_cor = Double.parseDouble(txtamplitude_corrente.getText());
             angulo_cor = Double.parseDouble(txtangulo_corrente.getText());
             List<Double> lista = graf_corrente.formaGrafico(amplitude_cor, angulo_cor);
             
             
			GraphPanel grafico_corrente = new GraphPanel(lista);
			grafico_corrente.setBounds(-20, 240, 650, 150);
	        
	        graficocorrente.setVisible(false);
	        painelUCII.add(grafico_corrente);
	        
	        grafico_corrente.revalidate();
	        grafico_corrente.repaint();
			
			
		}
		else if(comando.equals("ok3")) {
			double amplitude_cor, angulo_cor,amplitude_ten, angulo_ten;
			int v_potenativa = 0, v_potereativa = 0;
	        

			 amplitude_ten = Double.parseDouble(txtamplitude_tensao.getText());
             angulo_ten = Double.parseDouble(txtangulo_tensao.getText());
			 amplitude_cor = Double.parseDouble(txtamplitude_corrente.getText());
             angulo_cor = Double.parseDouble(txtangulo_corrente.getText());
             
             txtpotenciaAtiva.setText(String.valueOf(Math.round(pot_intantanea.Pativa(amplitude_ten, amplitude_cor, angulo_ten, angulo_cor))+ "     Watts"));
             txtpotenciaReativa.setText(String.valueOf(Math.round(pot_intantanea.Preativa(amplitude_ten, amplitude_cor, angulo_ten, angulo_cor))+ "     VAR"));
             txtpotenciaAparente.setText(String.valueOf(Math.round(pot_intantanea.Paparente(amplitude_ten, amplitude_cor)) + "     VA"));
             txtfatorPotencia.setText(String.valueOf(pot_intantanea.FatorPotencia(angulo_ten, angulo_cor)));
             
             v_potenativa = (int) pot_intantanea.Pativa(amplitude_ten, amplitude_cor, angulo_ten, angulo_cor);
             v_potereativa = (int) pot_intantanea.Preativa(amplitude_ten, amplitude_cor, angulo_ten, angulo_cor);
             
             
             List<Double> lista = pot_intantanea.FormaOndaPotenciaIns(amplitude_ten, angulo_ten, amplitude_cor, angulo_cor);
             
 			graficopotinst.setVisible(false); 
			GraphPanel grafico_potenciainst = new GraphPanel(lista);
			grafico_potenciainst.setBounds(-20, 430, 650, 150);
			painelUCII.add(grafico_potenciainst);
	       
	        
	       grafico_potenciainst.revalidate();
	       grafico_potenciainst.repaint();
	        
	        
	      triangulo.setVisible(false);
	      TrianguloPoten triangulo = new TrianguloPoten(v_potenativa,v_potereativa);
	      triangulo.setBounds(680, 400, 420,300);
	        
	      painelUCII.add(triangulo);
	        
	      
	       triangulo.revalidate();
	       triangulo.repaint();
			
			
		}
	}
	
}
    


