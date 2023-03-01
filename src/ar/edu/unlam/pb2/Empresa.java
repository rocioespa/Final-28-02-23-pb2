package ar.edu.unlam.pb2;

import java.util.*;

public class Empresa {
	
	private List<Transporte> listaTransporte;
	private List<Paquete> listaPaquetes;
	public Empresa() {
		super();
		this.listaPaquetes = new ArrayList<>();
		this.listaTransporte = new ArrayList<>();
	}
	public List<Transporte> getListaTransporte() {
		return listaTransporte;
	}
	public void setListaTransporte(List<Transporte> listaTransporte) {
		this.listaTransporte = listaTransporte;
	}
	public List<Paquete> getListaPaquetes() {
		return listaPaquetes;
	}
	public void setListaPaquetes(List<Paquete> listaPaquetes) {
		this.listaPaquetes = listaPaquetes;
	}
	public void agregarTransporte(Transporte t) {
		if(!getListaTransporte().contains(t)) this.listaTransporte.add(t);
		
	}
	public void agregarPaqueteParaTransportar(Paquete p) {
		if(!getListaPaquetes().contains(p)) this.listaPaquetes.add(p);
		
	}
	public boolean enviarPaqueteATransporte(Transporte t, Paquete p) {
		if(this.listaTransporte.contains(t) && this.listaPaquetes.contains(p)) {
			if(t.habilitadoATransportar(p)) {
				return true;
			}
		}
		return false;
		
	}
	

}
