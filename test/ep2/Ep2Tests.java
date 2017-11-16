package ep2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.FormaCorrente;
import model.FormaTensao;
import model.Potencias;

class Ep2Tests {
	private double amplitude_tensao;
	private double angulo_tensao;
	private double amplitude_corrente;
	private double angulo_corrente;
	Potencias potencia = new Potencias();
	private int poten_ativa;
	
	
	@BeforeEach
	public void beforeTests(){
		// Preparação
		amplitude_tensao = 220.0;
		angulo_corrente = 0.0;
		amplitude_corrente = 39.0;
		angulo_corrente = 35.0;
		
		
	}
	
	@Test
	void testpotencias() {
		assertEquals(7028.32454,potencia.Pativa(amplitude_tensao, amplitude_corrente, angulo_tensao, angulo_corrente),10e-5);
		assertEquals(8580,potencia.Paparente(amplitude_tensao, amplitude_corrente),10e-5);
		assertEquals(-4921.28582, potencia.Preativa(amplitude_tensao, amplitude_corrente, angulo_tensao, angulo_corrente),10e-5);
	}

}
