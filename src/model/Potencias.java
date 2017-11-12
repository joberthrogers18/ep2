package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Potencias{
	private FormaTensao tensao;
	private FormaCorrente corrente;
	
	public List<Double> calculaValor(List<Double> l, List<Double> lval){	  	   	
		List<Double> lTotalCC = new ArrayList<Double>();
		
		for(int i =0;i<l.size();i++){	   	
			lTotalCC.add( l.get(i) + lval.get(i));
		}	   	
		return lTotalCC;	   
	} 
	
	public double Pativa(double amplitude_tensao, double amplitude_corrente, double angulo_tensao, double angulo_corrente){
        double calcPativa;
        calcPativa = amplitude_tensao*amplitude_corrente*Math.cos(Math.toRadians(angulo_tensao-angulo_corrente));
     return calcPativa;
    }
	
	public double Preativa(double amplitude_tensao, double amplitude_corrente, double angulo_tensao, double angulo_corrente){
        double calcPreativa;
        calcPreativa = amplitude_tensao*amplitude_corrente*Math.sin(Math.toRadians(angulo_tensao-angulo_corrente));
     return calcPreativa;
    }
	
	public double Paparente(double amplitude_tensao, double amplitude_corrente){
        double calcPaparente;
        calcPaparente = amplitude_tensao*amplitude_corrente;
     return calcPaparente;
    }
	
	public static double arredondar(double valor, int escala) {
	    BigDecimal bd1 = new BigDecimal(valor);
	    BigDecimal bd2 = bd1.setScale(escala, BigDecimal.ROUND_HALF_UP);
	    return bd2.doubleValue();
	}
	
	public double FatorPotencia( double angulo_tensao, double angulo_corrente){
        double calcFatorPo;
        
        calcFatorPo = arredondar(Math.cos(Math.toRadians(angulo_tensao-angulo_corrente)),2);
        
     return calcFatorPo;
    }

	public  List<Double>  FormaOndaPotenciaIns(double amplitude_tensao, double angulo_tensao,double amplitude_corrente, double angulo_corrente){
		List<Double> lista = new ArrayList<>();
		
		for (float i = -100; i < 100; i = (float) (i + 0.4)) {
	        
			lista.add(amplitude_tensao*(Math.cos(120*3.14*i + angulo_tensao)) * amplitude_corrente*(Math.cos(120*3.14*i + angulo_corrente)));
			
			//lista.add(amplitude_tensao*Math.toDegrees(Math.cos(120*3.14*i + angulo_tensao)) + amplitude_corrente*Math.toDegrees(Math.cos(120*3.14*i + angulo_corrente)));
			//lista.add(amplitude_corrente*Math.toDegrees(Math.cos(120*3.14*i + angulo_corrente)));
		}
		
		return lista;
		
	}

	/*public List<Double> formaGrafico(double amplitude_ten, double angulo_ten,double amplitude_cor, double angulo_cor) {
		List<Double> lista = new ArrayList<>();
		
		corrente.setAmplitude(amplitude_cor);

		tensao.setAmplitude(amplitude_ten);

		corrente.setAngulo(angulo_cor);

		tensao.setAngulo(angulo_cor);
		
		
		for (float i = -100; i < 100; i = (float) (i + 0.4)) {
	          
			//lista.add(tensao.getAmplitude()*Math.cos(120*3.14*i + tensao.getAngulo()) + corrente.getAmplitude()*Math.cos(120*3.14*i + corrente.getAngulo()));
			lista.add(amplitude_ten*Math.toDegrees(Math.cos(120*3.14*i + angulo_ten)) + amplitude_cor*Math.toDegrees(Math.cos(120*3.14*i + angulo_cor)));
			//lista.add(amplitude_corrente*Math.toDegrees(Math.cos(120*3.14*i + angulo_corrente)));
		}
		
		return lista;
	}*/
	
}
