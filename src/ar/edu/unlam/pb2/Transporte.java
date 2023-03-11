package ar.edu.unlam.pb2;

import java.util.*;
import java.util.Objects;

public abstract class Transporte {
	
	private String patente;
	protected Double peso_max;
	protected Double volumen_max;
	protected Set<String> destino;
	protected Set<Paquete> paquetesTransportados;
	protected Double peso_actual;
	protected Double vol_actual;
	
	public Transporte(String patente) {
		super();
		this.patente = patente;
		this.destino = new HashSet<>();
		this.paquetesTransportados = new HashSet<>();
		this.peso_actual = 0.0;
		this.vol_actual = 0.0;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Double getPeso_max() {
		return peso_max;
	}
	public void setPeso_max(Double peso_max) {
		this.peso_max = peso_max;
	}
	public Double getVolumen_max() {
		return volumen_max;
	}
	public void setVolumen_max(Double volumen_max) {
		this.volumen_max = volumen_max;
	}
	
	public abstract boolean habilitadoATransportar(Paquete p);
	
	
	public Double getPeso_actual() {
		return peso_actual;
	}
	public void setPeso_actual(Double peso_actual) {
		this.peso_actual = peso_actual;
	}
	public Double getVol_actual() {
		return vol_actual;
	}
	public void setVol_actual(Double vol_actual) {
		this.vol_actual = vol_actual;
	}
	public Set<String> getDestino() {
		return destino;
	}
	public void setDestino(Set<String> destino) {
		this.destino = destino;
	}
	
	
	
	public Set<Paquete> getPaquetesTransportados() {
		return paquetesTransportados;
	}
	public void setPaquetesTransportados(Set<Paquete> paquetesTransportados) {
		this.paquetesTransportados = paquetesTransportados;
	}
	@Override
	public int hashCode() {
		return Objects.hash(patente, peso_max, volumen_max);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
		return Objects.equals(patente, other.patente) && Objects.equals(peso_max, other.peso_max)
				&& Objects.equals(volumen_max, other.volumen_max);
	}

	
	

}
