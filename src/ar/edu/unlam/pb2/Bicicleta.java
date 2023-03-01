package ar.edu.unlam.pb2;

import java.util.*;

public class Bicicleta extends Transporte {
	
	private final static Integer LIMITE_DESTINOS = 2;

	public Bicicleta(String patente) {
		super(patente);
		this.peso_max = 15.0;
		this.volumen_max = 0.125;
		
	}

	@Override
	public boolean habilitadoATransportar(Paquete p) {
		if(getPeso_actual()<getPeso_max() && getVol_actual()<getVolumen_max())  {
			if(this.destino.size()<LIMITE_DESTINOS) {
				this.peso_actual=p.getPeso_en_kg();
				this.vol_actual=p.getVolumen();
			this.destino.add(p.getDestino());
			return true;
		}
		}
		return false;
	}

	

	

}
