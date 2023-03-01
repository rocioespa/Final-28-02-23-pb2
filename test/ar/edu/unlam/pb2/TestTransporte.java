package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTransporte {

	@Test
	public void testQueUnaBicicletaPuedaLlevarUnPaquete() {
		Empresa e = new Empresa();
		Bicicleta b = new Bicicleta("JJS45");
		Paquete p = new Paquete(5.0, 1.0, 2.0, "Castelar");
		e.agregarTransporte(b);
		e.agregarPaqueteParaTransportar(p);
		p.calcularVolumen();
		p.calcularPeso();
		assertTrue(e.enviarPaqueteATransporte(b, p));
		assertEquals((Double) 0.0001, b.getVol_actual());
		assertEquals((Double) 0.0352, b.getPeso_actual());
		
		assertEquals(1, b.getDestino().size());
	}

	@Test
	public void testQueUnCamionPuedaLlevarDosPaquete() {
		Empresa e = new Empresa();
		Camion a = new Camion("JJS45");
		Paquete p = new Paquete(50.0, 15.0, 60.0, "Castelar");
		Paquete p1 = new Paquete(80.0, 40.0, 20.0, "Ituzaingo");
		
		e.agregarTransporte(a);
		e.agregarPaqueteParaTransportar(p);
		e.agregarPaqueteParaTransportar(p1);
		p.calcularVolumen();
		p.calcularPeso();
		p1.calcularVolumen();
		p1.calcularPeso();

		assertTrue(e.enviarPaqueteATransporte(a, p));
		assertTrue(e.enviarPaqueteATransporte(a, p1));

		assertEquals((Double) 383.68, a.getPeso_actual());
		assertEquals((Double) 1.09, a.getVol_actual());

		assertEquals(2, a.getDestino().size());

	}

	@Test
	public void testQueUnAutoMovilPuedaLlevarTresPaquete() {
		Empresa e = new Empresa();
		Automovil a = new Automovil("JJS45");
		Paquete p = new Paquete(20.0, 10.0, 5.0, "Castelar");
		Paquete p1 = new Paquete(40.0, 20.0, 10.0, "Ituzaingo");
		Paquete p3 = new Paquete(50.0, 15.0, 60.0, "San Justo");
		
		e.agregarTransporte(a);
		e.agregarPaqueteParaTransportar(p);
		e.agregarPaqueteParaTransportar(p1);
		e.agregarPaqueteParaTransportar(p3);
		
		p.calcularVolumen();
		p.calcularPeso();
		p1.calcularVolumen();
		p1.calcularPeso();
		p3.calcularVolumen();
		p3.calcularPeso();
		assertTrue(e.enviarPaqueteATransporte(a, p));
		assertTrue(e.enviarPaqueteATransporte(a, p1));
		assertTrue(e.enviarPaqueteATransporte(a, p3));
		
		assertEquals((Double) 190.08, a.getPeso_actual());
		assertEquals((Double) 0.54, a.getVol_actual());

		assertEquals(3, a.getDestino().size());

	}

}
