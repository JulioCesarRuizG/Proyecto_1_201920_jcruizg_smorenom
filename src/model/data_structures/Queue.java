package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Queue<T> implements IQueue{

	private Node primero;
	private Node ultimo;

	/**
	 * Crea una nueva cola
	 */
	public Queue(Node pPrimero)
	{
		primero = pPrimero;
		Node actual = primero;
		while(actual.darSiguiente() != null)
		{
			actual = actual.darSiguiente();
		}
		ultimo = actual;
	}

	/**
	 * Devuelve el primer viaje de la cola
	 * @return primer viaje
	 */
	public T darPrimero()
	{
		return (T) primero.darItem();
	}
	public Node darContenedorPrimero()
	{
		return primero;
	}

	public Node darPrimerNodo()
	{
		return primero;
	}

	/**
	 * Devuelve el ultimo viaje de la cola
	 * @return ultimo viaje
	 */
	public T darUltimo()
	{
		return (T) ultimo.darItem();
	}

	/**
	 * Agrega un objeto T a la cola
	 * @param valor a agregar
	 */
	public void enQueue(Object valor) 
	{
		Node i = new Node(valor, null);
		if(darPrimero() == null)
		{
			primero = i;
			ultimo =  i;
		}
		else
		{
			ultimo.cambiarSiguiente(i);
			ultimo = ultimo.darSiguiente();
		}
	}

	/**
	 * Elimina un objeto de la cola
	 * @return S� lo elimina retorna el objeto, null en caso contrario
	 */
	public T deQueue() {

		if(darPrimero() == null)
		{
			return null;
		}
		else if(primero.darSiguiente() == null)
		{
			Node eliminar = primero;
			primero = null;
			ultimo = null;
			return  (T) eliminar.darItem();
		}
		else
		{
			Node eliminar = primero;
			primero = primero.darSiguiente();
			return  (T) eliminar.darItem();
		}
	}

	/**
	 * Comprueba que la cola est� vac�a
	 * @return True si est� vac�a, false en caso contrario
	 */
	public boolean isEmpty() {
		if(darPrimero() == null)
		{
			return true;
		}
		else return false;
	}

	/**
	 * Devuelve el tama�o de la cola
	 * @return tama�o de la cola
	 */
	public int size() {
		if(darPrimero() == null)
		{
			return 0;
		}
		else
		{
			int cantidad = 1;
			Node actual = primero;
			while(actual.darSiguiente() != null)
			{
				actual = actual.darSiguiente();
				cantidad ++;
			}
			return cantidad;
		}
	}

	public Node darElemento(int i)
	{
		int valor = i;
		Node actual = this.darPrimerNodo();
		while(valor != 0)
		{
			if(actual.darSiguiente() != null)
			{
				actual = actual.darSiguiente();
			}
			valor --;
		}
		return actual;
	}

	/**
	 * Convierte la cola de objetos en un iterator
	 * @return cola de objetos iterables
	 */
	public Iterator iterator() {
		Node actual =  primero;
		Collection lista = new ArrayList<Viaje>();
		while(actual.darSiguiente() != null)
		{
			lista.add((Viaje)actual.darItem());
			actual = actual.darSiguiente();
		}
		return lista.iterator();
	}

}
