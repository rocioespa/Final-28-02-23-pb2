package ar.edu.unlam.pb2;

public class Automovil extends Transporte {

	private final static Integer LIMITE_DESTINOS = 3;

	public Automovil(String patente) {
		super(patente);
		this.peso_max = 500.0;
		this.volumen_max = 2.0;

	}

	@Override
	public boolean habilitadoATransportar(Paquete p) {
		this.peso_actual += p.getPeso_en_kg();
		this.vol_actual += p.getVolumen();
		if (getPeso_actual() < getPeso_max() && getVol_actual() < getVolumen_max()) {
			if ((!this.destino.contains(p.getDestino())) && this.destino.size() < LIMITE_DESTINOS) {
				this.destino.add(p.getDestino());
				
				this.paquetesTransportados.add(p);
				return true;

			}
			return false;

		}
		return false;
	}

}