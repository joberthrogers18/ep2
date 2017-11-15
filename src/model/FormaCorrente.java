package model;


import java.util.ArrayList;
import java.util.List;

public class FormaCorrente extends Calculos {
	private static float fre_angular = (float) (3.14*2*60);
	
	
	public  List<Double> formaGrafico(double corrente, double angulo_corrente){
		List<Double> lista = new ArrayList<>();
		
		setAmplitude(corrente);
		setAngulo(angulo_corrente);
		
		
		for (float i = -100; i < 100; i = (float) (i + 0.4)) {
           
			lista.add(getAmplitude()*(Math.cos(fre_angular*i + getAngulo())));
        }
		return lista;
		
	}
	
	
}
