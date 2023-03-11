package ar.edu.unlam.pb2;

import java.util.*;

public class Empresa {
	
	private List<Transporte> listaTransporte;
	
	public Empresa() {
		super();
		
		this.listaTransporte = new ArrayList<>();
	}
	public List<Transporte> getListaTransporte() {
		return listaTransporte;
	}
	public void setListaTransporte(List<Transporte> listaTransporte) {
		this.listaTransporte = listaTransporte;
	}

	public void agregarTransporte(Transporte t) {
		if(!getListaTransporte().contains(t)) this.listaTransporte.add(t);
		
	}
	
	public boolean enviarPaqueteATransporte(Transporte t, Paquete p) {
		if(this.listaTransporte.contains(t)) {
			if(t.habilitadoATransportar(p)) {
				return true;
			}
			return false;
		}
		return false;
		
	}
	

}
