package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import Exceptions.NoHayException;
import model.data_structures.Node;
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
	// por alguna razón, no carga correctamente el excel que se nos entrega. Pero, si utilizamos uno con el mismo orden y tipo de datos pero que solo tiene mil lineas,funciona correctamente
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
			System.out.print("El número de lineas leídas en el documento de viajes basado en mes del año del trimestre "+trimestre+" es: "+M);




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
			System.out.print("El número de lineas leídas en el documento de viajes basado en día de la semana del trimestre "+trimestre+" es: "+S);




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
			System.out.print("El número de lineas leídas en el documento de viajes basados en la hora del día del trimestre "+trimestre+" es: "+H);




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


	/////
	//Requerimientos parte A
	/////
	
	// 1A

	public Queue<Node<String>> consultarTiempoPromedioYDesviacionMes(int zonaOrigen, int zonaDestino, int mes) throws Exception
	{
		String info = "**Datos de los viajes**" + "\n" + "Tiempo promedio // Desviación estandar" + "\n";
		Node primero = colaM.darContenedorPrimero();
		Queue<Node<String>> datos=new Queue<Node<String>>(null);
		datos.enQueue(info);
		while(primero.darSiguiente() != null)
		{
			Viaje viaje = (Viaje)primero.darItem();
			if(viaje.darDestinoID() == zonaDestino && viaje.darInicioID() == zonaOrigen && viaje.darParametro() == mes)
			{    
				datos.enQueue(viaje.darTiempoPromedioEnSegundos() + " // " + viaje.darDesviacionEstandar());
				
			}

			primero = primero.darSiguiente();
		}
		if(datos.size()==1)
		{
			throw new NoHayException("No hay viajes que cumplan la condición", null);
		}
		else
		{
			return datos;
		}
		
	}
	
	// 2A
	
		public Queue<Node<String>> MayorTiempoPromedioNViajesMes(int N, int mes) {
			int valor = N;
			int num = 0;
			//Falta ordenar la colaM en este punto
			Node lugar = colaM.darPrimerNodo();
			Viaje viaje = (Viaje) lugar.darItem();
			Queue<Node<String>> datos=new Queue<Node<String>>(null);
			System.out.println("Los " + N + " viajes con los mayores tiempos promedio para el mes " + mes + " son:");
			while(valor >= 0 && viaje != null)
			{
				if(viaje.darParametro() == mes)
				{
				num ++;
				System.out.println(num + ": zona origen-" + viaje.darInicioID() + ", zona destino-" + viaje.darDestinoID() + ", tiempo promedio de viaje-" + viaje.darTiempoPromedioEnSegundos() + ", desviación estandar-" + viaje.darDesviacionEstandar() );
				datos.enQueue(num + ": zona origen-" + viaje.darInicioID() + ", zona destino-" + viaje.darDestinoID() + ", tiempo promedio de viaje-" + viaje.darTiempoPromedioEnSegundos() + ", desviación estandar-" + viaje.darDesviacionEstandar());
				valor --;
				viaje = (Viaje) lugar.darSiguiente().darItem();
				lugar = lugar.darSiguiente();
				}
			}
			return datos;
		}
	

	


	
	/////
	//Requerimientos parte B
	/////
	
	//1B
		public Queue<Node<String>> consultarTiempoPromedioYDesviacionDia(int zonaOrigen, int zonaDestino, int dia) throws Exception
		{
			String info = "**Datos de los viajes**" + "\n" + "Tiempo promedio // Desviación estandar" + "\n";
			Node primero = colaS.darContenedorPrimero();
			Queue<Node<String>> datos=new Queue<Node<String>>(null);
			datos.enQueue(info);
			while(primero.darSiguiente() != null)
			{
				Viaje viaje = (Viaje)primero.darItem();
				if(viaje.darDestinoID() == zonaDestino && viaje.darInicioID() == zonaOrigen && viaje.darParametro() == dia)
				{
					datos.enQueue(viaje.darTiempoPromedioEnSegundos() + " // " + viaje.darDesviacionEstandar());
				}

				primero = primero.darSiguiente();
			}
			if(datos.size()==1)
			{
				throw new NoHayException("No hay viajes que cumplan la condición", null);
			}
			else
			{
				return datos;
			}
		}
		
		//2B
		
		public Queue<Node<String>> MayorTiempoPromedioNViajesDia(int N, int dia) {
			int valor = N;
			int num = 0;
			//Falta ordenar la colaS en este punto
			Node lugar = colaS.darPrimerNodo();
			Viaje viaje = (Viaje) lugar.darItem();
			System.out.println("Los " + N + " viajes con los mayores tiempos promedio para el mes " + dia + " son:");
			Queue<Node<String>> datos=new Queue<Node<String>>(null);
			while(valor >= 0 && viaje != null)
			{
				if(viaje.darParametro() == dia)
				{
				num ++;
				System.out.println(num + ": zona origen-" + viaje.darInicioID() + ", zona destino-" + viaje.darDestinoID() + ", tiempo promedio de viaje-" + viaje.darTiempoPromedioEnSegundos() + ", desviación estandar-" + viaje.darDesviacionEstandar() );
				datos.enQueue(num + ": zona origen-" + viaje.darInicioID() + ", zona destino-" + viaje.darDestinoID() + ", tiempo promedio de viaje-" + viaje.darTiempoPromedioEnSegundos() + ", desviación estandar-" + viaje.darDesviacionEstandar());
				valor --;
				viaje = (Viaje) lugar.darSiguiente().darItem();
				lugar = lugar.darSiguiente();
				}
			}
			return datos;
		}
	
	//3B
		public Queue<Node<String>> compararTiemposZonaDadaDia(int zonaI, int zonaF, int zonaX,int dia) {

		    int inicio=zonaI;
		    int fin=zonaF;
			Queue<Node<String>> datos=new Queue<Node<String>>(null);
		    while(inicio<=fin){
		    	  String tiempo1="No hay viajes";
		    	  String tiempo2="No hay viajes";
		    	  boolean x=false;
		    	  Node check= colaS.darPrimerNodo();
		    		while(check.darSiguiente()!=null&&!x){
		    			Viaje actual= (Viaje)check.darItem();
		    			if((actual.darInicioID()==inicio&&actual.darDestinoID()==zonaX&&actual.darParametro()==dia)){
		    				tiempo1=String.valueOf(actual.darTiempoPromedioEnSegundos());
		    			}
		    			if((actual.darInicioID()==zonaX&&actual.darDestinoID()==inicio)&&actual.darParametro()==dia){
		    				tiempo2=String.valueOf(actual.darTiempoPromedioEnSegundos());
		    			}
		    			if(!tiempo1.equals("No hay viajes")&&!tiempo2.equals("No hay viajes")){
		    				x=true;
		    			}
		    			
		    		}
		    		
		    		datos.enQueue(tiempo1+ "  de  " +inicio+ "  a  "+ zonaX+ "  vs  " +tiempo2+ "  de  "+ zonaX+ "  a  "+inicio);
		    	
		    			
		    		
		    		inicio++;
		    		
		    }
			return datos;
		}
	
	/////
	//Requerimientos parte C
	/////
	
	// 1C
	public Queue<Node<String>> compararViajesFranjaHoraria(int zonaI, int zonaD, int horaI,int horaF) {

	    int inicio=horaI;
	    int fin=horaF;
		Queue<Node<String>> datos=new Queue<Node<String>>(null);
	    while(inicio<=fin){
	    	  boolean x=false;
	    	  Node check= colaS.darPrimerNodo();
	    		while(check.darSiguiente()!=null&&!x){
	    			Viaje actual= (Viaje)check.darItem();
	    			if(actual.darInicioID()==zonaI&&actual.darDestinoID()==zonaD&&actual.darInicioID()==inicio){
	    			 datos.enQueue(actual.darTiempoPromedioEnSegundos()+","+actual.darDesviacionEstandar());
	    			 x=true;
	    			}
	    			
	    		}
	    		
	    		
	    	
	    			
	    		
	    		inicio++;
	    		
	    }
		return datos;
	}	
	//2C
	
	public Queue<Node<String>> MayorTiempoPromedioNViajesHora(int N, int mes) {
		int valor = N;
		int num = 0;
		//Falta ordenar la colaH en este punto
		Node lugar = colaM.darPrimerNodo();
		Viaje viaje = (Viaje) lugar.darItem();
		Queue<Node<String>> datos=new Queue<Node<String>>(null);
		System.out.println("Los " + N + " viajes con los mayores tiempos promedio para el mes " + mes + " son:");
		while(valor >= 0 && viaje != null)
		{
			if(viaje.darParametro() == mes)
			{
			num ++;
			System.out.println(num + ": zona origen-" + viaje.darInicioID() + ", zona destino-" + viaje.darDestinoID() + ", tiempo promedio de viaje-" + viaje.darTiempoPromedioEnSegundos() + ", desviación estandar-" + viaje.darDesviacionEstandar() );
			datos.enQueue(num + ": zona origen-" + viaje.darInicioID() + ", zona destino-" + viaje.darDestinoID() + ", tiempo promedio de viaje-" + viaje.darTiempoPromedioEnSegundos() + ", desviación estandar-" + viaje.darDesviacionEstandar());
			valor --;
			viaje = (Viaje) lugar.darSiguiente().darItem();
			lugar = lugar.darSiguiente();
			}
		}
		return datos;
	}
	
	//3C
	
	public void ASCIIZonas(int zonaOrigen, int zonaDestino)
	{
		String todo= "Aproximación en minutos de viajes entre zona origen y zona destino." + "\n" + "Trimestre X del 2018 detallado por cada hora del día" + "\n" + "Zona Origen: "+ zonaOrigen + "\n"+ "Zona Destino: " + zonaDestino + "\n" + "Hora| # de minutos" + "\n";
		int cantidad = 0;
		Node actual = colaH.darPrimerNodo();
		boolean encontrado = false;
		for(int i=0 ; i<24 ; i++)
		{
			while(actual.darSiguiente() != null && encontrado == false)
			{
				Viaje viaje = (Viaje) actual.darItem();
				if(viaje.darParametro() == i && viaje.darInicioID() == zonaOrigen && viaje.darDestinoID() == zonaDestino)
				{
					double decimal = viaje.darTiempoPromedioEnSegundos();
					int entera = (int) viaje.darTiempoPromedioEnSegundos();
					if(decimal-entera >= 0.5)
					{
						cantidad =entera + 1;
					}
					else 
					{
						cantidad =entera;
					}
					encontrado = true;
				}
				actual = actual.darSiguiente();
			}
			String asteriscos = "";
			while(cantidad != 0)
			{
				asteriscos = asteriscos + "*";
				cantidad --;
			}
			if(asteriscos.equals(""))
			{
				asteriscos = "hora sin viajes";
			}
			todo = todo + "0" + i + "  |  " + asteriscos + "\n";
			encontrado = false;
		}
		System.out.println(todo);
	}
}