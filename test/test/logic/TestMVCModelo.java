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
			modelo= new MVCModelo(2);
		}
		catch (Exception e) {
			fail("Error al cargar los archivos: "+"/n"+"bogota-cadastral-2018-2-WeeklyAggregate.csv"+"/n"+".data/bogota-cadastral-2018-2-HourlyAggregate.csv"+"/n"+".data/bogota-cadastral-2018-2-MonthlyAggregate.csv");
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
			modelo= new MVCModelo(3);
		}
		catch (Exception e) {
			fail("Error al cargar los archivos: "+"/n"+"bogota-cadastral-2018-3-WeeklyAggregate.csv"+"/n"+".data/bogota-cadastral-2018-3-HourlyAggregate.csv"+"/n"+".data/bogota-cadastral-2018-3-MonthlyAggregate.csv");
		}
	}

}
