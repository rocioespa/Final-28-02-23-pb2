package ar.edu.unlam.pb2;

import java.util.*;

public class Bicicleta extends Transporte {
	
	
	private String cuidad;

	public Bicicleta(String patente, String cuidad) {
		super(patente);
		this.peso_max = 15.0;
		this.volumen_max = 0.125;
		this.cuidad = cuidad;
		
	}
	
	

	public String getCuidad() {
		return cuidad;
	}



	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}



	
	@Override
	public boolean habilitadoATransportar(Paquete p) {
		ingresarDestino(p);
		if(this.cuidad.equals(p.getDestino()) && this.paquetesTransportados.size()<2) {
			this.peso_actual += p.getPeso_en_kg();
			this.vol_actual += p.getVolumen();
		if(getPeso_actual() < getPeso_max() && getVol_actual() < getVolumen_max())  {
			
			this.paquetesTransportados.add(p);
			return true;
		
		}
		return false;
		}
		return false;
	}
	

	private void ingresarDestino (Paquete p) {
		if(getCuidad()==null) {
			setCuidad(p.getDestino());
			
		}else {
			setCuidad(cuidad);
		}
		
	}

	

	

}
