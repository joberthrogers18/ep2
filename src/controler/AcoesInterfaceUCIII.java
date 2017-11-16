package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.FormaTensao;
import model.Harmonicos;
import view.GraphPanel;
import view.InterfacePrincipal;

public class AcoesInterfaceUCIII implements ActionListener {
	private JFrame tPrincipal;
	private JPanel painelUCIII;
	private JComboBox num_harm;
	private JTextField txt_amplharm1;
	private JTextField txt_anghar1; 
	private JTextField txt_ordemh1;
	private JTextField txt_amplharm2;
	private JTextField txt_anghar2; 
	private JTextField txt_ordemh2;
	private JTextField txt_amplharm3;
	private JTextField txt_anghar3; 
	private JTextField txt_ordemh3;
	private JTextField txt_amplharm4;
	private JTextField txt_anghar4; 
	private JTextField txt_ordemh4;
	private JTextField txt_amplharm5;
	private JTextField txt_anghar5; 
	private JTextField txt_ordemh5;
	private JTextField txt_amplharm6;
	private JTextField txt_anghar6; 
	private JTextField txt_ordemh6;
	FormaTensao tensao = new FormaTensao();
	Harmonicos harmonico = new Harmonicos();
	private JTextField txt_amplfund;
	private JTextField txt_anglfund;
	private GraphPanel graf_fund;
	private JPanel painel_harm;
	private GraphPanel harm1;
	private GraphPanel harm2;
	private GraphPanel harm3;
	private GraphPanel harm4;
	private GraphPanel harm5;
	private GraphPanel harm6;
	private GraphPanel g_resul;
	private JTextArea serie;
	
	
	 public AcoesInterfaceUCIII( JPanel painelUCIII,JFrame tPrincipal,JComboBox num_harm, JTextField txt_amplharm1,
			 JTextField txt_angharm1, JTextField txt_ordemh1, JTextField txt_amplharm2,
			 JTextField txt_angharm2, JTextField txt_ordemh2, JTextField txt_amplharm3,
			 JTextField txt_angharm3, JTextField txt_ordemh3, JTextField txt_amplharm4,
			 JTextField txt_angharm4, JTextField txt_ordemh4, JTextField txt_amplharm5,
			 JTextField txt_angharm5, JTextField txt_ordemh5, JTextField txt_amplharm6,
			 JTextField txt_angharm6, JTextField txt_ordemh6,JTextField txt_amplfund,
			 JTextField txt_anglfund, GraphPanel graf_fund, JPanel painel_harm,GraphPanel
			 harm1,GraphPanel harm2,GraphPanel harm3,GraphPanel harm4,GraphPanel harm5,GraphPanel
			 harm6, GraphPanel g_resul,JTextArea serie) {
		 
		 this.tPrincipal = tPrincipal;
		 this.painelUCIII = painelUCIII;
		 this.num_harm = num_harm;
		 this.txt_amplharm1 = txt_amplharm1;
		 this.txt_anghar1 = txt_angharm1;
		 this.txt_ordemh1 = txt_ordemh1;
		 this.txt_amplharm2 = txt_amplharm2;
		 this.txt_anghar2 = txt_angharm2;
		 this.txt_ordemh2 = txt_ordemh2;
		 this.txt_amplharm3 = txt_amplharm3;
		 this.txt_anghar3 = txt_angharm3;
		 this.txt_ordemh3 = txt_ordemh3;
		 this.txt_amplharm4= txt_amplharm4;
		 this.txt_anghar4 = txt_angharm4;
		 this.txt_ordemh4 = txt_ordemh4;
		 this.txt_amplharm5 = txt_amplharm5;
		 this.txt_anghar5 = txt_angharm5;
		 this.txt_ordemh5 = txt_ordemh5;
		 this.txt_amplharm6 = txt_amplharm6;
		 this.txt_anghar6 = txt_angharm6;
		 this.txt_ordemh6 = txt_ordemh6;
		 this.txt_amplfund = txt_amplfund;
		 this.txt_anglfund = txt_anglfund;
		 this.graf_fund = graf_fund;
		 this.painel_harm = painel_harm;
		 this.harm1 = harm1;
		 this.harm2 = harm2;
		 this.harm3 = harm3;
		 this.harm4 = harm4;
		 this.harm5 = harm5;
		 this.harm6 = harm6;
		 this.g_resul = g_resul;
		 this.serie = serie;
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		 	String comando = e.getActionCommand();
		 
           
			if(e.getActionCommand().equals("voltar")){
					painelUCIII.setVisible(false);
				try {
					new InterfacePrincipal(tPrincipal);
				} catch (IOException e1) {
					 //TODO Auto-generated catch block
					e1.printStackTrace();
				
			}
		}
				
			else if(comando.equals("ok")) {
				double amplitude_ten, angulo_ten;
				
				 amplitude_ten = Double.parseDouble(txt_amplfund.getText());
	            angulo_ten = Double.parseDouble(txt_anglfund.getText());
	            
	            if(amplitude_ten < 0 || amplitude_ten > 220 || angulo_ten < -180 || angulo_ten > 180){
	                  JOptionPane.showMessageDialog(null, "\t\tCOMPONENTE FUNDAMENTAL\nAngulo ou Amplitude inválida \n\n"
	            		            	+ "           LIMITES:\n 0 > Amplitude > 220 \n -180 > Angulo < 180"); 
	            	 
	              }
	              else {
	            
						 List<Double> lista = tensao.formaGrafico(amplitude_ten, angulo_ten);
			             
						GraphPanel grafico_tensao = new GraphPanel(lista);
						grafico_tensao.setBounds(40, 70, 500, 100);
				        
						graf_fund.setVisible(false);
				        painelUCIII.add(grafico_tensao);
				        
				        grafico_tensao.revalidate();
				        grafico_tensao.repaint();
	              }       
							
			}
			else if(comando.equals("ok2")) {
				
				double amplitude_harm1, angulo_harm1, ordem1,amplitude_harm2, angulo_harm2, ordem2,
				amplitude_harm3, angulo_harm3, ordem3,amplitude_harm4, angulo_harm4, ordem4,
				amplitude_harm5, angulo_harm5, ordem5,amplitude_harm6, angulo_harm6, ordem6, amplitude_ten,angulo_ten;
				
				amplitude_ten = Double.parseDouble(txt_amplfund.getText());
	            angulo_ten = Double.parseDouble(txt_anglfund.getText());
				amplitude_harm1 = Double.parseDouble(txt_amplharm1.getText());
	            angulo_harm1 = Double.parseDouble(txt_anghar1.getText());
	            ordem1 = Double.parseDouble(txt_ordemh1.getText());
	            amplitude_harm2 = Double.parseDouble(txt_amplharm2.getText());
	            angulo_harm2 = Double.parseDouble(txt_anghar2.getText());
	            ordem2 = Double.parseDouble(txt_ordemh2.getText());
	            amplitude_harm3 = Double.parseDouble(txt_amplharm3.getText());
		        angulo_harm3 = Double.parseDouble(txt_anghar3.getText());
		        ordem3 = Double.parseDouble(txt_ordemh3.getText());
		        amplitude_harm4 = Double.parseDouble(txt_amplharm4.getText());
			    angulo_harm4 = Double.parseDouble(txt_anghar4.getText());
			    ordem4 = Double.parseDouble(txt_ordemh4.getText());
			    amplitude_harm5 = Double.parseDouble(txt_amplharm5.getText());
				angulo_harm5 = Double.parseDouble(txt_anghar5.getText());
				ordem5 = Double.parseDouble(txt_ordemh5.getText());
				amplitude_harm6 = Double.parseDouble(txt_amplharm6.getText());
				angulo_harm6 = Double.parseDouble(txt_anghar6.getText());
				ordem6 = Double.parseDouble(txt_ordemh6.getText());
	           
			if( amplitude_harm1  < 0||  amplitude_harm2 < 0 || amplitude_harm3 < 0 ||amplitude_harm4 < 0 ||
			   amplitude_harm5 < 0  || amplitude_harm6 < 0 || amplitude_harm1  > 220||  amplitude_harm2 > 220 
			   || amplitude_harm3 > 220 ||amplitude_harm4 > 220 ||  amplitude_harm5 > 220  || amplitude_harm6 > 220 || angulo_harm1 < -180
			   || angulo_harm2 < -180 || angulo_harm3 < -180|| angulo_harm4 < -180|| angulo_harm5 < -180|| angulo_harm6 < -180
			   || angulo_harm1 > 180 || angulo_harm2 > 180|| angulo_harm3 > 180|| angulo_harm4 > 180|| angulo_harm5 > 180|| angulo_harm6 > 180
			   || ordem1 < 0 || ordem2 < 0 || ordem3 < 0|| ordem4 < 0 || ordem5 < 0 || ordem6 < 0|| ordem1 > 15|| ordem2 > 15
			   || ordem3 > 15|| ordem4 > 15|| ordem5 > 15|| ordem6 > 15){
			
				JOptionPane.showMessageDialog(null, "\t\tHARMONICOS\nAngulo, Amplitude ou Ordem Harmonicas inválida \n\n"
		            	+ "           LIMITES:\n 0 >= Amplitude <= 220 \n -180 >= Angulo <= 180 \n 0 >= ordem <= 15"); 
				
			}
			else {	
				
				List<Double> listahar1 = harmonico.FormaOnda(amplitude_harm1, angulo_harm1, ordem1);
				
				List<Double> listahar2 = harmonico.FormaOnda(amplitude_harm2, angulo_harm2, ordem2);
				
		
				GraphPanel graf_harm1 = new GraphPanel(listahar1);
				graf_harm1.setBounds(60, 90, 330, 90);
		        
				harm1.setVisible(false);
		        painel_harm.add(graf_harm1);
		        
		        graf_harm1.revalidate();
		        graf_harm1.repaint();
		       
		         
				GraphPanel graf_harm2 = new GraphPanel(listahar2);
				graf_harm2.setBounds(60, 240, 330, 90);
		        
				harm2.setVisible(false);
		        painel_harm.add(graf_harm2);
		        
		        graf_harm2.revalidate();
		        graf_harm2.repaint();
		       
		        List<Double> listahar3 = harmonico.FormaOnda(amplitude_harm3, angulo_harm3, ordem3);
	             
				GraphPanel graf_harm3 = new GraphPanel(listahar3);
				graf_harm3.setBounds(480, 90, 330, 90);
		        
				harm3.setVisible(false);
		        painel_harm.add(graf_harm3);
		        
		        graf_harm3.revalidate();
		        graf_harm3.repaint();
		        
		        List<Double> listahar4 = harmonico.FormaOnda(amplitude_harm4, angulo_harm4, ordem4);
	             
				GraphPanel graf_harm4 = new GraphPanel(listahar4);
				graf_harm4.setBounds(480, 240, 330, 90);
		        
				harm4.setVisible(false);
		        painel_harm.add(graf_harm4);
		        
		        graf_harm4.revalidate();
		        graf_harm4.repaint();
		        
		        List<Double> listahar5 = harmonico.FormaOnda(amplitude_harm5, angulo_harm5, ordem5);
	             
				GraphPanel graf_harm5 = new GraphPanel(listahar5);
				graf_harm5.setBounds(890, 90, 330, 90);
		        
				harm5.setVisible(false);
		        painel_harm.add(graf_harm5);
		        
		        graf_harm5.revalidate();
		        graf_harm5.repaint();
		        
		        List<Double> listahar6 = harmonico.FormaOnda(amplitude_harm6, angulo_harm6, ordem6);
	             
				GraphPanel graf_harm6 = new GraphPanel(listahar6);
				graf_harm6.setBounds(890, 240, 330, 90);
		        
				harm6.setVisible(false);
		        painel_harm.add(graf_harm6);
		        
		        graf_harm6.revalidate();
		        graf_harm6.repaint();
		        
		        List<Double> lista_resul = harmonico.FormaOndaResul(amplitude_ten, angulo_ten, amplitude_harm1, 
		        		angulo_harm1, ordem1,amplitude_harm2, angulo_harm2, ordem2, amplitude_harm3, angulo_harm3 , 
		        		ordem3, amplitude_harm4, angulo_harm4, ordem4, amplitude_harm5, angulo_harm5, ordem5, 
		        		amplitude_harm6, angulo_harm6, ordem6);
		        
		        GraphPanel graf_resul = new GraphPanel(lista_resul);
				graf_resul.setBounds(40, 570, 500, 100);
		        
				g_resul.setVisible(false);
		        painelUCIII.add(graf_resul);
		        
		        graf_resul.revalidate();
		        graf_resul.repaint();
		        
		        String serie_f;
		        serie_f = harmonico.serieFourier(amplitude_ten, angulo_ten, amplitude_harm1, 
		        		angulo_harm1, ordem1,amplitude_harm2, angulo_harm2, ordem2, amplitude_harm3, angulo_harm3 , 
		        		ordem3, amplitude_harm4, angulo_harm4, ordem4, amplitude_harm5, angulo_harm5, ordem5, 
		        		amplitude_harm6, angulo_harm6, ordem6);
		        
		        serie.setText(serie_f);
		        
			  }
			}
			
			JComboBox nume_har = (JComboBox) e.getSource();
			 Object select = nume_har.getSelectedItem();
		
		
			 if(select.toString().equals("0")) {
				
				txt_amplharm1.setEnabled(false);
				txt_anghar1.setEnabled(false);
				txt_ordemh1.setEnabled(false);
				txt_amplharm2.setEnabled(false);
				txt_anghar2.setEnabled(false);
				txt_ordemh2.setEnabled(false);
				txt_amplharm3.setEnabled(false);
				txt_anghar3.setEnabled(false);
				txt_ordemh3.setEnabled(false);
				txt_amplharm4.setEnabled(false);
				txt_anghar4.setEnabled(false);
				txt_ordemh4.setEnabled(false);
				txt_amplharm5.setEnabled(false);
				txt_anghar5.setEnabled(false);
				txt_ordemh5.setEnabled(false);
				txt_amplharm6.setEnabled(false);
				txt_anghar6.setEnabled(false);
				txt_ordemh6.setEnabled(false);
				
				txt_amplharm1.setText("0");
				txt_anghar1.setText("0");
				txt_ordemh1.setText("0");
				txt_amplharm2.setText("0");
				txt_anghar2.setText("0");
				txt_ordemh2.setText("0");
				txt_amplharm3.setText("0");
				txt_anghar3.setText("0");
				txt_ordemh3.setText("0");
				txt_amplharm4.setText("0");
				txt_anghar4.setText("0");
				txt_ordemh4.setText("0");
				txt_amplharm5.setText("0");
				txt_anghar5.setText("0");
				txt_ordemh5.setText("0");
				txt_amplharm6.setText("0");
				txt_anghar6.setText("0");
				txt_ordemh6.setText("0");
				
				
		} 
		 if(select.toString().equals("1")) {
			txt_amplharm1.setEnabled(true);
			txt_anghar1.setEnabled(true);
			txt_ordemh1.setEnabled(true);
			txt_amplharm2.setEnabled(false);
			txt_anghar2.setEnabled(false);
			txt_ordemh2.setEnabled(false);
			txt_amplharm3.setEnabled(false);
			txt_anghar3.setEnabled(false);
			txt_ordemh3.setEnabled(false);
			txt_amplharm4.setEnabled(false);
			txt_anghar4.setEnabled(false);
			txt_ordemh4.setEnabled(false);
			txt_amplharm5.setEnabled(false);
			txt_anghar5.setEnabled(false);
			txt_ordemh5.setEnabled(false);
			txt_amplharm6.setEnabled(false);
			txt_anghar6.setEnabled(false);
			txt_ordemh6.setEnabled(false);
			
			txt_amplharm2.setText("0");
			txt_anghar2.setText("0");
			txt_ordemh2.setText("0");
			txt_amplharm3.setText("0");
			txt_anghar3.setText("0");
			txt_ordemh3.setText("0");
			txt_amplharm4.setText("0");
			txt_anghar4.setText("0");
			txt_ordemh4.setText("0");
			txt_amplharm5.setText("0");
			txt_anghar5.setText("0");
			txt_ordemh5.setText("0");
			txt_amplharm6.setText("0");
			txt_anghar6.setText("0");
			txt_ordemh6.setText("0");
		
			
		}
		 if(select.toString().equals("2")) {
			txt_amplharm1.setEnabled(true);
			txt_anghar1.setEnabled(true);
			txt_ordemh1.setEnabled(true);
			txt_amplharm2.setEnabled(true);
			txt_anghar2.setEnabled(true);
			txt_ordemh2.setEnabled(true);
			txt_amplharm3.setEnabled(false);
			txt_anghar3.setEnabled(false);
			txt_ordemh3.setEnabled(false);
			txt_amplharm4.setEnabled(false);
			txt_anghar4.setEnabled(false);
			txt_ordemh4.setEnabled(false);
			txt_amplharm5.setEnabled(false);
			txt_anghar5.setEnabled(false);
			txt_ordemh5.setEnabled(false);
			txt_amplharm6.setEnabled(false);
			txt_anghar6.setEnabled(false);
			txt_ordemh6.setEnabled(false);
			
			txt_amplharm3.setText("0");
			txt_anghar3.setText("0");
			txt_ordemh3.setText("0");
			txt_amplharm4.setText("0");
			txt_anghar4.setText("0");
			txt_ordemh4.setText("0");
			txt_amplharm5.setText("0");
			txt_anghar5.setText("0");
			txt_ordemh5.setText("0");
			txt_amplharm6.setText("0");
			txt_anghar6.setText("0");
			txt_ordemh6.setText("0");
			
		}
		 if(select.toString().equals("3")) {
			txt_amplharm1.setEnabled(true);
			txt_anghar1.setEnabled(true);
			txt_ordemh1.setEnabled(true);
			txt_amplharm2.setEnabled(true);
			txt_anghar2.setEnabled(true);
			txt_ordemh2.setEnabled(true);
			txt_amplharm3.setEnabled(true);
			txt_anghar3.setEnabled(true);
			txt_ordemh3.setEnabled(true);
			txt_amplharm4.setEnabled(false);
			txt_anghar4.setEnabled(false);
			txt_ordemh4.setEnabled(false);
			txt_amplharm5.setEnabled(false);
			txt_anghar5.setEnabled(false);
			txt_ordemh5.setEnabled(false);
			txt_amplharm6.setEnabled(false);
			txt_anghar6.setEnabled(false);
			txt_ordemh6.setEnabled(false);
		
			txt_amplharm4.setText("0");
			txt_anghar4.setText("0");
			txt_ordemh4.setText("0");
			txt_amplharm5.setText("0");
			txt_anghar5.setText("0");
			txt_ordemh5.setText("0");
			txt_amplharm6.setText("0");
			txt_anghar6.setText("0");
			txt_ordemh6.setText("0");
		
		}
		 if(select.toString().equals("4")) {
			txt_amplharm1.setEnabled(true);
			txt_anghar1.setEnabled(true);
			txt_ordemh1.setEnabled(true);
			txt_amplharm2.setEnabled(true);
			txt_anghar2.setEnabled(true);
			txt_ordemh2.setEnabled(true);
			txt_amplharm3.setEnabled(true);
			txt_anghar3.setEnabled(true);
			txt_ordemh3.setEnabled(true);
			txt_amplharm4.setEnabled(true);
			txt_anghar4.setEnabled(true);
			txt_ordemh4.setEnabled(true);
			txt_amplharm5.setEnabled(false);
			txt_anghar5.setEnabled(false);
			txt_ordemh5.setEnabled(false);
			txt_amplharm6.setEnabled(false);
			txt_anghar6.setEnabled(false);
			txt_ordemh6.setEnabled(false);
			
			txt_amplharm5.setText("0");
			txt_anghar5.setText("0");
			txt_ordemh5.setText("0");
			txt_amplharm6.setText("0");
			txt_anghar6.setText("0");
			txt_ordemh6.setText("0");
			
		}
		 if(select.toString().equals("5")) {
			txt_amplharm1.setEnabled(true);
			txt_anghar1.setEnabled(true);
			txt_ordemh1.setEnabled(true);
			txt_amplharm2.setEnabled(true);
			txt_anghar2.setEnabled(true);
			txt_ordemh2.setEnabled(true);
			txt_amplharm3.setEnabled(true);
			txt_anghar3.setEnabled(true);
			txt_ordemh3.setEnabled(true);
			txt_amplharm4.setEnabled(true);
			txt_anghar4.setEnabled(true);
			txt_ordemh4.setEnabled(true);
			txt_amplharm5.setEnabled(true);
			txt_anghar5.setEnabled(true);
			txt_ordemh5.setEnabled(true);
			txt_amplharm6.setEnabled(false);
			txt_anghar6.setEnabled(false);
			txt_ordemh6.setEnabled(false);
		
			txt_amplharm6.setText("0");
			txt_anghar6.setText("0");
			txt_ordemh6.setText("0");
		
		}
		if(select.toString().equals("6")) {
			txt_amplharm1.setEnabled(true);
			txt_anghar1.setEnabled(true);
			txt_ordemh1.setEnabled(true);
			txt_amplharm2.setEnabled(true);
			txt_anghar2.setEnabled(true);
			txt_ordemh2.setEnabled(true);
			txt_amplharm3.setEnabled(true);
			txt_anghar3.setEnabled(true);
			txt_ordemh3.setEnabled(true);
			txt_amplharm4.setEnabled(true);
			txt_anghar4.setEnabled(true);
			txt_ordemh4.setEnabled(true);
			txt_amplharm5.setEnabled(true);
			txt_anghar5.setEnabled(true);
			txt_ordemh5.setEnabled(true);
			txt_amplharm6.setEnabled(true);
			txt_anghar6.setEnabled(true);
			txt_ordemh6.setEnabled(true);
		
		}
			
	 }		
}
