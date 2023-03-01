package ar.edu.unlam.pb2;

import java.util.Objects;

public class Paquete {
	
	private Double alto;
	private Double ancho;
	private Double profundidad;
	private Double volumen;
	private Double peso_en_kg;
	private String destino;
	
	public Paquete(Double alto, Double ancho, Double profundidad, String destino) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.destino = destino;
	}
	public Double getAlto() {
		return alto;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}
	public Double getVolumen() {
		return volumen;
	}
	
	public Double getPeso_en_kg() {
		return peso_en_kg;
	}
	
	
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alto, ancho, destino, peso_en_kg, profundidad, volumen);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquete other = (Paquete) obj;
		return Objects.equals(alto, other.alto) && Objects.equals(ancho, other.ancho)
				&& Objects.equals(destino, other.destino) && Objects.equals(peso_en_kg, other.peso_en_kg)
				&& Objects.equals(profundidad, other.profundidad) && Objects.equals(volumen, other.volumen);
	}
	public void calcularVolumen() { //alto y ancho y profundidad estan en cm
		this.volumen = ((getAlto() * getAncho() * getProfundidad()) / 100000); // cm3 a m3
		
	}
	public void calcularPeso() { //alto y ancho y profundidad estan en cm
		this.peso_en_kg =  (((getAlto() * getAncho() * getProfundidad()) * 3.52) / 1000);// gramos a kg
		
	}
	
	

}
