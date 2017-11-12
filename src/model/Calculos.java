package model;

import java.util.ArrayList;
import java.util.List;


public class Calculos implements Calcular{
	private double angulo;
	private double amplitude;
	private List<Double> lista = new ArrayList<>();
	

	public double getAngulo() {
		return angulo;
	}
	
	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}


	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}

	public List<Double> getLista() {
		return lista;
	}


	public void setLista(List<Double> lista) {
		this.lista = lista;
	}


	@Override
	public List<Double> formaGrafico(double amplitude, double angulo){
		
		lista.add(null);
		
		return lista;
		
	}

}
