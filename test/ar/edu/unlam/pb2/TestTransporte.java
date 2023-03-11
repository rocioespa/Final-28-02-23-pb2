package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTransporte {

	@Test
	public void testQueUnaBicicletaPuedaLlevarUnPaquete() {
		Empresa e = new Empresa();
		Bicicleta b = new Bicicleta("JJS45","Castelar");
		Paquete p = new Paquete(5.0, 1.0, 2.0, "Castelar");
		e.agregarTransporte(b);
		
		p.calcularVolumen();
		p.calcularPeso();
		
		assertTrue(e.enviarPaqueteATransporte(b, p));
		assertEquals((Double) 0.0001, b.getVol_actual());
		assertEquals((Double) 0.0352, b.getPeso_actual());
		
		
	}
	
	@Test
	public void testQueUnaBicicletaPuedaLlevarUnPaqueteConDestinoNulo() {
		Empresa e = new Empresa();
		Bicicleta b = new Bicicleta("JJS45",null);
		Paquete p = new Paquete(5.0, 1.0, 2.0, "Castelar");
		e.agregarTransporte(b);
		
		p.calcularVolumen();
		p.calcularPeso();
		
		assertTrue(e.enviarPaqueteATransporte(b, p));
		assertEquals((Double) 0.0001, b.getVol_actual());
		assertEquals((Double) 0.0352, b.getPeso_actual());
		assertEquals("Castelar",b.getCuidad());
		
	}
	
	@Test
	public void testQueUnaBicicletaNoPuedaLlevarMasDeDosPaquetes() {
		Empresa e = new Empresa();
		Bicicleta b = new Bicicleta("JJS45",null);
		Paquete p = new Paquete(5.0, 1.0, 2.0, "Castelar");
		Paquete p2 = new Paquete(3.0, 1.0, 1.0, "Castelar");
		Paquete p1 = new Paquete(5.0, 2.0, 1.0, "Ituzaingo");
		e.agregarTransporte(b);
		
		p.calcularVolumen();
		p.calcularPeso();
		
		p2.calcularVolumen();
		p2.calcularPeso();;
		
		assertTrue(e.enviarPaqueteATransporte(b, p));
		assertTrue(e.enviarPaqueteATransporte(b, p2));
		assertFalse(e.enviarPaqueteATransporte(b, p1));
		assertEquals(2,b.getPaquetesTransportados().size());
		
	}
	
	@Test
	public void testQueUnaBicicletaNoPuedaLlevarUnPaquetePorPasarElLimiteDePeso() {
		Empresa e = new Empresa();
		Bicicleta b = new Bicicleta("JJS45","Castelar");
		Paquete p = new Paquete(800.0, 400.0, 200.0, "Castelar");
		e.agregarTransporte(b);
		
		p.calcularVolumen();
		p.calcularPeso();
		
		assertFalse(e.enviarPaqueteATransporte(b, p));
		
		
		
	}

	@Test
	public void testQueUnCamionNoPuedaLlevarDosPaquetesPorSuLimiteDePeso() {
		Empresa e = new Empresa();
		Camion a = new Camion("JJS45");
		Paquete p = new Paquete(50.0, 15.0, 60.0, "Castelar");
		Paquete p1 = new Paquete(800.0, 400.0, 200.0, "Ituzaingo");
		
		e.agregarTransporte(a);
		
		p.calcularVolumen();
		p.calcularPeso();
		p1.calcularVolumen();
		p1.calcularPeso();

		assertTrue(e.enviarPaqueteATransporte(a, p));
		assertFalse(e.enviarPaqueteATransporte(a, p1));

		assertEquals(1, a.getDestino().size());
		assertEquals(1,a.getPaquetesTransportados().size());
	}

	@Test
	public void testQueUnAutoMovilPuedaLlevarTresPaqueteDeDiferentesCuidades() {
		Empresa e = new Empresa();
		Automovil a = new Automovil("JJS45");
		Paquete p = new Paquete(20.0, 10.0, 5.0, "Castelar");
		Paquete p1 = new Paquete(40.0, 20.0, 10.0, "Ituzaingo");
		Paquete p3 = new Paquete(50.0, 15.0, 60.0, "San Justo");
		
		e.agregarTransporte(a);
		
		
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
		assertEquals(3,a.getPaquetesTransportados().size());

	}
	
	@Test
	public void testQueUnAutoMovilNoPuedaLlevarTresPaqueteDeCuidadesIguales() {
		Empresa e = new Empresa();
		Automovil a = new Automovil("JJS45");
		Paquete p = new Paquete(20.0, 10.0, 5.0, "Castelar");
		Paquete p1 = new Paquete(40.0, 20.0, 10.0, "Castelar");
		Paquete p3 = new Paquete(50.0, 15.0, 60.0, "San Justo");
		
		e.agregarTransporte(a);
		
		
		p.calcularVolumen();
		p.calcularPeso();
		p1.calcularVolumen();
		p1.calcularPeso();
		p3.calcularVolumen();
		p3.calcularPeso();
		assertTrue(e.enviarPaqueteATransporte(a, p));
		assertFalse(e.enviarPaqueteATransporte(a, p1));
		assertTrue(e.enviarPaqueteATransporte(a, p3));
		
		
		assertEquals(2, a.getDestino().size());
		assertEquals(2,a.getPaquetesTransportados().size());

	}
	
	@Test
	public void testQueUnAutoMovilNoPuedaLlevarTresPaquetePorLimiteDePeso() {
		Empresa e = new Empresa();
		Automovil a = new Automovil("JJS45");
		Paquete p = new Paquete(20.0, 10.0, 5.0, "Castelar");
		Paquete p1 = new Paquete(400.0, 200.0, 100.0, "Ituzaingo");
		Paquete p3 = new Paquete(500.0, 150.0, 600.0, "San Justo");
		
		e.agregarTransporte(a);
		
		
		p.calcularVolumen();
		p.calcularPeso();
		p1.calcularVolumen();
		p1.calcularPeso();
		p3.calcularVolumen();
		p3.calcularPeso();
		assertTrue(e.enviarPaqueteATransporte(a, p));
		assertFalse(e.enviarPaqueteATransporte(a, p1));
		assertFalse(e.enviarPaqueteATransporte(a, p3));
		
		
		

	}

}
