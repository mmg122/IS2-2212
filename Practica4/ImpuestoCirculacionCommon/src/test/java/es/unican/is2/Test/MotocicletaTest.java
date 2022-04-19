package es.unican.is2.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import es.unican.is2.Clases.Motocicleta;
import es.unican.is2.Excepciones.OperacionNoValida;

class MotocicletaTest {

	@Test
	public void constructorMotocicletaTest() {
		Motocicleta m;
		
		// Casos válidos
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(2020, 1, 1), 100);
			assertTrue(m.precioImpuesto() == 8.84);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(2020, 1, 1), 200);
			assertTrue(m.precioImpuesto() == 15.14);
		} catch (OperacionNoValida e) {
			fail("Caso 2: No debería lanzar la excepción");
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(2020, 1, 1), 400);
			assertTrue(m.precioImpuesto() == 30.3);
		} catch (OperacionNoValida e) {
			fail("Caso 3: No debería lanzar la excepción");
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(2020, 1, 1), 800);
			assertTrue(m.precioImpuesto() == 60.58);
		} catch (OperacionNoValida e) {
			fail("Caso 4: No debería lanzar la excepción");
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(2020, 1, 1), 1200);
			assertTrue(m.precioImpuesto() == 121.16);
		} catch (OperacionNoValida e) {
			fail("Caso 5: No debería lanzar la excepción");
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(1990, 1, 1), 100);
			assertTrue(m.precioImpuesto() == 0);
		} catch (OperacionNoValida e) {
			fail("Caso 11: No debería lanzar la excepción");
		}
		
		// Casos no válidos
		
		try {
			m = new Motocicleta(null, LocalDate.of(1990, 1, 1), 100);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			m = new Motocicleta("1111AA", null, 100);
			fail("Caso 13: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.now(), 100);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			m = new Motocicleta(null, LocalDate.now().plusMonths(5), 100);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(1990, 1, 1), -5);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
		
		try {
			m = new Motocicleta("1111AA", LocalDate.of(1990, 1, 1), 0);
			fail("Caso 12: Debería lanzar la excepción");
		} catch (OperacionNoValida e) {
		}
			
		
	}
}
