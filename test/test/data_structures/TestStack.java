package test.data_structures;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Node;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.Viaje;

public class TestStack {

	/**
	 * Viajes usados en las pruebas
	 */
	private Viaje quinto = new Viaje(100, 101, 102, 103, 104, 105, 106);
	private Viaje cuarto = new Viaje(22,23,24,25,26,27,28);
	private Viaje tercero = new Viaje(15,16,17,18,19,20,21);
	private Viaje segundo = new Viaje(8,9,10,11,12,13,14);
	private Viaje primero = new Viaje(1,2,3,4,5,6,7);
	private Node d = new Node(cuarto, null);
	private Node e = new Node(quinto, null);
	private Node c = new Node(tercero, d);
	private Node b = new Node(segundo, c);
	private Node a = new Node(primero, b);

	private Stack pila;

	/**
	 * Escenario de pruebas 1
	 */
	@Before
	public void setupEscenario1()
	{
		try
		{
			pila = new Stack(a);
		}
		catch (Exception e) {
			fail("Se ha producido un error en la creación de la pila");
		}
	}

	/**
	 * Prueba que se agreguen elementos correctamente
	 */
	@Test
	public void testPush()
	{
		setupEscenario1();
		try
		{
			pila.push(e);
			Viaje viaje = (Viaje) pila.darContenedorPrimero().darSiguiente().darItem();
			assertEquals("No es el viaje esperado", (Viaje)a.darItem(), viaje);
		}
		catch (Exception e) {
			fail("Error al intentar agregar un Viaje a la pila");
		}
	}

	/**
	 * Prueba que se saquen elementos correctamente
	 */
	@Test
	public void testPop()
	{
		setupEscenario1();
		try
		{
			pila.pop();
			Viaje viaje = (Viaje) pila.darContenedorPrimero().darItem();
			assertEquals("No se ha eliminado correctamente", viaje, b.darItem());
		}
		catch (Exception e) {
			fail("Error al intentar eliminar de la pila");
		}
	}

	/**
	 * Prueba que se compruebe la pila vacía
	 */
	@Test
	public void testIsEmpty()
	{
		setupEscenario1();
		try
		{
			assertEquals("No es el valor esperado", pila.isEmpty(), false);
			pila.pop();
			pila.pop();
			pila.pop();
			pila.pop();
			assertEquals("No es el valor esperado", pila.isEmpty(), true);
		}
		catch (Exception e) {
			fail("Error al usar el método isEmpty");
		}
	}

	/**
	 * Prueba que se devuelva el tamaño correctamente
	 */
	@Test
	public void testSize()
	{
		setupEscenario1();
		try
		{
			assertEquals("No es el tamaño esperado", pila.size(), 4);
			pila.pop();
			pila.pop();
			assertEquals("No es el tamaño esperado", pila.size(), 2);
		}
		catch (Exception e) {
			fail("Error al calcular el tamaño de la cola");
		}
	}

	/**
	 * Prueba que se haya creado el iterador correctamente
	 */
	@Test
	public void testIterator()
	{
		setupEscenario1();
		setupEscenario1();
		try
		{
			Iterator iterador = pila.iterator();
			Viaje viaje = (Viaje)iterador.next();
			assertEquals("No es el viaje esperado", viaje, primero);
		}
		catch (Exception e) {
			fail("No se pudo convertur la cola a un iterador");
		}
	}
}
