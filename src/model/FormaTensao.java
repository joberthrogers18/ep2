package model;

import java.util.ArrayList;
import java.util.List;

public class FormaTensao extends Calculos{
	private double voltagem;
	private static float fre_angular = (float) (3.14*2*60);
	private double ang_fase;

	public FormaTensao() {
		this.voltagem = 0;
		this.ang_fase = -180;
	}
	
	public  List<Double>  formaGrafico(double voltagem, double angulo){
		List<Double> lista = new ArrayList<>();
		
		setAmplitude(voltagem);
		setAngulo(angulo);
		
		for (float i = 0; i < 100; i = (float) (i + 0.4)) {
           
			lista.add(getAmplitude()*(Math.cos(fre_angular*i + getAngulo())));
        }
		return lista;
		
	}
	
	
}
