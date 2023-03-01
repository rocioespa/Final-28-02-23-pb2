package ar.edu.unlam.pb2;

public class Camion extends Transporte {
	
	

	public Camion(String patente) {
		super(patente);
		this.peso_max = 16000.0;
		this.volumen_max = 20.0;
	}
	
	@Override
	public boolean habilitadoATransportar(Paquete p) {
	
			if(getPeso_actual()<getPeso_max() && getVol_actual()<getVolumen_max()) {
				this.peso_actual+=p.getPeso_en_kg();
				this.vol_actual+=p.getVolumen();
				this.destino.add(p.getDestino());
				return true;
			
		}
		
		return false;
	}



	

}
