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
		//Casos v�lidos
		try {
			//lista no vac�a
			Integer i1 = 5;
			l.add(i1);
			i = l.get(l.size()-1);
			assertTrue(i == 5);
		} catch (IndexOutOfBoundsException e) {
			fail("Caso 1: No deber�a lanzar la excepci�n");
		}
		
		//Casos no v�lidos
		try {
			//lista vac�a
			l.clear();
			i = l.get(0);
			fail("Caso 2: Deber�a lanzar la excepci�n");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			i = l.get(20);
			fail("Caso 3: Deber�a lanzar la excepci�n");
		} catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	@Test
	public void addListaOrdenadaAcotadaTest() {
		ListaOrdenadaAcotada<Integer> l = new ListaOrdenadaAcotada();
		//Casos v�lidos
		try {
			for (int i = 0; i < 10; i++) {
				l.add(i);
				assertTrue(l.get(i) == i);
			}
		} catch(IllegalStateException e) {
			fail("Caso 4: No deber�a lanzar la excepci�n");
		}
		//Casos no v�lidos
		try {
			l.add(5);
			fail("Caso 5: Deber�a lanzar la excepci�n");
		}  catch(IllegalStateException e) {
		}
	}
	
	@Test
	public void removeListaOrdenadaAcotadaTest() {
		ListaOrdenadaAcotada<Integer> l = new ListaOrdenadaAcotada();
		//Casos v�lidos
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
			fail("Caso 6: No deber�a lanzar la excepci�n");
		}
		
		//Casos no v�lidos
		try {
			l.remove(0);
			fail("Caso 7: Deber�a lanzar la excepci�n");
		}  catch(IndexOutOfBoundsException e) {
		}
	}

}