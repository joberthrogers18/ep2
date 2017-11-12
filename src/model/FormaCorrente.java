package model;


import java.util.ArrayList;
import java.util.List;

public class FormaCorrente extends Calculos {
	private double corrente;
	private static float fre_angular = (float) (3.14*2*60);
	private double ang_corrente;
	private List<Double> lista = new ArrayList<>();
	
	public FormaCorrente() {
		this.corrente = 0;
		this.ang_corrente = -180;
	}
	
	
	public  List<Double> formaGrafico(double corrente, double angulo_corrente){
		
		setLista(lista);
		
		setAmplitude(corrente);
		setAngulo(angulo_corrente);
		
		for (float i = -100; i < 100; i = (float) (i + 0.4)) {
           
			getLista().add(getAmplitude()*(Math.cos(fre_angular*i + getAngulo())));
        }
		return getLista();
		
	}
	
	
}
