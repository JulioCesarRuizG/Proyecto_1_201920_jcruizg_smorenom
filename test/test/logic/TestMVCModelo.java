package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Queue;
import model.data_structures.Viaje;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {

	private MVCModelo modelo;

	/**
	 * Escenario 1
	 * @throws Exception
	 */
	@Before
	public void setUp1() throws Exception {
		//./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv
		try
		{
			modelo= new MVCModelo("./data/pruebas-diez.csv");
		}
		catch (Exception e) {
			fail("Error al cargar el archivo" +'"'+"pruebas-diez"+'"');
		}
	}
	
	/**
	 * Escenario 2
	 */
	@Before
	public void setUp2()
	{
		try
		{
			modelo= new MVCModelo("./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv");
		}
		catch (Exception e) {
			fail("Error al cargar el archivo" +'"'+"bogota-cadastral-2018-1-All-HourlyAggregate"+'"');
		}
	}

}
