package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Queue;
import model.data_structures.Viaje;
import model.logic.MVCModelo;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {

	private MVCModelo modelo;
	
	@Before
	public void setUp1() {
	    try {
			modelo=new MVCModelo(0);
		}
	    datos=new ArregloDinamico(21);
	    datos.agregar(new UBERTrip(30,80,5,900,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,1000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,2000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,3000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,4000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,5000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,6000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,7000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,8000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,9000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,10000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,20000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,30000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,40000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,50000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,50000,200,40,660));
		datos.agregar(new UBERTrip(40,7,5,100000,100,20,30));
		datos.agregar(new UBERTrip(8,30,5,200000,500,770,40));
		datos.agregar(new UBERTrip(5,20,5,200000,1000,50,10));
		datos.agregar(new UBERTrip(3,80,5,300000,80,10,50));
		datos.agregar(new UBERTrip(11,20,5,400000,80000,45,23));
	}

	public void setUp2() {
		 try {
				modelo=new MVCModelo(".data/pruebas 20 ordenadas ascendentes.csv");
			} catch (Exception e) {
				e.printStackTrace();
			}
		datos=new ArregloDinamico(21);
		
		datos.agregar(new UBERTrip(11,20,5,400000,80000,45,23));
		datos.agregar(new UBERTrip(3,80,5,300000,80,10,50));
		datos.agregar(new UBERTrip(5,20,5,200000,1000,50,10));
		datos.agregar(new UBERTrip(8,30,5,200000,500,770,40));
		datos.agregar(new UBERTrip(40,7,5,100000,100,20,30));
		datos.agregar(new UBERTrip(30,80,5,50000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,50000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,40000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,30000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,20000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,10000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,9000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,8000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,7000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,6000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,5000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,4000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,3000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,2000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,1000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,900,100,30,50));
	}
	public void setUp3() {
		 try {
				modelo=new MVCModelo(".data/pruebas 20 ordenadas ascendentes.csv");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		datos=new ArregloDinamico(21);
		datos.agregar(new UBERTrip(11,20,5,400000,80000,45,23));
		datos.agregar(new UBERTrip(30,80,5,3000,200,40,660));
		
		datos.agregar(new UBERTrip(8,30,5,200000,500,770,40));
		datos.agregar(new UBERTrip(40,7,5,100000,100,20,30));
	
		datos.agregar(new UBERTrip(30,80,5,50000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,40000,200,40,660));
		datos.agregar(new UBERTrip(3,80,5,300000,80,10,50));
		datos.agregar(new UBERTrip(5,20,5,200000,1000,50,10));
		datos.agregar(new UBERTrip(30,80,5,30000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,20000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,10000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,900,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,9000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,8000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,7000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,6000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,5000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,4000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,50000,200,40,660));
		datos.agregar(new UBERTrip(30,80,5,2000,100,30,50));
		datos.agregar(new UBERTrip(30,80,5,1000,200,40,660));
	
	
	}

}
