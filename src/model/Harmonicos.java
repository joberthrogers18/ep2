package model;

import java.util.ArrayList;
import java.util.List;

public class Harmonicos {
	private List<Double> lista = new ArrayList<>();
	
	
	public List<Double> FormaOnda(double amplitude, double angulo, double ordem) {
		
		for (float i = 0; i < 10; i = (float) (i + 0.4)) {
	           
			lista.add(amplitude * Math.cos(ordem*120*3.14*i + angulo));
        }
		return lista;
	}
	
	public List<Double> FormaOndaResul(double amplitude, double angulo,double amh1,double anh1,
			double ordem1,double amh2,double anh2, double ordem2,double amh3,double anh3,
			double ordem3,double amh4,double anh4, double ordem4,double amh5,double anh5,
			double ordem5,double amh6,double anh6, double ordem6) {
			
			List<Double> lista_resul = new ArrayList<>();
		
		for (float i = 0; i < 10; i = (float) (i + 0.4)) {
			
			lista_resul.add(amplitude * Math.cos(120*3.14*i + angulo) + amh1 * Math.cos(ordem1*120*3.14*i + anh1) + amh2 * Math.cos(ordem2*120*3.14*i + anh2)
			+ amh3 * Math.cos(ordem3*120*3.14*i + anh3) + amh4 * Math.cos(ordem4*120*3.14*i + anh4) + amh5 * Math.cos(ordem5*120*3.14*i + anh5)
			+amh6 * Math.cos(ordem6*120*3.14*i + anh6));
        }
		return lista_resul;
	}

}
