package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.UCII;
import view.UCIII;
import view.UCIV;

public class AcoeInterfacePrincipal  implements ActionListener{
	
	private JPanel painelInicial;
	private JFrame telaInicial;


	public AcoeInterfacePrincipal(JPanel painelInicial, JFrame telaInicial) {
		this.painelInicial=painelInicial;
		this.telaInicial=telaInicial;

	}

	public void actionPerformed(ActionEvent e){
			
	String comando = e.getActionCommand();
		
	if(comando.equals("simulacao1")){
			painelInicial.setVisible(false);
			try {
				new UCII(telaInicial);
				
			} catch (IOException e1) {
				System.out.println("Não foi possivel criar o frame\n");
			}
	   }
   
   else if(comando.equals("simulacao2")){
		painelInicial.setVisible(false);
		try {
			new UCIII(telaInicial);
			
		} catch (IOException e1) {
			System.out.println("Não foi possivel criar o frame\n");
		}
   }
   else if(comando.equals("simulacao3")){
		painelInicial.setVisible(false);
		try {
			new UCIV(telaInicial);
			
		} catch (IOException e1) {
			System.out.println("Não foi possivel criar o frame\n");
		}
  }
	
}


}