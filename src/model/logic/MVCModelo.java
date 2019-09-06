package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;


import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.Viaje;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	private Queue colaM;
	private Stack pilaM;
	private Queue colaS;
	private Stack pilaS;
	private Queue colaH;
	private Stack pilaH;

	private boolean valor=true;
	private Viaje agregar;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	// por alguna raz�n, no carga correctamente el excel que se nos entrega. Pero, si utilizamos uno con el mismo orden y tipo de datos pero que solo tiene mil lineas,funciona correctamente
	public MVCModelo(int trimestre) throws Exception{
	String pRutaM ="";
	String pRutaS="";
	String pRutaH="";
	if(trimestre==1){
		pRutaM=".data/bogota-cadastral-2018-1-MonthlyAggregate.csv";
	    pRutaH=".data/bogota-cadastral-2018-1-HourlyAggregate.csv";
	    pRutaS=".data/bogota-cadastral-2018-1-WeeklyAggregate.csv";
	}else if(trimestre==2){
		pRutaM=".data/bogota-cadastral-2018-2-MonthlyAggregate.csv";
	    pRutaH=".data/bogota-cadastral-2018-2-HourlyAggregate.csv";
	    pRutaS=".data/bogota-cadastral-2018-2-WeeklyAggregate.csv";
	}else if(trimestre==3){
		pRutaM=".data/bogota-cadastral-2018-3-MonthlyAggregate.csv";
	    pRutaH=".data/bogota-cadastral-2018-3-HourlyAggregate.csv";
	    pRutaS=".data/bogota-cadastral-2018-3-WeeklyAggregate.csv";
	}else if(trimestre==4){
		pRutaM=".data/bogota-cadastral-2018-4-MonthlyAggregate.csv";
	    pRutaH=".data/bogota-cadastral-2018-4-HourlyAggregate.csv";
	    pRutaS=".data/bogota-cadastral-2018-4-WeeklyAggregate.csv";
	}
	  colaM= new Queue(null);
	      pilaM= new Stack(null);
	   colaH =new Queue(null);
		pilaH= new Stack(null);
		   colaS= new Queue(null);
			pilaS= new Stack(null);
	CSVReader reader = null;
	CSVReader reader2 = null;
	CSVReader reader3 = null;
	CSVReader reader4 = null;
	CSVReader reader5= null;
	CSVReader reader6 = null;
	int min=0;
	int max=0;


	try {
		reader= new CSVReader(new FileReader(pRutaM));
		reader2= new CSVReader(new FileReader(pRutaM));
		int M =0;

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
				if(M==0){
					min=inicioID;
					max=inicioID;
					}
				if(inicioID>min)
					min=inicioID;
				if(inicioID>max)
					max=inicioID;
				if(destinoID>min)
					min=inicioID;
				if(destinoID>max)
					max=inicioID;

				Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG);
				agregar = i;

				colaM.enQueue(i);
				M++;
			}
		}
		System.out.print("El n�mero de lineas le�das en el documento de viajes basado en mes del a�o del trimestre "+trimestre+" es: "+M);




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
				
				Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG);
				agregar = i;

				pilaM.push(i);
			}}
			reader3= new CSVReader(new FileReader(pRutaS));
			reader4= new CSVReader(new FileReader(pRutaS));
			int S =0;

			for(String[] nextLine : reader3) {
				if(nextLine.toString().contains("sourceid,dstid,dow,mean_travel_time,standard_deviation_travel_time,geometric_mean_travel_time,geometric_standard_deviation_travel_time"))
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
					if(inicioID>min)
						min=inicioID;
					if(inicioID>max)
						max=inicioID;
					if(destinoID>min)
						min=inicioID;
					if(destinoID>max)
						max=inicioID;
					Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG);
					agregar = i;

					colaS.enQueue(i);
					S++;
				}
			}
			System.out.print("El n�mero de lineas le�das en el documento de viajes basado en d�a de la semana del trimestre "+trimestre+" es: "+S);




			for(String[] nextLine : reader4) {
				if(nextLine.toString().contains("sourceid,dstid,dow,mean_travel_time,standard_deviation_travel_time,geometric_mean_travel_time,geometric_standard_deviation_travel_time"))
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

					Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG);
					agregar = i;

					pilaS.push(i);
				}
		}
			reader5= new CSVReader(new FileReader(pRutaS));
			reader6= new CSVReader(new FileReader(pRutaS));
			int H =0;

			for(String[] nextLine : reader5) {
				if(nextLine.toString().contains("sourceid,dstid,hod,mean_travel_time,standard_deviation_travel_time,geometric_mean_travel_time,geometric_standard_deviation_travel_time"))
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
					if(destinoID>min)
						min=inicioID;
					if(destinoID>max)
						max=inicioID;
					if(inicioID>min)
						min=inicioID;
					if(inicioID>max)
						max=inicioID;
					Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG);
					agregar = i;

					colaH.enQueue(i);
					H++;
				}
			}
			System.out.print("El n�mero de lineas le�das en el documento de viajes basados en la hora del d�a del trimestre "+trimestre+" es: "+H);




			for(String[] nextLine : reader6) {
				if(nextLine.toString().contains("sourceid,dstid,hod,mean_travel_time,standard_deviation_travel_time,geometric_mean_travel_time,geometric_standard_deviation_travel_time"))
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

					Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG);
					agregar = i;

					pilaH.push(i);
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
	System.out.print("La zona con el mayor identificador es la zona: "+max);
	System.out.print("La zona con el menor identificador es la zona: "+min);
	}

}