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
	

}
