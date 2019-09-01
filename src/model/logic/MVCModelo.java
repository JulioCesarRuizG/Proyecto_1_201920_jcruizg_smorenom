package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.Viaje;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	private Queue cola;
	private Stack pila;

	private boolean valor=true;
	private Viaje agregar;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	// por alguna razón, no carga correctamente el excel que se nos entrega. Pero, si utilizamos uno con el mismo orden y tipo de datos pero que solo tiene mil lineas,funciona correctamente
	public MVCModelo(String pRuta) throws Exception
	{   cola= new Queue(null);
	pila= new Stack(null);
	CSVReader reader = null;
	CSVReader reader2 = null;

	try {
		reader= new CSVReader(new FileReader(pRuta));
		reader2= new CSVReader(new FileReader(pRuta));
		int c =0;

		for(String[] nextLine : reader) {
			if(nextLine.toString().contains("sourceid,dstid,month,mean_travel_time,standard_deviation_travel_time,geometric_mean_travel_time,geometric_standard_deviation_travel_time"))
			{

			}
			else
			{


				int  inicioID=Integer.parseInt(nextLine[0]);
				int destinoID=Integer.parseInt(nextLine[1]);
				int hora=Integer.parseInt(nextLine[2]);
				double tiempoPromedioEnSegundos=Double.parseDouble(nextLine[3]);
				double desviacionEstandar=Double.parseDouble(nextLine[4]);
				double tiempoPromedioGEnSegundos=Double.parseDouble(nextLine[5]);
				double desviacionEstandarG=Double.parseDouble(nextLine[6]);

				Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG,null);
				agregar = i;

				cola.enQueue(i);
				c++;
			}
		}




		for(String[] nextLine : reader2) {
			if(nextLine.toString().contains("sourceid,dstid,month,mean_travel_time,standard_deviation_travel_time,geometric_mean_travel_time,geometric_standard_deviation_travel_time"))
			{

			}
			else
			{
				int  inicioID=Integer.parseInt(nextLine[0]);
				int destinoID=Integer.parseInt(nextLine[1]);
				int hora=Integer.parseInt(nextLine[2]);
				double tiempoPromedioEnSegundos=Double.parseDouble(nextLine[3]);
				double desviacionEstandar=Double.parseDouble(nextLine[4]);
				double tiempoPromedioGEnSegundos=Double.parseDouble(nextLine[5]);
				double desviacionEstandarG=Double.parseDouble(nextLine[6]);

				Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG,null);
				agregar = i;

				pila.push(i);
			}


		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} finally{
		if (reader != null) {
			try {
				reader.close();
				reader2.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	System.out.print("-------- /nID zona de inicio:"+agregar.darInicioID()+"-------- /nID Destino:"+agregar.darDestinoID()+"-------- /nHora del dia:"+agregar.darHora()+"-------- /nTiempo Promedio:"+agregar.darTiempoPromedioEnSegundos());
	}

}