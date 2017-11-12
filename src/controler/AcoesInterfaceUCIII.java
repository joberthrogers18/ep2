package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	
	
	 public AcoesInterfaceUCIII( JPanel painelUCIII,JFrame tPrincipal,JComboBox num_harm, JTextField txt_amplharm1,
			 JTextField txt_angharm1, JTextField txt_ordemh1, JTextField txt_amplharm2,
			 JTextField txt_angharm2, JTextField txt_ordemh2, JTextField txt_amplharm3,
			 JTextField txt_angharm3, JTextField txt_ordemh3, JTextField txt_amplharm4,
			 JTextField txt_angharm4, JTextField txt_ordemh4, JTextField txt_amplharm5,
			 JTextField txt_angharm5, JTextField txt_ordemh5, JTextField txt_amplharm6,
			 JTextField txt_angharm6, JTextField txt_ordemh6,JTextField txt_amplfund,
			 JTextField txt_anglfund, GraphPanel graf_fund, JPanel painel_harm,GraphPanel
			 harm1,GraphPanel harm2,GraphPanel harm3,GraphPanel harm4,GraphPanel harm5,GraphPanel
			 harm6, GraphPanel g_resul) {
		 
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
	            
				 List<Double> lista = tensao.formaGrafico(amplitude_ten, angulo_ten);
	             
				GraphPanel grafico_tensao = new GraphPanel(lista);
				grafico_tensao.setBounds(40, 70, 500, 100);
		        
				graf_fund.setVisible(false);
		        painelUCIII.add(grafico_tensao);
		        
		        grafico_tensao.revalidate();
		        grafico_tensao.repaint();
		        
							
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
	            
				List<Double> listahar1 = new ArrayList<>();
				List<Double> listahar2 = new ArrayList<>();
				List<Double> listahar3 = new ArrayList<>();
				List<Double> listahar4 = new ArrayList<>();				
				List<Double> listahar5 = new ArrayList<>();
				List<Double> listahar6 = new ArrayList<>();
				//List<Double> listahar1 = harmonico.FormaOnda(amplitude_harm1, angulo_harm1, ordem1);
				
				//List<Double> listahar2 = harmonico.FormaOnda2(amplitude_harm2, angulo_harm2, ordem2);
				for (float i = 0; i < 100; i = (float) (i + 0.4)) {
			           
					listahar1.add(amplitude_harm1 * Math.cos(ordem1*120*3.14*i + angulo_harm1));
					listahar2.add(amplitude_harm2 * Math.cos(ordem2*120*3.14*i + angulo_harm2));
					listahar3.add(amplitude_harm3 * Math.cos(ordem3*120*3.14*i + angulo_harm3));
					listahar4.add(amplitude_harm4 * Math.cos(ordem4*120*3.14*i + angulo_harm4));
					listahar5.add(amplitude_harm5 * Math.cos(ordem5*120*3.14*i + angulo_harm5));
					listahar6.add(amplitude_harm6 * Math.cos(ordem6*120*3.14*i + angulo_harm6));
		        }
		
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
		       
		        //List<Double> listahar3 = harmonico.FormaOnda3(amplitude_harm3, angulo_harm3, ordem3);
	             
				GraphPanel graf_harm3 = new GraphPanel(listahar3);
				graf_harm3.setBounds(480, 90, 330, 90);
		        
				harm3.setVisible(false);
		        painel_harm.add(graf_harm3);
		        
		        graf_harm3.revalidate();
		        graf_harm3.repaint();
		        
		        //List<Double> listahar4 = harmonico.FormaOnda4(amplitude_harm4, angulo_harm4, ordem4);
	             
				GraphPanel graf_harm4 = new GraphPanel(listahar4);
				graf_harm4.setBounds(480, 240, 330, 90);
		        
				harm4.setVisible(false);
		        painel_harm.add(graf_harm4);
		        
		        graf_harm4.revalidate();
		        graf_harm4.repaint();
		        
		        //List<Double> listahar5 = harmonico.FormaOnda5(amplitude_harm5, angulo_harm5, ordem5);
	             
				GraphPanel graf_harm5 = new GraphPanel(listahar5);
				graf_harm5.setBounds(890, 90, 330, 90);
		        
				harm5.setVisible(false);
		        painel_harm.add(graf_harm5);
		        
		        graf_harm5.revalidate();
		        graf_harm5.repaint();
		        
		        //List<Double> listahar6 = harmonico.FormaOnda6(amplitude_harm6, angulo_harm6, ordem6);
	             
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
