package es.unican.is2.listaOrdenadaAcotadaTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

public class listaOrdenadaAcotadaTest<E extends Comparable<E>> {
	

	@Test
	public void getListaOrdenadaAcotadaTest() {
		ListaOrdenadaAcotada<Integer> l = new ListaOrdenadaAcotada();
		Integer i;
		//test constructor
		//Casos válidos
		try {
			//lista no vacía
			Integer i1 = 5;
			l.add(i1);
			i = l.get(l.size()-1);
			assertTrue(i == 5);
		} catch (IndexOutOfBoundsException e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		//Casos no válidos
		try {
			//lista vacía
			l.clear();
			i = l.get(0);
			fail("Caso 2: Debería lanzar la excepción");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			i = l.get(20);
			fail("Caso 3: Debería lanzar la excepción");
		} catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	@Test
	public void addListaOrdenadaAcotadaTest() {
		ListaOrdenadaAcotada<Integer> l = new ListaOrdenadaAcotada();
		//Casos válidos
		try {
			for (int i = 0; i < 10; i++) {
				l.add(i);
				assertTrue(l.get(i) == i);
			}
		} catch(IllegalStateException e) {
			fail("Caso 4: No debería lanzar la excepción");
		}
		//Casos no válidos
		try {
			l.add(5);
			fail("Caso 5: Debería lanzar la excepción");
		}  catch(IllegalStateException e) {
		}
	}
	
	@Test
	public void removeListaOrdenadaAcotadaTest() {
		ListaOrdenadaAcotada<Integer> l = new ListaOrdenadaAcotada();
		//Casos válidos
		try {
			for (int i = 0; i < 10; i++) {
				l.add(i);
				assertTrue(l.get(i) == i);
			}
			for (int i = 0; i < 10; i++) {
				//System.out.println(l.remove(0));
				assertTrue(l.remove(0) == i);
			}
		} catch(IndexOutOfBoundsException e) {
			fail("Caso 6: No debería lanzar la excepción");
		}
		
		//Casos no válidos
		try {
			l.remove(0);
			fail("Caso 7: Debería lanzar la excepción");
		}  catch(IndexOutOfBoundsException e) {
		}
	}

}