package model;

import java.util.ArrayList;
import java.util.List;

public class Harmonicos{
	FormaTensao tensao = new FormaTensao();
	
	
	public List<Double> FormaOnda(double amplitude, double angulo, double ordem) {
		 List<Double> lista = new ArrayList<>();
		
		for (float i = 0; i < 100; i = (float) (i + 0.4)) {
	           
			lista.add(amplitude * Math.cos(ordem*120*3.14*i + angulo));
        }
		return lista;
	}
	
	public List<Double> potenciaInstharm(double amplitude_ten, double angulo_ten,double amplitude_cor, double angulo_cor, double ordem) {
		List<Double> listacorrete = tensao.formaGrafico(amplitude_ten, angulo_ten);
		List<Double> lista = new ArrayList<>();
		int j = 0;
				
		for (float i = 0; i < 100; i = (float) (i + 0.4)) {
	          
			lista.add(listacorrete.get(j)*amplitude_cor * Math.cos(ordem*120*3.14*i + angulo_cor));
			j++;
		}
		return lista;
	}
	
	public List<Double> FormaOndaResul(double amplitude, double angulo,double amh1,double anh1,
			double ordem1,double amh2,double anh2, double ordem2,double amh3,double anh3,
			double ordem3,double amh4,double anh4, double ordem4,double amh5,double anh5,
			double ordem5,double amh6,double anh6, double ordem6) {
			
			List<Double> lista_resul = new ArrayList<>();
		
		for (float i = 0; i < 100; i = (float) (i + 0.4)) {
			
			lista_resul.add(amplitude * Math.cos(120*3.14*i + angulo) + amh1 * Math.cos(ordem1*120*3.14*i + anh1) + amh2 * Math.cos(ordem2*120*3.14*i + anh2)
			+ amh3 * Math.cos(ordem3*120*3.14*i + anh3) + amh4 * Math.cos(ordem4*120*3.14*i + anh4) + amh5 * Math.cos(ordem5*120*3.14*i + anh5)
			+amh6 * Math.cos(ordem6*120*3.14*i + anh6));
        }
		return lista_resul;
	}
	
	public String serieFourier(double amplitude, double angulo,double amh1,double anh1,
			double ordem1,double amh2,double anh2, double ordem2,double amh3,double anh3,
			double ordem3,double amh4,double anh4, double ordem4,double amh5,double anh5,
			double ordem5,double amh6,double anh6, double ordem6) {
			
		String serie = "";
		
		if(amplitude != 0) {
			serie += "f(t)="+(int)amplitude+"cos(ωt + "+(int)angulo+"º)";
		}
		if(amh1 != 0) {
			serie += "+"+(int)amh1+"cos("+(int)ordem1+"ωt + "+(int)anh1+"º)";
		}
		if(amh2 != 0) {
			serie += "+"+(int)amh2+"cos("+(int)ordem2+"ωt + "+(int)anh2+"º)\n";
		}
		if(amh3 != 0) {
			serie += "+"+(int)amh3+"cos("+(int)ordem3+"ωt + "+(int)anh3+"º)";
		}
		if(amh4 != 0) {
			serie += "+"+(int)amh4+"cos("+(int)ordem4+"ωt + "+(int)anh4+"º)";
		}
		if(amh5 != 0) {
			serie += "+"+(int)amh5+"cos("+(int)ordem5+"ωt + "+(int)anh5+"º)\n";
		}
		if(amh6 != 0) {
			serie += "+"+(int)amh6+"cos("+(int)ordem6+"ωt + "+(int)anh6+"º)";
		}
		return serie;
		
	}

	public double tPF(double potencial, double potenciad) {
		double fator;
		
		fator = potencial/potenciad;
		
		return fator;
	}

}
