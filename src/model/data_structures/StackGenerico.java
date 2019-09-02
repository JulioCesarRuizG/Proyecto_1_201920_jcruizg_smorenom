package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StackGenerico <T> {
	private T primero;
	/**
	 * Crea una nueva pila
	 */
	public StackGenerico(T pPrimero)
	{
		primero = pPrimero;
	}

	/**
	 * Agrega un valor a la pila
	 * @param valor a agregar a la pila
	 */
	public void push(T valor) {
		if(darPrimero() == null)
		{
			cambiarPrimero( valor);
		}
		else
		{
			T nuevo  =  valor;
			T cambiar  = primero;
			cambiarPrimero(nuevo);
			nuevo.cambiarSiguiente(cambiar);
		}
	}

	/**
	 * Elimina el último valor de la pila
	 * @return valor eliminado, null en caso contrario
	 */
	public T pop() {
		if(primero == null)
		{
			return null;
		}
		else
		{
			T eliminar = primero;
			primero = primero.darSiguiente();
			return eliminar;
		}
	}

	/**
	 * Comprueba que la pila esté vacía
	 * @return true si está vacío, false en caso contrario
	 */
	public boolean isEmpty() {
		if(darPrimero() == null)
		{
			return true;
		}
		else return false;
	}

	/**
	 * Devuelve el tamaño de la pila
	 * @return tamaño de la pila
	 */
	public int size(){
		int tamano = 1;
		T actual = primero;
		if(darPrimero() == null)
		{
			return 0;
		}
		while(actual.darSiguiente() != null)
		{
			actual = actual.darSiguiente();
			tamano++;
		}
		return tamano;
	}

	/**
	 * Convierte la pila de objetos en un iterator
	 * @return pila de objetos iterable
	 */
	public Iterator iterator() {
		T actual =  primero;
		Collection lista = new ArrayList<>();
		while(actual.darSiguiente() != null)
		{
			lista.add(actual);
			actual = actual.darSiguiente();
		}
		return lista.iterator();
	}

	/**
	 * Devuelve el primer elemento de la pila
	 * @return primero
	 */
	public T darPrimero()
	{
		return primero;
	}

	/**
	 * Cambia el primer elemento de la pila
	 * @param valor por el que se cambia
	 */
	public void cambiarPrimero(T valor)
	{
		primero = valor;
	}
}
