package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Consultar el tiempo promedio de viaje y desviaci�n est�ndar de los viajes entre unas zonas - mes");
			System.out.println("2. Consultar los N viajes con mayor tiempo promedio - mes");
			System.out.println("3. Comparar los tiempo promedios de los viajes para una zona dada contra cada zona X en un rango - mes");
			System.out.println("4. Consultar el tiempo promedio de viaje y desviaci�n est�ndar de los viajes entre unas zonas - d�a");
			System.out.println("5. Consultar los N viajes con mayor tiempo promedio - d�a");
			System.out.println("6. Comparar los tiempo promedios de los viajes para una zona dada contra cada zona X en un rango - d�a");
			System.out.println("7. Consultar el tiempo promedio de viaje y desviaci�n est�ndar de los viajes entre unas zonas y una franja horaria - hora");
			System.out.println("8. Consultar la informaci�n de N viajes con mayor tiempo promedio para una hora dada");
			System.out.println("9. Generar una gr�fica ASCII que muestre el tiempo promedio de los viajes entre una zona origen y destino. Cada hora de es representado con un *");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
